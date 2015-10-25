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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import vo.PessoaVO;

/**
 *
 * @author Roberto
 */
@ManagedBean
@RequestScoped
public class PessoaBean implements Serializable{
    
     private PessoaVO pessoa;
     private List<PessoaVO> listaPessoa;
     private List<PessoaVO> listaClientes;
     private PessoaDAO  pessoaDAO;
     private String buscaNome;

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

    public String getBuscaNome() {
        return buscaNome;
    }

    public void setBuscaNome(String buscaNome) {
        this.buscaNome = buscaNome;
    }   
    
    public void buscarClientesPorNome() {
        setListaClientes(pessoaDAO.getClientesPorNome(buscaNome));
    }
    
    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Cadastro de Cliente", "O registro foi incluído com sucesso!"));
        
        pessoaDAO.iniciarTransacao();
        pessoaDAO.incluir(pessoa);
        pessoaDAO.confirmarTransacao();
        
        pessoa = new PessoaVO();
    }
    
    public void excluir() {
        pessoaDAO.iniciarTransacao();
        pessoaDAO.excluir(pessoa);
        pessoaDAO.confirmarTransacao();
    }
    
    public void limparDadosCliente() {
        pessoa.setBairro("");
        pessoa.setCidade("");
        pessoa.setComplemento("");
        pessoa.setCpf("");
        pessoa.setDataCadastro(null);
        pessoa.setEmail("");
        pessoa.setLocalDeTrabalho("");
        pessoa.setNome("");
        pessoa.setNumero(0);
        pessoa.setRua("");
        pessoa.setUf("");
    }
    
}
