/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniminuto.logica;

import co.uniminuto.entidades.Inventario;
import co.uniminuto.entidades.Productos;
import com.uniminuto.logica.VO.InventarioVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Miguel
 */
@Stateless
@LocalBean
public class InventarioEJB extends AbstractFacade {

    @PersistenceContext(unitName = "EntidadesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @PostConstruct
    public void init() {

    }

    public List<InventarioVO> getCargueInventario(String zona, String fecha) {
        List<InventarioVO> inventarioVOs = new ArrayList<>();
        System.out.println("Entro EJB " + zona + fecha);
        try {

            String sql = "SELECT cg.id_usuario_vendedor_fk, cg.id_zona_fk, cg.fecha,\n" +
"                    inv.id_cargue_inventario_fk, inv.id_producto_fk, inv.cantidad, pr.nombre\n" +
"                  FROM CARGUE_INVENTARIO cg INNER JOIN INVENTARIO inv \n" +
"                   on cg.id=inv.id_cargue_inventario_fk\n" +
"				   inner join PRODUCTOS pr on pr.id=inv.id_producto_fk\n" +
"                WHERE cg.id_zona_fk = :zona and cg.fecha = :fecha";

            Query query = em.createNativeQuery(sql);
            query.setParameter("zona", zona);
            query.setParameter("fecha", fecha);

            List<Object[]> result = query.getResultList();

            if (result.size() > 0) {
                //recorre los resultados de la consulta
                for (Object[] objects : result) {
                    InventarioVO inventarioVO = new InventarioVO();

                    inventarioVO.setUsuarioRegistrado((int) objects[0]);
                    inventarioVO.setZona((String) objects[1]);
                    inventarioVO.setFecha((String) objects[2]);
                    inventarioVO.setCargueInventario((int) objects[3]);
                    inventarioVO.setProducto((String) objects[4]);
                    inventarioVO.setCantidad((int) objects[5]);
                    inventarioVO.setNombre((String) objects[6]);
                    
                    inventarioVOs.add(inventarioVO);
                }
            }

        } catch (Exception e) {
            System.out.println("Erro al consultar inventario " + e.getMessage());
        }
        System.out.println("Total registros "+ inventarioVOs.size());
        return inventarioVOs;
    }
    
      public Productos getProducto(String id){
         List<Productos> list = new ArrayList<>();
        try {        
           Query query = em.createNamedQuery("Productos.findById").setParameter("id", id);
           list = query.getResultList();
        } catch (Exception e) {
            System.err.println("error al consultar Zonas " + e.getMessage());
        }
        return list.get(0);
    } 

    public void createInventario(InventarioVO inventarioVO) {
        try{
            
           
            
        }catch(Exception e){
            
        }
    }

}
