package edu.guilford;

import java.io.File;

import org.apache.commons.io.FileUtils;

import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Screen;


//This class will be the pane that holds the method for the user
//to input the message they want to encrypt and the image they want
//to encrypt it in
public class StegoPane extends Pane {
    
    //add an beginning label to the pane
    private Label beginningLabel;

    // add a directions label to the pane 
    private TextArea directionsLabel;

    //add a text field for the user to input the message they want to encrypt
    private TextArea messageText;
    private Label messageLabel;
    private String message;
    //add a button for the user to click to send the message to the encrypt class
    private Button encrypt;
    private Label encryptLabel;
    
    //add a button for the user to click to select the image they want to encrypt
    private Button newImage;
    //add a button for the user to click to select a previously used image
    private Button prevImage;
    private Label imageText;
    private Label imageText2;
    //add an imageview to show the image chosen
    private ImageView imageView;
    
    //add a button for the user to click to save the encrypted image
    private Button send;
    private Label sendLabel;
    private Rectangle2D screenBounds;
    
    //Constructor for the StegoPane class
    public StegoPane() {

        screenBounds = Screen.getPrimary().getVisualBounds();

        //Instantiate the textArea
        messageText = new TextArea();
        //change the size of the textArea
        messageText.setPrefSize(500, 250);
        //change the font of the textArea
        messageText.setStyle("-fx-font-size: 18px; -fx-font-type: Arial");
        //wrap the text in the textArea
        messageText.setWrapText(true);
        //Scroll the text in the textArea
        messageText.setScrollLeft(100);

        imageText = new Label("Choose between either a new image");
        imageText2 = new Label("or a previously used image");
        //Change the size and font of the imageText
        imageText.setStyle("-fx-font-size: 18px; -fx-font-type: Arial");
        imageText2.setStyle("-fx-font-size: 18px; -fx-font-type: Arial");
        //Change the length of the imageText
        // imageText.setPrefSize(600, 100);
        // imageText.setEditable(false);
        // imageText.setWrapText(true);
        // imageText.setScrollLeft(0);

        //Instantiate the directions label
        directionsLabel = new TextArea();
        //Have preset text in the textArea
        directionsLabel.setText("Welcome to the Steganography App. \n\nThis app will allow you to encrypt a message and embed it in an image of your choice. \nYou can choose between a new image or a previously used image. If you choose a new image, you will be prompted to select an image from your computer. If you choose a previously used image, you will be prompted to select an image from a preset folder. \n\nAfter you have selected an image, you will be prompted to enter the message you want to encrypt. After you have entered the message, you will be prompted to click the encrypt button. After you have clicked the encrypt button, you will be prompted to click the send button. \n\nAfter you have clicked the send button, you will be prompted to select a location on your computer to save the encrypted image. After you have selected a location, the encrypted image will be saved to your computer.");
        //Change the size of the directions label
        directionsLabel.setPrefSize(300, 500);
        //Change the font of the directions label
        directionsLabel.setStyle("-fx-font-size: 18px; -fx-font-type: Arial");
        //Wrap the text in the directions label
        directionsLabel.setWrapText(true);
        //Scroll the text in the directions label
        directionsLabel.setScrollLeft(100);
        //Make the directions label uneditable
        directionsLabel.setEditable(false);

        //Set the location of the directions label to the middle of the pane
        directionsLabel.setLayoutX(screenBounds.getWidth() / 2.4);
        directionsLabel.setLayoutY(screenBounds.getHeight() / 8.5);

        //Instantiate the imageView
        imageView = new ImageView();

        //Instantiate the labels
        beginningLabel = new Label("Welcome to the Steganography App");
        //Change the size and font of the label
        beginningLabel.setStyle("-fx-font-size: 22px; -fx-font-type: Arial");
        messageLabel = new Label("Enter the message you want to encrypt");
        //Change the size and font of the label
        messageLabel.setStyle("-fx-font-size: 18px; -fx-font-type: Arial");
        encryptLabel = new Label("Click to encrypt the message. Click to embed the message in the image");
        //Change the size and font of the label
        encryptLabel.setStyle("-fx-font-size: 18px; -fx-font-type: Arial");
        sendLabel = new Label("Click to send the encrypted message into the image");
        //Change the size and font of the label
        sendLabel.setStyle("-fx-font-size: 18px; -fx-font-type: Arial");
        

        //Instantiate the buttons
        encrypt = new Button("Encrypt");
        //Change the font size of the button
        encrypt.setStyle("-fx-font-size: 15px; -fx-font-type: Arial");
        newImage = new Button("New Image");
        newImage.setStyle("-fx-font-size: 15px; -fx-font-type: Arial");
        prevImage = new Button("Previous Image");
        prevImage.setStyle("-fx-font-size: 15px; -fx-font-type: Arial");
        send = new Button("Send");
        //Change the font size of the button
        send.setStyle("-fx-font-size: 15px; -fx-font-type: Arial");
        
        //Set the location of the beginningLabel to the top center of the pane
        beginningLabel.relocate((screenBounds.getWidth() / 2.8), 0);

        //Set the location of the messageLabel and message
        messageLabel.relocate(screenBounds.getWidth() / 20, 50);
        messageText.relocate(screenBounds.getWidth() / 20, 100);

        //Set the location of the newImage and prevImage buttons and the imageText
        imageText.relocate((screenBounds.getWidth() / 1.5), 50);
        imageText2.relocate((screenBounds.getWidth() / 1.5), 80);
        newImage.relocate((screenBounds.getWidth() / 1.5), 150);
        prevImage.relocate((screenBounds.getWidth() / 1.2), 150);

        //Set the location of the encryptLabel and encrypt button
        encryptLabel.relocate((screenBounds.getWidth() / 27), (screenBounds.getHeight() / 1.78));
        encrypt.relocate((screenBounds.getWidth() / 15), (screenBounds.getHeight() / 1.58));
        send.relocate((screenBounds.getWidth() / 3.9), (screenBounds.getHeight() / 1.58));

        //Set the location of the sendLabel
        // sendLabel.relocate((screenBounds.getWidth() / 8), (screenBounds.getHeight() / 2.8));

        //Add an event listener for the newImage button to open a file chooser from the user's computer
        newImage.setOnAction(e -> {
            // Instantiate a FileChooser object
            FileChooser fileChooser2 = new FileChooser();
            //Set the title of the fileChooser
            fileChooser2.setTitle("Open New Image");
            //Find the path to the users home
            String path2 = "user.home";
            //Set the initial directory of the fileChooser
            fileChooser2.setInitialDirectory(new File(System.getProperty(path2)));
            //Set the extension filter of the fileChooser
            fileChooser2.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
            //Instantiate a File object
            File selectedFile2 = fileChooser2.showOpenDialog(null);
            //Instantiate an Image object
            Image image2 = new Image(selectedFile2.toURI().toString());
            //Copy the image using the Commons IO library
            try {
                FileUtils.copyFile(selectedFile2, new File("C:/stegofinalproject/src/main/PrevImages/Used" + selectedFile2.getName()), true);
            } catch (Exception e1) {
                //Print the stack trace if there is an error
                e1.printStackTrace();
            } 
            //Add the image to the imageView
            imageView.setImage(image2);
            //Set the size of the ImageView
            imageView.setFitWidth(300);
            //Preserve the aspect ratio of the image
            imageView.setPreserveRatio(true);
            //Set the location of the ImageView to the top left of the pane
            imageView.relocate(screenBounds.getWidth() / 1.48, 220);
        });

        //Add an event listener for the prevImage button to choose a previously used image 
        //from the PrevImages folder in the project
        prevImage.setOnAction(e -> {
            // Instantiate a FileChooser object to get the home directory
            FileChooser fileChooser = new FileChooser();
            //Set the title of the fileChooser
            fileChooser.setTitle("Open Previously Used Image");
            //Get the path to the PrevImage Folder
            String path = "C:/stegofinalproject/src/main/PrevImages";
            //Set the initial directory of the fileChooser
            fileChooser.setInitialDirectory(new File(path));
            //Set the extension filter of the fileChooser
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
            //Instantiate a File object
            File selectedFile = fileChooser.showOpenDialog(null);
            //Instantiate an Image object
            Image image = new Image(selectedFile.toURI().toString());
            //Add the image to the imageView
            imageView.setImage(image);
            //Set the size of the ImageView
            imageView.setFitWidth(300);
            //Preserve the aspect ratio of the image
            imageView.setPreserveRatio(true);
            //Set the location of the ImageView to the top left of the pane
            imageView.relocate(screenBounds.getWidth() / 1.48, 220);
        });

        //Add an event listener for the encrypt button to encrypt the message the user entered using the crypto class
        encrypt.setOnAction(e -> {
            //Get the message the user entered
            message = messageText.getText();
            //Instantiate a string object
            String crypto = "";
            //Try to encrypt the message the user entered
            try {
                //Encrypt the message the user entered
                crypto = Crypto.encrypt(message);
            } catch (Exception e1) {
                //Print the stack trace if there is an error
                e1.printStackTrace();
            }

            // Print the encrypted and decrypted message to the console***
            System.out.println("Message: " + message);
            System.out.println("Encrypted Message: " + crypto);
            //decrypt the message the user entered
            try {
                System.out.println("Decrypted Message: " + Crypto.decrypt(crypto));
            } catch (Exception e1) {
                //Print the stack trace if there is an error
                e1.printStackTrace();
            }
        });

        //Add an event listener to send the encrypted message into the image the user chose
        //and creates a popup window to save the image to the user's computer
        // send.setOnAction(e -> {
        //     //Instantiate a Stego object
        //     Stego stego = new Stego();
        //     //Try to embed the encrypted message into the image the user chose
        //     try {
        //         //Embed the encrypted message into the image the user chose
        //         stego.embed();
        //     } catch (Exception e1) {
        //         //Print the stack trace if there is an error
        //         e1.printStackTrace();
        //     }
        // });

        this.getChildren().addAll(beginningLabel, messageLabel, messageText, imageText, imageText2, newImage, prevImage, imageView, encrypt, encryptLabel, send, directionsLabel);
    }
}
