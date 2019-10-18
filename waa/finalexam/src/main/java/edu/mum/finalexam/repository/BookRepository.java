package edu.mum.finalexam.repository;

import edu.mum.finalexam.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Override
    List<Book> findAll();

//    @Query("select book from Book book where book.bookName = :bookName")
    public Optional<Book> findBookByBookName(String bookName);


    @Override
    Book save(Book s);
}
