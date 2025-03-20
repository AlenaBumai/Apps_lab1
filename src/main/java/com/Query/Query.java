package com.Query;

public class Query {

//1)	Выборка по АВТОРАМ, отсортировав по их Имени и Фамилии

    public static String selectAuthors = "SELECT * FROM books.authors ORDER BY lastName ASC, firstName asc";

 //   3)	Сделайте выборку Издателей и измените имя определенного Издателя.
 public static String selectPublishers = "SELECT * FROM books.publishers ORDER BY publisherName ASC";


 // ID publisher by Name
String getPublisherIdByName="SELECT publisherID  FROM publishers WHERE publisherName  LIKE \"%(?)%\"";

// ID author by lastname
 String getAuthorIdbyLastname = "SELECT isbn FROM authorisbn WHERE authorID=(SELECT authorID FROM authors WHERE lastName =(?)";

//   список книг по издателю
 public static String selectBooksByPublisher= "SELECT * FROM books.titles WHERE publisherID =?";

//    список книг по фамилии автора
public static String selectBooksByAuthorID = "SELECT * FROM books.titles WHERE isbn IN (SELECT isbn FROM books.authorisbn WHERE authorID=?);";


// public static String insertBook="start TRANSACTION; INSERT INTO books.titles (isbn, title, editionNumber, YEAR, publisherID, price) VALUES(?, ?, ?, ?, ?, ?);  INSERT INTO books.authorisbn (authorId, isbn) VALUES(?, ?);  COMMIT;";
 public static String insertBook="START TRANSACTION; " +
        "INSERT INTO books.titles (isbn, title, editionNumber, YEAR, publisherID, price) " +
        "VALUES (?, ?, ?, ?, ?, ?); " +
        "INSERT INTO books.authorisbn (authorId, isbn) " +
        "VALUES (?, ?); " +
        "COMMIT;";

 public static String insertTitle="INSERT INTO books.titles (isbn, title, editionNumber, YEAR, publisherID, price) VALUES(?, ?, ?, ?, ?, ?)";
 public static String insertIsbn="INSERT INTO books.authorisbn (authorId, isbn) VALUES(?, ?);";
}
