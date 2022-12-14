import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.HashMap;

public class VotingService {
    private Question question;
    private Map<Student, List<Character>> submissions;
    private Map<Character,Integer> frequencies;

    // Constructs the voting service using a preset question
    public VotingService(Question q) {
        this.question = q;
        this.submissions = new HashMap<>();
        this.frequencies = new HashMap<>();
    }
    
    // Prints question and all answers from the question
    public void printQuestion() {
        question.printQuestion();
        question.printAllAnswers();
    }

    // Submits answer from a given student to the submission and
    // frequency maps
    public void submitAnswer(Student stu) {
        // if student has already submitted, delete last submission first
        if (submissions.containsKey(stu)) {
            List<Character> temp = submissions.get(stu);
            if (question.isSingleChoice()) { 
                char c = temp.get(0); // only one answer in SCQ
                setFrequency(c, frequencies.get(c) - 1);
            } else { // multiple choice question requires multiple answers
                for (char c : temp) {
                    setFrequency(c, frequencies.get(c) - 1);
                }
            }

            submissions.remove(stu);
        }

        // Add answer to frequencies
        if (question.isSingleChoice()) { // when only one answer is allowed
            char c = stu.answers.get(0);
            setFrequency(c, frequencies.getOrDefault(c, 0) + 1);
        } else {
            // add frequency for given answer by 1 for each answer in list
            for (char c : stu.answers) {
                setFrequency(c, frequencies.getOrDefault(c, 0) + 1);
            }
        }
        
        submissions.put(stu, stu.answers); // assign answer(s) to a student
        stu.clearAnswers(); // resets student's answers
    }

    // Print correct answers and frequencies for all responses
    // Requires the question to have at least one correct answer
    public void printResults() 
            throws IllegalStateException {
        try {
            // checks if question has >= 1 correct answer
            if (!question.validateQuestion()) {
                throw new IllegalStateException();
            }

            question.printCorrectAns();
            System.out.println("Answer Frequencies: ");
            printAllFrequencies();
        } catch (Exception e) {
            System.out.println(
                "Question is not valid, needs a correct answer"
            );
        }
    }

    // Sets frequency for a letter choice
    public void setFrequency(char letter, int freq) 
            throws IllegalArgumentException {
        try {
            validateLetter(letter); // letter must be A-Z
            frequencies.put(letter, freq);
        } 

        catch (Exception e) {
            System.out.println(
                "Invalid letter input, letter must be A-Z."
            );
        }
    }

    // get the frequency for a specific choice
    public int getFrequency(char letter) 
            throws IllegalArgumentException {
        int freq;
        try {
            validateLetter(letter); // letter must be A-Z
            freq = frequencies.get(letter);
        } 

        catch (Exception e) {
            System.out.println(
                "Invalid letter input, letter must be A-Z."
            );
            return 0;
        }

        return freq;
    }

    // Prints out all frequencies in a comma-separated list
    public void printAllFrequencies() {
        String delimiter = ", "; 
        StringJoiner joiner = new StringJoiner(delimiter);

        // character = answer letter, integer = frequency for that answer
        for (Map.Entry<Character,Integer> freq : frequencies.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(freq.getKey() + ": " + freq.getValue());
            joiner.add(sb.toString());
        }

        System.out.println(joiner.toString());
    }

    // Letters should only be capital alphabet letters
    // So anything else would throw an exception
    private void validateLetter(char letter) 
            throws IllegalArgumentException {
        if ((letter < 'A' || letter > 'Z')) {
            throw new IllegalArgumentException();
        }
    }
}
