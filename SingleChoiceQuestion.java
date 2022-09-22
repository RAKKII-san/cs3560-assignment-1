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
        validateIndex(index);
        this.correctAns = index;
    }

    // sets correct answer with letter
    public void setCorrectAns(char letter) {
        validateLetter(letter);
        setCorrectAns(letterToIndex(letter));
    }

    // checks correct answer with index
    public boolean checkAnswer(int index) {
        validateIndex(index);
        return index == correctAns;
    }

    // checks correct answer with letter
    public boolean checkAnswer(char letter) {
        validateLetter(letter);
        return checkAnswer(letterToIndex(letter));
    }
}
