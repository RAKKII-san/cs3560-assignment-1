import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MultipleChoiceQuestion extends Question {
    private List<Character> correctList;

    // Constructor that initializes query
    public MultipleChoiceQuestion() {
        this.correctList = new ArrayList<>();
        this.answers = new HashMap<>();
    }

    // Adds correct answer for index
    public void addCorrectAns(char letter) {
        try {
            validateLetter(letter);
            if (answers.containsKey(letter)) {
                correctList.add(letter);
            } else {
                System.out.println(letter + " not in correct answer list!");
            }
        } 

        catch (IndexOutOfBoundsException e) {
            System.out.println(
                "Invalid letter input."
            );
        }
    }

    // Removes correct answer
    public void removeCorrectAns(char letter) {
        try {
            validateLetter(letter);
            if (answers.containsKey(letter)) {
                correctList.remove(letter);
            } else {
                System.out.println(letter + " not in correct answer list!");
            }
        } 

        catch (IndexOutOfBoundsException e) {
            System.out.println(
                "Invalid letter input."
            );
        }

        correctList.remove(letter);
    }

    public List<Character> getCorrectAns() {
        return correctList;
    }

    @Override
    public void printCorrectAns() {
        StringBuilder sb = new StringBuilder();
        for (char c : correctList) {
            sb.append(c);
            sb.append(' ');
        }
        System.out.println(
            "Correct answer(s): " + sb.toString()
        );
    }

    // this is to stop the person making the questions from being
    // a total jerk and making a question with no right answers
    @Override
    public boolean validateQuestion() {
        return correctList.size() > 0;
    }

	@Override
	public boolean isSingleChoice() {
		return false;
	}
}
