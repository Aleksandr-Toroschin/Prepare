package ru.toroschin.hw7.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDto {
    private Long id;

    private String name;

    private Integer age;

    public StudentDto(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
