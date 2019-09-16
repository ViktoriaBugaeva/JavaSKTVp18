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
import java.util.Scanner;

/**
 *
 * @author User
 */
public class App {

    public App() {
    }
      
    public void run(){
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do{
            
            System.out.println("Список задач:");
            System.out.println("0. Закрыть программу");
            System.out.println("1. Новая книга");
            System.out.println("2. Новый читатель");
            System.out.println("3. Список книг");
            System.out.println("4. Список читателей");
            System.out.println("5. Выдать книгу");
            System.out.println("6. Вернуть книгу");
            System.out.println("Введите номер задачи"); 
            String numberTask = scanner.nextLine();
            if("0".equals(numberTask)){
                flag = false;
            System.out.println("Заканчиваем работу программы");
            }else if("1".equals(numberTask)){
            System.out.println("Выполняем 1 задачу");
            }else if("2".equals(numberTask)){
            System.out.println("Выполняем 2 задачу");
            }else if("3".equals(numberTask)){
            System.out.println("Выполняем 3 задачу");
            }else if("4".equals(numberTask)){
            System.out.println("Выполняем 4 задачу");
            }else if("5".equals(numberTask)){
            System.out.println("Выполняем 5 задачу");
            }else if("6".equals(numberTask)){
            System.out.println("Выполняем 6 задачу");
            }
        }while(flag);
//        System.out.println("Привет!");
//        Book book = new Book();
//        book.setTitle("War and Peace");
//        book.setAuthor("Lev Tolstoy");
//        book.setYear(2010);  
//        System.out.println(book.toString());
//        book.setYear(2011);
//        System.out.println(book.getTitle());
//        System.out.println(book.getYear());
//        Reader reader = new Reader();
//        reader.setName("Sergey");
//        reader.setLastname("Smirnov");
//        reader.setEmail("sergey.smirnov@gmail.com");
//        System.out.println(reader.toString());
//        System.out.println(reader.getName());
//        System.out.println(reader.getLastname());
//        System.out.println(reader.getEmail());
//        History history = new History();
//        history.setBook(book);
//        history.setReader(reader);
//        history.setTakeOn(new Date());
//        System.out.println("Выдана книга:"+history.toString());
//        history.setReturnDate(new Date());
//        System.out.println("Книга возвращена: "+history.toString());
//        Book book1 = new Book();
//        book1.setTitle("War");
//        book1.setAuthor("Lev");
//        book1.setYear(2016); 
//        System.out.println(book.toString());


    }
    
}
