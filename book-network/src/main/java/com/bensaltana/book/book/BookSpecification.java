package com.bensaltana.book.book;

import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {
    public static Specification<Book> withOwnerId(Integer ownerId) {
        return (root, query, criteriaBuilder) -> {
            if (ownerId == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("owner").get("id"), ownerId);
        };
    }
}
