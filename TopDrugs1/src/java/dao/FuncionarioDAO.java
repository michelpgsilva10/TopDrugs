/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import vo.FuncionarioVO;

/**
 *
 * @author michel
 */
public class FuncionarioDAO extends GenericDAO<FuncionarioVO> {
    
    public FuncionarioDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
