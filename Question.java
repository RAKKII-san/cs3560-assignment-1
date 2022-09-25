import java.util.HashMap;

public abstract class Question extends VotingService {
    protected String query;
    protected HashMap<Character,String> answers;
    protected HashMap<Character,Integer> frequencies;

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
        frequencies.put(letter, 0);
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
        frequencies.put(letter, 0);
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

    protected void validateLetter(char letter) 
        throws IllegalArgumentException {
    if ((letter < 'A' || letter > 'Z')) {
            throw new IllegalArgumentException();
        }
    }

    // Using letters limit questions to 26 answers each
    private void validateSize() 
        throws IllegalStateException {
        if (answers.size() >= 26) {
            throw new IllegalStateException();
        }
    }

    public void setFrequency(char letter, int freq) {
        try {
            validateLetter(letter);
            frequencies.replace(letter, freq);
        } 

        catch (Exception e) {
            System.out.println(
                "Invalid letter input."
            );
        }
    }

    public int getFrequency(char letter) {
        int freq;
        try {
            validateLetter(letter);
            freq = frequencies.get(letter);
        } 

        catch (Exception e) {
            System.out.println(
                "Invalid letter input."
            );
            return 0;
        }

        return freq;
    }

    public void clearFrequencies() {
        frequencies.clear();
    }
}
