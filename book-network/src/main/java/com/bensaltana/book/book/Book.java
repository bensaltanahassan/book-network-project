package com.bensaltana.book.book;

import com.bensaltana.book.common.BaseEntity;
import com.bensaltana.book.feedback.Feedback;
import com.bensaltana.book.history.BookTransactionHistory;
import com.bensaltana.book.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book extends BaseEntity {
    private String title;
    private String authorName;
    private String isbn;
    private String synopsis;
    private String bookCover;
    private boolean archived;
    private boolean shareable;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BookTransactionHistory> histories;


    @Transient
    public double getRate() {
        if (feedbacks==null || feedbacks.isEmpty()) {
            return 0;
        }else{
            var rate = feedbacks.stream()
                    .mapToDouble(Feedback::getNote)
                    .average()
                    .orElse(0);
            return Math.round(rate * 100.0) / 100.0;
        }
    }
}
