package com.mihailo.pet_clinic.services;

import com.mihailo.pet_clinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
