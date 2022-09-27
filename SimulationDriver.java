import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SimulationDriver {
    public static HashMap<Integer, Student> students;
    public static Set<Question> questionSet = new HashSet<>();  
    // end questionSet
    public void addStudents(int population) {
        for (int i = 0; i < population; i++) {
            StringBuilder sb = new StringBuilder("Student ");
            sb.append(i + 1);
            Student newStudent = new Student(sb.toString());
            students.put(i, newStudent);
        }
    }

    // if random > 0.5 the student will choose the answer
    public static boolean chooseMCQAnswer(Student s) {
        double random = Math.random();
        return random > 0.5;
    }

    // student will randomly pick 1 answer from all possible answers
    public static void chooseSCQAnswer(Student s, Question q) {
        int totalAnswers = q.getNumberOfAnswers();
        int random = (int)(Math.random() * totalAnswers);
        char ans = (char)('A' + random);
        s.addAnswer(ans);
    }

    // here I hardcode a set of questions
    public static void setQuestions() {
        String q1Query = 
            "What is the answer to life, the universe, & everything?";
        SingleChoiceQuestion q1 = new SingleChoiceQuestion(q1Query);
        q1.addAnswer('A',"Getting a job with Amazon");
        q1.addAnswer('B',"42");
        q1.addAnswer('C',"getAnswer(life, universe, everything)");
        q1.addAnswer('D',"We don't know");
        q1.setCorrectAns('B');
        questionSet.add(q1);

        String q2Query = 
            "What's an acceptable time to go to bed?";
        MultipleChoiceQuestion q2 = new MultipleChoiceQuestion(q2Query);
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
        questionSet.add(q2);

        String q3Query = 
            "Should you practice LeetCode?";
        SingleChoiceQuestion q3 = new SingleChoiceQuestion(q3Query);
        q3.addAnswer('A',"Yes");
        q3.addAnswer('B',"No");
        q3.setCorrectAns('A');
        questionSet.add(q3);

        String q4Query = 
            "Is this statement false?";
        MultipleChoiceQuestion q4 = new MultipleChoiceQuestion(q4Query);
        q4.addAnswer('A',"Yes");
        q4.addAnswer('B',"No");
        q4.addCorrectAns('A');
        q4.addCorrectAns('B');
        questionSet.add(q4);

        String q5Query = 
            "The answer is really big.";
        SingleChoiceQuestion q5 = new SingleChoiceQuestion(q5Query);
        q5.addAnswer('A',"ANSWER");
        q5.addAnswer('B',"really big");
        q5.addAnswer('C',"Infinity");
        q5.addAnswer('D',"An elephant");
        q5.setCorrectAns('D');
        questionSet.add(q5);


    }

    public static void main(String[] args) {
        setQuestions();
    }
}
