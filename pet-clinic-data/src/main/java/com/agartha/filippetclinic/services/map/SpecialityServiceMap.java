package com.agartha.filippetclinic.services.map;

import com.agartha.filippetclinic.model.Speciality;
import com.agartha.filippetclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality var) {
        return super.save(var);
    }

    @Override
    public void delete(Speciality type) {
        super.deleteByObject(type);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
