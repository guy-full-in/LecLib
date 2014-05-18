package ru.kpfu.it.leclib.model;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by Ayrat on 01.05.2014.
 */
@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "lec_id")
    private Long id;

    @Size(min = 5, max = 100, message = "Длина заголовка должна быть от 5 до 100 символов")
    @Column(name = "lec_title")
    private String title;

    @Size(min = 20, message = "Минимальный размер лекции 20 символов")
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

    @ManyToOne
    @JoinColumn(name = "lec_author_id", referencedColumnName = "user_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "lec_univer_id", referencedColumnName = "univer_id")
    private University university;

    @OrderBy("createdAt asc")
    @OneToMany(mappedBy = "lecture", fetch=FetchType.EAGER)
    private List<Comment> comments;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = {@JoinColumn(name = "la_lec_id", referencedColumnName = "lec_id")},
            inverseJoinColumns = {@JoinColumn(name = "la_user_id", referencedColumnName = "user_id")})
    private List<User> readers;

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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<User> getReaders() {
        return readers;
    }

    public void setReaders(List<User> readers) {
        this.readers = readers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lecture lecture = (Lecture) o;

        if (!id.equals(lecture.id)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", reviews=" + reviews +
                ", category=" + category +
                ", author=" + author +
                ", university=" + university +
                ", comments=" + comments +
                ", readers=" + readers +
                '}';
    }
}
