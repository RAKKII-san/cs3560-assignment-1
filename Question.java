import java.util.List;
import java.util.Map;

public abstract class Question {
    protected String query;
    protected Map<Character,String> answers;

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
    public void addAnswer(char letter, String ans) 
            throws IllegalArgumentException, IllegalStateException {
        try {
            validateLetter(letter);
        }

        catch (Exception e) {
            System.out.println(
                "Invalid letter input, letter must be A-Z."
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
    private void printAnswer(char letter)
            throws IllegalArgumentException {
        validateLetter(letter);
        
        String ans = answers.get(letter);
        System.out.println(letter + ": " + ans);
    }

    // Prints all answers instead of just one
    public void printAllAnswers() {
        char letter = 'A';

        for (int i = 0; i < answers.size(); ++i) {
            printAnswer(letter);
            letter++;
        }
    }

    // Sets question query
    public void setQuestion(String q) {
        this.query = q;
    }

    // Prints the question query
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

    // Letters should only be capital alphabet letters
    // so anything else would throw an exception just in case
    protected void validateLetter(char letter) 
            throws IllegalArgumentException {
        if ((letter < 'A' || letter > 'Z')) {
            throw new IllegalArgumentException(
                "Invalid letter input, letter must be A-Z."
            );
        }
    }

    public int getNumberOfAnswers() {
        return answers.size();
    }

    protected abstract void printCorrectAns();
    protected abstract boolean validateQuestion();
    public abstract List<Character> getCorrectAns();
    public abstract boolean isSingleChoice();
}
