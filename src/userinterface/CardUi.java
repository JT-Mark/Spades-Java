/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import core.Card;
import java.awt.Image;
import java.net.URL;
import javax.swing.*;

/**
 *
 * @author joeltucker
 */
public class CardUi {

    /**
     * @return the button
     */
    public JButton getButton() {
        return button;
    }

    /**
     * @return the label
     */
    public JLabel getLabel() {
        return label;
    }
    
    //declare variables
    private Card card;
    private ImageIcon imageIcon;
    private JButton button;
    private JLabel label;
    private int position;
    
    //custom constructors
    public CardUi (Card card, JButton button) {
        
        //set member variables to the passed parameters
        this.card = card;
        this.button = button;
        
        //call method selectFrontImage;
        selectFrontImage();
        
    }//end custom constructor
    
    public CardUi(Card card, JLabel label, int position) {
        
        //set member variables to the passed parameters
        this.card = card;
        this.label = label;
        this.position = position;
        
        //call select image methods base on position
        
        if (position == 1 || position == 3) {
            selectVerticalBackImage();
        }
        else {
            selectHorizontalBackImage();
        }
        
    }//end custom constructor
    
    public CardUi(JLabel label) {
        this.label = label;
        selectHorizontalBackImage();
    }//end custom constructor
    
    
    //My own constructor for the AI faces
    public CardUi(JLabel label, String name) {
        this.card = card;
        this.label = label;
        
        selectFaceImage(name);
        
    }//end constructor
    
    //my own method selectFaceImage
    private void selectFaceImage(String name) {
        
        String fileName = "../images/faceImages/";
    /*    
        Ai names:
        "Hal", "Wall-E", "MCP", "WOPR", "Agent Smith",
        "R2-D2", "C-3PO", "Johnny 5", "Data", "T-800", "SkyNet"
    */    
        switch (name) {
            case  "Hal (AI)":
                fileName += "Hal.jpeg";
                break;
            case "Wall-E (AI)":
                fileName += "WallE.jpg";
                break;
            case "MCP (AI)":
                fileName += "MCP.jpg";
                break;
            case "WOPR (AI)":
                fileName += "Wopr.png";
                break;
            case "Agent Smith (AI)":
                fileName += "AgentSmith.png";
                break;
            case "R2-D2 (AI)":
                fileName += "R2D2.jpg";
                break;
            case "C-3PO (AI)":
                fileName += "C3PO.jpg";
                break;
            case "Johnny 5 (AI)":
                fileName += "Johnny5.jpg";
                break;
            case "Data (AI)":
                fileName += "Data.jpg";
                break;
            case "T-800 (AI)":
                fileName += "T800.jpg";
                break;
            case "SkyNet (AI)":
                fileName += "Skynet.jpg";
                break;
            
        }//end switch
        
        URL imageURL = getClass().getResource(fileName);
        
        //check if image is null. If it is, return error. else, instantiate image icon
        if (imageURL == null) {
            System.err.println("File: " + fileName + " not found.");
            imageIcon = null;
        }
        else {
            imageIcon = new ImageIcon(imageURL);
            imageIcon = imageResizeFace(imageIcon);
            label = new JLabel(imageIcon);
        }
        
    }//end selectFaceImage
    
    //define method selectFrontImage
    private void  selectFrontImage() {
        
        //strng for the filename to call image
        String fileName = "../images/";
        
        //switch to add the face to the string
        switch (card.getFace()) {
            case ACE:
                fileName += "Ace";
                break;
            case TWO:
                fileName += "Two";
                break;
            case THREE:
                fileName += "Three";
                break;
            case FOUR:
                fileName += "Four";
                break;
            case FIVE:
                fileName += "Five";
                break;
            case SIX:
                fileName += "Six";
                break;
            case SEVEN:
                fileName += "Seven";
                break;
            case EIGHT:
                fileName += "Eight";
                break;
            case NINE:
                fileName += "Nine";
                break;
            case TEN:
                fileName += "Ten";
                break;
            case JACK:
                fileName += "Jack";
                break;
            case QUEEN: 
                fileName += "Queen";
                break;
            case KING:
                fileName += "King";
                break;           
        }//end face switch
        
        //switch to add suit to string
        switch(card.getSuit()) {
            case HEARTS:
                fileName += "Hearts";
                break;
            case CLUBS:
                fileName += "Clubs";
                break;
            case DIAMONDS:
                fileName += "Diamonds";
                break;
            case SPADES:
                fileName += "Spades";
                break;
        }//end suit switch
        
        //concatenate the file extension to the string
        fileName += ".png";
        
        //instantiate new member of URL and assign the filename
        URL imageURL = getClass().getResource(fileName);
        
        //check if image is null. If it is, return error. else, instantiate image icon
        if (imageURL == null) {
            System.err.println("File: " + fileName + " not found.");
            imageIcon = null;
        }
        else {
            imageIcon = new ImageIcon(imageURL);
        //    imageIcon = imageResizeHorizontal(imageIcon);
            button = new JButton(imageIcon);
        }
    }// end selectFrontImage
    
    //define method selectVerticalBackImage
    private void selectVerticalBackImage() {
        //instantiate string for specific file
        String fileName = "../images/backVertical.jpg";
        
        //instantiate URL to get resource
        URL imageURL = getClass().getResource(fileName);
        
        //check if image is null. If it is, return error. else, instantiate image icon
        if (imageURL == null) {
            System.err.println("File: " + fileName + " not found.");
            imageIcon = null;
        }
        else {
            imageIcon = new ImageIcon(imageURL);
            imageIcon = imageResizeVertical(imageIcon);
            label = new JLabel(imageIcon);
        }
    }//end selectVerticalBackImage
    
    private void selectHorizontalBackImage() {
        
        //instantiate string for specific file
        String fileName = "../images/backHorizontal.jpg";
        
        //instantiate URL to get resource
        URL imageURL = getClass().getResource(fileName);
        
        //check if image is null. If it is, return error. else, instantiate image icon
        if (imageURL == null) {
            System.err.println("File: " + fileName + " not found.");
            imageIcon = null;
        }
        else {
            imageIcon = new ImageIcon(imageURL);
            imageIcon = imageResizeHorizontal(imageIcon);
            label = new JLabel(imageIcon);
        }
    }//end selectHorizontalBackImage
    
    //image resize methods
    
    private ImageIcon imageResizeHorizontal(ImageIcon icon) {
        
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(50,97, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }//end ImageIcon
    
       private ImageIcon imageResizeVertical(ImageIcon icon) {
        
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(90,40, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }//end ImageIcon
       
    private ImageIcon imageResizeFace(ImageIcon icon) {
        
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(60,75, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }//end ImageIcon
    
    private ImageIcon imageResizeTableCard(ImageIcon icon) {
        
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(60,100, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }//end ImageIcon
    
}//end CardUi
