/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.controladores;

import co.uniminuto.entidades.CargueInventario;
import co.uniminuto.entidades.Productos;
import co.uniminuto.entidades.UsuarioRegistrado;
import co.uniminuto.entidades.Zona;
import co.uniminuto.logica.GeneralEJB;
import co.uniminuto.logica.InventarioEJB;
import com.uniminuto.logica.VO.InventarioVO;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.behavior.validate.ClientValidator;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Miguel
 */
@Named(value = "InventarioMB")
@ViewScoped
public class InventarioMB implements Serializable {

    private int cantidad;
    private Productos productos;
    private CargueInventario cargueInventario;
    private List<Zona> Listzona = new ArrayList<>();
    private Zona zona;
    private String idZona;
    private Map<String, Zona> zonasMap = new LinkedHashMap<>();
    private Date fecha;
    private String fechaFormat;
    private UsuarioRegistrado vendedor;
    private List<InventarioVO> cargueInventarios;
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    InventarioVO car2Add;
    @EJB
    GeneralEJB generalEJB;

    @EJB
    InventarioEJB inventarioEJB;

    public InventarioMB() {
    }

    @PostConstruct
    public void init() {

       
        Date date = new Date();
        cargueInventarios = new ArrayList<>();
        try {
            Listzona = generalEJB.getZonas();
            System.out.println("Zonas " + Listzona.size());
            if (!Listzona.isEmpty()) {
                for (Zona zona1 : Listzona) {
                    System.out.println("Fecha " + zona1.getId());
                    zonasMap.put(zona1.getId(), zona1);
                }
            }
           
            fechaFormat = formatter.format(date);
            fecha = date;
        } catch (Exception e) {
               System.out.println("Errro en init " + e.getMessage());
        }

    }
    
    public void recalcualarFecha(SelectEvent<Date> event){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        fecha = new Date(formatter.format(event.getObject()));
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", formatter.format(event.getObject())));
    
    }
    
    public void consultaUsuarioVendedor(){
        try{
            System.out.println("Zona " + zona);
            vendedor = generalEJB.getVendedores(zona.getIdVendedorFk().getId()).get(0);
        }catch(Exception e){
            System.out.println("Error al consultar vendedor " + e.getMessage());
        }
    }

    public void ingresarProductoInventario() {

    }
    
    public void onAddNew() {
        // Add one new car to the table:
        car2Add = new InventarioVO();
        car2Add.setProducto("producto");
        car2Add.setCantidad(0);
        car2Add.setNombre("nombre");
              
        cargueInventarios.add(car2Add);
        FacesMessage msg = new FacesMessage("New pro", car2Add.getProducto());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
     public void onRowEdit(RowEditEvent<InventarioVO> event) {
        
        InventarioVO inventarioVO = event.getObject();
       
        
        inventarioEJB.createInventario(inventarioVO);
        
        System.out.println("Valores in" + inventarioVO.getNombre() + inventarioVO.getProducto() + inventarioVO.getCantidad());
        FacesMessage msg = new FacesMessage("Car Edited", event.getObject().getProducto());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent<InventarioVO> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().getProducto());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
     public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public void updateNombre(String id){
        
        Productos prod = inventarioEJB.getProducto(id);       
        car2Add.setNombre(prod.getNombre());
    }

    public void buscarInventario() {
        
        System.out.println("Fecha " + fecha.toString() );//+ " " + zona.getId());
        try{
      
        String fechaParameter = formatter.format(fecha);
            System.out.println("FEcha " + fechaParameter);
       
            cargueInventarios = inventarioEJB.getCargueInventario("22632", "19-05-2020");
        
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        

    }

//    public void insertProduct() {
//
//        Productos productosVO = new Productos();
//
//        productosVO.setId(codigo);
//        System.out.println("codigo " + codigo);
//        productosVO.setNombre(nombreProducto);
//        System.out.println("nombre " + nombreProducto);
//        productosVO.setIva(IVA);
//        System.out.println("iva " + IVA);
//        productosVO.setPrecio(precio);
//        productosVO.setEmbalaje(embalaje);
//
//        System.out.println("valores " + productosVO.toString());
//        if (productosVO.getId() != null) {
//            generalEJB.create(productosVO);
//            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Producto Registrado");
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//        } else {
//            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo guardar Producto");
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//        }
//
//    }

    public UsuarioRegistrado getVendedor() {
        return vendedor;
    }

    public void setVendedor(UsuarioRegistrado vendedor) {
        this.vendedor = vendedor;
    }
    
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Productos getProductos() {
        return productos;
    }

    public String getIdZona() {
        return idZona;
    }

    public void setIdZona(String idZona) {
        this.idZona = idZona;
    }
    
    
    
    public List<InventarioVO> getCargueInventarios() {
        return cargueInventarios;
    }

    public void setCargueInventarios(List<InventarioVO> cargueInventarios) {
        this.cargueInventarios = cargueInventarios;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public CargueInventario getCargueInventario() {
        return cargueInventario;
    }

    public void setCargueInventario(CargueInventario cargueInventario) {
        this.cargueInventario = cargueInventario;
    }

    public List<Zona> getListzona() {
        return Listzona;
    }

    public void setListzona(List<Zona> Listzona) {
        this.Listzona = Listzona;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFechaFormat() {
        return fechaFormat;
    }

    public void setFechaFormat(String fechaFormat) {
        this.fechaFormat = fechaFormat;
    }

   

    public GeneralEJB getGeneralEJB() {
        return generalEJB;
    }

    public void setGeneralEJB(GeneralEJB generalEJB) {
        this.generalEJB = generalEJB;
    }

    public InventarioEJB getInventarioEJB() {
        return inventarioEJB;
    }

    public void setInventarioEJB(InventarioEJB inventarioEJB) {
        this.inventarioEJB = inventarioEJB;
    }

    public Map<String, Zona> getZonasMap() {
        return zonasMap;
    }

    public void setZonasMap(Map<String, Zona> zonasMap) {
        this.zonasMap = zonasMap;
    }
    
    

}
