/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import core.AiPlayer;
import core.Player;
import constants.Constants;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author joeltucker
 */
public class AiPlayerUi extends JPanel {
    
    //bold line for panels
    Border BOLD_BLACKLINE = BorderFactory.createLineBorder(Color.BLACK, 2);
    Border BLACKLINE = BorderFactory.createLineBorder(Color.BLACK);
    
    //declare variables
    private AiPlayer ai;
    private int position;
    private ArrayList<JLabel> cards;
    
    private CardUi cardUi;
    private int width;
    private int height;
    
    //custom constructor
    public AiPlayerUi(Player player, int position) {
        
        ai = (AiPlayer) player;
        this.position = position;
        
        initComponents();
     }//end custom constructor   
    
    private void initComponents() {
        
        
        this.setBorder(BorderFactory.createTitledBorder(ai.getPlayerName()));
        this.setMinimumSize(new Dimension(150, 200));
        this.setPreferredSize(new Dimension(150, 200));
        
        cards = new ArrayList<JLabel>();
        
        if (position == 1 || position == 3) {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//            this.setLayout(new GridLayout(7, 7));

//            displayVerticalCards();
            this.width = 90;
            this.height = 40;        
        }
        else {
            this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//            displayHorizontalCards();
            this.width = 45;
            this.height = 95;
        }
        
        displayFace();
        displayCards();
        
    }//end initComponents
    
    //merge diplayvertical and display horizontal to one method: displayCards
    private void displayCards() {
        
        //instantiate new ArrayList for the hand
        cards = new ArrayList<JLabel>();
        
        int i;
        //loop throught the cards in the hand, setting the card equal to the cardUi
        //and adding it to the ArrayList cards
        for (i = 0; i < Constants.NUM_CARDHAND; i++) {
            
            JLabel card = new JLabel();
            cardUi = new CardUi(ai.getPlayerHand().get(i), card, position);
            card = cardUi.getLabel();
            card.setMinimumSize(new Dimension (width, height));
            card.setPreferredSize(new Dimension (width, height));
            card.setBorder(BLACKLINE);
            
    //        card.setAlignmentX(this.CENTER_ALIGNMENT);
                        
            //add the card to the ArrayList and the Ui
            cards.add(card);
            this.add(card);
   
        }//end for loop
    }//end displayCards
    
    //my own method to add a face to the ai
    private void displayFace() {
        JLabel face = new JLabel();
        cardUi = new CardUi(face, ai.getPlayerName());
        face = cardUi.getLabel();
    //    face.setAlignmentX(this.CENTER_ALIGNMENT);
        
        this.add(face);
    }
    
    
    
    
  /*  
    // define displayVerticalCards methods
    private void displayVerticalCards() {
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        int i;
        //loop through the amount of cards in the hand and set size
        for(i = 0; i < Constants.NUM_CARDHAND; i++) {
            JLabel card = new JLabel();
            card.setMinimumSize(new Dimension(170,30));
            card.setPreferredSize(new Dimension(170,30));
            card.setBorder(BLACKLINE);
            card.setText("CARD "+ i);
            cards.add(card);
            this.add(card);
        }//end for loop for the hand
        
    }//end displayVerticalCards
    
    private void displayHorizontalCards() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        int i;
        //loop through the amount of cards in the hand and set size
        for(i = 0; i < Constants.NUM_CARDHAND; i++) {
            JLabel card = new JLabel();
            card.setMinimumSize(new Dimension(50,200));
            card.setPreferredSize(new Dimension(50,200));
            card.setBorder(BLACKLINE);
            card.setText("CARD "+ i);
            cards.add(card);
            this.add(card);
        }//end for loop for the hand
        
    }//end displayVerticalCards
        
    */
   
    
    
    
    
}//end class AiPlayerUi
