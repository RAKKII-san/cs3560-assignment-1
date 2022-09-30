import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class SingleChoiceQuestion extends Question {
    private char correctAns;

    // Constructor with preset question but no preset correct answer
    public SingleChoiceQuestion() {
        this.correctAns = '\0';
        this.answers = new HashMap<>();
    }

    // Constructor with preset question and correct answer
    public SingleChoiceQuestion(char correctAns) {
        this.correctAns = correctAns;
        this.answers = new HashMap<>();
    }

    // Sets correct answer with letter
    public void setCorrectAns(char letter) 
            throws IllegalArgumentException {
        try {
            validateLetter(letter); // letter must be A-Z
            this.correctAns = letter;
        } catch (Exception e) {
            System.out.println(
                "Invalid letter input, letter must be A-Z."
            );
        }
    }

    // Print only 1 correct answer
    @Override
    public void printCorrectAns() {
        System.out.println("Correct answer: " + correctAns);
    }

    // Checks the question for having 1 correct answer
    public boolean validateQuestion() {
        return correctAns != '\0';
    }

    // Even though there's only one correct answer the method
    // still requires the return to be a list
	public List<Character> getCorrectAns() {
		List<Character> ans = new ArrayList<Character>();
        ans.add(correctAns);
        return ans;
	}

	@Override
	public boolean isSingleChoice() {
		return true;
	}
}
