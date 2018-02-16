
package core;

/**
 *
 * @author joeltucker
 */

//import enums
import constants.Constants.CardColor;
import constants.Constants.CardFace;
import constants.Constants.CardSuit;

public class Card {

    /**
     * @return the color
     */
    public CardColor getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(CardColor color) {
        this.color = color;
    }

    /**
     * @return the face
     */
    public CardFace getFace() {
        return face;
    }

    /**
     * @param face the face to set
     */
    public void setFace(CardFace face) {
        this.face = face;
    }

    /**
     * @return the suit
     */
    public CardSuit getSuit() {
        return suit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }
    
    //add member variables
   private CardColor color;
   private CardFace face;
   private CardSuit suit;
   
    
    
}//end class Card
