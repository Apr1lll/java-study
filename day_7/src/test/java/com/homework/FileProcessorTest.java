package com.homework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class FileProcessorTest {
    
    private List<String> unsortedNames;
    private List<String> expectedSorted;
    
    @BeforeEach
    void setUp() {
        // Подготовка данных для тестов
        unsortedNames = Arrays.asList("Сергей", "Анна", "Павел", "Иван", "Мария");
        expectedSorted = Arrays.asList("Анна", "Иван", "Мария", "Павел", "Сергей");
    }
    
    @Test
    void testSortNamesList() {
        List<String> result = FileProcessor.sortNamesList(unsortedNames);
        assertEquals(expectedSorted, result);
    }
    
    @Test
    void testSortNamesListWithDuplicates() {
        List<String> withDuplicates = Arrays.asList("Мария", "Анна", "Мария", "Павел");
        List<String> result = FileProcessor.sortNamesList(withDuplicates);
        
        assertEquals(4, result.size());
        assertEquals("Анна", result.get(0));
        assertEquals("Мария", result.get(1));
        assertEquals("Мария", result.get(2));
        assertEquals("Павел", result.get(3));
    }
    
    @Test
    void testSortNamesListEmpty() {
        List<String> empty = new ArrayList<>();
        List<String> result = FileProcessor.sortNamesList(empty);
        assertTrue(result.isEmpty());
    }
}