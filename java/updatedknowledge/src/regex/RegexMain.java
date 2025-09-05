package regex;

public class RegexMain extends RegexUtil {

	public static void main(String[] args) {
		RegexUtil reg = new RegexUtil();
		
		/*
		 * 
		reg.PatternExample();
		reg.MatcherExample();
		reg.MatchingCharactersExample();
		reg.LineBeginingExample();
		reg.CharOnlyLineBeginning2();
		reg.EndOfLineExample();
		
		*/
		
		// reg.WordBoundariesExample();
		
		// reg.WordBoundariesExample2();
		
		reg.NonWordBoundariesExample();
		
		reg.LogicalOperatorsExample();
		
		reg.LogicalOperatorExample2();
		
		reg.matchingExampleRegex();
	
		reg.splitExampleRegex();
		
		reg.replaceFirstRegex();
		
		reg.replaceAllLikeRegex();
		
	}
	
}
