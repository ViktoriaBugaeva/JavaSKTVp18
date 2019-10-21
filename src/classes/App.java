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
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class App {
    List<Book> listBooks = new ArrayList<>();
    List<Reader> listReaders = new ArrayList<>();
    List<History> listHistories = new ArrayList<>();
    public App() {
        SaveToBase saveToBase = new SaveToBase();
        listBooks = saveToBase.loadBooks();
        listReaders = saveToBase.loadReaders();
        listHistories = saveToBase.loadHistories();
    }
    
    public void run(){
        Scanner scanner = new Scanner(System.in);
        
        HistoryProvider historyProvider = new HistoryProvider();
        SaveToBase saveToBase = new SaveToBase();                    
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
            System.out.println("7. Список выданных книг");
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
                    saveToBase.saveBooks(listBooks);
                    for(Book b : listBooks){
                       System.out.println(b.toString()); 
                    }
                    break;
                case "2":
                    System.out.println("Новый читатель.");
                    ReaderProvider readerProvider = new ReaderProvider();
                    Reader reader = readerProvider.createReader();
                    listReaders.add(reader);
                    saveToBase.saveReaders(listReaders);
                    for(Reader r : listReaders){
                       System.out.println(r.toString()); 
                    }
                    break;
                case "3":
                    System.out.println("Список книг библиотеки:");
                    int i = 1;
                    for(Book b : listBooks){
                        System.out.println(i+". "+b.toString());
                        i++;
                    }
                    break;
                case "4":
                    System.out.println("Список читателей библиотеки:");
                    for(int j=0;j<listReaders.size();j++){
                        System.out.println(j+1+". "+listReaders.get(j).toString());
                    }
                    break;
                case "5":
                    System.out.println("Выдаем книгу читателю");
                    History history = historyProvider.createHistory(listBooks, listReaders);
                    listHistories.add(history);
                    saveToBase.saveHistories(listHistories);
                    break;
                case "6":
                    System.out.println("Возвращение книги");
                    historyProvider.returnBook(listHistories);
                    saveToBase.saveHistories(listHistories);
                    break;
                case "7":
                    System.out.println("Список выданных книг");
                    i = 1;
                    for(History h : listHistories){
                        if(h.getReturnDate() == null){
                            System.out.println(i+". "+h.toString());
                            i++;
                        }
                    }
                    if(i < 2){
                        System.out.println("Нет выданных книг");
                        System.out.println();
                    }
                    break;
            }
        }while(flagExit);
    }
}