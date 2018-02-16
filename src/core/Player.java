
package core;

/**
 *
 * @author joeltucker
 */
public abstract class Player implements IPlayer{

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
    
    //declare abstract methods inherited
    @Override
    public abstract Card playCard();
    
    @Override
    public abstract int placeBid();
    
} //end class Player
