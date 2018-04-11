package ru.sberbank.hibernate.task.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "AUTHOR")
@Setter @Getter @ToString @NoArgsConstructor
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID")
    private Long authorId;
    @Column(name = "AUTHOR_NAME")
    private String authorName;
    //todo: map to books via @ManyToMany and @JoinTable
    @ManyToMany(mappedBy = "authorList")
    private Set<Book> bookList;

    public Author(String authorName) {
        this.authorName = authorName;
    }

    public void addBook(Book book) {
        if (bookList == null) {
            bookList = new HashSet<>();
        }
        bookList.add(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(authorId, author.authorId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(authorId);
    }
}
