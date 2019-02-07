package com.agartha.filippetclinic.services.springdatajpa;

import com.agartha.filippetclinic.model.Owner;
import com.agartha.filippetclinic.repositories.OwnerRepository;
import com.agartha.filippetclinic.repositories.PetRepository;
import com.agartha.filippetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    private final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        Owner owner = Owner.builder().id(1L).lastName(LAST_NAME).build();
        /*Owner owner = new Owner();
        owner.setId(1L);
        owner.setLastName(LAST_NAME);*/
        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner foundOwner = ownerSDJpaService.findByLastName(LAST_NAME);
        assertNotNull(foundOwner);
        assertEquals(LAST_NAME, foundOwner.getLastName());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> returnedOwners = ownerSDJpaService.findAll();

        assertNotNull(returnedOwners);
        assertEquals(2, returnedOwners.size());
    }

    @Test
    void findById() {
        Optional<Owner> ownerOptional = Optional.of(Owner.builder().id(1L).build());
        when(ownerRepository.findById(anyLong())).thenReturn(ownerOptional);
        Owner returnedOwner = ownerSDJpaService.findById(1L);
        assertNotNull(returnedOwner);
        assertEquals(ownerOptional.get().getId(), returnedOwner.getId());
    }

    @Test
    void notFoundById(){
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner returnedOwner = ownerSDJpaService.findById(1L);
        assertNull(returnedOwner);
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(owner);
        Owner savedOwner = ownerSDJpaService.save(owner);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        Owner owner = Owner.builder().id(1L).build();
        ownerSDJpaService.delete(owner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}