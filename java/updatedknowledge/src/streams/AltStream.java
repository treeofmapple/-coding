package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AltStream {

	static List<String> items = new ArrayList<String>();

	public static String createData() {
		Stream<String> streams = items.stream();
		return streams.map(value -> value.toLowerCase()).collect(Collectors.joining(", "));
	}

	public static long terminalOperation() {
		return items.stream().map((value -> value.toLowerCase())).count();
	}
	
	public static List<String> nonTerminal() {
		return items.stream()
				.map(String::toUpperCase)
				.map(value -> value.substring(0,3))
				.collect(Collectors.toList()); 
	}
	
	public static List<String> filteredData() {
		return items.stream()
				.filter(value -> value.length() <= 3)
				.collect(Collectors.toList());
	}

	public static List<String> mappedData() {
		return items.stream()
				.map(String::toUpperCase)
				.collect(Collectors.toList());
	}
	
	
	public static List<String> flatMap() {
		List<String> stringList = new ArrayList<String>();

		stringList.add("One flew over the cuckoo's nest");
		stringList.add("To kill a muckingbird");
		stringList.add("Gone with the wind");

		return stringList.stream()
				.flatMap(value -> Arrays.stream(value.split(" ")))
				.collect(Collectors.toList());
	}
	
	
	public static List<String> removeAllDistinct() {
		return items.stream()
				.distinct()
				.collect(Collectors.toList());
	}
	
	public static String peekData() {
		List<String> items = List.of("apple", "banana", "cherry");
		return items.stream()
				.peek(value -> System.out.println("Peek at: " + value))
				.collect(Collectors.joining(", "));
	}
	
	public static String anyMatchData() {
		return String.valueOf(items.stream().anyMatch(value -> value.startsWith("one")));
	}
	
	public static String allMatchData() {
		return String.valueOf(items.stream().allMatch(value -> value.startsWith("")));
	}
	
	public static String noneMatchData() {
		return String.valueOf(items.stream().noneMatch(value -> value.startsWith("one")));
	}
	
	public static long countData() {
		return Long.valueOf(items.stream().count());
	}
	
	public static List<String> findAnyData() {
		Optional<String> optsout = items.stream().findAny();
		return optsout.stream().collect(Collectors.toList());
	}
	
	public static List<String> findFirstData() {
		Optional<String> optsout = items.stream().findFirst();
		return optsout.stream().collect(Collectors.toList());
	}
	
	public static void forEachData() {
		List<String> clonedData = new ArrayList<>(items);
		clonedData.stream().forEach(element -> System.out.println(element.toUpperCase()));
	}
	
	public static List<String> minData() {
		Optional<String> optsout = items.stream().min((val1, val2) -> val1.compareTo(val2));
		return optsout.stream().collect(Collectors.toList());
	}
	
	public static List<String> maxData() {
		Optional<String> optsout = items.stream().max((val1, val2) -> val1.compareTo(val2));
		return optsout.stream().collect(Collectors.toList());
	}
	
	public static List<String> reduceData() {
		Optional<String> optsout = items.stream().reduce((val1, val2) -> val2 + " space " + val1);
		return optsout.stream().collect(Collectors.toList());
	}
	
	public static Object[] returnArrayAsObject() {
		return items.stream().toArray();
	}
	
	public static List<String> concatenateStream(){
		Stream<String> stream1 = items.stream();

		List<String> stringList2 = new ArrayList<>();
		stringList2.add("Lord of the Rings");
		stringList2.add("Planet of the Rats");
		stringList2.add("Phantom Menace");
		Stream<String> stream2 = stringList2.stream();
		Stream<String> concatStream = Stream.concat(stream1, stream2);
		return concatStream.map(String::toUpperCase).collect(Collectors.toList()); 
	}
	
	public static List<String> createStreamFromArray(){
		Stream<String> streamOf = Stream.of("one", "two", "three");
		return streamOf.collect(Collectors.toList());
	}
	
}
