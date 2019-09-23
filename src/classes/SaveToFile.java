/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SaveToFile {  //sozdali klass dlja zapisi v fail. klassy nazyvaev suzestvitelnymi, 
    public void saveBooks(List<Book> listBooks) {  try {   // a metody nazyvaem glalgolami
            FileOutputStream fileOutputStream = new FileOutputStream("Books.txt"); //dobavit try-catch
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream); //dobavit Add catch ...Exception
            objectOutputStream.writeObject(listBooks);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка: на диске нет файла Books.txt");
        } catch (IOException ex) {
            System.out.println("Ошибка: записать файл не удалось");
        }
    }
    public List<Book> loadBooksFromFile(){
        List<Book> listBooks = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream ("Books.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(FileOutputStream);
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка: не найден файл Books.txt");
        } 
            System.out.println("Ошибка: чтение файла Books.txt не удалось");
        
        
        return listBooks;
    }
}
