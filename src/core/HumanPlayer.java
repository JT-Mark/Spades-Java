
package core;

import java.util.Scanner;

/**
 *
 * @author joeltucker
 */
public class HumanPlayer extends Player{

    //implement methods inherited with override 
    @Override
    public Card playCard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    //define method placeBid
    public int placeBid() {
        //ask the user for input and scan input
//        System.out.println(" ");
//        System.out.println("Please enter your Bid: ");
        Scanner scan = new Scanner(System.in);
        int bid = scan.nextInt();
        
        //if bid inputted was less than 1, print message and set bid value to 1
        if (bid < 1) {
//            System.out.println("You must enter a minimum bid of at least 1");
            bid = 1;
        }
        
        //set player bid by calling setter
        setPlayerBid(bid);
        
        //return player bid by calling getter
        return getPlayerBid();
    }// end method placeBid
    
}
