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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
    
    
}
