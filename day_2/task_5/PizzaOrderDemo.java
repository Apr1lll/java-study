package task_5;

enum Size {
    SMALL, MEDIUM, BIG
}

class PizzaOrder {
    private String name;
    private Size size;
    private boolean sauce;
    private String address;
    private boolean accepted;
    
    public PizzaOrder(String name, Size size, boolean sauce, String address) {
        this.name = name;
        this.size = size;
        this.sauce = sauce;
        this.address = address;
        this.accepted = false;
    }
    
    public void order() {
        if (accepted) {
            System.out.println("Заказ уже принят.");
            return;
        }
        accepted = true;
        System.out.print("Заказ принят. ");
        System.out.print(getSizeText() + " пицца \"" + name + "\" ");
        if (sauce) {
            System.out.print("с соусом ");
        } else {
            System.out.print("без соуса ");
        }
        System.out.println("на адрес " + address + ".");
    }
    
    public void cancel() {
        if (!accepted) {
            System.out.println("Заказ не был принят.");
            return;
        }
        accepted = false;
        System.out.println("Заказ отменен.");
    }
    
    private String getSizeText() {
        switch (size) {
            case SMALL: return "Маленькая";
            case MEDIUM: return "Средняя";
            case BIG: return "Большая";
            default: return "";
        }
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Size getSize() {
        return size;
    }
    
    public void setSize(Size size) {
        this.size = size;
    }
    
    public boolean isSauce() {
        return sauce;
    }
    
    public void setSauce(boolean sauce) {
        this.sauce = sauce;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public boolean isAccepted() {
        return accepted;
    }
    
    @Override
    public String toString() {
        return "PizzaOrder{" +
               "name='" + name + '\'' +
               ", size=" + size +
               ", sauce=" + sauce +
               ", address='" + address + '\'' +
               ", accepted=" + accepted +
               '}';
    }
}

public class PizzaOrderDemo {
    public static void main(String[] args) {
        PizzaOrder order1 = new PizzaOrder("Аль-Капчоне", Size.BIG, true, "Ярославская 101");
        PizzaOrder order2 = new PizzaOrder("Маргарита", Size.MEDIUM, false, "Ленина 25");
        PizzaOrder order3 = new PizzaOrder("Пепперони", Size.SMALL, true, "Гагарина 7");
        
        System.out.println("=== Демонстрация работы заказов ===\n");
        
        System.out.println("Заказ 1:");
        order1.order();
        order1.order();
        order1.cancel();
        order1.order();
        
        System.out.println("\nЗаказ 2:");
        order2.order();
        order2.cancel();
        order2.cancel();
        
        System.out.println("\nЗаказ 3:");
        order3.order();
        
        System.out.println("\n=== Демонстрация геттеров и сеттеров ===");
        System.out.println("Заказ 3 до изменений:");
        System.out.println("Название: " + order3.getName());
        System.out.println("Размер: " + order3.getSize());
        System.out.println("Соус: " + order3.isSauce());
        System.out.println("Адрес: " + order3.getAddress());
        
        order3.setName("Четыре сыра");
        order3.setSize(Size.BIG);
        order3.setSauce(false);
        order3.setAddress("Кирова 15");
        
        System.out.println("\nЗаказ 3 после изменений:");
        System.out.println("Название: " + order3.getName());
        System.out.println("Размер: " + order3.getSize());
        System.out.println("Соус: " + order3.isSauce());
        System.out.println("Адрес: " + order3.getAddress());
        
        System.out.println("\n=== Демонстрация toString() ===");
        System.out.println(order1);
        System.out.println(order2);
        System.out.println(order3);
    }
}