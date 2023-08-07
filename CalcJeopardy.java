/**
 * Names: Ishan Garg, Krish Patel, Pranav Mahabal
 * Course: MCV4U0-1
 * Date: January 18, 2023
 * Teacher: Ms Iulia Gugoiu.
 */

public class CalcJeopardy {

    static int numPlayers = 2;
    
    /**
     * Creates question generators.
     */
    static MysteryQuestions vectQ = new MysteryQuestions();
    static DiffQuestions diffQ = new DiffQuestions();
    static ApplyDiffQuestions curveQ = new ApplyDiffQuestions();
    static ApplyIntQuestions hopQ = new ApplyIntQuestions();
    static IntegrationQuestions intQ = new IntegrationQuestions();

    /**
     * Main method to start the main program's thread.
     * @param args command line arguments.
     */
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AskQuestion dialog = new AskQuestion(new javax.swing.JFrame(), true, numPlayers, vectQ, diffQ, curveQ,
                        hopQ, intQ);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

}
