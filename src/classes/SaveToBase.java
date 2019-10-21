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
        List<Book> listBooksSaved = loadBooks();
        
        for(int i=0; i<listBooks.size();i++){
            if(listBooksSaved.contains(listBooks.get(i))
                    && !listBooksSaved.get(i).equals(listBooks.get(i))){
                tx.begin();
                em.merge(listBooks.get(i));
                tx.commit();
            }else if(listBooks.get(i).getId() == null){
                tx.begin();
                em.persist(listBooks.get(i));
                tx.commit();
            }else{
                continue;
            }
        }
    }
    public List<Book> loadBooks(){
        return em.createQuery("SELECT b FROM Book b")
                .getResultList();
    }
    public void saveReaders(List<Reader> listReaders){
        List<Reader> listReadersSaved = loadReaders();
        
        for(int i=0; i<listReaders.size();i++){
            if(listReadersSaved.contains(listReaders.get(i))
                    && !listReadersSaved.get(i).equals(listReaders.get(i))){
                tx.begin();
                em.merge(listReaders.get(i));
                tx.commit();
            }else if(listReaders.get(i).getId()==null){
                tx.begin();
                em.persist(listReaders.get(i));
                tx.commit();
            }else{
                continue;
            }
        }
        
    }
    public List<Reader> loadReaders(){
        return em.createQuery("SELECT r FROM Reader r")
                .getResultList();
    }
    void saveHistories(List<History> listHistories) {
        for(History delHistory : listHistories){
            int flag = 0;
            for(int i=0;i<listHistories.size();i++){
                if(delHistory.getReader().equals(listHistories.get(i).getReader())){
                    if(delHistory.getBook().getId() == listHistories.get(i).getBook().getId()){
                        flag++;
                    }
                    if(flag >1){
                        listHistories.get(i).getBook().setCount(listHistories.get(i).getBook().getCount()+1);
                        listHistories.remove(listHistories.get(i));
                        System.out.println("Эту книгу читатель уже читал");
                        break;
                    }
                }
            }
            if(flag > 1) break;
        }
        List<History> listHistoriesSaved = loadHistories();
        History newHistory = null;
        History editHistory = null;
        History returnHistory = null;
        int i = 0;
        for(History h : listHistories){
            if(!listHistoriesSaved.contains(h) && h.getId() == null){
                newHistory = h;
                break;
            }
            if(listHistoriesSaved.contains(h) && !listHistoriesSaved.get(i).equals(h)){
                editHistory = h;
                break;
            }
            if(listHistoriesSaved.get(i).getId() == h.getId()
                    && listHistoriesSaved.get(i).getReturnDate() == null && h.getReturnDate()!=null){
                returnHistory = h;
                break;
            }
            i++;
        }
        if(newHistory != null){
            tx.begin();
            em.persist(newHistory);
            em.flush();
            em.merge(newHistory.getBook());
            tx.commit();
        }
        if(editHistory != null){
            tx.begin();
            em.merge(editHistory);
            em.merge(editHistory.getBook());
            tx.commit();
        }
        if(returnHistory != null){
            tx.begin();
            em.merge(returnHistory);
            em.flush();
            em.merge(returnHistory.getBook());
            tx.commit();
        }
    }
    List<History> loadHistories() {
        return em.createQuery("SELECT h FROM History h")
                .getResultList();
    }
}





/*package classes;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
 
public class SaveToBase {

    EntityManager em;
    EntityTransaction tx;

    public SaveToBase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SKTVp18LibraryPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    public void saveBooks(List<Book> listBooks) {
        tx.begin();
        for (int i = 0; i < listBooks.size(); i++) {
            if (i == listBooks.size() - 1) {
                em.persist(listBooks.get(i));
            }
        }
        tx.commit();
    }

    public List<Book> loadBooks() {
        return em.createQuery("SELECT b FROM Book b")
                    .getResultList();
    }

    public void saveReaders(List<Reader> listReaders) {
        tx.begin();
        for (int i = 0; i < listReaders.size(); i++) {
            if (i == listReaders.size() - 1) {
                em.persist(listReaders.get(i));
            }
        }
        tx.commit();
    }

    public List<Reader> loadReaders() {
        return em.createQuery("SELECT r FROM Reader r")
                    .getResultList();
    }

    void saveHistories(List<History> listHistories) {
        List<History> listHistoriesSaved = loadHistories();
        tx.begin();
        for (int i = 0; i < listHistories.size(); i++) {
            if (listHistoriesSaved.contains(listHistories.get(i)) && !listHistories.get(i).equals(listHistoriesSaved.get(i))) {
                em.merge(listHistories.get(i));
            } else {
                em.persist(listHistories.get(i));
            }
        }
        tx.commit();
    }

    List<History> loadHistories() {
        return em.createQuery("SELECT h FROM History h")
                    .getResultList();
    }
} */