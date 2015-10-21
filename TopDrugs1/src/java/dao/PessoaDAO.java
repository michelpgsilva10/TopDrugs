/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import vo.PessoaVO;

/**
 *
 * @author michel
 */
public class PessoaDAO extends GenericDAO<PessoaVO> {
    
    public PessoaDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}
