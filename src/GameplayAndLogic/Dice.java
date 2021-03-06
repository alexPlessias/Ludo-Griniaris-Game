package GameplayAndLogic;

import WindowInterface.GamePanel;
import java.io.File;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Dice of game, we roll it and gets the number and icon.
 * 
 * @author Πλέσσιας Αλέξανδρος (ΑΜ.:2025201100068).
 */
public class Dice {

    // Define max and min Roll num (changes based on the types of dice).
    private static final int DICE_MAX = 6;
    private static final int DICE_MIN = 1;


    // Dice Images paths.
    private final String dice_1_ImgPath = "Icons" + File.separator +"Dice" + File.separator +"dice_1.png";
    private final String dice_2_ImgPath = "Icons" + File.separator +"Dice" + File.separator +"dice_2.png";
    private final String dice_3_ImgPath = "Icons" + File.separator +"Dice" + File.separator +"dice_3.png";
    private final String dice_4_ImgPath = "Icons" + File.separator +"Dice" + File.separator +"dice_4.png";
    private final String dice_5_ImgPath = "Icons" + File.separator +"Dice" + File.separator +"dice_5.png";
    private final String dice_6_ImgPath = "Icons" + File.separator +"Dice" + File.separator +"dice_6.png";

    // Dice Icons.
    private Icon dice_1_Img;
    private Icon dice_2_Img;
    private Icon dice_3_Img;
    private Icon dice_4_Img;
    private Icon dice_5_Img;
    private Icon dice_6_Img;

    // Basic class fields.
    private int diceNum;
    private Random rand;

    /**
     * Dice Constructor create seed for random
     * and create dice icons.
     */
    public Dice() {
        this.rand = new Random();
        this.dice_1_Img = new ImageIcon(dice_1_ImgPath);
        this.dice_2_Img = new ImageIcon(dice_2_ImgPath);
        this.dice_3_Img = new ImageIcon(dice_3_ImgPath);
        this.dice_4_Img = new ImageIcon(dice_4_ImgPath);
        this.dice_5_Img = new ImageIcon(dice_5_ImgPath);
        this.dice_6_Img = new ImageIcon(dice_6_ImgPath);

    }

    /**
     * Generate random number form [DICE_MIN to DICE_MAX] for future use
     * from getDiceNum() and getDiceIcon().
     * @param gamePanel There is a JTextArea with game logs and use it for
     * show the dice result from dice.
     */
    public void diceRoll(GamePanel gamePanel) {
        
        int randNum= rand.nextInt(DICE_MAX) + DICE_MIN;
        
        String oldText = gamePanel.getInfoJTextArea().getText();
        String newText = ("\n[Zάρι]: Ο Παίκτης "+gamePanel.getGameplay().getPlayers().get(gamePanel.getRoundCounter()%gamePanel.getGameplay().getPlayers().size()).getNickname()+" έφερε "+randNum+".");
        
        gamePanel.getInfoJTextArea().setText(oldText+newText);
        
        this.diceNum = randNum;
    }

    /** 
     * @return  the random integer number generated by diceRoll() method. 
     */
    public int getDiceNum() {
        return this.diceNum;
    }

    /** 
     * @return  the  icon of random integer generated by diceRoll() method.
     */
    public Icon getDiceIcon() {
        
        Icon diceNumIcon= null;
        
        switch (diceNum) {
            case 1:
                diceNumIcon = dice_1_Img;
                break;

            case 2:
                diceNumIcon = dice_2_Img;
                break;

            case 3:
                diceNumIcon = dice_3_Img;
                break;

            case 4:
                diceNumIcon = dice_4_Img;
                break;

            case 5:
                diceNumIcon = dice_5_Img;
                break;

            case 6:
                 diceNumIcon = dice_6_Img;
                break;
        }
        
        return diceNumIcon;

    }

}
