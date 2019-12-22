public class Cocktail implements Food {
    private String drink;
    private String fruit;

    public Cocktail(String drink, String fruit) {  //конструктор класса
        this.drink = drink;     //this.drink - переменная класса, а drink - переменная конструктора
        this.fruit = fruit;
    }

    @Override
    public void consume() {
        System.out.println("Cocktail with " + drink + " and " + fruit + " consumed, calories = " + calculateCalories());
    }

    @Override
    public Integer calculateCalories() {
        return drink.length() + fruit.length();
    }
}
