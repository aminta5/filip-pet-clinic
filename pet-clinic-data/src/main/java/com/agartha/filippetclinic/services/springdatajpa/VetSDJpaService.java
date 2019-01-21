package com.agartha.filippetclinic.services.springdatajpa;

import com.agartha.filippetclinic.model.Vet;
import com.agartha.filippetclinic.repositories.VetRepository;
import com.agartha.filippetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;


    public VetSDJpaService(VetRepository vetRepository){
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets :: add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet var) {
        return vetRepository.save(var);
    }

    @Override
    public void delete(Vet type) {
        vetRepository.delete(type);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
