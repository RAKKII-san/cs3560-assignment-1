import java.util.ArrayList;

public class SingleChoiceQuestion extends Question {
    private int correctAns;

    public SingleChoiceQuestion() {
        this.correctAns = -1;
        this.answers = new ArrayList<>();
    }

    // constructor with preset question
    public SingleChoiceQuestion(String q) {
        this.query = q;
        this.correctAns = -1;
        this.answers = new ArrayList<>();
    }

    // sets correct answer with index
    public void setCorrectAns(int index) {
        try {
            validateIndex(index);
            this.correctAns = index;
        } catch (Exception e) {
            System.out.println(
                "Invalid input for setting correct answer: " + 
                "Index " + index + " out of bounds for size " + 
                this.answers.size()               
            );
        }
        
    }

    // sets correct answer with letter
    public void setCorrectAns(char letter) {
        try {
            validateLetter(letter);
            setCorrectAns(letterToIndex(letter));
        } catch (Exception e) {
            System.out.println(
                "Invalid letter input for setting correct answer."
            );
        }

    }

    // checks correct answer with index
    public boolean checkAnswer(int index) {
        try {
            validateIndex(index);
            return index == correctAns;
        } catch (Exception e) {
            System.out.println(
                "Invalid input for checking correct answer: " + 
                "Index " + index + " out of bounds for size " + 
                this.answers.size()               
            );
        }
        return false;
    }

    // checks correct answer with letter
    public boolean checkAnswer(char letter) {
        try {
            validateLetter(letter);
            return checkAnswer(letterToIndex(letter));
        } catch (Exception e) {
            System.out.println(
                "Invalid letter input for checking answer."
            );
        }
        
        return false;
    }
}
