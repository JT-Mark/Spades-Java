
package core;

/**
 *
 * @author joeltucker
 */

//import classes
import static constants.Constants.AI_NAMES;
import java.util.Scanner;
import constants.Constants.CardSuit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JOptionPane;


public class Game {

    /**
     * @return the playerPositions
     */
    public ArrayList<Player> getPlayerPositions() {
        return playerPositions;
    }

    /**
     * @return the input
     */
    public Scanner getInput() {
        return scan;
    }

    /**
     * @param input the input to set
     */
    public void setInput(Scanner input) {
        this.scan = input;
    }

    /**
     * @return the trumpSpades
     */
    public CardSuit getTrumpSpades() {
        return trumpSpades;
    }

    /**
     * @param trumpSpades the trumpSpades to set
     */
    public void setTrumpSpades(CardSuit trumpSpades) {
        this.trumpSpades = trumpSpades;
    }

    /**
     * @return the leadPlayer
     */
    public Player getLeadPlayer() {
        return leadPlayer;
    }

    /**
     * @param leadPlayer the leadPlayer to set
     */
    public void setLeadPlayer(Player leadPlayer) {
        this.leadPlayer = leadPlayer;
    }

    /**
     * @return the dealerPlayer
     */
    public Player getDealerPlayer() {
        return dealerPlayer;
    }

    /**
     * @param dealerPlayer the dealerPlayer to set
     */
    public void setDealerPlayer(Player dealerPlayer) {
        this.dealerPlayer = dealerPlayer;
    }

    /**
     * @return the winnerPlayer
     */
    public Player getWinnerPlayer() {
        return winnerPlayer;
    }

    /**
     * @param winnerPlayer the winnerPlayer to set
     */
    public void setWinnerPlayer(Player winnerPlayer) {
        this.winnerPlayer = winnerPlayer;
    }

    /**
     * @return the currentRound
     */
    public int getCurrentRound() {
        return currentRound;
    }

    /**
     * @param currentRound the currentRound to set
     */
    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }

    /**
     * @return the teamList
     */
    public ArrayList<Team> getTeamList() {
        return teamList;
    }

    /**
     * @param teamList the teamList to set
     */
    public void setTeamList(ArrayList<Team> teamList) {
        this.teamList = teamList;
    }

    /**
     * @return the deck
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * @param deck the deck to set
     */
    public void setDeck(Deck deck) {
        this.deck = deck;
    }
    
    //add member variables
    private CardSuit trumpSpades = CardSuit.SPADES;
    private Player leadPlayer;
    private Player dealerPlayer;
    private Player winnerPlayer;
    private int currentRound;
    private ArrayList<Team> teamList;
    private Deck deck;
    private Scanner scan;
    
    private ArrayList<Player> playerPositions;
    private int currentDealerIndex;
            
    
    //custom constructor that calls methods
    public Game() {
        createTeams();
//        outputTeams();
        generateDeck();
        setTable();
        dealHand();
//        displayHands();
//        play();
        
    } //end constructor
    
    //define method generateDeck
    private void generateDeck() {
        deck = new Deck();
    }//end method generateDeck()
    
    
    //define method createTeams
     private void createTeams() {
        //instantiate teamList
        teamList = new ArrayList<>();
        //instantiate teams
        Team teamOne = new Team();
        Team teamTwo = new Team();
        
        //set team names
        teamOne.setTeamName("Team One");
        teamTwo.setTeamName("Team Two");
        
        //add teams to teamList
        teamList.add(teamOne);
        teamList.add(teamTwo);
        
        //instantiate Scanner variable to take in user input
        scan = new Scanner(System.in);
        
        //output to request user input
//        System.out.println("Enter human player name");
        String stringName = JOptionPane.showInputDialog("Enter human player's name");
        //instantiate string to save user input
//        String stringName = scan.next();
        
        //instantiate Human Player and set name to user input
        HumanPlayer human = new HumanPlayer();
        human.setPlayerName(stringName);
        
        //teamOne.addPlayer(human);
        teamOne.getTeam().add(human);
        
        if (teamOne.getTeam().contains(human)) {
  //      System.out.println("Human Player, "+stringName+", added to Team One!");
        }
        else {
  //      System.out.println("Error: Could not add"+stringName+"to Team One");
        }
        
        //local variable for loop
        int i;
        
        
        //instantiate new object of Random class to go through array
        Random rand = new Random();
        //local variables for counting through aiNames array
        //x variables as counters to avoid duplicating AI names
        int index; 
        //need to initialize the variables first for comparing
        int x1 = AI_NAMES.length + 1; 
        int x2 = AI_NAMES.length + 1;
        int x3 = AI_NAMES.length + 1;
        
        
        //loop to generate AI players
        for(i = 1; i<=3; i++) {
            AiPlayer aiPlayer = new AiPlayer();
            
            //initialize playerName string first to be able to compare later
            aiPlayer.setPlayerName("temp");
            
            //do while loop to keep names from repeating 
            //keep generating random numbers as long as it matches a number 
            //picked
            do {
                index = rand.nextInt(AI_NAMES.length);
            } while (index == x1 || index == x2 || index == x3); 
            
            aiPlayer.setPlayerName(AI_NAMES[index]+" (AI)");
            //add ai Players to appropriate teams
            if (i == 1) {
                teamOne.getTeam().add(aiPlayer);
                x1 = index; //record first name counter
            }
            else {
                teamTwo.getTeam().add(aiPlayer);
                if (i == 3) {
                    x3 = index; //record third name counter
                } else {
                    x2 = index; //record second name counter
                }
            }//end else
          
        }//end for loop
        
    }//end method createTeams
    
    //define method outputTeams
    private void outputTeams() {
        //for loop to loop through the team list and print team name
        for (Team team : teamList) {
 //           System.out.println(team.getTeamName()+" includes players:");
            //inside for loop to loop through players of the team and print out
            for(Player player: team.getTeam()) {
//                System.out.println("Player: "+ player.getPlayerName());
            } //end inside for
        }//end outside for
    }//end method outputTeams
  
    //define method setTable
    private void setTable() {

    //new arraylist for table positions
    playerPositions = new ArrayList<>();
    
    //instantiate team variables equal to the stored teams
    Team teamOne = teamList.get(0);
    Team teamTwo = teamList.get(1);
    
    //instantiate Player variables from each team
    Player teamOnePlayerOne = teamOne.getTeam().get(0);
    Player teamTwoPlayerOne = teamTwo.getTeam().get(0);
    Player teamOnePlayerTwo = teamOne.getTeam().get(1);
    Player teamTwoPlayerTwo = teamTwo.getTeam().get(1);
    
    //add team players in alternating order to the table positions
        getPlayerPositions().add(0, teamOnePlayerOne);
        getPlayerPositions().add(1, teamTwoPlayerOne);
        getPlayerPositions().add(2, teamOnePlayerTwo);
        getPlayerPositions().add(3, teamTwoPlayerTwo);
    
    //create a random number between 0 and 3
    Random rand = new Random();
    int randPlayer = rand.nextInt(4);
    int i = 1;
    //print out headers
//    System.out.println(" ");
//    System.out.println("******************************");
//    System.out.println("Seat Positions:");    
        
    //loop through player positions and print out 
    for (Player pl : getPlayerPositions()) {
 
//        System.out.println("Seat " +i + ": "+ pl.getPlayerName());
        i++;
     }
    //print out who the dealer is and who should be dealt the first card
    if (randPlayer + 1 == 4) {
//      System.out.println("Current dealer is "+ getPlayerPositions().get(randPlayer).getPlayerName() +
//            " and first card should go to " + getPlayerPositions().get(0).getPlayerName());  
    }
    else {
//        System.out.println("Current dealer is "+ getPlayerPositions().get(randPlayer).getPlayerName() +
//            " and first card should go to " + getPlayerPositions().get(randPlayer + 1).getPlayerName());
    }
    //set the dealer to that random seat position 
    dealerPlayer = getPlayerPositions().get(randPlayer);
    currentDealerIndex = randPlayer;
    
    } //end method setTable
    
    private void dealHand() {  
        //print header
//        System.out.println(" ");
//        System.out.println("Dealing hands...");
        //instantiate local variable to count through card dealing
        int currentPlayerIndex = currentDealerIndex;
        
        //instantiate Iterator to loop through deck
        Iterator itr = deck.getDeck().iterator();
        Player currentPlayer;
        
        //check if currentPlayerIndex is at the end.
        //If it is set it to 0 to start over, otherwise increment
        if (currentPlayerIndex == 3) {
                currentPlayerIndex = 0;
               }
        else {
            currentPlayerIndex ++;
        }
        //while loop to go through deck
        while (itr.hasNext()) { 
                
            //if the index is at the end, start it back at 0
            if (currentPlayerIndex == 4) {
                currentPlayerIndex = 0;
               }
            //set currentPlayer to the right position
            currentPlayer = getPlayerPositions().get(currentPlayerIndex);
            
            //iterate next card to new instantiation
            Card card = (Card)itr.next();
            //add the new card to the current player
            currentPlayer.getPlayerHand().add(card);
            //increment player index
            currentPlayerIndex++;
            
            //remove the card from the iterator
            itr.remove();
            
        }//end while loop going through deck
        
        
    } //end method dealHand
    
    //define method displayHands
    private void displayHands() {
        //print out header
//        System.out.println(" ");
//        System.out.println("******************************");
//        System.out.println("Sorting and displaying hands...");
//        

        //loop through teams and then through players to out put hands
        for (Team team : teamList) {
//            System.out.println(" ");
//            System.out.println(team.getTeamName());
//            System.out.println("---------------------------");
            for (Player player : team.getTeam()) {
                //sort each player's hand by suit
                player.sortBySuit();
                //output the name of the player and their hand            
//                System.out.println(" ");
//                System.out.println(player.getPlayerName() +"'s hand:");
                
                //display hand only for human player
                if (player instanceof HumanPlayer) {
                player.displayHand();
                } 
                else  {                   
 //                   System.out.println("Hand hidden");
                }
            }//end inside for loop
        }//end outside for loop

    } //end displayHands method
    
    //define method play
    private void play() {
        //call getBids
        getBids();
    }// end method play
    
    //define method getBids
    private void getBids() {
        //print out header
//        System.out.println(" ");
//        System.out.println("******************************");
//        System.out.println("Getting bids...");
//        System.out.println(" ");
        //declare local variables
        int bidsPlaced = 0;
        int leadPlayerIndex;
        
        //set the lead player index for the position to the left of the dealer
        if (currentDealerIndex < 3) {
            leadPlayerIndex = currentDealerIndex + 1;
        }
        else {
            leadPlayerIndex = 0;
        }
        
        //set the leadPlayer to the lead player index
        leadPlayer = getPlayerPositions().get(leadPlayerIndex);
        
        //if the dealer is human, ask for the bid
        if (leadPlayer instanceof HumanPlayer) {
            HumanPlayer human = new HumanPlayer();
            human = (HumanPlayer) leadPlayer;
//            System.out.println("Getting bid from "+ human.getPlayerName());
            human.placeBid();          
        }
        //else set the bid for the AI
        else {
            AiPlayer ai = new AiPlayer();
            ai = (AiPlayer) leadPlayer;
 //           System.out.println("Getting bid from "+ ai.getPlayerName());
            ai.placeBid();           
        }
        //increment the bid
        bidsPlaced++;
        
        int currentPlayerIndex;
        
        //set the current player index to the position left of the lead
        if (leadPlayerIndex < 3) {
            currentPlayerIndex = leadPlayerIndex + 1;
        }
        else {
            currentPlayerIndex = 0;
        }
        
        //set next player to the player to the left of the lead
        Player nextPlayer;
        nextPlayer = getPlayerPositions().get(currentPlayerIndex);
        
        //while loop to go through the rest of the players
        while (bidsPlaced < 4) {
            //if next player is human, ask for the bid
            if (nextPlayer instanceof HumanPlayer) {
                HumanPlayer human = new HumanPlayer();
                human = (HumanPlayer) nextPlayer;
 //               System.out.println("Getting bid from "+ human.getPlayerName());
                human.placeBid();
            }
            //else set the bid for the AI
            else {
                AiPlayer ai = new AiPlayer();
                ai = (AiPlayer) nextPlayer;
 //               System.out.println("Getting bid from "+ ai.getPlayerName());
                ai.placeBid();
            }
            //increment bid
            bidsPlaced++;
            
            //loop through the player positions
            if (currentPlayerIndex < 3) {
                currentPlayerIndex++;
            }
            else {
                currentPlayerIndex = 0;
            }
            
            //set next player to the current player index
            nextPlayer = getPlayerPositions().get(currentPlayerIndex);
        }//end while
                
        //print out bids by team
//        System.out.println(" ");
//        System.out.println("Bids ");
//        System.out.println("---------------------------");
//        //enhanced for loop for teams
        for (Team team: teamList) {
            //enhanced for loop for the players
 //           System.out.println(team.getTeamName());
            for (Player player : team.getTeam()) {
 //               System.out.println(player.getPlayerName()+"'s Bid:" + player.getPlayerBid());
            }
        }
    }//end method getBids
    
    
}// end class Game

