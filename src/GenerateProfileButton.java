import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.net.URL;


public class GenerateProfileButton extends HBox {
    //Variable declaration
    Button submit, clear;
    VBox vbox2;
    static Label nameSet;
    Label bioSet, bioSet2, eduSet, workSet, birthdaySet;

    ImageView profImg;

    private Stage newWindow;
    Scene secondScene;

    HBox hbox1, hboxToggle, hbox2, hbox3, hbox4;
    private boolean isDarkMode = false;
    Button darkModeButton, lightModeButton, back;
    Rectangle rect;

    //Creating method to generated new window displaying information put in by the user
    public GenerateProfileButton() {
        submit = new Button("Generate Profile");  //Button to submit information put in
        submit.setOnAction(this::processSubmit);

        clear = new Button("Clear Form");  //Button to clear sheet to start over information input
        clear.setOnAction(this::processClear);


        HBox subBox = new HBox(submit, clear);   //Placing buttons in HBox
        subBox.setPadding(new Insets(15, 15, 15, 25));
        subBox.setSpacing(10);

        getChildren().addAll(subBox);
    }

    //Action method for steps taken for information to be displayed in new scene
    private void processSubmit(ActionEvent event) {
        ColorPick accentColor1 = new ColorPick();
        Paint accentColorValue = accentColor1.getAccentColor();  //Trying to set TextFill based on what's in color picker.


        //Setting Profile Title Label
        Label accentC = new Label("Welcome to "+ Name.name.getText() + "'s Profile");
        accentC.setFont(Font.font("Calibre", FontWeight.BOLD, FontPosture.REGULAR, 24));
        accentC.setTextFill(accentColorValue);

        //Creating labels and positioning them, so they can be displayed in the new window. Also calling on font method
        //so they can be adjusted based on font selection
        nameSet = new Label();
        nameSet.setTranslateX(300);
        nameSet.setText("Name: " + Name.name.getText());
        nameSet.setFont(Name.name.getFont());
        nameSet.setTextFill(Color.BLACK);

        birthdaySet = new Label();
        birthdaySet.setTranslateX(300);
        birthdaySet.setText("Age: " + Birthday.message.getText());
        birthdaySet.setFont(Birthday.message.getFont());
        birthdaySet.setTextFill(Color.BLACK);

        bioSet = new Label();
        bioSet.setTranslateX(300);
        bioSet.setAlignment(Pos.CENTER);
        bioSet.setText("LinkedIn: " + Biography.bio.getText());
        bioSet.setFont(Biography.bio.getFont());
        bioSet.setTextFill(Color.BLACK);

        bioSet2 = new Label();
        bioSet2.setTranslateX(300);
        bioSet2.setText("Biography: " + Bio.content.getText());


        eduSet = new Label();
        eduSet.setTranslateX(300);
        eduSet.setText("Education: " + Education.edu.getText());
        eduSet.setFont(Education.edu.getFont());
        eduSet.setTextFill(Color.BLACK);

        //Trying to create hyperlink for LinkedIn profile
        Hyperlink bioLink = new Hyperlink( Biography.bio.getText());
        bioLink.setOnAction(e -> {
            String linkedInURL = Biography.bio.getText();
            if (!linkedInURL.isEmpty()) {

            }
        });
        bioLink.setStyle("-fx-font-size: 16px;");  //hyperlink text size
        bioLink.setStyle("-fx-text-fill: black;");
        //bioLink.setWrapText(true);

        workSet = new Label();
        workSet.setTranslateX(300);
        workSet.setText(" Work Experience: " + WorkExperience.work.getText());
        workSet.setFont(WorkExperience.work.getFont());
        workSet.setTextFill(Color.BLACK);

        //ImageView for profile picture. Also placing picture selected in ImageView
        profImg = new ImageView();
        Image selectedImage = Picture.getImage();
        if (selectedImage != null) {
            profImg.setImage(selectedImage);
            profImg.setFitWidth(300); // Set the desired width
            profImg.setPreserveRatio(true); // Ensure the image ratio is preserved
        }

        //Creating border design of ImageView
        rect = new Rectangle(300, 220, null);
        rect.setStroke(Color.AQUAMARINE);
        rect.setStrokeWidth(6);

        StackPane imagePane = new StackPane(profImg, rect);

        //final Separator divider = new Separator(Orientation.HORIZONTAL); (Excluding divider)
        //divider.setHalignment(HPos.CENTER);

        //Creating ImageView for Birthday image associated with month and putting images in ImageView
        ImageView img2 = new ImageView(Birthday.image2);
        img2.setSmooth(true);
        img2.setCache(true);
        if (Birthday.image2 != null) {
            img2.setImage(Birthday.image2);
            img2.setFitWidth(50); // Set the desired width
            img2.setPreserveRatio(true); // Ensure the image ratio is preserved

        }

        // Dark Mode Toggle
        darkModeButton = new Button("Dark Mode");
        darkModeButton.setOnAction(this::processDark);
        darkModeButton.setTooltip(new Tooltip("It's so dark"));

        //Light Mode Toggle
        lightModeButton = new Button("Light Mode");
        lightModeButton.setOnAction(this::processLight);
        lightModeButton.setTooltip(new Tooltip("It's so bright"));

        hboxToggle = new HBox(lightModeButton, darkModeButton);    //HBox for toggle buttons
        hboxToggle.setAlignment(Pos.TOP_CENTER);

        //HBox for birth month image
        hbox1 = new HBox(img2);
        hbox1.setAlignment(Pos.CENTER);

        //Return button to close new window
        back = new Button("Return");
        back.setAlignment(Pos.CENTER_LEFT);
        back.setOnAction(this::processHome);

        hbox2 = new HBox(back);
        hbox2.setAlignment(Pos.CENTER);

        //Some elements in HBoxes for positioning purposes
        hbox3 = new HBox(bioLink);
        getChildren().addAll(hbox3);
        hbox3.setAlignment(Pos.CENTER);

        hbox4 = new HBox(accentC);
        hbox4.setAlignment(Pos.CENTER);
        getChildren().addAll(hbox4);

        //Placing all elements in a VBox
        vbox2 = new VBox(hboxToggle, hbox4, imagePane, nameSet, birthdaySet, hbox1, eduSet, workSet, hbox3, Bio.content, hbox2);
        vbox2.setSpacing(10);
        vbox2.setAlignment(Pos.CENTER_LEFT);
        vbox2.setStyle("-fx-background-color: teal");
        vbox2.setPrefSize(1000, 600);


        //Creating scroll pane so all elements in VBox can be displayed
        ScrollPane root2 = new ScrollPane(vbox2);
        root2.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        root2.setPrefViewportHeight(400);
        root2.setPrefViewportWidth(800);
        secondScene = new Scene(root2, 1000, 600);

        //Creating new window to display information
        newWindow = new Stage();
        newWindow.setTitle("Profile for " + Name.name.getText());
        newWindow.setScene(secondScene);  //Putting second scene in second stage
        secondScene.getRoot().applyCss();

        newWindow.initModality(Modality.WINDOW_MODAL);

        newWindow.show();  //Making window visible
    }


    //Method to return to previous window
    private void processHome(ActionEvent event) {
        if (event.getSource() == back) {
            newWindow.close();
        }
    }

    //Actioning dark mode method
    private void processDark(ActionEvent event) {
        if (event.getSource() == darkModeButton) {
            URL stylesheetUrl = getClass().getResource("style/darkmode.css ");  //Linking to .css file
            secondScene.getStylesheets().clear();

            if (stylesheetUrl != null) {
                // Convert the URL to an external form (String)
                String darkModeStyleSheet = stylesheetUrl.toExternalForm();
                secondScene.getStylesheets().add(darkModeStyleSheet);

                darkModeButton.setDisable(true);   //Button toggle
                lightModeButton.setDisable(false);
            }
        }
    }

    //Light mode action method
    private void processLight(ActionEvent event) {
        if (event.getSource() == lightModeButton) {
            secondScene.getStylesheets().clear();
            URL stylesheetUrl2 = getClass().getResource("style/lightmode.css");

            if (stylesheetUrl2 != null) {
                String darkModeStyleSheet2 = stylesheetUrl2.toExternalForm();
                secondScene.getStylesheets().add(darkModeStyleSheet2);
                darkModeButton.setDisable(false);
                lightModeButton.setDisable(true);

            }
        }
    }

    //Method to clear forms text fields
    private void processClear(ActionEvent event) {
        Name.name.clear();
        Education.edu.clear();
        Biography.bio.clear();
        WorkExperience.work.clear();

    }
    public void setStrokeColor(Color color) {
        rect.setStroke(color);
    }
}






