import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.HashMap;

public class VotingService {
    private Question q;
    private HashMap<Student, List<Character>> submissions;
    private HashMap<Character,Integer> frequencies;

    public VotingService() {
        this.submissions = new HashMap<>();
    }

    public VotingService(Question q) {
        this.q = q;
        this.submissions = new HashMap<>();
        initializeFrequencies();
    }
    
    public void printQuestion() {
        q.printQuestion();
        q.printAllAnswers();
    }

    // when multiple answers are allowed
    public void submitAnswer(MultipleChoiceQuestion q, Student stu) {
        // if student has already submitted, delete last submission first
        if (submissions.containsKey(stu)) {
            List<Character> temp = submissions.get(stu);
            for (char c : temp) {
                setFrequency(c, frequencies.get(c) - 1);
            }
            submissions.remove(stu);
        }

        // add frequency for given answer by 1 for each answer in list
        for (char c : stu.answers) {
            setFrequency(c, frequencies.getOrDefault(c, 0) + 1);
        }

        submissions.put(stu, stu.answers);
    }

    // when only one answer is allowed
    public void submitAnswer(SingleChoiceQuestion q, Student stu) {
        // if student has already submitted, delete last submission first
        if (submissions.containsKey(stu)) {
            List<Character> temp = submissions.get(stu);
            char c = temp.get(0);
            setFrequency(c, frequencies.get(c) - 1);
            submissions.remove(stu);
        }

        // add frequency for given answer by 1 for student's first answer in list
        char c = stu.answers.get(0);
        setFrequency(c, frequencies.getOrDefault(c, 0) + 1);

        submissions.put(stu, stu.answers);
    }

    public void printResults(Question q) {
        try {
            if (!q.validateQuestion()) {
                throw new IllegalStateException();
            }
            q.printCorrectAnswers();
            printAllFrequencies();
        } catch (Exception e) {
            System.out.println(
                "Question is not valid, needs a correct answer"
            );
        }
    }

    // sets frequency for a letter choice
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

    // get the frequency for a specific choice
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

    // sets all frequencies to 0
    private void initializeFrequencies() {
        for (char c : q.answers.keySet()) {
            frequencies.put(c, 0);
        }
    }

    // prints out all frequencies
    public void printAllFrequencies() {
        String delimiter = ", ";
        StringJoiner joiner = new StringJoiner(delimiter);
        for (Map.Entry<Character,Integer> freq : frequencies.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(freq.getKey() + ": " + freq.getValue());
            joiner.add(sb.toString());
        }

        System.out.println(joiner.toString());
    }

    // letters should only be capital alphabet letters
    // so anything else would throw an exception just in case
    private void validateLetter(char letter) 
        throws IllegalArgumentException {
        if ((letter < 'A' || letter > 'Z')) {
            throw new IllegalArgumentException();
        }
    }
}
