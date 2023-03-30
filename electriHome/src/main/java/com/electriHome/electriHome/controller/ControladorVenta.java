package com.electriHome.electriHome.controller;

import com.electriHome.electriHome.encript.Encript;
import com.electriHome.electriHome.models.Cliente;
import com.electriHome.electriHome.models.venta.ItemsVenta;
import com.electriHome.electriHome.models.venta.Producto;
import com.electriHome.electriHome.models.venta.SucursalProducto;
import com.electriHome.electriHome.models.venta.VentaProducto;
import com.electriHome.electriHome.respositories.ClienteRepository;
import com.electriHome.electriHome.respositories.ProductoRepository;
import com.electriHome.electriHome.respositories.SucursalProductoRepository;
import com.electriHome.electriHome.respositories.VentaProductoRepository;
import com.electriHome.electriHome.respositories.itemsVentaRepository;
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
@RequestMapping("/Electronic-Home/venta")
public class ControladorVenta {

    private final Encript encript = new Encript();

    @Autowired
    ClienteRepository clienteRpo;

    @Autowired
    SucursalProductoRepository sucursalProductoRpo;

    @Autowired
    itemsVentaRepository itemVentaRpo;

    @Autowired
    ProductoRepository productoRpo;

    @Autowired
    VentaProductoRepository ventaRepo;

    /**
     * 
     * @param nit
     * @return obtiene el cliente sgegun el nit 
     */
    @GetMapping(path = "/getCliente")
    public Cliente clienteVenta(@RequestParam String nit) {
        List<Object[]> result = this.clienteRpo.getCliente((String) nit);
        if (!result.isEmpty()) {
            Cliente cliente = new Cliente();
            cliente.setNit((String) result.get(0)[0]);
            cliente.setNombre((String) result.get(0)[1]);
            cliente.setApellido((String) result.get(0)[2]);
            return cliente;
        } else {
            return null;
        }
    }

    /**
     * 
     * @return list de clientes registrados
     */
    @GetMapping(path = "/getClientes")
    public List<Cliente> getClientes() {
        try {
            return this.clienteRpo.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 
     * @param cliente
     * @return guarda al nuevo cliente
     */
    @PostMapping(path = "/saveCliente")
    public Cliente saveClinte(@RequestBody Cliente cliente) {
        try {
            return this.clienteRpo.save(cliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 
     * @param cliente
     * @return actualiza al cliente
     */
    @PutMapping(path = "/setCliente")
    public Cliente setCliente(@RequestBody Cliente cliente) {
        try {
            return this.clienteRpo.save(cliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    /**
     * gurada la venta
     * @param venta
     * @param gana
     * @param cui
     * @return  venta nueva
     */
    @PostMapping(path = "/saveVenta")
    public VentaProducto saveVenta(@RequestBody VentaProducto venta, @RequestParam BigDecimal gana, @RequestParam String cui) {
        venta.setGanaciaReal(gana);
        venta.setCuiEmpleado(cui);
        venta.setCodigo(this.encript.ecnode("venta#" + this.ventaRepo.count() + 2));
        try {
            return this.ventaRepo.save(venta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    /**
     * guarda los items de la venta realizada
     * @param itemsVenta
     * @param codigoSucural
     * @return 
     */
    @PostMapping(path = "/saveItemVenta")
    public boolean saveItemVenta(@RequestBody List<ItemsVenta> itemsVenta, @RequestParam Integer codigoSucural) {
        try {
            if (!itemsVenta.isEmpty()) {
                this.procesoUpdateProductoSucur(itemsVenta, codigoSucural);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;

    }

    /**
     * descuenta el producto de la sucursal
     * @param itemsVenta
     * @param codigoSucural 
     */
    private void procesoUpdateProductoSucur(List<ItemsVenta> itemsVenta, Integer codigoSucural) {
        for (ItemsVenta item : itemsVenta) {
            ItemsVenta itemVenta = this.itemVentaRpo.save(item);
            if (itemVenta != null) {
                List<Object[]> result = this.sucursalProductoRpo.getProductoAmacenado(item.getCodigoProducto(), codigoSucural);
                if (!result.isEmpty()) {
                    SucursalProducto sucursalP = new SucursalProducto();
                    sucursalP.setCodigoId((Integer) result.get(0)[0]);
                    sucursalP.setCodigoProducto((Integer) result.get(0)[1]);
                    sucursalP.setCodigoSucursal((Integer) result.get(0)[2]);
                    sucursalP.setCantidadExistente(this.calculoCantidadExisitent((Integer) result.get(0)[3], item.getCantidadProducto()));
                    this.sucursalProductoRpo.save(sucursalP);
                }
            }
        }
    }

    /**
     * descuenta la cantidad comprada
     * @param cantActu
     * @param cantCompra
     * @return 
     */
    private Integer calculoCantidadExisitent(Integer cantActu, Integer cantCompra) {
        return cantActu - cantCompra;
    }

    /**
     * 
     * @param sucursal
     * @param producto
     * @return 
     */
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

    @GetMapping(path = "/getProductos")
    public List<Producto> getListProductosSucursal(@RequestParam Integer sucursal) {
        try {
            List<Object[]> result = this.productoRpo.getListProductosSucursal(sucursal);
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

    @GetMapping(path = "/getDescuento")
    public VentaProducto getDescuento(@RequestParam String nit) {
        try {
            List<Object[]> result = this.ventaRepo.getDescuento(nit);
            if (!result.isEmpty()) {
                VentaProducto vtn = new VentaProducto();
                vtn.setDescuento((BigDecimal) result.get(0)[0]);
                System.out.println(vtn.getDescuento());
                return vtn;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
