
package core;

//import java class
import constants.Constants;
import constants.Constants.CardFace;
import constants.Constants.CardSuit;
import static constants.Constants.CardSuit.CLUBS;
import static constants.Constants.CardSuit.SPADES;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author joeltucker
 */
public class Deck {

    /**
     * @return the deck
     */
    public Set<Card> getDeck() {
        return deck;
    }

    /**
     * @param deck the deck to set
     */
    public void setDeck(Set<Card> deck) {
        this.deck = deck;
    }
    
    private Set<Card> deck;
    
    //custom constructors
    public Deck() {
    generateDeck();
    displayDeck();
    shuffleDeck();
    displayDeck();
}
    private void generateDeck() {
        deck = new HashSet<Card>();
        //loop through face and suit enum to generate unique cards
        for (CardFace face : CardFace.values()) {
            for (CardSuit suit : CardSuit.values()) {
                //instantiate new instance of Card
                Card card = new Card();
                card.setFace(face);
                card.setSuit(suit);
                //set color according to the suits
                if (suit.equals(CLUBS) || suit.equals(SPADES)) {
                    card.setColor(Constants.CardColor.BLACK);                  
                }//end if
                else {
                    card.setColor(Constants.CardColor.RED);
                }//end else
                //check if card iteration is already in deck. if it is
                //continue, otherwise add it to deck
                if (deck.contains(card)) {
                    continue;
                }
                else {
                    deck.add(card);
                }
            }//end for
            
        }//end for
        
    }//end method generateDeck()
    
    private void displayDeck() {
        //print out deck size and header
        int i = 1;
//        System.out.println("\nDeck size: "+ deck.size() + " cards");
//        System.out.println("*******************************");
//        System.out.println("Printing new deck");
//        System.out.println("*******************************");

        //iterate through the deck and print out the elements
        for (Card card : deck) {
            //print out each card as the loop iterates
//            System.out.println(i + ". " +
//                    (card.getColor().toString())+ " " + 
//                    card.getFace().toString() + " of " + 
//                    (card.getSuit().toString()));
            //counter for the card number
            i++;
        }//end for 
    }//end method displayDeck()
    
    private void shuffleDeck() {
        //instantiate new Arraylist of the set deck and call the shuffle method
    ArrayList<Card> list = new ArrayList<Card>(deck);
//       System.out.println("\nShuffling Deck...");
    Collections.shuffle(list);
    deck = new HashSet<Card>(list);
    
}//end methode shuffleDeck()
    
} //end class Deck
