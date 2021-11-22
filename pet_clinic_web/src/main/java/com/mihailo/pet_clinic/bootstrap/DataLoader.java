package com.mihailo.pet_clinic.bootstrap;

import com.mihailo.pet_clinic.model.*;
import com.mihailo.pet_clinic.services.OwnerService;
import com.mihailo.pet_clinic.services.PetTypeService;
import com.mihailo.pet_clinic.services.SpecialityService;
import com.mihailo.pet_clinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int countPetTypes = petTypeService.findAll().size();

        if (countPetTypes == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 =  new Owner();
        owner1.setFirstName("Mihailo");
        owner1.setLastName("Djordjevic");
        owner1.setAddress("123 Street");
        owner1.setCity("Belgrade");
        owner1.setTelephone("060-1234-567");

        Pet dog1 = new Pet();
        dog1.setPetType(savedDogPetType);
        dog1.setName("Doggo");
        dog1.setBirthDate(LocalDate.now());
        dog1.setOwner(owner1);

        owner1.getPets().add(dog1);

        ownerService.save(owner1);

        Owner owner2 =  new Owner();
        owner2.setFirstName("Pera");
        owner2.setLastName("Peric");
        owner1.setAddress("321 Street");
        owner1.setCity("Novi Sad");
        owner1.setTelephone("069-8765-432");

        Pet cat1 = new Pet();
        cat1.setPetType(savedCatPetType);
        cat1.setName("Catto");
        cat1.setBirthDate(LocalDate.now());
        cat1.setOwner(owner2);

        owner2.getPets().add(cat1);

        ownerService.save(owner2);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiologySpeciality = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgerySpeciality = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistrySpeciality = specialityService.save(dentistry);

        Vet vet1 =  new Vet();
        vet1.setFirstName("Zika");
        vet1.setLastName("Zikic");
        vet1.getSpecialities().add(savedRadiologySpeciality);

        vetService.save(vet1);

        Vet vet2 =  new Vet();
        vet2.setFirstName("Mika");
        vet2.setLastName("Mikic");
        vet2.getSpecialities().add(savedDentistrySpeciality);

        vetService.save(vet2);
    }
}
