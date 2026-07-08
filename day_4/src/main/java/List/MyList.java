import java.util.LinkedList;

class MyList<T> {
    private LinkedList<T> list = new LinkedList<>();
    private int maxSize;

    public MyList(int maxSize) {
        this.maxSize = maxSize;
    }

    public void add(T value) {
        if (list.size() >= maxSize) {
            throw new ListOverflowException("Список переполнен, максимум: " + maxSize);
        }
        list.add(value);
    }

    public void add(int index, T value) {
        if (index > list.size()) {
            throw new ElementNotFoundException("Индекс " + index + " больше размера списка");
        }
        if (list.size() >= maxSize) {
            throw new ListOverflowException("Список переполнен, максимум: " + maxSize);
        }
        list.add(index, value);
    }

    public T get(int index) {
        if (index < 0 || index >= list.size()) {
            throw new ElementNotFoundException("Элемент с индексом " + index + " не существует");
        }
        return list.get(index);
    }

    public void remove(int index) {
        if (index < 0 || index >= list.size()) {
            throw new ElementNotFoundException("Элемент с индексом " + index + " не существует");
        }
        list.remove(index);
    }

    public int size() {
        return list.size();
    }
}