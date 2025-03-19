class Groovy {
    static void main(String[] args) {
        def listOfNumbers = [1, 3, 4, 5, 1, 5, 4]
        def countedElements = listOfNumbers.groupBy { it }.collectEntries
                { [(it.key): it.value.size()] }

        def associativeString = countedElements.collect {
            "${it.key} : ${it.value}"
        }.join(", ")

        println "{ $associativeString }"
    }
}
