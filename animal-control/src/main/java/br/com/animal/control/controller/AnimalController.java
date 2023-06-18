package br.com.animal.control.controller;

import br.com.animal.control.dto.AnimalDTO;
import br.com.animal.control.dto.AnimalRequest;
import br.com.animal.control.dto.AnimalResponse;
import br.com.animal.control.service.AnimalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping(value = "/status")
    public String statusService(@Value("${local.server.port}") String port) {
        return String.format("Serviço ativo executando na porta %s", port);
    }

    @PostMapping
    public ResponseEntity<AnimalResponse> createAnimal(@RequestBody AnimalRequest request) {
        ModelMapper mapper = new ModelMapper();
        AnimalDTO dto = mapper.map(request, AnimalDTO.class);
        dto = animalService.createAnimal(dto);
        return new ResponseEntity<>(mapper.map(dto, AnimalResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AnimalResponse>> listAnimals() {
        List<AnimalDTO> animals = animalService.listAnimals();
        ModelMapper mapper = new ModelMapper();
        List<AnimalResponse> responseList = animals
                .stream()
                .map(animal -> mapper.map(animal, AnimalResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @GetMapping("/{idOwner}/list")
    public ResponseEntity<List<AnimalResponse>> searchAnimalByOwner(@PathVariable Long idOwner) {
        List<AnimalDTO> dtos = animalService.searchByOwner(idOwner);

        if(dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<AnimalResponse> response = dtos.stream()
                .map(dto -> mapper.map(dto, AnimalResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalResponse> updateAnimal(@RequestBody AnimalRequest request, @PathVariable Long id) {
        ModelMapper mapper = new ModelMapper();
        AnimalDTO dto = mapper.map(request, AnimalDTO.class);
        dto = animalService.updateAnimal(id, dto);
        return new ResponseEntity<>(mapper.map(dto, AnimalResponse.class), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> setDead(@PathVariable Long id) {
        if(animalService.updateAsAlive(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
