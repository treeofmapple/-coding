package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class sample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Anna", "Ben");

        System.out.println("Original names: " + names);

        List<String> filteredAndMappedNames = names.stream()
                                                    .filter(name -> name.startsWith("A")) // Intermediate operation
                                                    .map(String::toUpperCase)           // Intermediate operation
                                                    .collect(Collectors.toList());      // Terminal operation
        System.out.println("Names starting with 'A' (uppercase): " + filteredAndMappedNames); // [ALICE, ANNA]

        List<String> sortedNames = names.stream()
                                        .sorted() // Natural order sorting
                                        .collect(Collectors.toList());
        System.out.println("Sorted names: " + sortedNames); // [Alice, Anna, Ben, Bob, Charlie, David]

        long countOfNamesWithLength5 = names.stream()
                                            .filter(name -> name.length() == 5)
                                            .count(); // Terminal operation
        System.out.println("Number of names with length 5: " + countOfNamesWithLength5); // 2 (Alice, David)

        Optional<Integer> totalLengthOptional = names.stream()
                                                      .map(String::length) // Stream of integers (lengths)
                                                      .reduce(Integer::sum); // Terminal operation
        totalLengthOptional.ifPresent(totalLength ->
                System.out.println("Total length of all names: " + totalLength)); // 30

        Map<Character, List<String>> namesByFirstLetter = names.stream()
                                                                .collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println("Names grouped by first letter: " + namesByFirstLetter);

        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "grape"),
                Arrays.asList("kiwi")
        );

        List<String> allFruits = listOfLists.stream()
                                            .flatMap(List::stream) // Flattens streams into a single stream
                                            .collect(Collectors.toList());
        System.out.println("All fruits (flattened): " + allFruits); // [apple, banana, orange, grape, kiwi]
        
    }

}
