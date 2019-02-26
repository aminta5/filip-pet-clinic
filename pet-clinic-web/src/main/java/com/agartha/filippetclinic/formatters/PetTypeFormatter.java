package com.agartha.filippetclinic.formatters;

import com.agartha.filippetclinic.model.PetType;
import com.agartha.filippetclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;
@Component
public class PetTypeFormatter implements Formatter<PetType> {
    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public PetType parse(String s, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = petTypeService.findAll();

        for(PetType type : findPetTypes){
            if(type.getName().equals(s)){
                return type;
            }
        }
        throw new ParseException("type not found:" + s, 0);
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }
}
