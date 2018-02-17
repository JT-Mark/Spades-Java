
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
import java.util.Random;


public class Game {

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
    private CardSuit trumpSpades;
    private Player leadPlayer;
    private Player dealerPlayer;
    private Player winnerPlayer;
    private int currentRound;
    private ArrayList<Team> teamList;
    private Deck deck;
    private Scanner scan;
    
    //custom constructor that calls methods
    public Game() {
        createTeams();
        outputTeams();
    } //end constructor
    
    
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
        System.out.println("Enter human player name");
        //instantiate string to save user input
        String stringName = scan.next();
        
        //instantiate Human Player and set name to user input
        HumanPlayer human = new HumanPlayer();
        human.setPlayerName(stringName);
        
        //teamOne.addPlayer(human);
        teamOne.getTeam().add(human);
        
        if (teamOne.getTeam().contains(human)) {
        System.out.println("Human Player, "+stringName+", added to Team One!");
        }
        else {
        System.out.println("Error: Could not add"+stringName+"to Team One");
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
        for (Team element : teamList) {
            System.out.println(element.getTeamName()+" includes players:");
            //inside for loop to loop through players of the team and print out
            for(Player player: element.getTeam()) {
                System.out.println("Player: "+ player.getPlayerName());
            } //end inside for
        }//end outside for
    }//end method outputTeams
   
}// end class Game
