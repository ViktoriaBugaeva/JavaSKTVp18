/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author User
 */
public class HistoryProvider {
    public History  createHistory(List<Book>listBook, List<Reader>listReaders){
        Scanner scanner = new Scanner(System.in);
        History history = new History();
        System.out.println("Список книг: ");
        for(int i=0; i<listBooks.size();i++){
            System.out.printf("%d. Название книги: %s, автор: %s, год издания: %d%n", i+1, listBooks.get(i).getTitle(), listBooks.get(i).getAuthor(), listBooks.get(i).getYear());
        }
        System.out.print("Выберите номер выдаваемой книги: ");
        int takeBookNum = scanner.nextInt();
        Book book = ListBooks.get(takeBookNum-1);
        System.out.println("Список читателей: ");
        for(Reader r : listReaders){
            System.out.printf("%d. Имя и фамилия читателя: %s %s, email %s%n", i+1, r.getName(), r.getLastName(), r.getEmail());
        }
        System.out.println("Выберите номер читателя: ");
        int readerNum = scanner.nextInt();
        Reader reader = ListReaders.get(takeReaderNum-1);
        history.setBook(book);
        history.setReader(reader);
        history.setTakeOn(new Date());
        return History;
    }
}
