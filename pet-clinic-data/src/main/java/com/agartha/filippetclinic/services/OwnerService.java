package com.agartha.filippetclinic.services;

import com.agartha.filippetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends MyCrudService<Owner, Long> {
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
