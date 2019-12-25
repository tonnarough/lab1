import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Food> breakfast = Arrays.stream(args).map(food -> {         
            String[] components = food.split("/");
            if (components[0].equals("Cocktail")) {
                return new Cocktail(components[1], components[2]);
            } else {
                System.out.println("Unexpected " + food);
                return null;
            }
        }).filter(Objects::nonNull).sorted(Comparator.comparing((Function<Food, Integer>) Nutritious::calculateCalories)).collect(Collectors.toList());
        breakfast.forEach(Food::consume);
        if (Arrays.asList(args).contains("-calories")) {
            System.out.println("Calories=" + breakfast.stream().mapToInt(Food::calculateCalories).sum());    //метод мэп
        }
    }
}

