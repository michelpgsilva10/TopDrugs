/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import dao.FuncionarioDAO;
import dao.PessoaDAO;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import vo.FuncionarioVO;
import vo.PessoaVO;

/**
 *
 * @author michel
 */
public class Principal {
    
    public static void main(String args[]) {
        EntityManagerFactory fabrica = null;
        EntityManager gerenciadorEntidade = null;
        
        try {
            fabrica = Persistence.createEntityManagerFactory("TopDrugs1PU");
            gerenciadorEntidade = fabrica.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        /*FuncionarioVO func = new FuncionarioVO();
        func.setDataAdmissao(new Date(2015, 05, 15));
        func.setFuncao("Vendedor");
        func.setMatricula("0000106");
        func.setSalario(25000.50f);
        func.setNome("Evair Santos");
        func.setBairro("Coxipó");
        func.setCidade("Cuiabá");
        func.setCpf("001.001.001-75");
        func.setDataNascimento(new Date(1964, 1, 28));
        func.setUf("MT");
        func.setDataCadastro(new Date(2015, 9, 1));
        func.setEmail("evair.sant0s@hotmail.com");
        func.setNumero(15);
        
        PessoaVO pess = new PessoaVO();
        pess.setNome("Roberto");
        pess.setBairro("Paiaguás");
        pess.setCidade("Cuiabá");
        pess.setCpf("000.000.000-00");
        pess.setDataNascimento(new Date(1986, 1, 11));
        pess.setUf("MT");
        pess.setEmail("conselheiro.roberto@tce.mt.gov.br");
        pess.setNumero(10);
        
        gerenciadorEntidade.getTransaction().begin();
        gerenciadorEntidade.persist(pess);
        gerenciadorEntidade.persist(func);        
        gerenciadorEntidade.getTransaction().commit();*/
        
        PessoaDAO pessoaDAO = new PessoaDAO(gerenciadorEntidade);
        List<PessoaVO> listaPess = pessoaDAO.getListaClientes();
        
        for (PessoaVO p : listaPess) 
            System.out.println("Nome: " + p.getNome() + " Email: " + p.getEmail());
        
        System.exit(0);
        
    }
    
}
