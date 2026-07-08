package main.java.annotations;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class PrintProcessor {
    
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    
    private static final Map<String, String> STYLE_PREFIXES = new HashMap<>();
    private static final Map<String, String> STYLE_SUFFIXES = new HashMap<>();
    
    static {
        STYLE_PREFIXES.put("arrow", "---> ");
        STYLE_SUFFIXES.put("arrow", " <---");
        
        STYLE_PREFIXES.put("hurray", "^^^ ");
        STYLE_SUFFIXES.put("hurray", " ^^^");
        
        STYLE_PREFIXES.put("!", "!!! ");
        STYLE_SUFFIXES.put("!", " !!!");
        
        STYLE_PREFIXES.put("default", "");
        STYLE_SUFFIXES.put("default", "");
    }
    
    public static void print(Object obj) {
        Class<?> clazz = obj.getClass();
        
        Print classAnnotation = clazz.getAnnotation(Print.class);
        String classColor = classAnnotation != null ? classAnnotation.color() : WHITE;
        String classStyle = classAnnotation != null ? classAnnotation.style() : "default";
        
        Method[] methods = clazz.getDeclaredMethods();
        
        for (Method method : methods) {
            Print methodAnnotation = method.getAnnotation(Print.class);
            
            if (methodAnnotation != null) {
                printMethodResult(obj, method, methodAnnotation.color(), methodAnnotation.style());
            } else if (classAnnotation != null) {
                printMethodResult(obj, method, classColor, classStyle);
            }
        }
    }
    
    private static void printMethodResult(Object obj, Method method, String color, String style) {
        try {
            if (method.getReturnType() == String.class && method.getParameterCount() == 0) {
                method.setAccessible(true);
                String result = (String) method.invoke(obj);
                
                String prefix = STYLE_PREFIXES.getOrDefault(style, "");
                String suffix = STYLE_SUFFIXES.getOrDefault(style, "");
                
                System.out.println(color + prefix + result + suffix + RESET);
            }
        } catch (Exception e) {
            System.err.println("Ошибка при вызове метода " + method.getName() + ": " + e.getMessage());
        }
    }
}