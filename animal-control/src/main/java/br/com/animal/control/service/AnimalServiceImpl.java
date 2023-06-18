package br.com.animal.control.service;

import br.com.animal.control.dto.AnimalDTO;
import br.com.animal.control.exception.ResourceNotFoundException;
import br.com.animal.control.model.Animal;
import br.com.animal.control.repository.AnimalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public AnimalDTO createAnimal(AnimalDTO dto) {
        dto.setId(null);
        ModelMapper mapper = new ModelMapper();
        Animal animal = mapper.map(dto, Animal.class);
        animal = animalRepository.save(animal);
        return mapper.map(animal, AnimalDTO.class);
    }

    public List<AnimalDTO> listAnimals() {
        List<Animal> animals = animalRepository.findAll();
        return animals.stream().map(animal -> new ModelMapper()
                        .map(animal, AnimalDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AnimalDTO> searchById(Long id) {
        Optional<Animal> animal = animalRepository.findById(id);
        if(animal.isPresent()) {
            return Optional.of(new ModelMapper().map(animal.get(), AnimalDTO.class));
        }
        throw new ResourceNotFoundException("Animal não encontrado");
    }

    @Override
    public List<AnimalDTO> searchByOwner(Long idOwner) {
        List<Animal> animals = animalRepository.findByOwner(idOwner);

        return animals.stream()
                .map(animal -> new ModelMapper().map(animal, AnimalDTO.class))
                .collect(Collectors.toList());
    }

    public void deleteAnimal(Long id) {
        Optional<Animal> animal = animalRepository.findById(id);
        if (animal.isEmpty()) {
            throw new ResourceNotFoundException("Animal não encontrado");
        }
        animalRepository.deleteById(id);
    }

    @Override
    public boolean updateAsAlive(Long id) {
        Optional<Animal> animal = animalRepository.findById(id);
        if(animal.isPresent()) {
            animal.get().setAlive(false);

        }
        return false;
    }

    @Override
    public AnimalDTO updateAnimal(Long id, AnimalDTO dto) {
        Optional<Animal> animal = animalRepository.findById(id);
        if (animal.isEmpty()) {
            throw new ResourceNotFoundException("Animal não encontrado");
        }
        dto.setId(id);
        ModelMapper mapper = new ModelMapper();
        Animal animalUpdate = mapper.map(dto, Animal.class);
        animalUpdate = animalRepository.save(animalUpdate);
        return mapper.map(animalUpdate, AnimalDTO.class);
    }
}
