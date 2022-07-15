package TopWords;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
//		System.out.println(top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"));
		System.out.println(top3(
			String.join("\n", "In a village of La Mancha, the name of which I have no desire to call to",
				"mind, there lived not long since one of those gentlemen that keep a lance",
				"in the lance-rack, an old buckler, a lean hack, and a greyhound for",
				"coursing. An olla of rather more beef than mutton, a salad on most",
				"nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra",
				"on Sundays, made away with three-quarters of his income.")));
	}

	public static List<String> top3(String s) {
		// Your code here
		return Arrays.stream(s.split("\\W+"))
			.collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
			.entrySet().stream()
			.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			.limit(3)
			.map(Map.Entry::getKey)
			.collect(Collectors.toList());
	}
}
