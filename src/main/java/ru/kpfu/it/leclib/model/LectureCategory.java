package ru.kpfu.it.leclib.model;

import javax.persistence.*;

/**
 * Created by Ayrat on 01.05.2014.
 */
@Entity
public class LectureCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "lc_id")
    private Long id;

    @Column(name = "lc_title")
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
