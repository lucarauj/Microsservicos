package br.com.people.control.service;

import br.com.people.control.dto.PeopleDTO;

import java.util.List;
import java.util.Optional;

public interface PeopleService {

    PeopleDTO createPeople(PeopleDTO peopleDTO);
    List<PeopleDTO> getAll();
    Optional<PeopleDTO> getById(Long id);
    void deletePeople(Long id);
    PeopleDTO updatePeople(Long id, PeopleDTO peopleDTO);
}
