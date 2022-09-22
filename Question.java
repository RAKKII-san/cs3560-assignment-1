import java.util.ArrayList;

public abstract class Question {
    protected String query;
    protected ArrayList<String> answers;

    // Adds answer to the bottom of the list
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

        answers.add(ans);
    }

    // Adds answer to index, pushing everything after it down 1 index
    public void addAnswer(int index, String ans) {
        try {
            // Using letters limit questions to 26 answers each
            validateSize();
        } 

        catch (Exception e) {
            System.out.println(
                "Questions cannot have more than 26 answers."
            );
        }

        answers.add(index, ans);
    }

    // Prints out one answer from an index
    public void printAnswer(int index)
    {
        try {
            // Using letters limit questions to 26 answers each
            validateIndex(index);
            
            String ans = answers.get(index);
            char letter = (char)(index + 'A');
            System.out.println(letter + ": " + ans);
        } 

        catch (Exception e) {
            System.out.println("Questions cannot have more than 26 answers.");
        }
    }

    // Prints all answers instead of just one
    public void printAllAnswers() {
        for (int i = 0; i < answers.size(); ++i) {
            printAnswer(i);
        }
    }

    public void setQuestion(String q) {
        this.query = q;
    }

    public void printQuestion() {
        System.out.println(this.query);    
    }

    protected void validateLetter(char letter) 
        throws IllegalArgumentException {
    if ((letter < 'A' || letter > 'Z') &&
                (letter < 'a' || letter > 'z')) {
            throw new IllegalArgumentException();
        }
    }

    protected void validateIndex(int index) 
        throws IndexOutOfBoundsException {
        if (index >= answers.size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    // Using letters limit questions to 26 answers each
    private void validateSize() 
        throws IllegalStateException {
        if (answers.size() >= 26) {
            throw new IllegalStateException();
        }
    }

    protected int letterToIndex(char letter) {
        return letter > 'Z' ? letter - 'a' : letter - 'A';
    }
}
