/**
 * Names: Ishan Garg, Krish Patel, Pranav Mahabal
 * Course: MCV4U0-1
 * Date: January 18, 2023
 * Teacher: Ms Iulia Gugoiu
 * 
 * Generates the mystery (vectors, differential equations) questions.
 */

import java.util.Random;

public class MysteryQuestions {

    private double correctAnswer;
    private String displayFunction;
    private int g;
    private int z;
    private String question;
    private Random rand;
    private String[] displayFunctions;
    private String[] pops;
    private Function[] funcs;

    /**
     * Class constructor.
     */
    public MysteryQuestions() {
        correctAnswer = 0.0;
        funcs = new Function[] {
            (x, y) -> z*Math.pow(x,2) + g*x*y,
            (x, y) -> Math.pow(x,2) + z*Math.pow(y,2) - g,
            (x, y) -> z*y+Math.sqrt(Math.pow(x,2)+Math.pow(y,2)),
            (x, y) -> Math.pow(x,2)-z*x*y+Math.pow(y,2)-g*y,
            (x, y) -> Math.sin(x*y)-Math.pow(x,2)*y,
        };
        displayFunctions = new String[] {
                "z*(x^2) + g*x*y",
                "x^2 + z*(y^2) - g",
                "z*y + sqrt(x^2 + y^2)",
                "x^2 - z*x*y + y^2 -g*y",
                "sin(x*y) - (x^2)*y",
        };
        pops = new String[] {
                "fish",
                "bacteria",
                "kangaroos",
                "squids",
                "beavers",
                "koalas",
        };
        question = "";
        rand = new Random();
    }

    /**
     * Generates the dot product question.
     */
    private void generateQuestion1() {
        int x = rand.nextInt(7) + 0;
        int y = rand.nextInt(7) + 0;
        int z = rand.nextInt(7) + 0;
        int x1 = rand.nextInt(7) + 0;
        int y1 = rand.nextInt(7) + 0;
        int z1 = rand.nextInt(7) + 0;

        correctAnswer = x * x1 + y * y1 + z * z1;

        question = "Find the dot product of the following two vectors: (" + x + "," + y + "," + z + ") and (" + x1 + ","
                + y1 + "," + z1 + ").";
    }

    /**
     * Generates the Euler's method question.
     */
    private void generateQuestion2() {
        double x = rand.nextInt(3) + 0;
        double y = rand.nextInt(3) + 0;
        double approxX = rand.nextInt(2) + x + 1;
        z = rand.nextInt(5) + 1;
        g = rand.nextInt(5) + 1;

        double h = Math.round(((approxX - x) / (rand.nextInt(100) + 1)) * 100.0) / 100.0;
        while ((approxX - x) % h != 0 || (approxX - x > 1.0 && h < 1.0) || (approxX - x > 1.0 && h > 1.0)) {
            h = Math.round(((approxX - x) / (rand.nextInt(100) + 1)) * 100.0) / 100.0;
        }

        int j = rand.nextInt(5) + 0;

        displayFunction = displayFunctions[j].replaceAll("z", String.valueOf(z)).replaceAll("g", String.valueOf(g));

        correctAnswer = 0;
        double tempY = y;
        double dx = 0;
        for (double i = 0; i < (approxX - x); i += h) {
            dx = funcs[j].eval(x+i,tempY);
            correctAnswer = tempY + h * (dx);
            tempY = correctAnswer;
        }

        question = "Suppose y = y(x) is the solution to the differential equation dy/dx = " + displayFunction
                + " with y(" + x + ") = " + y + ". "
                + "Use Euler's method to approximate y(" + approxX + ") using h = " + h + " as the increment.";
    }

    /**
     * Generates the logistical population growth question.
     */
    private void generateQuestion3() {
        boolean based = false;
        double popM = 100 * rand.nextInt(3) + 300;
        double popI = rand.nextInt(10) + 1;
        while (!based) {
            if (popM == 300 & popI == 7 || popI == 8 || popI == 9) {
                popI = rand.nextInt(10) + 1;
            } else if (popM == 400 & popI == 3 || popI == 6 || popI == 7 || popI == 9) {
                popI = rand.nextInt(10) + 1;
            } else if (popM == 500 & popI == 3 || popI == 6 || popI == 7 || popI == 9 || popI == 8) {
                popI = rand.nextInt(10) + 1;
            } else {
                based = true;
            }
        }

        double pop1 = rand.nextInt(4) + popI + 1;
        double yearC = rand.nextInt(4) + pop1 + 1;
        double A = (popM - popI) / popI;
        double k = -Math.log(((popM / pop1) - 1) / A) / 1;
        correctAnswer = popM / (1 + A * Math.exp(-k * yearC));

        int i = rand.nextInt(pops.length) + 0;
        String type = pops[i];

        question = "Harry loves " + type + ", but Harry hates controlling them. Assume a maximum of "
                + popM + " " + type + " can be supported by the environment, and he starts off with " + popI
                + ". If in the first year, the population of " + type + " rises to "
                + pop1 + ", how many " + type + " will he have in year " + yearC + "?";
    }

    /**
     * Generates the distance between a point and plane question.
     */
    private void generateQuestion4() {
        double x0 = rand.nextInt(11) - 5;
        double y0 = rand.nextInt(11) - 5;
        double z0 = rand.nextInt(11) - 5;

        double ux = rand.nextInt(11) - 5;
        double uy = rand.nextInt(11) - 5;
        double uz = rand.nextInt(11) - 5;

        double vx = rand.nextInt(11) - 5;
        double vy = rand.nextInt(11) - 5;
        double vz = rand.nextInt(11) - 5;

        double cx = uy * vz - uz * vy;
        double cy = uz * vx - ux * vz;
        double cz = ux * vy - uy * vx;
        double d = -(cx * x0 + cy * y0 + cz * z0);

        double px0 = rand.nextInt(15) - 7;
        double py0 = rand.nextInt(15) - 7;
        double pz0 = rand.nextInt(15) - 7;

        double dist = Math.abs(cx * px0 + cy * py0 + cz * pz0 + d)
                / Math.sqrt(Math.pow(cx, 2) + Math.pow(cy, 2) + Math.pow(cz, 2));
        correctAnswer = dist;

        question = "Given the plane in vector form: (" + x0 + ", " + y0 + ", " + z0 + ") + u(" + ux + ", " + uy + ", "
                + uz + ")" + " + v(" + vx + ", " + vy + ", " + vz + ")"
                + " and the point (" + px0 + ", " + py0 + ", " + pz0
                + "), find the distance between this point and plane.";
    }

    /**
     * Generates the skew line distance question.
     */
    private void generateQuestion5() {
        double pv0 = rand.nextInt(13) - 6;
        double pv1 = rand.nextInt(13) - 6;
        double pv2 = rand.nextInt(13) - 6;

        double ux = rand.nextInt(7) - 3;
        double uy = rand.nextInt(7) - 3;
        double uz = rand.nextInt(7) - 3;

        double vx = rand.nextInt(7) - 3;
        double vy = rand.nextInt(7) - 3;
        double vz = rand.nextInt(7) - 3;

        double cx = uy * vz - uz * vy;
        double cy = uz * vx - ux * vz;
        double cz = ux * vy - uy * vx;

        double coeff = rand.nextInt(5) - 2;
        double pu0 = pv0 - cx + coeff * ux;
        double pu1 = pv1 - cy + coeff * uy;
        double pu2 = pv2 - cz + coeff * uz;

        correctAnswer = Math.abs((pv0 - pu0) * cx + (pv1 - pu1) * cy + (pv2 - pu2) * cz)
                / Math.abs(Math.sqrt(cx * cx + cy * cy + cz * cz));

        question = "Given the skew lines in vector form: \n(" + pv0 + ", " + pv1 + ", " + pv2 + ") + v(" + vx + ", "
                + vy
                + ", " + vz + ")" + " and \n(" + pu0 + ", " + pu1 + ", " + pu2 + ") + u(" + ux + ", " + uy + ", "
                + uz + "), \n\nFind the minimum distance between them.";
    }
    
    /**
     * Creates interface to store and evaluate functions.
     */
    private interface Function {
        public double eval(double x, double y);
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