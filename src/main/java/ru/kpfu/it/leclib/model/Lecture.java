package ru.kpfu.it.leclib.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Ayrat on 01.05.2014.
 */
@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "lec_id")
    private Long id;

    @NotEmpty(message = "Заголовок не должен быть пустым")
    @Size(min = 5, max = 100, message = "Длина заголовка должна быть от 5 до 100 символов")
    @Column(name = "lec_title")
    private String title;

    @NotEmpty(message = "Лекция не должна быть пустой")
    @Size(min = 300, message = "Минимальный размер лекции 300 символов")
    @Lob
    @Column(name = "lec_text")
    private String text;

    @Column(name = "lec_created_at")
    private Date createdAt;

    @Column(name = "lec_updated_at")
    private Date updatedAt;

    @Column(name = "lec_reviews")
    private int reviews;

    @ManyToOne
    @JoinColumn(name = "lec_lc_id", referencedColumnName = "lc_id")
    private LectureCategory category;

    @OneToOne
    @JoinColumn(name = "lec_author_id", referencedColumnName = "user_id")
    private User author;

    @OneToOne
    @JoinColumn(name = "lec_univer_id", referencedColumnName = "univer_id")
    private University university;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public LectureCategory getCategory() {
        return category;
    }

    public void setCategory(LectureCategory category) {
        this.category = category;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    //    @Override
//    public void save() {
//        createdAt();
//        super.save();
//    }
//
//    @Override
//    public void update() {
//        updatedAt();
//        super.update();
//    }
//
//    @PrePersist
//    void createdAt() {
//        this.createdAt = this.updatedAt = new Date();
//    }
//
//    @PreUpdate
//    void updatedAt() {
//        this.updatedAt = new Date();
//    }
}
