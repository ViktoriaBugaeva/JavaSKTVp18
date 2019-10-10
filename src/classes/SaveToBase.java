/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class SaveToBase {
    EntityManager em;
    EntityTransaction tx;
    

    public SaveToBase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SKTVp18LibraryPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
    
    
    public void saveBooks(List<Book> listBooks){
        tx.begin();
            for(int i=0; i<listBooks.size();i++){
                if(i==listBooks.size()-1)
                em.persist(listBooks.get(i));
            }
        tx.commit();
    }
    public List<Book> loadBooks(){
        return em.createQuery("SELECT b FROM Book b")
                .getResultList();
    }
    public void saveReaders(List<Reader> listReaders){
        
    }
    public List<Reader> loadReaders(){
        return null;
    }
    void saveHistories(List<History> listHistories) {
        
    }
    List<History> loadHistories() {
        return null;
    }
}