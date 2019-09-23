/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class BookProvider {
    public Book createBook(){
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Название книги: ");
        book.setTitle(scanner.nextLine());// сканер считает и вернет то что мы ввели с клавиатуры
        System.out.println("Автор книги: ");
        book.setAuthor(scanner.nextLine());
        System.out.println("Год издания книги: ");
        book.setYear(new Integer(scanner.nextLine()));
    return book;//всегда должен присутствовать, чтобы вернуть объект этого класса
    } 
}
