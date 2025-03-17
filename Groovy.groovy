class Groovy {
    static void main(String[] args) {
        def listOfNumbers = [1, 3, 4, 5, 1, 5, 4]
        def countedElements = [:]

        listOfNumbers.each {
            number ->
                countedElements[number] = countedElements.get(number, 0) + 1
        }

        def associativeString = "{"
        countedElements.each {
            key, value ->
                associativeString += "$key : $value, "
        }

        if (associativeString.length() > 1)
            associativeString = associativeString[0..-3]

        associativeString += "}"

        println associativeString
    }
}
