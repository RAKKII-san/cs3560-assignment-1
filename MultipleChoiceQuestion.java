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

	// TODO Use StringJoiner to print comma-separated list
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

    // Checks the question for having at least 1 correct answer
    @Override
    public boolean validateQuestion() {
        return correctList.size() > 0;
    }

	@Override
	public boolean isSingleChoice() {
		return false;
	}
}
