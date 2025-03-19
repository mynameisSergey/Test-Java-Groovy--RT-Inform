import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName

import static org.junit.jupiter.api.Assertions.*

class GroovyTest {

    private List<Integer> listOfNumbers

    private static String getAssociativeString(List<Integer> listOfNumbers) { //Получение ассоциативной строки из списка

        if (listOfNumbers.isEmpty()) {
            return "{}"
        }

        def countedElements = listOfNumbers.groupBy { it }.collectEntries
                { [(it.key): it.value.size()] }
        return countedElements.collect { "${it.key} : ${it.value}" }.join(", ").toString()
                .with { "{ $it }" }
    }

    @BeforeEach
    void setUp() {
       listOfNumbers = []
    }

    @Test
    @DisplayName("Проверка списка с повторяющимися цифрами")
    void test_1_CalculateNumbers() {
        listOfNumbers = [1, 1, 2, 2, 2, 3]
        def expectedAssociativeString = "{ 1 : 2, 2 : 3, 3 : 1 }"
        def result = getAssociativeString(listOfNumbers)
        assertEquals(expectedAssociativeString, result)
    }

    @Test
    @DisplayName("Проверка пустого списка")
    void test_2_CalculateNumbersEmptyList() {
        def expectedAssociativeString = "{}"
        def result = getAssociativeString(listOfNumbers)
        assertEquals(expectedAssociativeString, result)
    }

    @Test
    @DisplayName("Проверка неповторяющихся чисел")
    void test_3_CalculateNumbersNonRepeating() {
        listOfNumbers = [1, 2, 3]
        def expectedAssociativeString = "{ 1 : 1, 2 : 1, 3 : 1 }"
        def result = getAssociativeString(listOfNumbers)
        assertEquals(expectedAssociativeString, result)
    }

    @Test
    @DisplayName("Проверка списка с одним элементом")
    void test_4_CalculateNumbersSingleElement() {
        listOfNumbers = [5]
        def expectedAssociativeString = "{ 5 : 1 }"
        def result = getAssociativeString(listOfNumbers)
        assertEquals(expectedAssociativeString, result)
    }

}
