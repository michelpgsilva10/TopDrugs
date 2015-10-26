/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author miche
 */
public class FabricaEntityManager {
    
    private static EntityManagerFactory entityManagerFactory = null;
    
    private FabricaEntityManager() {
        
    }
    
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("TopDrugs1PU");
    }
    
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    
}
