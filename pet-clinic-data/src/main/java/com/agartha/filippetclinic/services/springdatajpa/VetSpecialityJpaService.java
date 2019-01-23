package com.agartha.filippetclinic.services.springdatajpa;

import com.agartha.filippetclinic.model.Speciality;
import com.agartha.filippetclinic.repositories.SpecialityRepository;
import com.agartha.filippetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSpecialityJpaService implements SpecialityService {
    private final SpecialityRepository specialityRepository;

    public VetSpecialityJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {

        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality var) {
        return specialityRepository.save(var);
    }

    @Override
    public void delete(Speciality type) {
        specialityRepository.delete(type);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);

    }
}
