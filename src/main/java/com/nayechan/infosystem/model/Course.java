package com.nayechan.infosystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int year;
    private int semester;
    private String code;
    private String name;
    private String category;
    private String professor;
    private int credit;
}