/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class App {
    List<Book> listBooks = new ArrayList<>(); //класс относящийся к коллекции. этот метод описан в BookProvider
    public App() {
        SaveToFile saveToFile = new SaveToFile();
        listBooks = saveToFile.loadBooksFromFile(); 
    }
    
    public void run(){
        Scanner scanner = new Scanner(System.in); //для вводаа данных с клавиатуры
        
        List<Reader> listReaders = new ArrayList<>();
        List<History> listHistories = new ArrayList<>();
        HistoryProvider historyProvider = new HistoryProvider();
        boolean flagExit = true;
        do{
            System.out.println("Список задач:");
            System.out.println("0. Закрыть программу");
            System.out.println("1. Новая книга");
            System.out.println("2. Новый читатель");
            System.out.println("3. Список книг");
            System.out.println("4. Список читателей");
            System.out.println("5. Выдать книгу");
            System.out.println("6. Вернуть книгу");
            System.out.println("Введите номер задачи:");
            String numberTask = scanner.nextLine();
            if(null != numberTask)
            switch (numberTask) {
                case "0":
                    flagExit = false;
                    System.out.println("Заканчиваем работу программы");
                    break;
                case "1":
                    System.out.println("Новая книга.");
                    BookProvider bookProvider = new BookProvider();
                    Book book = bookProvider.createBook();
                    listBooks.add(book);
                    SaveToFile saveToFile = new SaveToFile();
                    saveToFile.saveBooks(listBooks);
                    for(Book b : listBooks){
                       System.out.println(b.toString()); //распечатывает список описанный в методе
                    }
                    break;
                case "2":
                    System.out.println("Новый читатель.");
                    ReaderProvider readerProvider = new ReaderProvider();
                    Reader reader = readerProvider.createReader();
                    listReaders.add(reader);
                    for(Reader r : listReaders){
                       System.out.println(r.toString()); 
                    }
                    break;
                case "3":
                    System.out.println("Список книг библиотеки:");
                    int i = 1;
                    for(Book b : listBooks){
                        System.out.println(i+". "+b.toString());
                        i++;//сколько раз выполниться for, столько раз i++ прибавит
                    }
                    break;
                case "4":
                    System.out.println("Список читателей библиотеки:");
                    for(int j=0;j<listReaders.size();j++){
                        System.out.println(j+1+". "+listReaders.get(j).toString());// так так j=0 начинается с 0, то мы прибавляем 1 "j+1"
                    }
                    break;
                case "5":
                    System.out.println("Выдаем книгу читателю");
                    
                    History history = historyProvider.createHistory(listBooks, listReaders);//создаем историю с помощью historyProvider
                    listHistories.add(history);// в лист хистори добавляем историю
                    break;
                case "6":
                    System.out.println("Возвращение книги");
                    historyProvider.returnBook(listHistories);//в хистори провайдер передаем историю
                    break;
                default:
                    break;
            }
        }while(flagExit);
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
