package com.homework; 
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileProcessor {

    public static void removeExtraSpaces(String inputFile, String outputFile) throws IOException {
        InputStream inputStream = FileProcessor.class.getClassLoader()
            .getResourceAsStream(inputFile);
        
        List<String> lines;
        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                lines = new ArrayList<>();
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }
            System.out.println("Файл найден в resources: " + inputFile);
        } else {
            System.out.println("Файл не найден в resources, ищем в файловой системе: " + inputFile);
            lines = Files.readAllLines(Paths.get(inputFile));
        }
        
        List<String> cleanedLines = new ArrayList<>();
        for (String line : lines) {
            String cleaned = line.replaceAll("\\s+", " ").trim();
            cleanedLines.add(cleaned);
        }
        
        Path outputPath = Paths.get(outputFile);
        Files.write(outputPath, cleanedLines);
        System.out.println("Файл обработан! Результат в: " + outputPath.toAbsolutePath());
    }

    public static void sortNames(String inputFile, String outputFile) throws IOException {
        InputStream inputStream = FileProcessor.class.getClassLoader()
            .getResourceAsStream(inputFile);
        
        String content;
        if (inputStream != null) {
            System.out.println("Файл найден в resources: " + inputFile);
            try (Scanner scanner = new Scanner(inputStream, "UTF-8")) {
                content = scanner.useDelimiter("\\A").next();
            }
        } else {
            System.out.println("Файл не найден в resources, ищем в файловой системе: " + inputFile);
            content = Files.readString(Paths.get(inputFile));
        }
        
        String[] namesArray = content.split(",");
        List<String> names = new ArrayList<>();
        for (String name : namesArray) {
            names.add(name.trim());
        }
        
        Collections.sort(names);
        
        Path outputPath = Paths.get(outputFile);
        Files.write(outputPath, names);
        System.out.println("Имена отсортированы! Результат в: " + outputPath.toAbsolutePath());
    }

    public static List<String> sortNamesList(List<String> names) {
        List<String> sorted = new ArrayList<>(names);
        Collections.sort(sorted);
        return sorted;
    }
}