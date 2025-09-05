package regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexUtil {

	public void PatternExample() {
		String text = "This is the text to be searched " + "for occurrences of the http:// pattern.";
		String regex = ".*http://.*";
		boolean matches = Pattern.matches(regex, text);
		System.out.println("Matches = " + matches);
	}

	public void MatcherExample() {
		String text = "This is the text which is to be searched " + "for occurrences of the word 'is'.";

		String regex = "is";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);

		int count = 0;
		while (matcher.find()) {
			count++;
			System.out.println("found: " + count + " : " + matcher.start() + " - " + matcher.end());
		}
	}

	public void MatchingCharactersExample() {
		String regex = "http://";
		String text1 = "http://";
		String text2 = "The URL is http://myDomain.com";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text1);
		Matcher matcher2 = pattern.matcher(text2);

		System.out.println(matcher.find());
		System.out.println(matcher2.find());
	}

	public void LineBeginingExample() {
		String text = "Line 1\nLine2\nLine3";

		Pattern pattern = Pattern.compile("^");
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			System.out.println("Found match at: " + matcher.start() + " to " + matcher.end());
		}

	}

	public void CharOnlyLineBeginning2() {
		String text = "http://jenkov.com";

		Pattern pattern = Pattern.compile("^http://");
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			System.out.println("Found match at: " + matcher.start() + " to " + matcher.end());
		}
	}

	public void EndOfLineExample() {
		String text = "http://jenkov.com";

		Pattern pattern = Pattern.compile(".com$");
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			System.out.println("Found match at: " + matcher.start() + " to " + matcher.end());
		}
	}

	public void WordBoundariesExample() {
		String text = "Mary had a little lamb";

		Pattern pattern = Pattern.compile("\\b");
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			System.out.println("Found match at: " + matcher.start() + " to " + matcher.end());
		}
	}

	public void WordBoundariesExample2() {
		String text = "Mary had a little lamb";

		Pattern pattern = Pattern.compile("\\bl");
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			System.out.println("Found match at: " + matcher.start() + " to " + matcher.end());
		}
	}

	public void NonWordBoundariesExample() {
		String text = "Mary had a little lamb";

		Pattern pattern = Pattern.compile("\\B");
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			System.out.println("Found match at: " + matcher.start() + " to " + matcher.end());
		}
	}

	public void LogicalOperatorsExample() {
		String text = "Cindarella and Sleeping Beauty sat in a tree";

		Pattern pattern = Pattern.compile("[Cc][Ii].*");
		Matcher matcher = pattern.matcher(text);

		System.out.println("matcher.matches() = " + matcher.matches());
	}

	public void LogicalOperatorExample2() {
		String text = "Cindarella and Sleeping Beauty sat in a tree";

		Pattern pattern = Pattern.compile(".*Ariel.*|.*Sleeping Beauty.*");
		Matcher matcher = pattern.matcher(text);

		System.out.println("matcher.matches() = " + matcher.matches());
	}

	public void matchingExampleRegex() {
		String text = "one two three two one";

		boolean matches = text.matches(".*two.*");

		System.out.println(matches);

	}

	public void splitExampleRegex() {
		String text = "one two three two one";

		String[] twos = text.split("two");

		for (int i = 0; i < twos.length; i++) {
			System.out.println(twos[i]);
		}
	}

	public void replaceFirstRegex() {
		String text = "one two three two one";
		String s = text.replaceFirst("two", "five");
		System.out.println(s);
	}

	public void replaceAllLikeRegex() {
		String text = "one two three two one";
		String t = text.replaceAll("two", "five");
		System.out.println(t);
	}
	
}
