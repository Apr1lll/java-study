package main.java.animals;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetToAnimalConverter {
    public static Animal convertToAnimal(Pet pet) {
        Animal animal = new Animal();
        
        try {
            Field[] petFields = Pet.class.getDeclaredFields();
            
            for (Field petField : petFields) {
                petField.setAccessible(true);
                Object petValue = petField.get(pet);
                
                String animalFieldName = mapPetFieldToAnimalField(petField.getName());
                if (animalFieldName == null) {
                    continue;
                }
                
                try {
                    Field animalField = Animal.class.getDeclaredField(animalFieldName);
                    animalField.setAccessible(true);
                    
                    Object convertedValue = convertValue(petField.getType(), animalField.getType(), petValue);
                    animalField.set(animal, convertedValue);
                    
                } catch (NoSuchFieldException e) {
                    // Пропускаем
                }
            }
            
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        
        return animal;
    }
    
    private static String mapPetFieldToAnimalField(String petFieldName) {
        switch (petFieldName) {
            case "name":
                return "title";
            case "status":
                return "isAvailable";
            case "photosList":
                return "photosMap";
            default:
                return null;
        }
    }
    
    private static Object convertValue(Class<?> sourceType, Class<?> targetType, Object value) {
        if (value == null) {
            return null;
        }
        
        if (sourceType == Status.class && targetType == boolean.class) {
            Status status = (Status) value;
            return status == Status.AVAILABLE;
        }
        
        if (List.class.isAssignableFrom(sourceType) && targetType == Map.class) {
            List<?> list = (List<?>) value;
            Map<String, String> photosMap = new HashMap<>();
            
            for (int i = 0; i < list.size(); i++) {
                Object item = list.get(i);
                if (item instanceof Photo) {
                    Photo photo = (Photo) item;
                    photosMap.put("photo_" + (i + 1), photo.getURL());
                }
            }
            
            return photosMap;
        }
        
        return value;
    }
}