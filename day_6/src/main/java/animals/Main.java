package main.java.animals;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Photo> photos = new ArrayList<>();
        photos.add(new Photo("photo1", "https://example.com/photo1.jpg"));
        photos.add(new Photo("photo2", "https://example.com/photo2.jpg"));
        
        Pet pet = new Pet("PetName", Status.AVAILABLE, photos);
        Animal animal = PetToAnimalConverter.convertToAnimal(pet);
        
        System.out.println(animal);
    }
}