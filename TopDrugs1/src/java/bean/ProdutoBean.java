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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
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
     private String buscaNome;
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
        if(listaproduto == null)
            return produtoDAO.listarTodos();
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

    public String getBuscaNome() {
        return buscaNome;
    }

    public void setBuscaNome(String buscaNome) {
        this.buscaNome = buscaNome;
    }
    
     public void salvar(){
                 FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Cadastro de Produto", "O registro foi incluído com sucesso!"));
           produtoDAO.iniciarTransacao();
           produtoDAO.incluir(produto);
           produtoDAO.confirmarTransacao();        
           }
         public void excluir(){
           produtoDAO.iniciarTransacao();
           produtoDAO.excluir(produto);
           produtoDAO.confirmarTransacao();
           produto = new ProdutoVO();
       }
         
       public void limparDadosProduto(){
           produto.setCodBarra("");
           produto.setDataValidade(null);
           produto.setFabricante("");
           produto.setPreco(0);
           produto.setNome("");
           produto.setQtdeMax(0);
           produto.setQtdeMin(0);
           produto.setTipo("");
           produto.setLote("");
       }  
        public void buscar(){
    
           setListaproduto(produtoDAO.buscar(buscaNome));
           
           
       }
    
    
}
