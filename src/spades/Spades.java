
package spades;

//imported class Game and JOptionPane
import core.Game;
import javax.swing.JOptionPane;

/**
 *
 * @author Joel Tucker (jo793161)
 * Assignment 1
 * COP 3330 Object Oriented Programming Spring 2018
 * Whiting
 */
public class Spades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //Print out string
        System.out.println("Welcome to Spades!");
        //Send string to UI output using JOption Pane
        JOptionPane.showMessageDialog(null, "Let's Play Spades!");
        
        //Instantiate class Game
        Game game = new Game();
        
    } //end main 
    
}//end class Spades
