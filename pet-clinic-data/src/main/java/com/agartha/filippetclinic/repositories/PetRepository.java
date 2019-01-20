package com.agartha.filippetclinic.repositories;

import com.agartha.filippetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
