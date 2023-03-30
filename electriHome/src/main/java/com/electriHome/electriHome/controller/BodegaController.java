/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.electriHome.electriHome.controller;

import com.electriHome.electriHome.models.bodega.BodegaProducto;
import com.electriHome.electriHome.models.bodega.Marca;
import com.electriHome.electriHome.models.bodega.ProductoEnty;
import com.electriHome.electriHome.models.bodega.ProductoMarca;
import com.electriHome.electriHome.models.inventario.Pedido;
import com.electriHome.electriHome.models.inventario.SolucionPedido;
import com.electriHome.electriHome.models.venta.Producto;
import com.electriHome.electriHome.models.venta.SucursalProducto;
import com.electriHome.electriHome.respositories.ProductoRepository;
import com.electriHome.electriHome.respositories.SucursalProductoRepository;
import com.electriHome.electriHome.respositories.inventario.BodegaProductoRepository;
import com.electriHome.electriHome.respositories.inventario.MarcaRepository;
import com.electriHome.electriHome.respositories.inventario.PedidoRepository;
import com.electriHome.electriHome.respositories.inventario.ProductoEntyRepository;
import com.electriHome.electriHome.respositories.inventario.ProductoMarcaRepository;
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
@RequestMapping("/Electronic-Home/bodega")
public class BodegaController {

    @Autowired
    ProductoRepository productoRpo;

    @Autowired
    MarcaRepository marcaRpo;

    @Autowired
    ProductoEntyRepository prodcutoEntyRpo;

    @Autowired
    ProductoMarcaRepository producMarcaRpo;

    @Autowired
    BodegaProductoRepository bodegaProdRpo;

    @Autowired
    SolucionPedidoRepository solucionPrediodRpo;

    @Autowired
    SucursalProductoRepository sucursalProductoRpo;
    
    @Autowired
    PedidoRepository pedidoRpo;

    /**
     * 
     * @param sucursal sucursal de busqueda
     * @return productos almacenados en la sucursal
     */
    @GetMapping(path = "/getProductos")
    public List<Producto> getListProductosSucursal(@RequestParam Integer sucursal) {
        try {
            List<Object[]> result = this.productoRpo.getListProductosBodega(sucursal);
            if (!result.isEmpty()) {
                List<Producto> productos = new ArrayList<>();
                for (Object[] obj : result) {
                    Producto tmp = new Producto();
                    tmp.setCodigoId((Integer) obj[0]);
                    tmp.setNombre((String) obj[1]);
                    tmp.setPrecio((BigDecimal) obj[2]);
                    tmp.setMarca((String) obj[3]);
                    tmp.setCantidad((Integer) obj[4]);
                    tmp.setCodigoProducto((String) obj[5]);
                    productos.add(tmp);
                }
                return productos;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    /**
     * 
     * @return list marcas exisitentes
     */
    @GetMapping(path = "/getMarcas")
    public List<Marca> getMarcas() {
        try {
            return this.marcaRpo.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 
     * @param producto
     * @param descripcion
     * @return guarda el producto nuevo a registrar
     */
    @PostMapping(path = "/saveProducto")
    public Producto saveProdcuto(@RequestBody Producto producto, @RequestParam String descripcion) {
        try {
            ProductoEnty productoE = new ProductoEnty();
            productoE.setNombre(producto.getNombre());
            productoE.setDescripcion(descripcion);
            productoE.setCodigo(producto.getCodigoProducto());
            productoE = this.prodcutoEntyRpo.save(productoE);
            if (productoE != null) {
                return producto;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 
     * @param marca
     * @return gurada el nuevo producto con su respectiva marca
     */
    @PostMapping(path = "/saveMarca")
    public Marca saveMarca(@RequestBody Marca marca) {
        try {
            if (marca.getCodigoId() == null) {
                return this.marcaRpo.save(marca);
            }
            return marca;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 
     * @param producto
     * @param codigoMarca
     * @return 
     */
    @PostMapping(path = "/saveProductoBodega")
    public boolean saveProductoBodega(@RequestBody Producto producto, @RequestParam Integer codigoMarca) {
        try {
            ProductoMarca productoMarca = new ProductoMarca();
            productoMarca.setCodigoMarca(codigoMarca);
            productoMarca.setCodigoProducto(producto.getCodigoProducto());
            productoMarca.setPrecio(producto.getPrecio());
            productoMarca = this.producMarcaRpo.save(productoMarca);
            if (productoMarca != null) {
                producto.setCodigoId(productoMarca.getCodigoId());
                BodegaProducto prodcutoBod = new BodegaProducto();
                prodcutoBod.setCantidadExistente(producto.getCantidad());
                prodcutoBod.setCodigoProducto(producto.getCodigoId());
                prodcutoBod.setCodigoBodega(1);
                return this.bodegaProdRpo.save(prodcutoBod) != null;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @PutMapping(path = "/setProcuto")
    public boolean setProducto(@RequestBody Producto producto) {
        try {
            List<Object[]> result = this.prodcutoEntyRpo.getProducto(producto.getCodigoProducto());
            if (!result.isEmpty()) {
                ProductoEnty pro = new ProductoEnty();
                pro.setCodigo((String) result.get(0)[0]);
                pro.setNombre(producto.getNombre());
                pro.setDescripcion((String) result.get(0)[2]);
                return null != this.prodcutoEntyRpo.save(pro);
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    @PutMapping(path = "/setProcutoMarca")
    public boolean setProcutoMarca(@RequestBody Producto producto, @RequestParam Integer idMarca) {
        try {
            ProductoMarca proMarc = this.producMarcaRpo.findById(producto.getCodigoId() + 0);
            if (proMarc != null) {
                proMarc.setCodigoMarca(idMarca);
                proMarc.setPrecio(producto.getPrecio());
                return null != this.producMarcaRpo.save(proMarc);
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 
     * @param producto
     * @return 
     */
    @PutMapping(path = "/setBodegaProducto")
    public boolean setBodegaProducto(@RequestBody Producto producto) {
        try {
            List<Object[]> result = this.bodegaProdRpo.getProductoAmacenado(producto.getCodigoId());
            if (result != null) {
                BodegaProducto bodegP = new BodegaProducto();
                bodegP.setCodigoId((Integer) result.get(0)[0]);
                bodegP.setCodigoProducto((Integer) result.get(0)[1]);
                bodegP.setCodigoBodega((Integer) result.get(0)[2]);
                bodegP.setCantidadExistente(producto.getCantidad());
                return null != this.bodegaProdRpo.save(bodegP);
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @GetMapping(path = "/getPedidos")
    public List<SolucionPedido> getPedidos(@RequestParam String estado, @RequestParam Integer codigo) {
        try {
            List<Object[]> result = this.solucionPrediodRpo.getSolicitudesBodega(estado, 1);
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

    @PutMapping(path = "/solucionPedido")
    public boolean solucionPido(@RequestBody SolucionPedido solPedido) {
        try {
            this.procesoUpdateProductoSucurAumento(solPedido);
            this.procesoUpdateProductoBodegaDescuento(solPedido);
            this.updateEstadoPedido(solPedido);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
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

    private void procesoUpdateProductoBodegaDescuento(SolucionPedido solPedido ) {
        List<Object[]> result = this.bodegaProdRpo.getProductoAmacenado(solPedido.getCodigoProducto());
        if (!result.isEmpty()) {
            BodegaProducto sucursalP = new BodegaProducto();
            sucursalP.setCodigoId((Integer) result.get(0)[0]);
            sucursalP.setCodigoProducto((Integer) result.get(0)[1]);
            sucursalP.setCodigoBodega((Integer) result.get(0)[2]);
            sucursalP.setCantidadExistente(this.calculoCantidadExisitent((Integer) result.get(0)[3], solPedido.getCantidad(), true));
            this.bodegaProdRpo.save(sucursalP);
        }
    }

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

    private Integer calculoCantidadExisitent(Integer cantActu, Integer cantCompra, boolean isDescuento) {
        if (isDescuento) {
            return cantActu - cantCompra;
        }
        return cantActu + cantCompra;
    }

}
