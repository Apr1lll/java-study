public class Main {
    public static void main(String[] args){
        pair<String, Integer> pair = new pair<>("Год", 1999);
        System.out.println(pair.getKey() + "=" + pair.getValue());

        pair.setValue(2000);

        System.out.println(pair.getKey() + "=" + pair.getValue());
    }

}
