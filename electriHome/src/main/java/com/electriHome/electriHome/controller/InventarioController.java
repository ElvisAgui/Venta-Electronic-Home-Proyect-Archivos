package com.electriHome.electriHome.controller;

import com.electriHome.electriHome.models.empleados.Sucursal;
import com.electriHome.electriHome.models.inventario.Bodega;
import com.electriHome.electriHome.models.inventario.Pedido;
import com.electriHome.electriHome.models.inventario.SolucionPedido;
import com.electriHome.electriHome.models.venta.ItemsVenta;
import com.electriHome.electriHome.models.venta.Producto;
import com.electriHome.electriHome.models.venta.SucursalProducto;
import com.electriHome.electriHome.respositories.ProductoRepository;
import com.electriHome.electriHome.respositories.SucursalProductoRepository;
import com.electriHome.electriHome.respositories.SucursalRepository;
import com.electriHome.electriHome.respositories.inventario.BodegaRepository;
import com.electriHome.electriHome.respositories.inventario.PedidoRepository;
import com.electriHome.electriHome.respositories.inventario.SolucionPedidoRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author elvis_agui
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/Electronic-Home/inventario")
public class InventarioController {

    @Autowired
    SucursalRepository sucursalRpo;

    @Autowired
    ProductoRepository productoRpo;

    @Autowired
    SucursalProductoRepository sucursalProductoRpo;

    @Autowired
    SolucionPedidoRepository solucionPrediodRpo;

    @Autowired
    BodegaRepository bodegaRpo;

    @Autowired
    PedidoRepository pedidoRpo;
    
    /**
     * guarda el pedido echo hacia otras sucursales
     * @param pedido
     * @return 
     */
    @PostMapping(path = "/savePedido")
    public boolean savePedido(@RequestBody Pedido pedido) {
        try {
            if (pedido.getCodigoBodega() == 0) {
                pedido.setCodigoBodega(null);
            } else {
                pedido.setCodigoSucursal(null);
            }
            Pedido pedio = this.pedidoRpo.save(pedido);
            return pedido != null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 
     * @param solPedido
     * @param SucurDescuento
     * @return 
     */
    @PutMapping(path = "/solucionPedido")
    public boolean solucionPido(@RequestBody SolucionPedido solPedido, @RequestParam Integer SucurDescuento) {
        try {
            this.procesoUpdateProductoSucurAumento(solPedido);
            this.procesoUpdateProductoSucurDescuento(solPedido, SucurDescuento);
            this.updateEstadoPedido(solPedido);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 
     * @param solPedido 
     */
    private void updateEstadoPedido(SolucionPedido solPedido) {
        Pedido pedido = new Pedido();
        pedido.setCodigoId(solPedido.getCodigoId());
        pedido.setCodigoProducto(solPedido.getCodigoProducto());
        pedido.setCodigoSucursal(solPedido.getCodigoSucursal());
        pedido.setCodigoBodega(solPedido.getCodigoBodega());
        pedido.setSucuralSolicitante(solPedido.getSucuralSolicitante());
        pedido.setCantidad(solPedido.getCantidad());
        pedido.setEstado(solPedido.getEstado());
        pedido.setCuiEmpleado(solPedido.getCuiEmpleado());
        this.pedidoRpo.save(pedido);

    }

    /**
     * 
     * @param solPedido
     * @return 
     */
    @PutMapping(path = "/rechazarPedido")
    public boolean updateEstadoPedidoRechazado(@RequestBody SolucionPedido solPedido) {
        try {
            Pedido pedido = new Pedido();
            pedido.setCodigoId(solPedido.getCodigoId());
            pedido.setCodigoProducto(solPedido.getCodigoProducto());
            pedido.setCodigoSucursal(solPedido.getCodigoSucursal());
            pedido.setCodigoBodega(solPedido.getCodigoBodega());
            pedido.setSucuralSolicitante(solPedido.getSucuralSolicitante());
            pedido.setCantidad(solPedido.getCantidad());
            pedido.setEstado("Rechazado");
            pedido.setCuiEmpleado(solPedido.getCuiEmpleado());
            this.pedidoRpo.save(pedido);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    private void procesoUpdateProductoSucurDescuento(SolucionPedido solPedido, Integer SucurDescuento) {
        List<Object[]> result = this.sucursalProductoRpo.getProductoAmacenado(solPedido.getCodigoProducto(), SucurDescuento);
        if (!result.isEmpty()) {
            SucursalProducto sucursalP = new SucursalProducto();
            sucursalP.setCodigoId((Integer) result.get(0)[0]);
            sucursalP.setCodigoProducto((Integer) result.get(0)[1]);
            sucursalP.setCodigoSucursal((Integer) result.get(0)[2]);
            sucursalP.setCantidadExistente(this.calculoCantidadExisitent((Integer) result.get(0)[3], solPedido.getCantidad(), true));
            this.sucursalProductoRpo.save(sucursalP);
        }
    }

    private void procesoUpdateProductoSucurAumento(SolucionPedido solPedido) {
        List<Object[]> result = this.sucursalProductoRpo.getProductoAmacenado(solPedido.getCodigoProducto(), solPedido.getCodigoSucursal());
        SucursalProducto sucursalP = new SucursalProducto();
        if (!result.isEmpty()) {
            sucursalP.setCodigoId((Integer) result.get(0)[0]);
            sucursalP.setCodigoProducto((Integer) result.get(0)[1]);
            sucursalP.setCodigoSucursal((Integer) result.get(0)[2]);
            sucursalP.setCantidadExistente(this.calculoCantidadExisitent((Integer) result.get(0)[3], solPedido.getCantidad(), false));
        } else {
            sucursalP.setCodigoProducto(solPedido.getCodigoProducto());
            sucursalP.setCodigoSucursal(solPedido.getCodigoSucursal());
            sucursalP.setCantidadExistente(solPedido.getCantidad());
        }
        this.sucursalProductoRpo.save(sucursalP);
    }

    private Integer calculoCantidadExisitent(Integer cantActu, Integer cantCompra, boolean isDescuento) {
        if (isDescuento) {
            return cantActu - cantCompra;
        }
        return cantActu + cantCompra;
    }

    @GetMapping(path = "/getPedidos")
    public List<SolucionPedido> getPedidos(@RequestParam String estado, @RequestParam Integer codigo) {
        try {
            List<Object[]> result = this.solucionPrediodRpo.getSolicitudesSucursal(estado, codigo);
            List<SolucionPedido> pedidos = new ArrayList<>();
            if (!result.isEmpty()) {
                for (Object[] obj : result) {
                    SolucionPedido pedido = new SolucionPedido();
                    pedido.setCodigoId((Integer) obj[0]);
                    pedido.setCodigoProducto((Integer) obj[1]);
                    pedido.setCodigoSucursal((Integer) obj[2]);
                    pedido.setCodigoBodega((Integer) obj[3]);
                    pedido.setSucuralSolicitante((String) obj[4]);
                    pedido.setCantidad((Integer) obj[5]);
                    pedido.setEstado((String) obj[6]);
                    pedido.setCuiEmpleado((String) obj[7]);
                    pedido.setNombre((String) obj[8]);
                    pedido.setMarca((String) obj[9]);
                    pedido.setCodigo((String) obj[10]);
                    pedidos.add(pedido);
                }
                return pedidos;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping(path = "/getSucursales")
    public List<Sucursal> getSucursales() {
        try {
            return this.sucursalRpo.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping(path = "/getBodega")
    public List<Bodega> getBodega() {
        try {
            return this.bodegaRpo.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping(path = "/getProducto")
    public Producto getProducto(@RequestParam Integer sucursal, @RequestParam String producto) {
        try {
            List<Object[]> result = this.productoRpo.getProductoSucursal(sucursal, producto);
            if (!result.isEmpty()) {
                Producto producTem = new Producto();
                producTem.setCodigoId((Integer) result.get(0)[0]);
                producTem.setNombre((String) result.get(0)[1]);
                producTem.setPrecio((BigDecimal) result.get(0)[2]);
                producTem.setMarca((String) result.get(0)[3]);
                producTem.setCantidad((Integer) result.get(0)[4]);
                return producTem;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @GetMapping(path = "/getProductoBodega")
    public Producto getProductoBodega(@RequestParam Integer sucursal, @RequestParam String producto) {
        try {
            List<Object[]> result = this.productoRpo.getProductoBodega(sucursal, producto);
            if (!result.isEmpty()) {
                Producto producTem = new Producto();
                producTem.setCodigoId((Integer) result.get(0)[0]);
                producTem.setNombre((String) result.get(0)[1]);
                producTem.setPrecio((BigDecimal) result.get(0)[2]);
                producTem.setMarca((String) result.get(0)[3]);
                producTem.setCantidad((Integer) result.get(0)[4]);
                return producTem;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @PutMapping(path = "/aumentarCantidad")
    public boolean updateCantidadProductoSucursal(@RequestBody Producto prodcuto, @RequestParam Integer codigoSucursal) {
        try {
            List<Object[]> result = this.sucursalProductoRpo.getProductoAmacenado(prodcuto.getCodigoId(), codigoSucursal);
            SucursalProducto sucursalP = new SucursalProducto();
            if (!result.isEmpty()) {
                sucursalP.setCodigoId((Integer) result.get(0)[0]);
                sucursalP.setCodigoProducto((Integer) result.get(0)[1]);
                sucursalP.setCodigoSucursal((Integer) result.get(0)[2]);
                sucursalP.setCantidadExistente(this.calculoCantidadExisitent((Integer) result.get(0)[3], 1, false));
                this.sucursalProductoRpo.save(sucursalP);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

}
