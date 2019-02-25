package com.agartha.filippetclinic.services.map;

import com.agartha.filippetclinic.model.Owner;
import com.agartha.filippetclinic.model.Pet;
import com.agartha.filippetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Profile({"defaul", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetServiceMap petService;
    private final PetTypeMapService petTypeService;

    public OwnerServiceMap(PetServiceMap petService, PetTypeMapService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

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
        if (owner != null) {
            if (owner.getPets() != null) {
                owner.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }
                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(owner);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Owner type) {
        super.deleteByObject(type);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
       return this.findAll()
               .stream()
               .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
               .findFirst()
               .orElse(null);

    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        //to do
        return null;
    }
}
