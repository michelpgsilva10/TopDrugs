/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author miche
 */
public class GenericDAO<VO> {
    private Class<VO> persistentClass;
    private EntityManager entityManager;
    
    public GenericDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.persistentClass = (Class<VO>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];        
    }
    
    public void incluir(VO vo) {
        this.entityManager.persist(vo);
    }
    
    public void excluir(VO vo) {
        this.entityManager.remove(vo);
    }
    
    public void alterar(VO vo) {
        this.entityManager.merge(vo);
    }
    
    public void iniciarTransacao() {
        this.entityManager.getTransaction().begin();
    }
    
    public void confirmarTransacao() {
        this.entityManager.getTransaction().commit();
    }
    
    public void cancelarTransacao() {
        this.entityManager.getTransaction().rollback();
    }
    
    public List<VO> listarTodos() {
        return this.entityManager.createQuery("Select c From " + persistentClass.getSimpleName() + " c").getResultList();
    }
}
