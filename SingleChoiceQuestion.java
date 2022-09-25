import java.util.HashMap;

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

    public void printCorrectAns() {
        System.out.println("Correct answer: " + correctAns);
    }

    public boolean isValidSingleChoiceQ() {
        return correctAns != '\0';
    }
}
