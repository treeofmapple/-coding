package streams;

public class StreamDataKnowledge extends AltStream {

	public static void main(String[] args) {
		dataInsertion();
		
		/*
		System.out.println(createData());
		System.out.println(terminalOperation());
		System.out.println(nonTerminal());
		System.out.println(filteredData());
		System.out.println(mappedData());
		System.out.println(flatMap());
		System.out.println(items.toString());
		System.out.println(removeAllDistinct());
		String peekingData = peekData();
		System.out.println("Final: " + peekingData);
		System.out.println(anyMatchData());
		System.out.println(allMatchData());
		System.out.println(noneMatchData());
		System.out.println(countData());
		System.out.println(findAnyData());
		System.out.println(findFirstData());
		// forEachData();
		*/
		
		System.out.println(minData());
		System.out.println(maxData());
		System.out.println(reduceData());
		System.out.println(returnArrayAsObject());
		System.out.println(concatenateStream());
		System.out.println(createStreamFromArray());
		
	}
	
	private static void dataInsertion() {
		items.add("one");
		items.add("two");
		items.add("three");
		items.add("four");
		items.add("five");
		items.add("six");
		items.add("one1");
		items.add("two1");
		items.add("three1");
		items.add("one1");
		items.add("two1");
		items.add("three1");
		items.add("one2");
		items.add("two2");
		items.add("three2");
	}
	
}
