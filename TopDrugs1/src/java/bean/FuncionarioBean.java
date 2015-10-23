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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import vo.FuncionarioVO;

/**
 *
 * @author michel
 */
@ManagedBean
@ApplicationScoped
public class FuncionarioBean implements Serializable {

    private FuncionarioVO funcionario;
    private List<FuncionarioVO> listaFuncionarios;
    private FuncionarioDAO funcionarioDAO;
    
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
        if (listaFuncionarios == null) 
            return funcionarioDAO.listarTodos();
        
        return listaFuncionarios;
    }
    
    public void setListaFuncionarios(List<FuncionarioVO> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }
    
    public FuncionarioDAO getFuncionarioDAO() {
        return this.funcionarioDAO;
    }
    
    public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }
       public void salvar(){
           funcionarioDAO.iniciarTransacao();
           funcionarioDAO.incluir(funcionario);
           funcionarioDAO.confirmarTransacao();        
           }
   }
   

