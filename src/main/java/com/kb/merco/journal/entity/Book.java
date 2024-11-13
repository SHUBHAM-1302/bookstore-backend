package com.kb.merco.journal.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private Long bookId;
    private String title ;
    private String auther ;
    private String price ;
    private String description ;
    private Double rate ;
    private Boolean sold ;

}
