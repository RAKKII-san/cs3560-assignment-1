import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class SingleChoiceQuestion extends Question {
    private char correctAns;

    // constructor with preset question
    public SingleChoiceQuestion() {
        this.correctAns = '\0';
        this.answers = new HashMap<>();
    }

    // constructor with preset question and correct answer
    public SingleChoiceQuestion(char correctAns) {
        this.correctAns = correctAns;
        this.answers = new HashMap<>();
    }

    // sets correct answer with letter
    public void setCorrectAns(char letter) {
        try {
            validateLetter(letter);
            this.correctAns = letter;
        } catch (Exception e) {
            System.out.println(
                "Invalid letter input."
            );
        }
    }

    // it should only print 1 correct answer
    @Override
    public void printCorrectAns() {
        System.out.println("Correct answer: " + correctAns);
    }

    // this is to stop the person making the questions from being
    // a total jerk and making a question with no right answers
    public boolean validateQuestion() {
        return correctAns != '\0';
    }

    // even though there's only one correct answer the method
    // still requires the return to be a set
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
