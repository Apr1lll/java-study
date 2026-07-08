package task_4;

class Author {
    private String name;
    private char gender;
    private String email;
    
    public Author(String name, char gender, String email) {
        this.name = name;
        this.gender = gender;
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public char getGender() {
        return gender;
    }
    
    public void setGender(char gender) {
        this.gender = gender;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return name + " (" + gender + ") - " + email;
    }
}

class Book {
    private String title;
    private Author author;
    private int year;
    
    public Book(String title, Author author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public Author getAuthor() {
        return author;
    }
    
    public void setAuthor(Author author) {
        this.author = author;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    @Override
    public String toString() {
        return "\"" + title + "\" - " + author.toString() + ", " + year;
    }
}

public class BookDemo {
    public static void main(String[] args) {
        Author author1 = new Author("Лев Толстой", 'М', "tolstoy@example.com");
        Author author2 = new Author("Джоан Роулинг", 'Ж', "rowling@example.com");
        Author author3 = new Author("Фёдор Достоевский", 'М', "dostoevsky@example.com");
        
        Book book1 = new Book("Война и мир", author1, 1869);
        Book book2 = new Book("Гарри Поттер и философский камень", author2, 1997);
        Book book3 = new Book("Преступление и наказание", author3, 1866);
        
        System.out.println("Информация о книгах:");
        System.out.println("1. " + book1);
        System.out.println("2. " + book2);
        System.out.println("3. " + book3);
        
        System.out.println("\nДемонстрация работы геттеров:");
        System.out.println("Книга: " + book1.getTitle());
        System.out.println("Автор: " + book1.getAuthor().getName());
        System.out.println("Пол автора: " + book1.getAuthor().getGender());
        System.out.println("Email автора: " + book1.getAuthor().getEmail());
        System.out.println("Год издания: " + book1.getYear());
        
        System.out.println("\nДемонстрация работы сеттеров:");
        book1.setTitle("Война и мир (том 1)");
        book1.getAuthor().setEmail("lev.tolstoy@example.com");
        book1.setYear(1867);
        System.out.println("Обновленная информация о книге 1:");
        System.out.println(book1);
        
        System.out.println("\nДополнительная информация:");
        System.out.println("Автор 2: " + author2);
        System.out.println("Автор 3: " + author3);
        
        Book book4 = new Book("1984", new Author("Джордж Оруэлл", 'М', "orwell@example.com"), 1949);
        System.out.println("\nКнига 4: " + book4);
    }
}