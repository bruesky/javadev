package edu.mum.finalexam.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "book")
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "book_name")
    @NotEmpty(message = "*Please provide your name")
    private String bookName;

    @ManyToOne(fetch = FetchType.EAGER,cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name = "cat_id",nullable = false)
    private Category category;

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", category=" + category +
                '}';
    }

    public Book() {
    }

    public Book(String bookName, Category category) {
        this.bookName = bookName;
        this.category = category;
    }
}
