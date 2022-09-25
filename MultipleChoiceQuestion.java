import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MultipleChoiceQuestion extends Question {
    private Set<Character> correctList;

    public MultipleChoiceQuestion() {
        this.query = "";
        this.correctList = new HashSet<>();
        this.answers = new HashMap<>();
    }

    // Constructor that initializes query
    public MultipleChoiceQuestion(String q) {
        this.query = q;
        this.correctList = new HashSet<>();
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

    // checks answer for index
    private boolean checkAnswer(char letter) {
        try {
            validateLetter(letter);
            return correctList.contains(letter);
        }

        catch (IndexOutOfBoundsException e) {
            System.out.println(
                "Invalid letter input."
            );
        }

        return false;
    }

    public boolean checkCorrect(List<Character> ans) {
        if (ans.isEmpty()) return false;
        for (char c : ans) {
            if (!checkAnswer(c)) return false;
        }
        return true;
    }

    public Set<Character> getCorrectList() {
        return correctList;
    }

    public void printCorrectList() {
        StringBuilder sb = new StringBuilder();
        for (char c : correctList) {
            sb.append(c);
            sb.append(' ');
        }
        System.out.println(
            "Correct answers: " + sb.toString()
        );
    }

    public boolean validateQuestion() {
        return correctList.size() > 0;
    }
}
