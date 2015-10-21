/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import vo.ProdutoVO;

/**
 *
 * @author michel
 */
public class ProdutoDAO extends GenericDAO<ProdutoVO> {
    
    public ProdutoDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
