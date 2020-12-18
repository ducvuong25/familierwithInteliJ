package com.vuong.service;

import com.vuong.entity.Book;
import com.vuong.entity.Category;

import java.util.List;

public interface LibServiceIF {
    void initDate();

    List<Book> getAllBook();

    List<Category> getAllCategory();

    void saveBook(Book book);

    Book getBookById(int id);

    void deleteBookById(int Id);
}
