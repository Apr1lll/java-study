package main.java.com.homework;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("=== ЗАДАНИЕ 1: Убираем лишние пробелы ===\n");
            FileProcessor.removeExtraSpaces(
                "Borodino.txt",
                "Borodino_cleaned.txt"
            );
            
            System.out.println("\n=== ЗАДАНИЕ 2: Сортировка имён ===\n");
            FileProcessor.sortNames(
                "listNames.txt",
                "listNames_sorted.txt"
            );
            
            System.out.println("\n=== ЗАДАНИЕ 3: Сохранение/загрузка объекта ===\n");
            
            Weapon sword = new Weapon("Меч драконоборца", 150);
            Armor plate = new Armor("Рыцарская броня", 200);
            Hero hero = new Hero("Артур", 42, sword, plate);
            
            System.out.println("Оригинальный герой: " + hero);
            
            String filename = "hero.ser";
            HeroSerializer.saveHero(hero, filename);
            
            hero.setName("Ланселот");
            hero.setLvl(50);
            System.out.println("Герой после изменений: " + hero);
            
            Hero loadedHero = HeroSerializer.loadHero(filename);
            System.out.println("Загруженный герой: " + loadedHero);
            
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}