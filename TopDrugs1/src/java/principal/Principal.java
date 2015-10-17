/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import vo.FuncionarioVO;
import vo.PessoaVO;

/**
 *
 * @author miche
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
        
        FuncionarioVO func = new FuncionarioVO();
        func.setDataAdmissao(new Date(2015, 05, 15));
        func.setFuncao("Gerente");
        func.setMatricula("0000106");
        func.setSalario(25000.50f);
        
        PessoaVO pess = new PessoaVO();
        pess.setNome("Juracy");
        pess.setBairro("CPA");
        pess.setCidade("Cuiabá");
        pess.setCpf("000.000.000-00");
        pess.setDataNascimento(new Date(1986, 1, 11));
        pess.setUf("MT");
        pess.setEmail("procurador-geral.juracy@mp.mt.gov.br");
        pess.setNumero(10);
        
        gerenciadorEntidade.getTransaction().begin();
        gerenciadorEntidade.persist(func);
        gerenciadorEntidade.persist(pess);
        gerenciadorEntidade.getTransaction().commit();
        
        System.exit(0);
        
    }
    
}
