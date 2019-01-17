package com.agartha.filippetclinic.services.map;

import com.agartha.filippetclinic.model.Vet;
import com.agartha.filippetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet var) {
        return super.save(var.getId(), var);
    }

    @Override
    public void delete(Vet type) {
        super.deleteByObject(type);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
