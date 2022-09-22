import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MultipleChoiceQuestion extends Question {
    private Set<Integer> correctList;

    public MultipleChoiceQuestion() {
        this.correctList = new HashSet<>();
        this.answers = new ArrayList<>();
    }

    public MultipleChoiceQuestion(String q) {
        this.query = q;
        this.correctList = new HashSet<>();
        this.answers = new ArrayList<>();
    }

    // Adds correct answer for index
    public void addCorrectAns(int index) {
        try {
            validateIndex(index);
        } 

        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        
        if (!correctList.contains(index)) {
            correctList.add(index);
        }
    }

    // Adds correct answer for letter
    public void addCorrectAns(char letter) {
        try {
            validateLetter(letter);
        }

        catch (IllegalArgumentException e) {
            System.out.println(
                "Invalid letter input for adding correct answer."
            );
        }

        addCorrectAns(letterToIndex(letter));
    }

    // Removes correct answer for index
    public void removeCorrectAns(int index) {
        try {
            if (!correctList.contains(index)) {
                throw new IllegalArgumentException();
            } else {
                correctList.remove(index);
            }
        }

        catch (IllegalArgumentException e) {
            System.out.println(
                "Correct Answer does not exist in list."
            );
        }
    }

    // Removes correct answer for letter
    public void removeCorrectAns(char letter) {
        try {
            validateLetter(letter);
        }

        catch (IllegalArgumentException e) {
            System.out.println(
                "Invalid letter input for removing correct answer."
            );
        }

        removeCorrectAns(letterToIndex(letter));
    }

    // checks answer for index
    public boolean checkAnswer(int index) {
        try {
            validateIndex(index);
        }

        catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        return correctList.contains(index);
    }

    // checks answer for letter
    public boolean checkAnswer(char letter) {
        try {
            validateLetter(letter);
        }

        catch (IllegalArgumentException e) {
            System.out.println(
                "Invalid letter input for checking answer."
            );
        }

        return checkAnswer(letterToIndex(letter));
    }
}
