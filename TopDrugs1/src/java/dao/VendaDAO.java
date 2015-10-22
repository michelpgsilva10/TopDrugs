/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import vo.VendaVO;

/**
 *
 * @author Roberto
 */
public class VendaDAO extends GenericDAO<VendaVO> {
    
    public VendaDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}
