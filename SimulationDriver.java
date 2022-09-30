import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class SimulationDriver {
    public static Map<Integer, Student> studentList = new HashMap<>();
    public static ArrayList<Question> questionList = new ArrayList<>();  

    // A given number of students are added to the student list
    public static void addStudents(int population) {
        for (int i = 0; i < population; i++) {
            StringBuilder sb = new StringBuilder("Student ");
            sb.append(i + 1); // Student ID number is 1-indexed
            Student newStudent = new Student(sb.toString());
            studentList.put(i, newStudent);
        }
    }

    // Student randomly picks answers from a multiple choice question
    public static void chooseMCQAnswer(Student s, Question q) 
            throws IllegalArgumentException {
        for (int i = 0; i < q.getNumberOfAnswers(); i++) {
            // If random > 0.75 the student will choose the answer
            if (Math.random() > 0.75) {
                char letter = (char)('A' + i);
                s.addAnswer(letter);
            }
        }
    }

    // Student randomly picks 1 answer from all possible answers
    public static void chooseSCQAnswer(Student s, Question q) 
            throws IllegalArgumentException {
        // Student chooses (n + 1)th answer,
        // n = random int from 0 to total answers - 1
        int totalAnswers = q.getNumberOfAnswers();
        int random = (int)(Math.random() * totalAnswers);
        char ans = (char)('A' + random);
        s.addAnswer(ans);
    }

    // Provides a set of questions
    public static void setQuestions() {
        String q1Query = 
            "What is the answer to life, the universe, & everything?";
        SingleChoiceQuestion q1 = new SingleChoiceQuestion('B');
        q1.setQuestion(q1Query);
        q1.addAnswer('A',"Getting a job with Amazon");
        q1.addAnswer('B',"42");
        q1.addAnswer('C',"getAnswer(life, universe, everything)");
        q1.addAnswer('D',"We don't know");
        questionList.add(q1);

        String q2Query = 
            "What's an acceptable time to go to bed?";
        MultipleChoiceQuestion q2 = new MultipleChoiceQuestion();
        q2.setQuestion(q2Query);
        q2.addAnswer('A',"9:00 PM");
        q2.addAnswer('B',"10:00 PM");
        q2.addAnswer('C',"11:00 PM");
        q2.addAnswer('D',"12:00 AM");
        q2.addAnswer('E',"1:00 AM");
        q2.addAnswer('F',"2:00 AM");
        q2.addAnswer('G',"3:00 AM");
        q2.addAnswer('H',"4:00 AM");
        q2.addAnswer('I',"5:00 AM");
        q2.addAnswer('J',"Not getting any sleep at all");
        q2.addCorrectAns('A');
        q2.addCorrectAns('B');
        q2.addCorrectAns('C');
        q2.addCorrectAns('D');
        q2.addCorrectAns('E');
        q2.addCorrectAns('F');
        q2.addCorrectAns('G');
        q2.addCorrectAns('H');
        q2.addCorrectAns('I');
        questionList.add(q2);

        String q3Query = 
            "Should you practice LeetCode?";
        SingleChoiceQuestion q3 = new SingleChoiceQuestion('A');
        q3.setQuestion(q3Query);
        q3.addAnswer('A',"Yes");
        q3.addAnswer('B',"No");
        questionList.add(q3);

        String q4Query = 
            "Is this statement false?";
        MultipleChoiceQuestion q4 = new MultipleChoiceQuestion();
        q4.setQuestion(q4Query);
        q4.addAnswer('A',"Yes");
        q4.addAnswer('B',"No");
        q4.addCorrectAns('A');
        q4.addCorrectAns('B');
        questionList.add(q4);

        String q5Query = 
            "The answer is really big.";
        SingleChoiceQuestion q5 = new SingleChoiceQuestion('D');
        q5.setQuestion(q5Query);
        q5.addAnswer('A',"ANSWER");
        q5.addAnswer('B',"really big");
        q5.addAnswer('C',"Infinity");
        q5.addAnswer('D',"An elephant");
        q5.setCorrectAns('D');
        questionList.add(q5);

        String q6Query = 
            "I'm already running out of ideas for questions.";
        MultipleChoiceQuestion q6 = new MultipleChoiceQuestion();
        q6.setQuestion(q6Query);
        q6.addAnswer('A',"Booooooo");
        q6.addAnswer('B',"You stink!");
        q6.addAnswer(
            'C',"hey why does this question only have one right answer"
        );
        q6.addAnswer('D',"lol");
        q6.addCorrectAns('C');
        questionList.add(q6);

        String q7Query = 
            "Did you read the Terms and Conditions before answering?";
        SingleChoiceQuestion q7 = new SingleChoiceQuestion('A');
        q7.setQuestion(q7Query);
        q7.addAnswer('A',"Yes.");
        q7.setCorrectAns('A');
        questionList.add(q7);

        String q8Query = 
            "What letter do you like best?";
        MultipleChoiceQuestion q8 = new MultipleChoiceQuestion();
        q8.setQuestion(q8Query);
        q8.addAnswer('A',"A");
        q8.addAnswer('B',"B");
        q8.addAnswer('C',"C");
        q8.addAnswer('D',"D");
        q8.addAnswer('E',"E");
        q8.addAnswer('F',"F");
        q8.addAnswer('G',"G");
        q8.addAnswer('H',"H");
        q8.addAnswer('I',"I");
        q8.addAnswer('J',"J");
        q8.addAnswer('K',"K");
        q8.addAnswer('L',"L");
        q8.addAnswer('M',"M");
        q8.addAnswer('N',"N");
        q8.addAnswer('O',"O");
        q8.addAnswer('P',"P");
        q8.addAnswer('Q',"Q");
        q8.addAnswer('R',"R");
        q8.addAnswer('S',"S");
        q8.addAnswer('T',"T");
        q8.addAnswer('U',"U");
        q8.addAnswer('V',"V");
        q8.addAnswer('W',"W");
        q8.addAnswer('X',"X");
        q8.addAnswer('Y',"Y");
        q8.addAnswer('Z',"Z");
        q8.addCorrectAns('A');
        q8.addCorrectAns('B');
        q8.addCorrectAns('C');
        q8.addCorrectAns('D');
        q8.addCorrectAns('E');
        q8.addCorrectAns('F');
        q8.addCorrectAns('G');
        q8.addCorrectAns('H');
        q8.addCorrectAns('I');
        q8.addCorrectAns('J');
        q8.addCorrectAns('K');
        q8.addCorrectAns('L');
        q8.addCorrectAns('M');
        q8.addCorrectAns('N');
        q8.addCorrectAns('O');
        q8.addCorrectAns('P');
        q8.addCorrectAns('Q');
        q8.addCorrectAns('R');
        q8.addCorrectAns('S');
        q8.addCorrectAns('T');
        q8.addCorrectAns('U');
        q8.addCorrectAns('V');
        q8.addCorrectAns('W');
        q8.addCorrectAns('X');
        q8.addCorrectAns('Y');
        q8.addCorrectAns('Z');
        questionList.add(q8);
    }

    // Chooses a question from the question list and removes it
    // to prevent the same question from being picked twice
    public static Question chooseQuestion() {
        int randomQ = (int)(Math.random() * questionList.size());
        Question returnQ = questionList.get(randomQ);
        questionList.remove(randomQ);
        return returnQ;
    }
    public static void main(String[] args) 
        throws IllegalArgumentException, IllegalStateException {
        // Randomly chooses between 100-199 students to test
        int numOfStudents = (int)(Math.random() * 100 + 100);

        // Number is editable, however only 8 example questions 
        // were made; if numOfQuestions > actual number of questions,
        // the for loop ends early
        int numOfQuestions = 8;

        // Prints out number of students and questions
        System.out.printf(
            "Testing %d students on %d questions.\n", 
            numOfStudents, numOfQuestions
        );

        addStudents(numOfStudents);
        setQuestions();

        // Goes through each question per loop iteration
        for (int i = 0; i < numOfQuestions; i++) {
            // To prevent empty list issues
            if (questionList.isEmpty()) break; 

            Question currQ = chooseQuestion();
            VotingService vote = new VotingService(currQ);
            System.out.printf("\nQuestion %d:\n", i + 1);
            vote.printQuestion();

            for (int j = 0; j < studentList.size(); j++) {
                Student stu = studentList.get(j);
                if (currQ.isSingleChoice()) {
                    chooseSCQAnswer(stu, currQ);
                } else {
                    chooseMCQAnswer(stu, currQ);
                }
                vote.submitAnswer(stu);
            }

            vote.printResults();
        }
    }
}
