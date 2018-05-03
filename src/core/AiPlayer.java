
package core;

/**
 *
 * @author joeltucker
 */
public class AiPlayer extends Player{

    //implement methods inherited with override 
    @Override
    public Card playCard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int placeBid() {
        int bid = 0;
        //for loop to go through the hand
        for (Card card: this.getPlayerHand()) {
            //1 bid for every ACE and KING in the hand
            if (card.getFace() == card.getFace().ACE || card.getFace() == card.getFace().KING) {
                bid++;
            }
            //1 bid for every royal SPADE face card
            else if (card.getSuit() == card.getSuit().SPADES && card.getFace().getValue() > 10) {
                bid ++;
            }           
        } //end for
        
        //if no bid has been placed, set the minimum bid of 1
        if (bid == 0) {
            bid = 1;
        }
        //call the setter to set the bid
        setPlayerBid(bid);
        //return bid
        return getPlayerBid(); 
    }
   
}//end AiPlayer
