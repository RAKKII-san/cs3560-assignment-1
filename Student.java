import java.util.ArrayList;

public class Student {
    ArrayList<Character> answers;
    String id;

    // There really shouldn't be a default constructor for Student
    // without ID but sure
    public Student() {
        this.id = "";
    }

    // Constructor with string id
    public Student(String id) {
        this.id = id;
    }

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