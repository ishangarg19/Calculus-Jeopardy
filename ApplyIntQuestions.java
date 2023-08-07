/**
 * Names: Ishan Garg, Krish Patel, Pranav Mahabal
 * Course: MCV4U0-1
 * Date: January 18, 2023
 * Teacher: Ms Iulia Gugoiu
 * 
 * Generates the applications of integration questions.
 */

import java.util.Random;

public class ApplyIntQuestions {

    private double correctAnswer;
    private String expression;
    private String displayFunction;
    private int x;
    private int y;
    private String question;
    private Random rand;

    /**
     * Class constructor.
     */
    public ApplyIntQuestions() {
        correctAnswer = 0.0;
        expression = "";
        x = 0;
        y = 0;
        question = "";
        rand = new Random();
    }

    /**
     * Generates the downward displacement question.
     */
    private void generateQuestion1() {
        x = rand.nextInt(7) + 1;
        y = rand.nextInt(7) + 1;
        int a = rand.nextInt(2) + 1;
        int b = rand.nextInt(5) + 3;

        correctAnswer = ((x/2.0)*Math.pow(b, 2) + y*b)-((x/2.0)*Math.pow(a, 2) + y*a);

        question = "Find the downward displacement of Harry on a drop tower over the interval  [" + a + ", " + b
                + "] if his velocity is defined by v(t) = " + x +"*t + " + y + ".";
    }

    /**
     * Generates the area enclosed by two functions question.
     */
    private void generateQuestion2() {
        int a = rand.nextInt(7) + 1;
        int x = rand.nextInt(4) + 1;
        int b = a * x;
        
        Function f1 = (z) -> a*Math.pow(z,2);
        Function f2 = (z) -> b*z;
        
        displayFunction = a + "*(x^2)";

        correctAnswer = integrate(f2, 0, (double) b / (double) a) - integrate(f1, 0, (double) b / (double) a);

        question = "Find the area of the region enclosed by f(x) = " + displayFunction + " and g(x) = " + b + "*x.";
    }

    /**
     * Generates the pyramid volume question.
     */
    private void generateQuestion3() {
        int a = rand.nextInt(20) + 1;
        int b = rand.nextInt(20) + 1;
        int c = rand.nextInt(20) + 1;

        correctAnswer = (double) (1.0 / 6.0) * a * b * c;

        question = "Find the volume of the pyramid delimited by the coordinate planes and the plane x/" + a + " + y/"
                + b + " + z/" + c + " = 1.";
    }

    /**
     * Generates the washer method volume question.
     */
    private void generateQuestion4() {
        x = rand.nextInt(3) + 1;
        y = rand.nextInt(3) + 4;
        int g = rand.nextInt(6) + 1;
        int c = rand.nextInt(6) + 1;

        Function f = (z) -> Math.pow(g*Math.pow(z, 2) + c, 2) - Math.pow(c, 2);
        
        displayFunction = ("g*(x^2)+c").replaceAll("g", String.valueOf(g)).replaceAll("c", String.valueOf(c));

        correctAnswer = Math.PI * integrate(f, x, y);

        question = "Find the volume of the region bounded by the function y = " + displayFunction + " and the line y = "
                + c + " over the interval [" + x + ", " + y + "] when rotated about the x-axis."
                + "\n\nPlease do not enter in terms of pi.";
    }

    /**
     * Generates the shell method volume question.
     */
    private void generateQuestion5() {
        int g = rand.nextInt(5) + 1;
        int c = rand.nextInt(5) + 1;
        
        Function f = (z) -> z*(g*z*Math.pow(z-c, 2));
        
        displayFunction = ("g*x*(x-c)^2").replaceAll("g", String.valueOf(g)).replaceAll("c", String.valueOf(c));

        correctAnswer = 2 * Math.PI * integrate(f, 0, c);

        question = "Find the volume of the region bounded by the function y = " + displayFunction
                + " and the x-axis over the interval [" + 0 + ", " + c + "] when rotated about the y-axis."
                + "\n\nPlease do not enter in terms of pi.";
    }
    
    /**
     * Calculates the definite integral of a function.
     * @param f the function.
     * @param a lower bound.
     * @param b upper bound.
     * @return value of the definite integral over the interval.
     */
    private double integrate(Function f, double a, double b) {
        double ans = 0.0;
        double n = 20000000.0;
        for(int i = 0; i<n; i++) {
            double fx = f.eval(a + (double)(i-1)*(b-a)/n);
            ans += (double) ((b - a) / n) * fx;
        }
        return ans;
    }
    
    /**
     * Creates interface to store and evaluate functions.
     */
    private interface Function {
        public double eval(double x);
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