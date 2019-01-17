package com.agartha.filippetclinic.services.map;

import com.agartha.filippetclinic.model.Owner;
import com.agartha.filippetclinic.services.MyCrudService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements MyCrudService<Owner, Long> {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }

    @Override
    public void delete(Owner type) {
        super.deleteByObject(type);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
