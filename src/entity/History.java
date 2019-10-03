/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author user
 */
public class History implements Serializable{
    private Book book;
    private Reader reader;
    private Date takeOn;
    private Date returnDate;

    public History() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getTakeOn() {
        return takeOn;
    }

    public void setTakeOn(Date takeOn) {
        this.takeOn = takeOn;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "History{" + "book=" + book + ", reader=" + reader + ", takeOn=" + takeOn + ", returnDate=" + returnDate + '}';
    }
    
}

/*package entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author user
 */
/*public class History implements Serializable {

    private Book book;
    private Reader reader;
    private Date takeOn;
    private Date returnDate;

    public History() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getTakeOn() {
        return takeOn;
    }

    public void setTakeOn(Date takeOn) {
        this.takeOn = takeOn;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "History{" + "book=" + book + ", reader=" + reader + ", takeOn=" + takeOn + ", returnDate=" + returnDate + '}';
    }

    public Object getReturnBook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}*/
