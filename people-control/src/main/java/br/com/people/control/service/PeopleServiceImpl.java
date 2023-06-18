package br.com.people.control.service;

import br.com.people.control.dto.PeopleDTO;
import br.com.people.control.model.People;
import br.com.people.control.repository.PeopleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public PeopleDTO createPeople(PeopleDTO peopleDTO) {
        ModelMapper mapper = new ModelMapper();
        People peopleEntity = mapper.map(peopleDTO, People.class);
        peopleEntity = peopleRepository.save(peopleEntity);
        return mapper.map(peopleEntity, PeopleDTO.class);
    }

    @Override
    public List<PeopleDTO> getAll() {
        List<People> peopleList = peopleRepository.findAll();
        return peopleList.stream()
                .map(people -> new ModelMapper().map(people, PeopleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PeopleDTO> getById(Long id) {
        Optional<People> people = peopleRepository.findById(id);
        if(people.isPresent()) {
            PeopleDTO dto = new ModelMapper().map(people.get(), PeopleDTO.class);
            return Optional.of(dto);
        }
        return Optional.empty();
    }

    @Override
    public void deletePeople(Long id) {
        peopleRepository.deleteById(id);
    }

    @Override
    public PeopleDTO updatePeople(Long id, PeopleDTO peopleDTO) {
        peopleDTO.setId(id);
        return createPeople(peopleDTO);
    }
}
