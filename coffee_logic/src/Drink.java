public class Drink implements  IDrink{
    private String type;
    private int sugar;

    @Override
    public String getCommand(){
        StringBuilder builder = new StringBuilder();
        builder.append(type).append(":");
        if(sugar > 0) builder.append(sugar).append(":").append("0");
        else builder.append(":");

        return builder.toString();
    }

    public Drink(String type, int sugar){
        this.type = type;
        this.sugar = sugar > 2 ? 2 : sugar;
    }
    Drink(String type){
        this(type, 0);
    }

    // drink,sugarCount
    public static IDrink parse(String drink){
        String [] parts = drink.split(",");
        String [] types = {"Tea", "Coffee", "Chocolate"};
        String type = "";
        for(String t : types){
            if(t.equals(parts[0])) {
                type = t;
                break;
            }
        }

        switch(type) {
            case "Tea":
                type = "T";
                break;
            case "Chocolate":
                type = "H";
                break;
            default:
                type = "C";
        }

        int sugar = Integer.valueOf(parts[1]);
        if(sugar > 0) return new Drink(type, sugar);
        return new Drink(type);
    }


}
