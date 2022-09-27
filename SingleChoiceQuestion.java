import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SingleChoiceQuestion extends Question {
    private char correctAns;

    public SingleChoiceQuestion() {
        this.correctAns = '\0';
        this.answers = new HashMap<>();
    }

    // constructor with preset question
    public SingleChoiceQuestion(String q) {
        this.query = q;
        this.correctAns = '\0';
        this.answers = new HashMap<>();
    }

    // constructor with preset question and correct answer
    public SingleChoiceQuestion(String q, char correctAns) {
        this.query = q;
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

    // checks correct answer with index
    // this isn't used but assuming that the code will be expanded
    // I think this would be a good choice to let the student know
    // if they got the answer right or not
    public boolean checkAnswer(char letter) {
        try {
            validateLetter(letter);
            return letter == correctAns;
        } catch (Exception e) {
            System.out.println(
                "Invalid letter input."
            );
        }
        return false;
    }

    // despite the plural name it should only print 1 correct answer
    @Override
    public void printCorrectAnswers() {
        System.out.println("Correct answer: " + correctAns);
    }

    // this is to stop the person making the questions from being
    // a total jerk and making a question with no right answers
    public boolean validateQuestion() {
        return correctAns != '\0';
    }

    // even though there's only one correct answer the method
    // still requires the return to be a set
	@Override
	protected Set<Character> getCorrectAns() {
		Set<Character> ans = new HashSet<Character>();
        ans.add(correctAns);
        return ans;
	}
}
