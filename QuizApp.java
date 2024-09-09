import java.util.*;

public class QuizApp {
    // Class representing each quiz question
    static class Question {
        String questionText;
        String[] options;
        int correctAnswerIndex;

        // Constructor for a question
        public Question(String questionText, String[] options, int correctAnswerIndex) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswerIndex = correctAnswerIndex;
        }
    }

    // Timer class to handle time limits for each question
    static class Timer extends Thread {
        private boolean timeUp = false;
        private int timeLimit;

        public Timer(int timeLimit) {
            this.timeLimit = timeLimit;
        }

        public void run() {
            try {
                Thread.sleep(timeLimit * 1000); // timeLimit in seconds
                timeUp = true;
            } catch (InterruptedException e) {
                // Do nothing if interrupted
            }
        }

        public boolean isTimeUp() {
            return timeUp;
        }
    }

    // Method to run the quiz
    public static void runQuiz(List<Question> quizQuestions) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        Map<Question, Boolean> answerSummary = new HashMap<>();

        // Loop through each question
        for (int i = 0; i < quizQuestions.size(); i++) {
            Question question = quizQuestions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.questionText);
            for (int j = 0; j < question.options.length; j++) {
                System.out.println((j + 1) + ". " + question.options[j]);
            }

            Timer timer = new Timer(10); // Set a 10-second timer for each question
            timer.start();

            int userAnswer = 0;
            boolean answered = false;

            // Allow user to submit the answer within the time limit
            while (!timer.isTimeUp() && !answered) {
                System.out.print("Enter your answer (1-" + question.options.length + "): ");
                if (scanner.hasNextInt()) {
                    userAnswer = scanner.nextInt();
                    answered = true;
                } else {
                    System.out.println("Please enter a valid option.");
                    scanner.next(); // Clear invalid input
                }
            }

            if (!answered) {
                System.out.println("\nTime's up! Moving to the next question.");
            } else {
                if (userAnswer == (question.correctAnswerIndex + 1)) {
                    System.out.println("Correct!");
                    score++;
                    answerSummary.put(question, true);
                } else {
                    System.out.println("Incorrect.");
                    answerSummary.put(question, false);
                }
            }

            System.out.println();
        }

        // Display the final result and summary
        System.out.println("Quiz Completed!");
        System.out.println("Your final score: " + score + " out of " + quizQuestions.size());

        // Summary of correct/incorrect answers
        System.out.println("\nSummary of your answers:");
        for (Question q : answerSummary.keySet()) {
            System.out.println(q.questionText);
            if (answerSummary.get(q)) {
                System.out.println("Your answer: Correct");
            } else {
                System.out.println("Your answer: Incorrect");
            }
        }
    }

    public static void main(String[] args) {
        // List of quiz questions
        List<Question> quizQuestions = new ArrayList<>();
        quizQuestions.add(new Question("What is the capital of France?",
                new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 2));
        quizQuestions.add(new Question("Which planet is known as the Red Planet?",
                new String[]{"Earth", "Mars", "Jupiter", "Venus"}, 1));
        quizQuestions.add(new Question("Which element has the chemical symbol 'O'?",
                new String[]{"Oxygen", "Gold", "Osmium", "Oganesson"}, 0));

        // Run the quiz
        runQuiz(quizQuestions);
    }
}
