package ru.kpfu.it.leclib.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Ayrat on 01.05.2014.
 */
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "comm_id")
    private Long id;

    @NotEmpty(message = "Комментарий не должен быть пустым")
    @Size(min = 10, message = "Минимальный размер комментария 10 символов")
    @Column(name = "comm_text")
    private String text;

    @Column(name = "comm_created_at")
    private Date createdAt;

    @Column(name = "comm_updated_at")
    private Date updatedAt;

    @OneToOne
    @JoinColumn(name = "comm_author_id", referencedColumnName = "user_id")
    private User author;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "comm_lec_id", referencedColumnName = "lec_id")
    private Lecture lecture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
}
