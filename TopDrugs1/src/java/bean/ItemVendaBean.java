/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.FabricaEntityManager;
import dao.ItemVendaDAO;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import vo.ItemVendaVO;

/**
 *
 * @author miche
 */
@ManagedBean
@RequestScoped
public class ItemVendaBean {
    
    private ItemVendaVO itemVenda;
    private List<ItemVendaVO> listaItemVenda;
    private ItemVendaDAO itemVendaDAO;

    /**
     * Creates a new instance of ItemVendaBean
     */
    public ItemVendaBean() {
        
    }
    
    @PostConstruct
    public void init() {
        itemVendaDAO = new ItemVendaDAO(FabricaEntityManager.getEntityManager());
        itemVenda = new ItemVendaVO();
    }

    public ItemVendaVO getItemVenda() {
        return itemVenda;
    }

    public void setItemVenda(ItemVendaVO itemVenda) {
        this.itemVenda = itemVenda;
    }

    public List<ItemVendaVO> getListaItemVenda() {
        if (listaItemVenda == null)
            return itemVendaDAO.listarTodos();
        return listaItemVenda;
    }

    public void setListaItemVenda(List<ItemVendaVO> listaItemVenda) {
        this.listaItemVenda = listaItemVenda;
    }

    public ItemVendaDAO getItemVendaDAO() {
        return itemVendaDAO;
    }

    public void setItemVendaDAO(ItemVendaDAO itemVendaDAO) {
        this.itemVendaDAO = itemVendaDAO;
    }
    
    
    
}
