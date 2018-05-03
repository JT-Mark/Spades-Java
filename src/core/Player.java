
package core;

import java.util.ArrayList;

/**
 *
 * @author joeltucker
 */
public abstract class Player implements IPlayer{

    /**
     * @return the playerHand
     */
    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    /**
     * @param playerHand the playerHand to set
     */
    public void setPlayerHand(ArrayList<Card> playerHand) {
        this.playerHand = playerHand;
    }

    /**
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @param playerName the playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * @return the playerTricks
     */
    public int getPlayerTricks() {
        return playerTricks;
    }

    /**
     * @param playerTricks the playerTricks to set
     */
    public void setPlayerTricks(int playerTricks) {
        this.playerTricks = playerTricks;
    }

    /**
     * @return the playerBid
     */
    public int getPlayerBid() {
        return playerBid;
    }

    /**
     * @param playerBid the playerBid to set
     */
    public void setPlayerBid(int playerBid) {
        this.playerBid = playerBid;
    }

    /**
     * @return the playerScore
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /**
     * @param playerScore the playerScore to set
     */
    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
    
    //add member variables
    private String playerName;
    private int playerTricks;
    private int playerBid;
    private int playerScore;
    private ArrayList<Card> playerHand;
    
    
    
    //declare abstract methods inherited
    @Override
    public abstract Card playCard();
    
    @Override
    public abstract int placeBid();
    
    //custom constructor to instantiate player hand array list
    public Player() {
        playerHand = new ArrayList<Card>();
    }
    
    //define method displayHand to loop through hand and print out 
    public void displayHand() {
        for (Card card : playerHand) {
//            System.out.println("  " + card.getColor() + " " + card.getFace() +
//                    " of " + card.getSuit());
        } //end method displayHand
    }// end method displayHand
    
    //define method sortBySuit
    public void sortBySuit() {
        //create new array list to hold the sorted hand
        ArrayList<Card> sortedHand = new ArrayList<Card>();
      
        //while the hand is over 0 loop through all the cards
        while (playerHand.size() > 0) {
            int currentPosition = 0;
            Card firstCard;
            //set the firstCard variable to the first element
            firstCard = playerHand.get(0);
            
            int i;
            //inside for loop to compare each card to the first card
            for (i = 1; i < playerHand.size(); i ++) {
                Card nextCard;
                //nextCard equal to the next i
                nextCard = playerHand.get(i);
                //if nextCard is lower in rank or the same but lower in value
                //set it as the first card
                if (nextCard.getSuit().getRank() < firstCard.getSuit().getRank()
                    || (nextCard.getSuit().getRank() == firstCard.getSuit().getRank()
                    && nextCard.getFace().getValue() < firstCard.getFace().getValue())) {
                    
                    currentPosition = i;
                    firstCard = nextCard;
                }//end if               
            }//end for
            
            //remove the sorted card from the unsorted hand array list
            playerHand.remove(currentPosition);
            
            //add the sorted hand to the sorted array list
            sortedHand.add(firstCard);
        }//end while
        
        //after sorting, set the old unsorted array list to the new sorted values
        playerHand = sortedHand;
    }
    
} //end class Player
