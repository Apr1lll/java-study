public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>(3);

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("Размер: " + list.size());
        System.out.println("Элемент 1: " + list.get(1));

        try {
            list.add(4);
        } catch (ListOverflowException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            list.get(10);
        } catch (ElementNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            list.add(10, 5);
        } catch (ElementNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        list.remove(0);
        System.out.println("Размер после удаления: " + list.size());
    }
}