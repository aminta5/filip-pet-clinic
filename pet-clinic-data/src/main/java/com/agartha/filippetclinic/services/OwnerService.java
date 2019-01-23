package com.agartha.filippetclinic.services;

import com.agartha.filippetclinic.model.Owner;

public interface OwnerService extends MyCrudService<Owner, Long> {
    Owner findByLastName(String lastName);

}
