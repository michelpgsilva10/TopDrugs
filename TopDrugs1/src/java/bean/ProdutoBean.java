/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.FabricaEntityManager;
import dao.ProdutoDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import vo.ProdutoVO;

/**
 *
 * @author Roberto
 */
@ManagedBean
@RequestScoped
public class ProdutoBean implements Serializable  {

     private ProdutoVO produto;
     private List<ProdutoVO> listaproduto;
     private ProdutoDAO produtoDAO;
    /**
     * Creates a new instance of ProdutoBean
     */
    public ProdutoBean() {
    }
        @PostConstruct
    public void init() {
        produtoDAO = new ProdutoDAO(FabricaEntityManager.getEntityManager());
        produto = new ProdutoVO();
    }

    public ProdutoVO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoVO produto) {
        this.produto = produto;
    }

    public List<ProdutoVO> getListaproduto() {
        return listaproduto;
    }

    public void setListaproduto(List<ProdutoVO> listaproduto) {
        this.listaproduto = listaproduto;
    }

    public ProdutoDAO getProdutoDAO() {
        return produtoDAO;
    }

    public void setProdutoDAO(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }
    
    
}
