import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    // Mapping of digits to corresponding letters
    private static final Map<Character, String> digitToLetters = new HashMap<>();
    static {
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder currentCombination, List<String> result) {
        // Base case: if the current combination is the same length as the digits string, add it to the result
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        char digit = digits.charAt(index);
        String letters = digitToLetters.get(digit);

        // Iterate through the letters and make a recursive call (DFS)
        for (char letter : letters.toCharArray()) {
            // Append the letter to the current combination
            currentCombination.append(letter);
            // Move to the next digit
            backtrack(digits, index + 1, currentCombination, result);
            // Backtrack: remove the last letter to explore other possibilities
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }
}
