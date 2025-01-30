package com.mappings.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    // define constructors
    public InstructorDetail() {

    }

    public InstructorDetail(String hobby, String youtubeChannel) {
        this.hobby = hobby;
        this.youtubeChannel = youtubeChannel;
    }

    // define getters/setters

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    // define toString

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "hobby='" + hobby + '\'' +
                ", id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                '}';
    }

}
