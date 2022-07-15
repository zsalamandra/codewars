package Brackets;

import java.util.Map;

public class Main {

	static Map<Character, Integer> brackets = Map.of(
		'(', 1,
		')',-1,
		'[', 2,
		']',-2,
		'{', 3,
		'}',-3
	);

	public static void main(String[] args) {
		System.out.println(isCorrectString("()x()d()33(){}{}2"));
	}

	public static boolean isCorrectString(String str) {

		char[] chars = str.toCharArray();
		Integer accChars = 0;

		for (char aChar : chars) {
			if (!brackets.containsKey(aChar)) {
				continue;
			}
			accChars += brackets.get(aChar);;
			if (accChars < 0) {
				return false;
			}
		}

		return accChars == 0;
	}

}
