package com.agartha.filippetclinic.services.map;

import com.agartha.filippetclinic.model.PetType;
import com.agartha.filippetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType var) {
        return super.save(var);
    }

    @Override
    public void delete(PetType type) {
        super.deleteByObject(type);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
