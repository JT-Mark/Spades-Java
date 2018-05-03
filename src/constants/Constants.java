package constants;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

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

    /**
     *
     */
//    Border BOLD_BLACKLINE = BorderFactory.createLineBorder(Color.BLACK, 2);

    //add enumerations for cards
    /**
     * Colors of the cards
     */
    public static enum CardColor {
        RED, BLACK
    };

    public static enum CardSuit //display values for each enum and initialize getters and custom constructor          
    {
        CLUBS(0), DIAMONDS(1), HEARTS(2), SPADES(3);

        /**
         * @return the rank
         */
        public int getRank() {
            return rank;
        }

        private int rank;

        private CardSuit(int rank) {
            this.rank = rank;
        }

    };

    public static enum CardFace //display values for each enum and initialize getters and custom constructor
    {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
        NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(13);

        /**
         * @return the value
         */
        public int getValue() {
            return value;
        }

        private int value;

        private CardFace(int value) {
            this.value = value;
        }

    };

    // my own addition of AI names to vary the names of the AI Players
    public static final String[] AI_NAMES = {"Hal", "Wall-E", "MCP", "WOPR", "Agent Smith",
        "R2-D2", "C-3PO", "Johnny 5", "Data", "T-800", "SkyNet"};

}//end class Constants
