package ru.sberbank.hibernate.task;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sberbank.hibernate.task.entities.Author;
import ru.sberbank.hibernate.task.entities.Book;

import java.util.List;

public class p02_ManyToMany_LazyAndEager {

    public static void main(String[] args) {
        p02_ManyToMany_LazyAndEager hs = new p02_ManyToMany_LazyAndEager();

        Session s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Author jackSparrow = new Author("Jack Sparrow");
        s.save(jackSparrow);

        hs.createBook("Alphabet for Dummies", jackSparrow, s);

        List<Book> bookList = s.createQuery("from Book").list();

        System.out.println(bookList);

        s.getTransaction().commit();
        s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();

        s.getTransaction().commit();
    }

    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    private void createBook(String bookName, Author oldAuthor, Session s) throws HibernateException {
        Book newBook = new Book();
        newBook.setBookName(bookName);

        newBook.addAuthor(oldAuthor);

        Author newAuthor = new Author();
        newAuthor.setAuthorName("New Author 1");

        newBook.addAuthor(newAuthor);
        s.save(newAuthor);

        s.save(newBook);
    }
}
