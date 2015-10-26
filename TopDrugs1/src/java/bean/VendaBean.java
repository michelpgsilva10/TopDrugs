/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.FabricaEntityManager;
import dao.VendaDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import vo.VendaVO;

/**
 *
 * @author Roberto
 */
@ManagedBean
@RequestScoped
public class VendaBean implements Serializable{

    
    private VendaVO venda;
    private List<VendaVO> listavenda;
    private VendaDAO vendaDAO;
    /**
     * Creates a new instance of VendaBean
     *
     */
    public VendaBean() {
    }
    
         @PostConstruct
    public void init() {
        vendaDAO = new VendaDAO(FabricaEntityManager.getEntityManager());
        venda = new VendaVO();
    }

    public VendaVO getVenda() {
        return venda;
    }

    public void setVenda(VendaVO venda) {
        this.venda = venda;
    }

    public List<VendaVO> getListavenda() {
        if (listavenda == null)
            return vendaDAO.listarTodos();
        return listavenda;
    }

    public void setListavenda(List<VendaVO> listavenda) {
        this.listavenda = listavenda;
    }

    public VendaDAO getVendaDAO() {
        return vendaDAO;
    }

    public void setVendaDAO(VendaDAO vendaDAO) {
        this.vendaDAO = vendaDAO;
    }
    
    public void salvar() {
        vendaDAO.iniciarTransacao();
        vendaDAO.incluir(venda);
        vendaDAO.confirmarTransacao();
        
        venda = new VendaVO();
    }
    
}
