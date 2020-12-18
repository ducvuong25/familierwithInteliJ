package com.vuong.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String author;
    private String name;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;


    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private BookDetail bookDetail;

    //overide lombok
    public void setBookDetail(BookDetail bookDetail) {
        this.bookDetail = bookDetail;
        bookDetail.setBook(this);
    }

}
