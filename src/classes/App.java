/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Date;

/**
 *
 * @author User
 */
public class App {
    public void run(){
        System.out.println("Привет!");
        Book book = new Book();
        book.setTitle("War and Peace");
        book.setAuthor("Lev Tolstoy");
        book.setYear(2010);  
        System.out.println(book.toString());
        book.setYear(2011);
        System.out.println(book.getTitle());
        System.out.println(book.getYear());
        Reader reader = new Reader();
        reader.setName("Sergey");
        reader.setLastname("Smirnov");
        reader.setEmail("sergey.smirnov@gmail.com");
        System.out.println(reader.toString());
        System.out.println(reader.getName());
        System.out.println(reader.getLastname());
        System.out.println(reader.getEmail());
        History history = new History();
        history.setBook(book);
        history.setReader(reader);
        history.setTakeOn(new Date());
        System.out.println("Выдана книга:"+history.toString());
        
    }
    
}
