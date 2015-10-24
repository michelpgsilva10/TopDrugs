/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import vo.FuncionarioVO;

/**
 *
 * @author michel
 */
public class FuncionarioDAO extends GenericDAO<FuncionarioVO> {
    private EntityManager manager;
    public FuncionarioDAO(EntityManager entityManager) {
        super(entityManager);
        this.manager =entityManager;
    }
    
    
    public List<FuncionarioVO> buscar( String nome){
        String sql="Select f from FuncionarioVO f where f.nome LIKE :name";
       return manager.createQuery(sql).setParameter("name","%"+nome+"%").getResultList();
    }
}
