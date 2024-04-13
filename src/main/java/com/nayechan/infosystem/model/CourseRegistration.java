package com.nayechan.infosystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRegistration {
    @Min(value = 2000, message = "잘못된 연도입니다.")
    @Max(value = 2099, message = "잘못된 연도입니다.")
    private int year;

    @Min(value = 1, message = "잘못된 학기입니다.")
    @Max(value = 2, message = "잘못된 학기입니다.")
    private int semester;

    @Length(min = 1, max = 20, message = "이름이 너무 깁니다.")
    private String name;

    @NotBlank(message = "교과구분을 선택하십시오.")
    @Length(min = 1, max = 20, message = "잘못된 교과구분입니다.")
    private String category;

    @Length(min = 1, max = 20, message = "지도교수님 성함이 너무 깁니다.")
    private String professor;

    @Min(value = 1, message = "잘못된 학점입니다.")
    @Max(value = 3, message = "잘못된 학점입니다.")
    private int credit;

    // Getters and setters
}