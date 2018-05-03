
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
   
   //method hashCode with return of int variable hashCode
   public int hashCode() {
       
       int hashCode = 0;
       
       return hashCode;
   }//end hashCode()
   
   //Method  returns type Boolean with one parameter, Object
   public boolean equals(Object item) {
       //check if the parameter is instanceof Card
       if (item instanceof Card) {
           //convert parameter to instance of Card 
           Card localCard = (Card) item;
           return (
                   localCard.face.equals(this.face) &&
                   localCard.color.equals(this.color) &&
                   localCard.suit.equals(this.suit));
       }//end if
       else {
          //otherwise return false
           return false;
       }//end else
   }//end equals()
   
    
}//end class Card
