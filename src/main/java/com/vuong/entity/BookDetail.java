package com.vuong.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class BookDetail {
    @Id
    private int bookDetailId;
    private String isbn;
    private  int numberOfPage;
    private double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishDate;

    @OneToOne
    @MapsId
    @JoinColumn(name="bookDetailId")
    private Book book;


}
