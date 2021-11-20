package com.mihailo.pet_clinic.bootstrap;

import com.mihailo.pet_clinic.model.Owner;
import com.mihailo.pet_clinic.model.PetType;
import com.mihailo.pet_clinic.model.Vet;
import com.mihailo.pet_clinic.services.OwnerService;
import com.mihailo.pet_clinic.services.PetTypeService;
import com.mihailo.pet_clinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 =  new Owner();
        owner1.setFirstName("Mihailo");
        owner1.setLastName("Djordjevic");

        ownerService.save(owner1);

        Owner owner2 =  new Owner();
        owner2.setFirstName("Pera");
        owner2.setLastName("Peric");

        ownerService.save(owner2);

        Vet vet1 =  new Vet();
        vet1.setFirstName("Zika");
        vet1.setLastName("Zikic");

        vetService.save(vet1);

        Vet vet2 =  new Vet();
        vet2.setFirstName("Mika");
        vet2.setLastName("Mikic");

        vetService.save(vet2);
    }
}
