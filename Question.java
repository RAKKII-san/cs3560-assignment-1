import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public abstract class Question {
    protected String query;
    protected Map<Character,String> answers;

    public Question() {
        this.answers = new HashMap<>();
    }

    // Adds answer to the end of the list
    public void addAnswer(String ans) {
        try {
            // Using letters limit questions to 26 answers each
            validateSize();
        } 

        catch (Exception e) {
            System.out.println(
                "Questions cannot have more than 26 answers."
            );
        }

        char letter = (char)(answers.size() + 'A');
        answers.put(letter, ans);
    }

    // Adds answer to a letter on the list
    // If letter already exists in answer list, new ans replaces old
    // If letter does not exist, ans is placed at the end of the list
    public void addAnswer(char letter, String ans) {
        try {
            validateLetter(letter);
        }

        catch (Exception e) {
            System.out.println(
                "Invalid letter input."
            );
        }

        if (!answers.containsKey(letter)) {
            try {
                // Using letters limit questions to 26 answers each
                validateSize();
                letter = (char)(answers.size() + 'A');
            } 
    
            catch (Exception e) {
                System.out.println(
                    "Questions cannot have more than 26 answers."
                );
                return;
            }
        }

        answers.put(letter, ans);
    }


    // Prints out one answer from a letter
    public void printAnswer(char letter)
    {
        try {
            validateLetter(letter);
            
            String ans = answers.get(letter);
            System.out.println(letter + ": " + ans);
        } 

        catch (Exception e) {
            System.out.println(
                "Invalid letter input."
            );
        }
    }

    // Prints all answers instead of just one
    public void printAllAnswers() {
        char letter = 'A';
        for (int i = 0; i < answers.size(); ++i) {
            printAnswer(letter);
            letter++;
        }
    }

    public void setQuestion(String q) {
        this.query = q;
    }

    public void printQuestion() {
        System.out.println(this.query);    
    }

    // Using letters limit questions to 26 answers each
    private void validateSize() 
        throws IllegalStateException {
        if (answers.size() >= 26) {
            throw new IllegalStateException();
        }
    }

    // letters should only be capital alphabet letters
    // so anything else would throw an exception just in case
    protected void validateLetter(char letter) 
        throws IllegalArgumentException {
        if ((letter < 'A' || letter > 'Z')) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumberOfAnswers() {
        return answers.size();
    }

    protected abstract void printCorrectAnswers();
    protected abstract boolean validateQuestion();
    protected abstract Set<Character> getCorrectAns();
}
