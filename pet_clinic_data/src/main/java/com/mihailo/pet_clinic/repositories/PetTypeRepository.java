package com.mihailo.pet_clinic.repositories;

import com.mihailo.pet_clinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
