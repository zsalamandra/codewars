package TopWords;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		System.out.println(top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"));
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
