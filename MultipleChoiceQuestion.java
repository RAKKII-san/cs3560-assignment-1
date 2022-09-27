import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MultipleChoiceQuestion extends Question {
    private Set<Character> correctList;

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

    // checks answer if it's correct
    // this isn't used but assuming that the code will be expanded
    // I think this would be a good choice to let the student know
    // if they got the answer right or not
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

    // checks if all of the answers in a MCQ submission are correct
    // not used but I think this would be a good method to use
    // for an expansion
    public boolean checkCorrect(List<Character> ans) {
        if (ans.isEmpty()) return false;
        for (char c : ans) {
            if (!checkAnswer(c)) return false;
        }
        return true;
    }

    @Override
    public Set<Character> getCorrectAns() {
        return correctList;
    }

    @Override
    public void printCorrectAnswers() {
        StringBuilder sb = new StringBuilder();
        for (char c : correctList) {
            sb.append(c);
            sb.append(' ');
        }
        System.out.println(
            "Correct answers: " + sb.toString()
        );
    }

    // this is to stop the person making the questions from being
    // a total jerk and making a question with no right answers
    @Override
    public boolean validateQuestion() {
        return correctList.size() > 0;
    }
}
