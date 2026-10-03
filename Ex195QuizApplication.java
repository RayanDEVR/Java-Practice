/*
Quiz Application [Mini Project | Project]
Model Question, Option data using arrays/fields, Quiz and QuizResult. Use Scanner, validation loops and 
enums/status as useful. Score answers and provide final review.
Done when: Invalid choices do not consume a question; score is correct; questions are not hard-coded entirely 
inside main.
*/

import java.util.*;

class Question {
    int id;
    String question;
    String[] options;
    int correctAnswer;
    
    Question(int id, String question, String[] options, int correctAnswer) {
        this.id = id;
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

class QuizResult {
    int totalQuestions;
    int correctAnswers;
    int wrongAnswers;
    
    QuizResult(int totalQuestions, int correctAnswers) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.wrongAnswers = totalQuestions - correctAnswers;
    }
    
    void showResult() {
        System.out.println("\nQuiz Result:");
        System.out.println("Total Questions: " + totalQuestions);
        System.out.println("Correct Answers: " + correctAnswers);
        System.out.println("Wrong Answers: " + wrongAnswers);
        System.out.println("Score: " + correctAnswers +"/" + totalQuestions);
    }
}

class Quiz {
    List<Question> questions = new ArrayList<>();
    
    void addQuestion(Question question) {
        questions.add(question);
    }
    
    QuizResult startQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int answer;
        
        for (Question q: questions) {
            System.out.println("\n" + q.id + ". " + q.question);
            
            for (int i = 0; i < q.options.length; i++) {
                System.out.println((i+1) + ") " + q.options[i]);
            }
            
            while(true) {
                System.out.print("Choose your answer (1-" + q.options.length + "): ");
                answer = scanner.nextInt();
                
                if (answer < 1 || answer > q.options.length) {
                    System.out.println("Invalid choice! Choose again.");
                    continue;
                }
                
                if (answer == q.correctAnswer) {
                    score++;
                }
                
                break;
            }
        }
            
        return new QuizResult(questions.size(), score);
    }
}

public class Ex195QuizApplication {
    public static void main(String[] args) {
        
        Quiz quiz = new Quiz();
        
        quiz.addQuestion(new Question(1, "Which language is used for Spring Boot?", new String[]{"Python", "Java", "HTML", "C"}, 2));
        quiz.addQuestion(new Question(2, "Which collection stores key-value pairs?", new String[]{"List", "Set", "Map", "Queue"}, 3));
        quiz.addQuestion(new Question(3, "Which keyword creates an object in Java?", new String[]{"class", "new", "this", "void"}, 2));
        
        QuizResult result = quiz.startQuiz();
        
        result.showResult();
    }
}