/**
 * Names: Ishan Garg, Krish Patel, Pranav Mahabal
 * Course: MCV4U0-1
 * Date: January 18, 2023
 * Teacher: Ms Iulia Gugoiu
 * 
 * Generates the applications of differentiation questions.
 */

import java.util.Random;

public class ApplyDiffQuestions {

    private double correctAnswer;
    private String displayFunction;
    private int x;
    private int y;
    private String question;
    private Random rand;
    private String[] displayFunctions;

    /**
     * Class constructor.
     */
    public ApplyDiffQuestions() {
        correctAnswer = 0.0;
        displayFunctions = new String[] {
                "sin^2(x)/x^2",
                "(1-cos(x))/x^2",
                "(sin(x)-x)/x^3",
                "((e^x)-1-x)/x^2",
                "tan(x)/x"
        };
        x = 0;
        y = 0;
        question = "";
        rand = new Random();
    }

    /**
     * Generates the balloon volume related rates question.
     */
    private void generateQuestion1() {
        x = rand.nextInt(30) + 30;
        y = rand.nextInt(5) + 1;

        correctAnswer = ((double) x) / (((double) (y * y)) * Math.PI);

        question = "Air is being pumped into a spherical balloon at a rate of " + x
                + " cm^3/min. Determine the rate at which the radius of the balloon is increasing when its diameter is "
                + y + "cm.";
    }

    /**
     * Generates the L'Hopital question.
     */
    private void generateQuestion2() {
        int i = rand.nextInt(5) + 0;
        displayFunction = displayFunctions[i];
        switch (i) {
            case 0 -> correctAnswer = 1.0;
            case 1 -> correctAnswer = 1.0 / 2.0;
            case 2 -> correctAnswer = -1.0 / 6.0;
            case 3 -> correctAnswer = 1.0 / 2.0;
            case 4 -> correctAnswer = 1.0;
        }

        displayFunction = displayFunction.replaceAll("Math.", "");

        question = "Evaluate the limit of y = " + displayFunction
                + " as x approaches zero.\n\nPlease enter the answer correct to two decimal places.";
    }

    /**
     * Generates the ladder related rates question.
     */
    private void generateQuestion3() {
        x = rand.nextInt(10) + 5;
        y = rand.nextInt(10) + 5;
        int z = rand.nextInt(10) + 5;

        correctAnswer = Math.sqrt((double) (y * y) + Math.pow((double) (-y * x) / (z), 2));

        question = "A ladder is resting on a vertical wall. The foot of the ladder is sliding away at a rate of " + x
                + " m/s and is " + y + "m from the wall. At this moment, the top of the ladder is moving down at a "
                + "rate of " + z + " m/s. Find the length of the ladder.";
    }

    /**
     * Generates the right circular cone optimization question.
     */
    private void generateQuestion4() {
        int x = rand.nextInt(16) + 5;

        correctAnswer = (32.0 * Math.PI * x * x * x) / 81.0;

        question = "Find the volume of the largest right circular cone that can be inscribed in a sphere of radius " + x
                + ".";
    }

    /**
     * Generates the square and circle wire optimization question.
     */
    private void generateQuestion5() {
        int x = 10 * (rand.nextInt(12) + 4);

        correctAnswer =  (double)x/(Math.PI + 4.0);

        question = "A piece of wire " + x + "m long is cut into two pieces. One piece is "
                + "bent into a square and the other is bent into a circle. What is the side length "
                + "of the square so that the total area enclosed by both shapes is a minimum?"
                + "\n\nPlease do not enter in terms of pi.";
    }

    /**
     * Sends correct answer to the main program.
     * @return Correct answer
     */
    public double getCorrectAns() {
        return correctAnswer;
    }

    /**
     * Retrieves which question to generate, then generates and sends it to the main program.
     * @param num Question number.
     * @return question to be asked.
     */
    public String getQuestion(int num) {
        switch (num) {
            case 100 -> generateQuestion1();
            case 200 -> generateQuestion2();
            case 300 -> generateQuestion3();
            case 400 -> generateQuestion4();
            case 500 -> generateQuestion5();
        }

        return question;
    }
}