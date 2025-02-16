package com.mappings.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "comment")
    private String comment;

    // define constructors

    public Review() {

    }

    public Review(String comment) {
        this.comment = comment;
    }

    // define getters/setters


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // define toString

    @Override
    public String toString() {
        return "Review{" +
                "comment='" + comment + '\'' +
                ", id=" + id +
                '}';
    }

}
