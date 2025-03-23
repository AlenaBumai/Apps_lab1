package com.Connection;
import com.TestOfTables.*;



public class TestDatabase {
    public static void main(String[] args){
        //DataAuthor.insertAuthor("Фридрих","Ницше");
        // DataAuthor.updateAuthorName("Клод", 7);
       // DataPublisher.insertPublisher("издательство Книга");
        // DataPublisher.updatePublisher("издательство Вилейка", 6);
       DataTitles.insertBook("44bb", "По ту сторону добра и зла", 4, 2021, "издательство Вилейка", 41.00F, "Фридрих", "Ницше");
      //  GetAllRows.getAuthors();
       // GetAllRows.getPublishers();
        //DataPublisher.getPublisherId("издательство Вилейка");
        //DataAuthor.getAuthorId("Клод","Леви-Стросс");

        GetAllRows.getAllBooks();
       // GetAllRows.getBooksByPublisher("издательство Гродно");
      //  GetAllRows.getBooksByAuthor("Клод","Леви-Стросс");


    }
}
