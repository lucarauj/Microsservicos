package br.com.animal.control.dto;

public record AnimalRequest(
        Long id,
        String name,
        Integer owner,
        Integer age
) {
}
