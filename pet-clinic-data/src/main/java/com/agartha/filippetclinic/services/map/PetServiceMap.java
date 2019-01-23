package com.agartha.filippetclinic.services.map;

import com.agartha.filippetclinic.model.Pet;
import com.agartha.filippetclinic.services.MyCrudService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
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
        return super.save(var);
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
