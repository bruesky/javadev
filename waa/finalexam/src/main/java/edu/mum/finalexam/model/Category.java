package edu.mum.finalexam.model;


import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "category")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catId;

    @Column(name = "cat_name")
    private String catName;

    @OneToMany(cascade=CascadeType.REMOVE,orphanRemoval=true,fetch = FetchType.EAGER,mappedBy = "category")
    private List<Book> books = new ArrayList<>();

    @Override
    public String toString() {
        return "Category{" +
                "catId=" + catId +
                ", catName='" + catName +
                '}';
    }

    public Category() {
    }

    public Category(String catName, List<Book> books) {
        this.catName = catName;
        this.books = books;
    }
}
