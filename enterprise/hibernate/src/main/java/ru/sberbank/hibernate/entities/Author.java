package ru.sberbank.hibernate.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHOR")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID")
    private Long authorId;
    @Column(name = "AUTHOR_NAME")
    private String authorName;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "BOOK_TO_AUTHOR",
        joinColumns = @JoinColumn(name = "AUTHOR_ID"),
        inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
    @OrderBy(value="bookName")
    //@Transient
    private Set<Book> bookList;

    public Author(String authorName) {
        this.authorName = authorName;
    }

    public void addBook(Book book) {
        if (bookList == null) {
            bookList = new HashSet<Book>();
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
