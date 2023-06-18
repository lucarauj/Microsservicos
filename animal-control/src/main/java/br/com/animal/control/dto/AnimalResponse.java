package br.com.animal.control.dto;

public record AnimalResponse(
        Long id,
        String name,
        Integer owner,
        Integer age,
        String breed,
        Boolean alive
) {
}
