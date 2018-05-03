/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

/**
 *
 * @author joeltucker
 */

//import com.sun.istack.internal.logging.Logger;
import core.HumanPlayer;
import core.Player;
import constants.Constants;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;


public class HumanPlayerUi extends JPanel {
    
    Border BOLD_BLACKLINE = BorderFactory.createLineBorder(Color.BLACK, 2);
    Border BLACKLINE = BorderFactory.createLineBorder(Color.BLACK);

    //declare variables
    private HumanPlayer human;
    private ArrayList<JButton> cards;
    
    private CardUi cardUi;
    
    //custom constructor
    public HumanPlayerUi(Player player) {
        
        human = (HumanPlayer) player;
        
        initComponents();
        
    }//end custom constructor
    
    //define initComponents
    private void initComponents() {
        
        this.setBorder(BorderFactory.createTitledBorder(BOLD_BLACKLINE, human.getPlayerName()));
        this.setMinimumSize(new Dimension(200, 150));
        this.setPreferredSize(new Dimension(200, 150));
        
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        displayCards();
    }//end initComponents
    
    //define displayCards
    private void displayCards() {
        cards = new ArrayList<JButton>();
        human.sortBySuit();
        
        //loop throught the amount of cards in a hand and iterate a new button
        int i;
        for (i = 0; i < Constants.NUM_CARDHAND; i++) {
            
            JButton card = new JButton();
            cardUi = new CardUi (human.getPlayerHand().get(i), card);
            card = cardUi.getButton();
            
            card.setMinimumSize(new Dimension(75,200));
            card.setPreferredSize(new Dimension(75, 200));
            card.setBorder(BLACKLINE);
          //  card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
          //add the card to the ArrayList and the Ui
            cards.add(card);
            this.add(card);
        }//end for
        
        int breakpoint = 0;
    }//end displayCards
    
 //   private static final Logger LOG = Logger.getLogger(HumanPlayerUi.class.getName());
}//end class HumanPlayerUi
