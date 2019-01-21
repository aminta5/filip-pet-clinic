package com.agartha.filippetclinic.services.springdatajpa;


import com.agartha.filippetclinic.model.Pet;
import com.agartha.filippetclinic.repositories.PetRepository;
import com.agartha.filippetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaService  implements PetService {
    private final PetRepository petRepository;

    public PetSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets :: add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet var) {
        return petRepository.save(var);
    }

    @Override
    public void delete(Pet type) {
        petRepository.delete(type);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
