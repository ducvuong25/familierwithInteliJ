package com.vuong.service;

import com.vuong.entity.Book;
import com.vuong.entity.BookDetail;
import com.vuong.entity.Category;
import com.vuong.repository.BookDetailRepository;
import com.vuong.repository.BookRepository;
import com.vuong.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LibServiceimpl implements LibServiceIF {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookDetailRepository bookDetailRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public void initDate() {
        // create 3 catgory
        Category english = new Category();
        english.setCateName("English");
        english.setCateDesc("for book about English");

        Category math = new Category();
        math.setCateName("Math");
        math.setCateDesc("for book about Math");

        Category programing = new Category();
        programing.setCateName("Programming");
        programing.setCateDesc("for book about Programming");

        // save 3 category to Database
        categoryRepository.save(english);
        categoryRepository.save(math);
        categoryRepository.save(programing);

        // create a book
        Book book = new Book();
        book.setAuthor("le duc vuong");
        book.setName("beginning spring");

        //create a BookDetail
        BookDetail bookDetail = new BookDetail();
        bookDetail.setIsbn("93484934");
        bookDetail.setNumberOfPage(99);
        bookDetail.setPrice(44.3);
        bookDetail.setPublishDate(LocalDate.parse("2020-10-10"));

        //set Category for book
        book.setCategory(programing);
        //set bookdetail fo book
        book.setBookDetail(bookDetail);


        //finally save book
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBook() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public List<Category> getAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }
}
