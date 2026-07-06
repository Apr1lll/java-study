package day_4;

import java.util.HashMap;
import java.util.Map;

public class MapSwapper {

    public static <K, V> Map<V, K> swapKeysAndValues(Map<K, V> original) {
        if (original == null) {
            throw new IllegalArgumentException("Исходная карта не может быть null");
        }

        Map<V, K> swapped = new HashMap<>();
        
        for (Map.Entry<K, V> entry : original.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();
            
            if (swapped.containsKey(value)) {
                throw new IllegalArgumentException(
                    "Невозможно выполнить замену: значение '" + value + 
                    "' встречается несколько раз. Возможна потеря данных."
                );
            }
            
            swapped.put(value, key);
        }
        
        return swapped;
    }

    public static <K, V> Map<V, K> swapKeysAndValuesWithoutCheck(Map<K, V> original) {
        if (original == null) {
            throw new IllegalArgumentException("Исходная карта не может быть null");
        }

        Map<V, K> swapped = new HashMap<>();
        
        for (Map.Entry<K, V> entry : original.entrySet()) {
            swapped.put(entry.getValue(), entry.getKey());
        }
        
        return swapped;
    }

    public static void main(String[] args) {
        // Пример 1: Успешная замена
        Map<String, Integer> original = new HashMap<>();
        original.put("A", 1);
        original.put("B", 2);
        original.put("C", 3);
        
        System.out.println("=== Пример 1: Успешная замена ===");
        System.out.println("Исходная карта: " + original);
        Map<Integer, String> swapped = swapKeysAndValues(original);
        System.out.println("Результат замены: " + swapped);
        System.out.println();

        // Пример 2: С дублирующимися значениями (вызовет исключение)
        Map<String, Integer> withDuplicates = new HashMap<>();
        withDuplicates.put("A", 1);
        withDuplicates.put("B", 2);
        withDuplicates.put("C", 2); // Дубликат значения
        
        System.out.println("=== Пример 2: Дублирующиеся значения ===");
        System.out.println("Карта с дубликатами: " + withDuplicates);
        try {
            swapKeysAndValues(withDuplicates);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println();

        // Пример 3: Без проверки дубликатов
        System.out.println("=== Пример 3: Без проверки дубликатов ===");
        System.out.println("Результат без проверки дубликатов: " + 
            swapKeysAndValuesWithoutCheck(withDuplicates));
        System.out.println();

        // Пример 4: Разные типы данных
        System.out.println("=== Пример 4: Разные типы данных ===");
        Map<Double, String> doubleMap = new HashMap<>();
        doubleMap.put(1.5, "OnePointFive");
        doubleMap.put(2.7, "TwoPointSeven");
        System.out.println("Double->String: " + doubleMap);
        System.out.println("Результат: " + swapKeysAndValues(doubleMap));
        System.out.println();

        // Пример 5: Пустая карта
        System.out.println("=== Пример 5: Пустая карта ===");
        Map<String, String> emptyMap = new HashMap<>();
        System.out.println("Пустая карта: " + emptyMap);
        System.out.println("Результат: " + swapKeysAndValues(emptyMap));
    }
}