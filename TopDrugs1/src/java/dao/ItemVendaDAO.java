/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import vo.ItemVendaVO;

/**
 *
 * @author miche
 */
public class ItemVendaDAO extends GenericDAO<ItemVendaVO> {
    
    public ItemVendaDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
}
