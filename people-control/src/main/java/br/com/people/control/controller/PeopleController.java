package br.com.people.control.controller;

import br.com.people.control.dto.PeopleDTO;
import br.com.people.control.dto.PeopleRequest;
import br.com.people.control.dto.PeopleResponse;
import br.com.people.control.service.PeopleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping(value = "/status")
    public String statusService(@Value("${local.server.port}") String port) {
        return String.format("Serviço ativo executando na porta %s", port);
    }

    @PostMapping
    public ResponseEntity<PeopleResponse> createPeople(@RequestBody PeopleRequest request) {
        ModelMapper mapper = new ModelMapper();
        PeopleDTO dto = mapper.map(request, PeopleDTO.class);
        dto = peopleService.createPeople(dto);
        return new ResponseEntity<>(mapper.map(dto, PeopleResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PeopleResponse>> getAll() {
        List<PeopleDTO> peopleList = peopleService.getAll();
        ModelMapper mapper = new ModelMapper();
        List<PeopleResponse> responseList = peopleList
                .stream()
                .map(people -> mapper.map(people, PeopleResponse.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PeopleResponse>> getById(@PathVariable Long id) {
        Optional<PeopleDTO> peopleDTO = peopleService.getById(id);
        PeopleResponse response = new ModelMapper().map(peopleDTO.get(), PeopleResponse.class);
        return new ResponseEntity<>(Optional.of(response), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeopleResponse> updatePeople(@RequestBody PeopleRequest request, @PathVariable Long id) {
        ModelMapper mapper = new ModelMapper();
        PeopleDTO dto = mapper.map(request, PeopleDTO.class);
        dto = peopleService.updatePeople(id, dto);
        return new ResponseEntity<>(mapper.map(dto, PeopleResponse.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePeople(@PathVariable Long id) {
        peopleService.deletePeople(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
