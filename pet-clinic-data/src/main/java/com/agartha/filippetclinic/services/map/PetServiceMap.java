package com.agartha.filippetclinic.services.map;

import com.agartha.filippetclinic.model.Pet;
import com.agartha.filippetclinic.services.MyCrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements MyCrudService<Pet, Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet var) {
        return super.save(var.getId(), var);
    }

    @Override
    public void delete(Pet type) {
        super.deleteByObject(type);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
