import java.util.*;

public class Java {
    public static void main(String[] args) {
        List<Integer> listOfNumbers = List.of(1, 3, 4, 5, 1, 5, 4);
        Map<Integer, Integer> countedElements = new HashMap<>();

        for (Integer number : listOfNumbers)
            countedElements.put(number, countedElements.getOrDefault(number, 0) + 1);

        StringBuilder associativeString = new StringBuilder("{");

        for (Map.Entry<Integer, Integer> entry : countedElements.entrySet())
            associativeString.append(entry.getKey()).append(" : ").append(entry.getValue()).append(", ");

        if (associativeString.length() > 1)
            associativeString.setLength((associativeString.length() - 2));

        associativeString.append("}");

        System.out.println(associativeString);
    }

}
