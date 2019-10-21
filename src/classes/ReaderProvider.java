/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import entity.Reader;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ReaderProvider {
    public Reader createReader(){
        Scanner scanner = new Scanner(System.in);
        Reader reader = new Reader();
        System.out.println("Имя читателя: ");
        reader.setName(scanner.nextLine());
        System.out.println("Фамилия читателя: ");
        reader.setLastname(scanner.nextLine());
        System.out.println("Электронная почта: ");
        reader.setEmail(scanner.nextLine());
        return reader;
    }
}


/*package classes;

import entity.Reader;
import java.util.Scanner;

/**
 *
 * @author User
 */
/*public class ReaderProvider {
    public Reader createReader() {
    Scanner scanner = new Scanner(System.in);
    Reader reader = new Reader();
        System.out.println("Имя: ");
        reader.setName(scanner.nextLine());
        System.out.println("Фамилия: ");
        reader.setLastname(scanner.nextLine());
        System.out.println("e-mail: ");
        reader.setEmail(scanner.nextLine());
    return reader;
    }
    
}*/
