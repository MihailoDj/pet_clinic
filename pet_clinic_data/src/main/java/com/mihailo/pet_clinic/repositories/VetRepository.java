package com.mihailo.pet_clinic.repositories;

import com.mihailo.pet_clinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
