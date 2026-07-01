class Phone {
    private String number;
    private String model;
    private double weight;

    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
        this.weight = 0.0;
    }

    public Phone() {
        this.number = "Unknown";
        this.model = "Unknown";
        this.weight = 0.0;
    }

    public void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }

    public void receiveCall(String name, String callerNumber) {
        System.out.println("Звонит " + name + " с номера " + callerNumber);
    }

    public String getNumber() {
        return number;
    }

    public void sendMessage(String[] phoneNumbers) {
        System.out.println("Отправка сообщения на номера:");
        for (String num : phoneNumbers) {
            System.out.println(num);
        }
    }

    public void sendMessage(String[] phoneNumbers, String message) {
        System.out.println("Отправка сообщения \"" + message + "\" на номера:");
        for (String num : phoneNumbers) {
            System.out.println(num);
        }
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", model='" + model + '\'' +
                ", weight=" + weight +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

public class Main {
    public static void main(String[] args) {
        Phone phone1 = new Phone("+7-999-123-45-67", "iPhone 15 Pro", 187.0);
        Phone phone2 = new Phone("+7-888-987-65-43", "Samsung Galaxy S24");
        Phone phone3 = new Phone();

        System.out.println("=== Демонстрация работы класса Phone ===");

        System.out.println("\nИнформация о телефонах:");
        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);

        System.out.println("\n--- receiveCall (один параметр) ---");
        phone1.receiveCall("Анна");
        phone2.receiveCall("Петр");
        phone3.receiveCall("Мария");

        System.out.println("\n--- receiveCall (два параметра) ---");
        phone1.receiveCall("Анна", "+7-999-123-45-67");
        phone2.receiveCall("Петр", "+7-888-987-65-43");
        phone3.receiveCall("Мария", "+7-777-555-44-33");

        System.out.println("\n--- getNumber ---");
        System.out.println("Номер телефона 1: " + phone1.getNumber());
        System.out.println("Номер телефона 2: " + phone2.getNumber());
        System.out.println("Номер телефона 3: " + phone3.getNumber());

        System.out.println("\n--- sendMessage (массив номеров) ---");
        String[] numbersForMessage = {"+7-999-111-11-11", "+7-888-222-22-22", "+7-777-333-33-33"};
        phone1.sendMessage(numbersForMessage);

        System.out.println("\n--- sendMessage (массив номеров + текст) ---");
        String[] numbersForMessageWithText = {"+7-999-444-44-44", "+7-888-555-55-55"};
        phone1.sendMessage(numbersForMessageWithText, "Привет! Как дела?");

        System.out.println("\n=== Работа с телефоном 1 ===");
        System.out.println("Текущий телефон: " + phone1);
        phone1.receiveCall("Алексей");
        phone1.receiveCall("Алексей", "+7-999-123-45-67");
        System.out.println("Номер телефона: " + phone1.getNumber());

        System.out.println("\n=== Изменение данных телефона 3 ===");
        phone3.setNumber("+7-111-222-33-44");
        phone3.setModel("Xiaomi Mi 13");
        phone3.setWeight(185.5);
        System.out.println("Обновленный телефон: " + phone3);
    }
}