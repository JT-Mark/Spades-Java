
package constants;

/**
 *
 * @author joeltucker
 */
public class Constants {
    //initialize constants
    public static final int NUM_AI = 3;
    public static final int NUM_CARDDECK = 52;
    public static final int NUM_CARDHAND = 13;
    public static final int NUM_ROUNDS = 13;
    public static final int MIN_BID = 1;
    public static final int WIN_SCORE = 200;
    
    //add enumerations for cards

    /**
     *Colors of the cards
     */
    public static enum CardColor {RED, BLACK};
    public static enum CardSuit {CLUBS, DIAMONDS, HEARTS, SPADES};
    public static enum CardFace {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, 
        NINE, TEN, JACK, QUEEN, KING, ACE};
    
    // my own addition of AI names to vary the names of the AI Players
    public static final String[] AI_NAMES = {"Hal","Jane","Max","Wall-E","R2-D2"
        ,"C-3PO", "Johnny 5", "Data", "T-800", "SkyNet"}; 
    
    
    
}//end class Constants
