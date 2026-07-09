package main.java.com.homework;

import java.io.*;

public class HeroSerializer {
    
    public static void saveHero(Hero hero, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            oos.writeObject(hero);
            System.out.println("✅ Герой сохранён в: " + new File(filename).getAbsolutePath());
        }
    }
    
    public static Hero loadHero(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filename))) {
            return (Hero) ois.readObject();
        }
    }
}
