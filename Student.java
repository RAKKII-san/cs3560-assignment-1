import java.util.ArrayList;
import java.util.List;

public class Student {
    List<Character> answers;
    String id;

    // Constructor with string id
    public Student(String id) {
        this.id = id;
        this.answers = new ArrayList<>();
    }

    // Adds answer to bottom of the list for Student
    // Requires input validation first
    public void addAnswer(char letter) {
        try {
            validateLetter(letter);
            answers.add(letter);
        }
        catch (Exception e) {
            System.out.println(
                "Invalid letter input."
            );
        }
    }

    // char can't just be anything, it has to be A-Z capital letters
    private void validateLetter(char letter) 
        throws IllegalArgumentException {
    if ((letter < 'A' || letter > 'Z')) {
            throw new IllegalArgumentException();
        }
    }
}
