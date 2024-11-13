package com.bensaltana.book.email;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum EmailTemplateName {
    ACTIVATE_ACCOUNT("activate_account");


    private final String name;
    EmailTemplateName(String name) {
        this.name = name;
    }
}
