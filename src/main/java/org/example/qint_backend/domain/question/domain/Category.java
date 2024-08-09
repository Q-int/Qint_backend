package org.example.qint_backend.domain.question.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Category {
    FRONTEND("FrontEnd"),
    BACKEND("BackEnd"),
    FLUTTER("Flutter"),
    IOS("iOS");

    private final String name;
}
