package ru.kpfu.it.leclib.model;


import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ayrat on 01.05.2014.
 */
@Entity
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "univer_id")
    private Long id;

    @Column(name = "univer_shorttitle")
    private String shortTitle;

    @Column(name = "univer_fulltitle")
    private String fullTitle;

    @JsonIgnore
    @OneToMany(mappedBy = "university")
    private List<Lecture> lectures;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }
}
