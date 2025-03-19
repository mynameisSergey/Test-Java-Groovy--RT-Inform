import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JavaTest {

    private List<Integer> testList;
    private Map<Integer, Integer> testMap;

    private Map<Integer, Integer> calculateNumbers(List<Integer> list) { // считает количество цифр в списке
        Map<Integer, Integer> elementCountMap = new HashMap<>();
        for (Integer number : list) {
            elementCountMap.put(number, elementCountMap.getOrDefault(number, 0) + 1);
        }
        return elementCountMap;
    }

    @BeforeEach
    public void setUp() {
        testList = new ArrayList<>();
        testMap = new HashMap<>();
    }

    @Test
    @DisplayName("Подсчет элементов в списке с повторяющимися цифрами")
    public void test_1_CalculateNumbers() {
        testList = List.of(2, 5, 7, 2, 3, 8, 5, 9, 3, 3, 3);
        testMap.put(2, 2);
        testMap.put(5, 2);
        testMap.put(7, 1);
        testMap.put(8, 1);
        testMap.put(9, 1);
        testMap.put(3, 4);

        Map<Integer, Integer> resultCountMap = calculateNumbers(testList);

        assertEquals(testMap, resultCountMap, "Не совпадают результаты для списка с повторяющимися цифрами");
    }

    @Test
    @DisplayName("Проверка списка с одним элементом")
    public void test_2_CalculateNumbersSingleElement() {
        testList = List.of(10);
        testMap.put(10, 1);

        Map<Integer, Integer> resultCountMap = calculateNumbers(testList);

        assertEquals(testMap, resultCountMap, "В списке и мапе разное колличество элементов");
    }

    @Test
    @DisplayName("Проверка списка с неповторяющимися цифрами")
    public void test_3_CalculateNumbersNonRepeating() {
        testList = List.of(4, 6, 8);
        testMap.put(4, 1);
        testMap.put(6, 1);
        testMap.put(8, 1);

        Map<Integer, Integer> resultCountMap = calculateNumbers(testList);

        assertEquals(testMap, resultCountMap, "Не совпадают результаты для списка с неповторяющимися цифрами");
    }

    @Test
    @DisplayName("Проверка пустого списка")
    public void test_4_CalculateNumbersEmptyList() {
        testList = List.of();

        Map<Integer, Integer> resultCountMap = calculateNumbers(testList);

        assertEquals(testMap, resultCountMap, "В списке и мапе не должно быть элементов");
    }
}
