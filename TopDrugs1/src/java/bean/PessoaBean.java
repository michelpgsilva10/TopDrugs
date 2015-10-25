/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.FabricaEntityManager;
import dao.PessoaDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import vo.PessoaVO;

/**
 *
 * @author Roberto
 */
@ManagedBean
@SessionScoped
public class PessoaBean implements Serializable{
    
     private PessoaVO pessoa;
     private List<PessoaVO> listaPessoa;
     private List<PessoaVO> listaClientes;
     private PessoaDAO  pessoaDAO;

    /**
     * Creates a new instance of PessoaBean
     */
    public PessoaBean() {
    }
    
    @PostConstruct
    public void init() {
        pessoaDAO = new PessoaDAO(FabricaEntityManager.getEntityManager());
        pessoa = new PessoaVO();
    }

    public PessoaVO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaVO pessoa) {
        this.pessoa = pessoa;
    }

    public List<PessoaVO> getListaPessoa() {
        return listaPessoa;
    }

    public void setListaPessoa(List<PessoaVO> listaPessoa) {
        this.listaPessoa = listaPessoa;
    }

    public PessoaDAO getPessoaDAO() {
        return pessoaDAO;
    }

    public void setPessoaDAO(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }

    public List<PessoaVO> getListaClientes() {
        if (listaClientes == null) 
            return pessoaDAO.getListaClientes();
        return listaClientes;
    }

    public void setListaClientes(List<PessoaVO> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Cadastro de Cliente", "O registro foi incluído com sucesso!"));
        
        pessoaDAO.iniciarTransacao();
        pessoaDAO.incluir(pessoa);
        pessoaDAO.confirmarTransacao();
        
        pessoa = new PessoaVO();
    }
    
    public void alterarCadastro() {
        setPessoa(pessoa);
    }
    
    
}
