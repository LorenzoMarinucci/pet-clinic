package petclinic.formatters;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import petclinic.model.Pet;
import petclinic.model.PetType;
import petclinic.services.PetTypeService;

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
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = petTypeService.findAll();
        for (PetType type: findPetTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }
        throw new ParseException("Pet Type not found: " + text, 0);
    }

    @Override
    public String print(PetType object, Locale locale) {
        return object.getName();
    }
}
