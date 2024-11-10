package com.bensaltana.book.feedback;

import com.bensaltana.book.book.Book;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class FeedbackMapper {
    public Feedback toFeedback(FeedbackRequest request) {

        return Feedback.builder()
                .note(request.note())
                .comment(request.comment())
                .book(Book.builder().id(request.bookId()).build())
                .build();
    }

    public FeedbackResponse toFeedbackResponse(Feedback feedback,Integer userId) {

        return FeedbackResponse.builder()
                .note(feedback.getNote())
                .comment(feedback.getComment())
                .ownFeedback(Objects.equals(feedback.getBook().getOwner().getId(), userId))
                .build();
    }
}