package br.com.animal.control.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnimalDTO {

    private Long id;
    private String name;
    private Integer age;
    private String breed;
    private Boolean alive;
}
