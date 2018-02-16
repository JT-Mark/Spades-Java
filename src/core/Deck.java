
package core;

//import java class
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
    
}
