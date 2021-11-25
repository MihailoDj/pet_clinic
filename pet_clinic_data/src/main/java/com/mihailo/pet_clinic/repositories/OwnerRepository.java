package com.mihailo.pet_clinic.repositories;

import com.mihailo.pet_clinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
