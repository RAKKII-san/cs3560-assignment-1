import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MultipleChoiceQuestion extends Question {
    private List<Character> correctList;

    // Constructor without preset correct answer list
    public MultipleChoiceQuestion() {
        this.correctList = new ArrayList<>();
        this.answers = new HashMap<>();
    }

    // Constructor with preset correct answer list
    public MultipleChoiceQuestion(List<Character> list) {
        this.correctList = list;
        this.answers = new HashMap<>();
    }

    // Adds correct answer for index
    public void addCorrectAns(char letter) 
            throws IllegalArgumentException, IllegalStateException {
        try {
            validateLetter(letter);

            if (answers.containsKey(letter)) {
                correctList.add(letter);
            } else {
                throw new IllegalStateException();
            }
        } 

        catch (IllegalArgumentException e) {
            System.out.println(
                "Invalid letter input, letter must be A-Z."
            );
        }

        catch (IllegalStateException e2) {
            System.out.println(letter + " not in answer list.");
        }
    }

    // Removes correct answer
    // Needs input validation first and have it be in the list
    public void removeCorrectAns(char letter) 
            throws IllegalArgumentException, IllegalStateException {
        try {
            validateLetter(letter);
            if (answers.containsKey(letter)) {
                correctList.remove(letter);
            } else {
                throw new IllegalStateException();
            }
        } 

        catch (IllegalArgumentException e) {
            System.out.println(
                "Invalid letter input, letter must be A-Z."
            );
        }

        catch (IllegalStateException e2) {
            System.out.println(letter + " not in correct answer list!");
        }

        correctList.remove(letter);
    }

    // Returns correct answer list
    public List<Character> getCorrectAns() {
        return correctList;
    }

	// Prints out all answers in a comma-separated list
    @Override
    public void printCorrectAns() {
        StringBuilder ansList = new StringBuilder();

        for (char c : correctList) {
            ansList.append(c);
            ansList.append(", ");
        }
        System.out.println(
            // removes last comma
            "Correct answer(s): " 
                + ansList.substring(0, ansList.length() - 2)
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
