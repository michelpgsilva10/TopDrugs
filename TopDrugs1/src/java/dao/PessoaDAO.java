/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import vo.PessoaVO;

/**
 *
 * @author michel
 */
public class PessoaDAO extends GenericDAO<PessoaVO> {

    private EntityManager entityManager;

    public PessoaDAO(EntityManager entityManager) {
        super(entityManager);
        this.entityManager = entityManager;
    }

    public List<PessoaVO> getListaClientes() {
        return entityManager.createQuery("Select c From PessoaVO c Where c.codigoPessoa not in "
                + "(Select f.codigoPessoa From FuncionarioVO f)").getResultList();
    }

}
