/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.List;

/**
 *
 * @author User
 */
public interface Saveble {
    public void saveBooks(List<Book> listBooks);
    public List<Book> loadBooks();
    public void saveReaders(List<Reader> listReaders);
    public List<Reader> loadReaders();
    public void saveHistories(List<History> listHistories);
    public List<History> loadHistories();
    
}
