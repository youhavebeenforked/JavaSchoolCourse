package ru.sberbank.hibernate.task.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "BOOK")
@Setter @Getter
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
    private Long bookId;
    @Column(name = "BOOK_NAME")
    private String bookName;
    //todo: map to authors via @ManyToMany and @JoinTable
    private Set<Author> authorList;

    public void addAuthor(Author author) {
        if (authorList == null) {
            authorList = new HashSet<>();
        }
        authorList.add(author);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Book{");
        sb.append("bookId=").append(bookId);
        sb.append(", bookName='").append(bookName).append('\'');
        sb.append(", authorList='");
        authorList.forEach(author -> sb.append(author.getAuthorName()).append(", "));
        sb.append("'}");
        return sb.toString();
    }
}
