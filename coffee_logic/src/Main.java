public class Main {

    public static void main(String[] args) {
        String command = "Chocolate,2";
        IDrink drink = Drink.parse(command);
        System.out.println(drink.getCommand());
    }
}
