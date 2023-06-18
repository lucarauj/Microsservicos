package br.com.animal.control.repository;

import br.com.animal.control.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findByOwner(Long id);
}
