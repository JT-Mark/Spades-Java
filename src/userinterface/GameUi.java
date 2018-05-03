/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import core.Card;
import core.Game;
import core.Player;
import core.Team;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.border.Border;
/**
 *
 * @author joeltucker
 */
public class GameUi {

//Declare variables

//the game    
private	Game game;

//ArrayLists
private ArrayList<Card> cardsPlayed;
private ArrayList<JLabel>cardsPlayedLbl;
private ArrayList<JLabel>aiFaces;

//the layout
private	JFrame frame;
private	JPanel aiOnePanel;
private JPanel tablePanel;
private	JPanel aiTwoPanel;
private	JPanel hpPanel;
private	JPanel aiThreePanel;
private	JPanel northPanel;
private	JPanel scorePanel;
private	JPanel bidPanel;

//the menu
private	JMenuBar menuBar;
private	JMenu gameMenu;
private	JMenu helpMenu;
private	JMenuItem newGameMenuItem;
private	JMenuItem exitMenuItem;
private	JMenuItem aboutMenuItem;
private	JMenuItem rulesMenuItem;

Border BOLD_BLACKLINE = BorderFactory.createLineBorder(Color.BLACK, 2);
Border BOLD_GREENLINE = BorderFactory.createLineBorder(Color.GREEN);



    //custom constructor
    public GameUi(Game game) {
        this.game = game;
        
        initComponents();
    }//end constructor
   
private void initComponents() {
    
    initMenuBar();
    layoutTable();
    
    frame.setVisible(true);
    
}//end method initComponents 

private void initMenuBar() {
    
    //instantiate the new Menu elements
    //add listeners
    menuBar = new JMenuBar();
    
    gameMenu = new JMenu("Game");
    newGameMenuItem = new JMenuItem("New Game");
    newGameMenuItem.addActionListener(new NewGameListener());
    exitMenuItem = new JMenuItem("Exit");
    exitMenuItem.addActionListener(new ExitListener());
    
    helpMenu = new JMenu("Help");
    aboutMenuItem = new JMenuItem("About");
    aboutMenuItem.addActionListener(new AboutListener());
    rulesMenuItem = new JMenuItem("Game Rules");
    rulesMenuItem.addActionListener(new RulesListener());
    
    //put the elements together
    gameMenu.add(newGameMenuItem);
    gameMenu.add(exitMenuItem);
    
    helpMenu.add(aboutMenuItem);
    helpMenu.add(rulesMenuItem);
    
    menuBar.add(gameMenu);
    menuBar.add(helpMenu);
   
}//end initMenuBar

private void layoutTable() {
    
    //instantiate and size the JFrame
    frame = new JFrame("Spades");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1000, 1000);
    
    //call the menu bar
    initMenuBar();
    
    //instantiate and size the panels
    aiOnePanel = new AiPlayerUi(game.getPlayerPositions().get(1), 1);
    aiTwoPanel = new AiPlayerUi(game.getPlayerPositions().get(2), 2);
    aiThreePanel = new AiPlayerUi(game.getPlayerPositions().get(3), 3);
    hpPanel = new HumanPlayerUi(game.getPlayerPositions().get(0));
    
    //call north and center(table) panels
    initNorthPanel();
    initTablePanel();
    
    //set the panels in the right locations
    frame.add(aiOnePanel, BorderLayout.WEST);
    frame.add(northPanel, BorderLayout.NORTH);
    frame.add(aiThreePanel, BorderLayout.EAST);
    frame.add(hpPanel, BorderLayout.SOUTH);
    frame.add(tablePanel, BorderLayout.CENTER);
    
    frame.setJMenuBar(menuBar);
    
}//end layoutTable 

private void initNorthPanel() {
    //init and size north panel
    northPanel = new JPanel();
    northPanel.setMinimumSize(new Dimension(980, 130));
    northPanel.setPreferredSize(new Dimension(980, 130));
    
    //init and size sub panels
    bidPanel = new JPanel();
    bidPanel.setBorder(BorderFactory.createTitledBorder(BOLD_BLACKLINE,"Bids"));
    bidPanel.setMinimumSize(new Dimension(90, 120));
    bidPanel.setPreferredSize(new Dimension(90, 120));
    
    //init and size score panel
    scorePanel = new JPanel();
    scorePanel.setBorder(BorderFactory.createTitledBorder(BOLD_BLACKLINE, "Score"));
    scorePanel.setMinimumSize(new Dimension(90, 120));
    scorePanel.setPreferredSize(new Dimension(90, 120));
    
    aiTwoPanel.setMinimumSize(new Dimension(700, 120));
    aiTwoPanel.setPreferredSize(new Dimension(700, 120));
    
    //add panels to the north Panel
    northPanel.add(scorePanel);
    northPanel.add(aiTwoPanel);
    northPanel.add(bidPanel);
    
}//end method initNorthPanel

private void initTablePanel() {
            
    //initialize table panel 
    tablePanel = new JPanel();
    tablePanel.setBorder(BorderFactory.createTitledBorder(BOLD_BLACKLINE, "Spades"));
    tablePanel.setMaximumSize(new Dimension(350, 350));
    tablePanel.setMinimumSize(new Dimension(350, 350));
    tablePanel.setPreferredSize(new Dimension(350, 350));
    
    tablePanel.setLayout(new BorderLayout());
    
    cardsPlayedLbl = new ArrayList<JLabel>();    
    int i;
    
    //loop through the players and set sizes for the cards vertical or horizontal        
    for (i = 0; i < 4; i++) {
       
        //instantiate new JLabel for the card on the table
       JLabel card = new JLabel();
            
       if (i == 1 || i == 3) {
            card.setMaximumSize(new Dimension (50,50));
            card.setPreferredSize(new Dimension (50, 50));
            card.setMinimumSize(new Dimension (50, 50));
            
        
        }
        else {
            card.setMaximumSize(new Dimension (50,50));
            card.setPreferredSize(new Dimension (50, 50));
            card.setMinimumSize(new Dimension (50, 50));
       
        }       
       
       
       //instantiate instance of class CardUi with card as argument
       CardUi cardUi = new CardUi(card);
       
       
       //set card equal to getLabel method of Cardui
       card = cardUi.getLabel();
       //add the card to the ArrayList
       cardsPlayedLbl.add(card);
    }//end for loop
    
    //add each instance of the card in the ArrayList to the tablePanel
    tablePanel.add(cardsPlayedLbl.get(0), BorderLayout.SOUTH);
    tablePanel.add(cardsPlayedLbl.get(1), BorderLayout.WEST);
    tablePanel.add(cardsPlayedLbl.get(2), BorderLayout.NORTH);
    tablePanel.add(cardsPlayedLbl.get(3), BorderLayout.EAST);

    
}//end initTablePanel

//create the Listener inner classes

//define NewGameListener
private class NewGameListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }//end actionPerformed override
}//end NewGameListener

//define ExitListener
private class ExitListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //give the confirm option
        int response = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit Spades?",
                "Exit?", JOptionPane.YES_NO_OPTION);
        
        //exit the program if the response is yes
        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//end actionPerformed override
}//end ExitListener

private class AboutListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //output the about message
        String message = "Spades version 1.0\nJoel Tucker\nSpring 2018";
        JOptionPane.showMessageDialog(frame, message);
    }//end actionPerformed override
}//end AboutListener inner class

private class RulesListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //rule strings
        String playersAndCards = "Players and Cards\nthe four players are in fixed"
         + ", with partners sitting opposite each other.\nDeal and play are clockwise.\n"
                + "A standard pack of 52 cards is used. The cards, in each suit, rank"
                + " from highest to lowest: A,K,Q,J,10,9,8,7,6,5,4,3,2.\n\n";
    
       String theDeal = "The Deal\nThe first dealer is chosen at random, and the turn"
            + " to deal rotates clockwise.\nThe cards are shuffled and then dealt"
            + " singly, in clockwise order beginning with the player on the dealer's"
            + "left,\nuntil all 52 cards have been dealt and everyone has 13 cards.\n\n";
       
       String theBidding = "The Bidding\nIn Spades, all four players bid a number"
               + " of tricks.\nEach team adds together the bids of the two partners,"
               + " and the total is the number of tricks that team must try to win in"
               + " order to get a positive score.\nThe bidding begins with the player"
               + " to dealer's left and continues clockwise around the table.\nEveryone"
               + " must bid a number, and in theory any number from 1 to 13 is allowed.\n"
               + "There is no requirement for each bid to be higher than the last one,"
               + " and players are not allowed to pass.\n\n";
       
       String thePlayofHand = "The Play of the Hand\nThe player to dealer's left leads"
               + " any card except a spade to the first trick.\nEach player, in turn,"
               + " clockwise, must follow suit if able; if unable to follow suit, the"
               + " player may play any card.\n\n";
       
       String trickWin = "A trick containing a spade is won by the highest spade"
               + " played; if no spade is played, the trick is won by the highest card"
               + " of the suit led.\nThe winner of each trick leads to the next.\nSpades"
               + " may not be led until either:\nsome player has played a spade (on"
               + " the lead of another suit, of course), or\nthe leader has nothing"
               + " but spades lef in hand.\nPlaying the first spade is known as"
               + " \"breaking\" spades...\n\n";
       
       String scoring = "Scoring\nA side that takes at least as many tricks as its bid"
               + " calls for receives a score equal to 10 times its bid.\nAdditional"
               + " tricks (overtricks) are worth and extra one point each.\n\n";
       
       String sandbagging = "Sandbagging rule: Overtricks are colloquially known as bags."
               + "\nA side which acumulates 10 or more bags has 100 points deducted from"
               + " its score.\nAny bags beyond 10 are carried over to the next cycle of ten"
               + " overtricks (that is if they reached 20 overtricks they would lose"
               + " another 100 points and so on.).\nIf a side does not make its bid"
               + " they lose 10 points for each trick they bid.\n\n";
       
       //output the strings concatenated
       JOptionPane.showMessageDialog(frame, playersAndCards + theDeal + theBidding
               + thePlayofHand + trickWin + scoring + sandbagging);
                    
    }//end actionPerformed
}//end class RulesListener




}//end class GameUi
