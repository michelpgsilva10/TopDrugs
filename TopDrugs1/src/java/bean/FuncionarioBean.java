/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.FabricaEntityManager;
import dao.FuncionarioDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import vo.FuncionarioVO;

/**
 *
 * @author michel
 */
@ManagedBean
@RequestScoped
public class FuncionarioBean implements Serializable {

    private FuncionarioVO funcionario;
    private List<FuncionarioVO> listaFuncionarios;
    private FuncionarioDAO funcionarioDAO;
    private String buscaNome;

    /**
     * Creates a new instance of FuncionarioBean
     */
    public FuncionarioBean() {

    }

    @PostConstruct
    public void init() {
        funcionarioDAO = new FuncionarioDAO(FabricaEntityManager.getEntityManager());
        funcionario = new FuncionarioVO();

    }

    public FuncionarioVO getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(FuncionarioVO funcionario) {
        this.funcionario = funcionario;
    }

    public List<FuncionarioVO> getListaFuncionarios() {
        if (listaFuncionarios == null) {
            return funcionarioDAO.listarTodos();
        }

        return listaFuncionarios;
    }

    public void setListaFuncionarios(List<FuncionarioVO> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

    public FuncionarioDAO getFuncionarioDAO() {
        return this.funcionarioDAO;
    }

    public int getID() {
        return this.funcionario.getCodigoPessoa();
    }

    public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    public String getBuscaNome() {
        return buscaNome;
    }

    public void setBuscaNome(String buscaNome) {
        this.buscaNome = buscaNome;
    }

    public void incluir() {
        funcionarioDAO.iniciarTransacao();
        funcionarioDAO.incluir(funcionario);
        funcionarioDAO.confirmarTransacao();
    }

    public void alterar() {
        funcionarioDAO.iniciarTransacao();
        funcionarioDAO.alterar(funcionario);
        funcionarioDAO.confirmarTransacao();
    }

    public void excluir() {
        funcionarioDAO.iniciarTransacao();
        funcionarioDAO.excluir(funcionario);
        funcionarioDAO.confirmarTransacao();
    }
    
        public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage("Cadastro de Funcionario", "O registro foi incluído com sucesso!"));
        
        funcionarioDAO.iniciarTransacao();
        funcionarioDAO.excluir(funcionario);
        funcionarioDAO.confirmarTransacao();
        
        funcionario = new FuncionarioVO();
    }

    public void buscar() {
        setListaFuncionarios(funcionarioDAO.buscar(buscaNome));

    }

    public void limparDadosFuncionario() {

        funcionario.setDataAdmissao(null);
        funcionario.setFuncao("");
        funcionario.setMatricula("");
        funcionario.setSalario(0);
        funcionario.setNome("");
        funcionario.setCpf("");
        funcionario.setDataNascimento(null);
        funcionario.setDataCadastro(null);
        funcionario.setEmail("");

    }

}
