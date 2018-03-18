package ru.sberbank.hibernate.solved;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sberbank.hibernate.entities.Author;
import ru.sberbank.hibernate.entities.Book;

import java.util.List;

public class s02_ManyToMany {

    public static void main(String[] args) {
        s02_ManyToMany hs = new s02_ManyToMany();

        Session s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();

        Author jackSparrow = new Author("Jack Sparrow");
        s.save(jackSparrow);

        hs.createBook("Alphabet for Dummies", jackSparrow, s);

        List<Book> bookList = s.createQuery("from Book").list();

        System.out.println(bookList);

        Author oldAuthor = bookList.get(0).getAuthorList().iterator().next();
        Book oldBook = bookList.get(0);

        System.out.println("saving book");
        hs.createBook("Alphabet", oldAuthor, s);
        System.out.println("saving author");
        hs.saveAuthor(oldBook, s);

        // Если не закрыть - то вылетает ошибка
        s.getTransaction().commit();
        s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();

        bookList = s.createQuery("from Book").list();

        System.out.println(bookList);

        s.getTransaction().commit();
    }

    private void createBook(String bookName, Author oldAuthor, Session s) throws HibernateException {
        Book newBook = new Book();
        newBook.setBookName(bookName);

        // Вариант добавления новой книги и существуюего автора
        newBook.addAuthor(oldAuthor);

        // Вариант добавления нового автора к новой книге
        Author newAuthor = new Author();
        newAuthor.setAuthorName("New Author 1");
        // Нет надобности добавлять книгу к автору
        // Если связь однонаправленная - то не проблема. Иначе будет забавный эффект
        //newAuthor.addBook(newBook);

        newBook.addAuthor(newAuthor);
        s.save(newAuthor);

        s.save(newBook);
    }

    private void saveAuthor(Book oldBook, Session s) throws HibernateException {
        Author newAuthor = new Author();
        newAuthor.setAuthorName("New Author 2");

        // Вариант добавления новой книги и существуюего автора
        newAuthor.addBook(oldBook);

        // Вариант добавления нового автора к новой книге
        Book newBook = new Book();
        newBook.setBookName("New Book 2");
        // Нет надобности добавлять автора к книге
        // Если связь однонаправленная - то не проблема. Иначе будет забавный эффект
        //newBook.addAuthor(newAuthor);
        newAuthor.addBook(newBook);
        s.save(newBook);

        s.save(newAuthor);
    }


    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

}
