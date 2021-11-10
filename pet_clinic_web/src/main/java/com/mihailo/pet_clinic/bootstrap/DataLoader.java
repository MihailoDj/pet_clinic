package com.mihailo.pet_clinic.bootstrap;

import com.mihailo.pet_clinic.model.Owner;
import com.mihailo.pet_clinic.model.Vet;
import com.mihailo.pet_clinic.services.OwnerService;
import com.mihailo.pet_clinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 =  new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Mihailo");
        owner1.setLastName("Djordjevic");

        ownerService.save(owner1);

        Owner owner2 =  new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Pera");
        owner2.setLastName("Peric");

        ownerService.save(owner2);

        Vet vet1 =  new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Zika");
        vet1.setLastName("Zikic");

        vetService.save(vet1);

        Vet vet2 =  new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Mika");
        vet2.setLastName("Mikic");

        vetService.save(vet2);
    }
}
