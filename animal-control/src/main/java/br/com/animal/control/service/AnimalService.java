package br.com.animal.control.service;


import br.com.animal.control.dto.AnimalDTO;

import java.util.List;
import java.util.Optional;

public interface AnimalService {
    AnimalDTO createAnimal(AnimalDTO dto);
    List<AnimalDTO> listAnimals();
    Optional<AnimalDTO> searchById(Long id);
    List<AnimalDTO> searchByOwner(Long idOwner);
    void deleteAnimal(Long id);
    boolean updateAsAlive(Long id);
    AnimalDTO updateAnimal(Long id, AnimalDTO dto);

}
