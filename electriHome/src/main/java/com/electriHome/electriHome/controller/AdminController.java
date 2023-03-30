package com.electriHome.electriHome.controller;

import com.electriHome.electriHome.encript.Encript;
import com.electriHome.electriHome.models.admin.BodegaEmpleado;
import com.electriHome.electriHome.models.admin.Cargo;
import com.electriHome.electriHome.models.admin.CargoEmpleado;
import com.electriHome.electriHome.models.admin.ClienteReport;
import com.electriHome.electriHome.models.admin.EmpleadoEnty;
import com.electriHome.electriHome.models.admin.EmpleadoReport;
import com.electriHome.electriHome.models.admin.ProductoReport;
import com.electriHome.electriHome.models.admin.SucursalEmpleado;
import com.electriHome.electriHome.models.admin.SucursalReport;
import com.electriHome.electriHome.models.empleados.Empleado;
import com.electriHome.electriHome.respositories.adminRpo.BodegaEmpleadoRepository;
import com.electriHome.electriHome.respositories.adminRpo.CargoEmpleadoRepository;
import com.electriHome.electriHome.respositories.adminRpo.CargoRepository;
import com.electriHome.electriHome.respositories.adminRpo.ClienteReportRepository;
import com.electriHome.electriHome.respositories.adminRpo.EmpleadoEntyRepository;
import com.electriHome.electriHome.respositories.adminRpo.EmpleadoReportRepository;
import com.electriHome.electriHome.respositories.adminRpo.ProductoReportRepository;
import com.electriHome.electriHome.respositories.adminRpo.SucursalEmpleadoRepository;
import com.electriHome.electriHome.respositories.adminRpo.SucursalReportRepository;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/Electronic-Home/administracion")
public class AdminController {

    private final Encript encript = new Encript();

    @Autowired
    CargoRepository cargoRepository;

    @Autowired
    EmpleadoEntyRepository empleadoEntyRepository;

    @Autowired
    CargoEmpleadoRepository cargoEmpleadoRepository;

    @Autowired
    SucursalEmpleadoRepository sucursalEmpleadoRepository;

    @Autowired
    BodegaEmpleadoRepository bodegaEmpleadoRepository;

    @Autowired
    ClienteReportRepository clienteReportRepository;
    
    @Autowired
    EmpleadoReportRepository empleadoReportRepository;
    
    @Autowired
    ProductoReportRepository productoReportRepository;
    
    @Autowired
    SucursalReportRepository supeReportRepository;
    
    /**
     * peticion get para cargos existentes para los empleados
     * @return 
     */
    @GetMapping(path = "/getCargos")
    public List<Cargo> getListProductosSucursal() {
        try {
            return cargoRepository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /**
     * obtiene los clientes para el reporte de clientes mas ganancias
     * @return 
     */
    @GetMapping(path = "/getClientesReport")
    public List<ClienteReport> getRportClientes() {
        try {
           List<Object[]> result = this.clienteReportRepository.getClientesReport();
            if (!result.isEmpty()) {
                List<ClienteReport> clientes = new ArrayList<>();
                for (Object[] obj : result) {
                    ClienteReport tmp = new ClienteReport();
                    tmp.setNitCliente((String)obj[0]);
                    tmp.setNombre((String)obj[1]);
                    tmp.setApellido((String)obj[2]);
                    tmp.setGanacia((BigDecimal)obj[3]);
                    tmp.setProductos((BigInteger)obj[4]);
                    clientes.add(tmp);
                }
                return clientes;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    /**
     * 
     * @return top empleados con mas ventas
     */
    @GetMapping(path = "/getEmpleadoReportMasVenta")
    public List<EmpleadoReport> getEmpleadoMasVentas(){
         try {
           List<Object[]> result = this.empleadoReportRepository.getEmpleadoMasVentas();
            if (!result.isEmpty()) {
                List<EmpleadoReport> empleados = new ArrayList<>();
                for (Object[] obj : result) {
                    EmpleadoReport emp = new EmpleadoReport();
                    emp.setCuiEmpleado((String)obj[0]);
                    emp.setNombre((String)obj[1]);
                    emp.setApellido((String)obj[2]);
                    emp.setProductos((BigInteger)obj[3]);
                    empleados.add(emp);
                }
                return empleados;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /**
     * 
     * @return top empleados mas ingresos
     */
    @GetMapping(path = "/getEmpleadoReportMasIngresos")
    public List<EmpleadoReport> getEmpleadoReportMasIngresos(){
         try {
           List<Object[]> result = this.empleadoReportRepository.getEmpleadoMasIngresos();
            if (!result.isEmpty()) {
                List<EmpleadoReport> empleados = new ArrayList<>();
                for (Object[] obj : result) {
                    EmpleadoReport emp = new EmpleadoReport();
                    emp.setCuiEmpleado((String)obj[0]);
                    emp.setNombre((String)obj[1]);
                    emp.setApellido((String)obj[2]);
                    emp.setGanancia((BigDecimal)obj[3]);
                    empleados.add(emp);
                }
                return empleados;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /**
     * 
     * @return productos mas vendidos
     */
    @GetMapping(path = "/getProductoMasVendido")
    public List<ProductoReport> getProductoMasVendido(){
         try {
           List<Object[]> result = this.productoReportRepository.getProductoMasVendido();
            if (!result.isEmpty()) {
                List<ProductoReport> prodcutos = new ArrayList<>();
                for (Object[] obj : result) {
                    ProductoReport tem = new ProductoReport();
                    tem.setCodigo((String)obj[0]);
                    tem.setNombre((String)obj[1]);
                    tem.setPrecio((BigDecimal)obj[2]);
                    tem.setMarca((String)obj[3]);
                    tem.setVecesVendida((BigInteger)obj[4]);
                    prodcutos.add(tem);
                }
                return prodcutos;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /**
     * 
     * @return productos con mas ingresos 
     */
    @GetMapping(path = "/getProductoMasIngreso")
    public List<ProductoReport> getProductoMasIngresos(){
         try {
           List<Object[]> result = this.productoReportRepository.getProductoMasIngresos();
            if (!result.isEmpty()) {
                List<ProductoReport> prodcutos = new ArrayList<>();
                for (Object[] obj : result) {
                    ProductoReport tem = new ProductoReport();
                    tem.setCodigo((String)obj[0]);
                    tem.setNombre((String)obj[1]);
                    tem.setPrecio((BigDecimal)obj[2]);
                    tem.setMarca((String)obj[3]);
                    tem.setIngresos((BigDecimal)obj[4]);
                    prodcutos.add(tem);
                }
                return prodcutos;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    
    /**
     * 
     * @param sucursal
     * @return producto mas vendido por cada sucursal
     */
    @GetMapping(path = "/getProductoMasVendidoSucural")
    public List<ProductoReport> getProductoMasVendidoSucursal(@RequestParam Integer sucursal){
         try {
           List<Object[]> result = this.productoReportRepository.getProductoMasVendidoSucursal(sucursal);
            if (!result.isEmpty()) {
                List<ProductoReport> prodcutos = new ArrayList<>();
                for (Object[] obj : result) {
                    ProductoReport tem = new ProductoReport();
                    tem.setCodigo((String)obj[0]);
                    tem.setNombre((String)obj[1]);
                    tem.setPrecio((BigDecimal)obj[2]);
                    tem.setMarca((String)obj[3]);
                    tem.setVecesVendida((BigInteger)obj[4]);
                    prodcutos.add(tem);
                }
                return prodcutos;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    
    /**
     * 
     * @param sucursal codigo de sucursal para el reporte
     * @return productos con mas ingresos de cada sucural
     */
    @GetMapping(path = "/getProductoMasIngresoSucursal")
    public List<ProductoReport> getProductoMasIngresosSucursal(@RequestParam Integer sucursal){
         try {
           List<Object[]> result = this.productoReportRepository.getProductoMasIngresoSucursal(sucursal);
            if (!result.isEmpty()) {
                List<ProductoReport> prodcutos = new ArrayList<>();
                for (Object[] obj : result) {
                    ProductoReport tem = new ProductoReport();
                    tem.setCodigo((String)obj[0]);
                    tem.setNombre((String)obj[1]);
                    tem.setPrecio((BigDecimal)obj[2]);
                    tem.setMarca((String)obj[3]);
                    tem.setIngresos((BigDecimal)obj[4]);
                    prodcutos.add(tem);
                }
                return prodcutos;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    
    /**
     * 
     * @return top de las sucursales con mas ventas
     */
    @GetMapping(path = "/getSucursalMasVentas")
    public List<SucursalReport> getSucursalMasVenta(){
         try {
           List<Object[]> result = this.supeReportRepository.getSucursalMasVentas();
            if (!result.isEmpty()) {
                List<SucursalReport> sucusal = new ArrayList<>();
                for (Object[] obj : result) {
                    SucursalReport tem = new SucursalReport();
                    tem.setNombre((String)obj[0]);
                    tem.setTotalVentas((BigInteger)obj[1]);
                    sucusal.add(tem);
                }
                return sucusal;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    
    /**
     * 
     * @return sucursales con mas ingresos
     */
    @GetMapping(path = "/getSucursalMasIngresos")
    public List<SucursalReport> getSucursalMasIngresos(){
         try {
           List<Object[]> result = this.supeReportRepository.getSucursalMasIngresos();
            if (!result.isEmpty()) {
                List<SucursalReport> sucusal = new ArrayList<>();
                for (Object[] obj : result) {
                    SucursalReport tem = new SucursalReport();
                    tem.setNombre((String)obj[0]);
                   tem.setTotalIngresos((BigDecimal)obj[1]);
                    sucusal.add(tem);
                }
                return sucusal;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /**
     * 
     * @param empleado guarda al nuevo empleado
     * @return 
     */
    @PostMapping(path = "/saveEmpleado")
    public Empleado saveEmpleado(@RequestBody Empleado empleado) {
        try {
            if (saveTableEmpleado(empleado) && saveCargoEmpleado(empleado)) {
                if (empleado.getCodigoSucursal() == 10) {
                    //guardar en bodega
                    if (this.guardarBodega(empleado)) {
                        return empleado;
                    }
                } else {
                    //guardar en sucursal
                    if (this.guardarSucursal(empleado)) {
                        return empleado;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    /**
     * guarda al empleado en la tabla empleado
     * @param empleado
     * @return 
     */
    private boolean saveTableEmpleado(Empleado empleado) {
        EmpleadoEnty emp = new EmpleadoEnty();
        emp.setApellido(empleado.getApellido());
        emp.setNombre(empleado.getNombre());
        emp.setCui(empleado.getCui());
        emp.setPassworde(this.encript.ecnode(empleado.getPassworde()));
        emp.setSalario(empleado.getSalario());
        return null != this.empleadoEntyRepository.save(emp);
    }

    /**
     * guarda el cargo asignado al empelado 
     * @param empleado
     * @return 
     */
    private boolean saveCargoEmpleado(Empleado empleado) {
        CargoEmpleado cargoEmp = new CargoEmpleado();
        cargoEmp.setCodigoCargo(empleado.getTipoCargo() + 0);
        cargoEmp.setCuiEmpleado(empleado.getCui());
        return null != this.cargoEmpleadoRepository.save(cargoEmp);
    }

    /**
     * guarda al empleado en la sucursal donde trabajara
     * @param empleado
     * @return 
     */
    private boolean guardarSucursal(Empleado empleado) {
        SucursalEmpleado sucurEmp = new SucursalEmpleado();
        sucurEmp.setCodigoSucursal(empleado.getCodigoSucursal());
        sucurEmp.setCuiEmpleado(empleado.getCui());
        return null != this.sucursalEmpleadoRepository.save(sucurEmp);
    }

    /**
     * si el empleado es de bodega lo guarda en bodega
     * @param empleado
     * @return 
     */
    private boolean guardarBodega(Empleado empleado) {
        BodegaEmpleado bodegEmpl = new BodegaEmpleado();
        bodegEmpl.setCodigoBodega(1);
        bodegEmpl.setCuiEmpleado(empleado.getCui());
        return null != this.bodegaEmpleadoRepository.save(bodegEmpl);
    }
}
