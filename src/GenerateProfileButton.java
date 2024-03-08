
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;

public class GenerateProfileButton extends HBox {
    Button submit, clear;
    VBox vbox2;
    static Label nameSet, label;
    Label bioSet, bioSet2, eduSet, workSet, birthdaySet;

    ImageView profImg;
    private Paint ColorPick;
    private FinalProject finalProject;
    private Stage newWindow;
    Scene secondScene;
    public ColorPick accentColor;
    HBox hbox1, hboxToggle, hbox2, hbox3, hbox4;
    private boolean isDarkMode = false;

    TextField linkedInField;
    private HostServices hostServices;
    Button darkModeButton, lightModeButton, back;
    String darkModeStyleSheet;


    public ColorPick newColor;
    // Font selectedFont;

    public GenerateProfileButton() {
        submit = new Button("Generate Profile");
        submit.setOnAction(this::processSubmit);

        clear = new Button("Clear Form");
        clear.setOnAction(this::processClear);


        HBox subBox = new HBox(submit, clear);
        subBox.setPadding(new Insets(15, 15, 15, 25));
        subBox.setSpacing(10);

        getChildren().addAll(subBox);
    }


    private void processSubmit(ActionEvent event) {
        ColorPick accentColor1 = new ColorPick();
        Paint accentColorValue = accentColor1.getAccentColor();
        // Set the text fill of the label with the accent color


        Label accentC = new Label("Welcome to "+ Name.name.getText() + "'s Profile");
        accentC.setFont(Font.font("Calibre", FontWeight.BOLD, FontPosture.REGULAR, 24));
        //accentC.setTranslateX(400);
        accentC.setTextFill(accentColorValue);


        nameSet = new Label();
        nameSet.setTranslateX(300);
        nameSet.setText("Name: " + Name.name.getText());
        nameSet.setFont(Name.name.getFont());


        birthdaySet = new Label();
        birthdaySet.setTranslateX(300);
        birthdaySet.setText("Birthday: " + Birthday.message.getText());
        birthdaySet.setFont(Birthday.message.getFont());

        bioSet = new Label();
        bioSet.setTranslateX(300);
        bioSet.setAlignment(Pos.CENTER);
        bioSet.setText("LinkedIn: " + Biography.bio.getText());
        bioSet.setFont(Biography.bio.getFont());
        //bioSet.setStyle("-fx-font-size: 20");



        bioSet2 = new Label();
        bioSet2.setTranslateX(300);
        bioSet2.setText("Biography: " + Bio.content.getText());
        //bioSet.setTextFill(accentColor.colorPick.getValue());

        eduSet = new Label();
        eduSet.setTranslateX(300);
        eduSet.setText("Education: " + Education.edu.getText());
        eduSet.setFont(Education.edu.getFont());

        Hyperlink bioLink = new Hyperlink( Biography.bio.getText());
        bioLink.setOnAction(e -> {
            //HostServices hostServices1 = getHostServices();
            // Get the LinkedIn URL from the text field
            String linkedInURL = Biography.bio.getText();
            if (!linkedInURL.isEmpty()) {

                //handleHyperlinkClick(getHostServices());
                // Open the URL in the default web browser
                //getHostServices().showDocument(linkedInURL);
            }
        });
        bioLink.setStyle("-fx-font-size: 14px;");

        //HBox linkedInSection = new HBox(10);
        //linkedInSection.setAlignment(Pos.CENTER);
        //Label linkedInLabel = new Label(bioSet.getText());
        //linkedInField = new TextField();
        //linkedInSection.getChildren().addAll(linkedInLabel, linkedInField);
        // LinkedIn Link Section
        //Hyperlink = new Hyperlink(linkedInField.getText());

        workSet = new Label();
        workSet.setTranslateX(300);
        workSet.setText(" Work Experience: " + WorkExperience.work.getText());
        workSet.setFont(WorkExperience.work.getFont());


        profImg = new ImageView();
        //profImg.setTranslateX(220);
        Image selectedImage = Picture.getImage();
        if (selectedImage != null) {
            profImg.setImage(selectedImage);
            profImg.setFitWidth(300); // Set the desired width
            profImg.setPreserveRatio(true); // Ensure the image ratio is preserved
        }
        Rectangle rect = new Rectangle(300, 220, null);
        rect.setStroke(Color.AQUAMARINE);
        rect.setStrokeWidth(6);

        StackPane imagePane = new StackPane(profImg, rect);

        //final Separator divider = new Separator(Orientation.HORIZONTAL);
        //divider.setHalignment(HPos.CENTER);

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

        lightModeButton = new Button("Light Mode");
        lightModeButton.setOnAction(this::processLight);
        lightModeButton.setTooltip(new Tooltip("It's so bright"));

        hboxToggle = new HBox(lightModeButton, darkModeButton);
        hboxToggle.setAlignment(Pos.TOP_CENTER);


        hbox1 = new HBox(img2);
        hbox1.setAlignment(Pos.CENTER);


        back = new Button("Return");
        back.setAlignment(Pos.CENTER_LEFT);
        back.setOnAction(this::processHome);

        hbox2 = new HBox(back);
        hbox2.setAlignment(Pos.CENTER);

        hbox3 = new HBox(bioLink);
        getChildren().addAll(hbox3);
        hbox3.setAlignment(Pos.CENTER);

        hbox4 = new HBox(accentC);
        getChildren().addAll(hbox4);
        hbox4.setAlignment(Pos.CENTER);


        vbox2 = new VBox(hboxToggle, hbox4, imagePane, nameSet, birthdaySet, hbox1, eduSet, workSet, hbox3, Bio.content, hbox2);
        vbox2.setAlignment(Pos.CENTER_LEFT);
        vbox2.setStyle("-fx-background-color: teal");
        vbox2.setPrefSize(1000, 600);


        ScrollPane root2 = new ScrollPane(vbox2);
        root2.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        root2.setPrefViewportHeight(400);
        root2.setPrefViewportWidth(800);
        secondScene = new Scene(root2, 1000, 600);
        // secondScene.setFill(accentColor.colorPick.getValue());


        newWindow = new Stage();
        newWindow.setTitle("Profile for " + Name.name.getText());
        newWindow.setScene(secondScene);
        secondScene.getRoot().applyCss();


        newWindow.initModality(Modality.WINDOW_MODAL);

        newWindow.show();

    }



    private void processHome(ActionEvent event) {
        if (event.getSource() == back) {
            newWindow.close();
        }
    }

    private void processDark(ActionEvent event) {
        if (event.getSource() == darkModeButton) {
            URL stylesheetUrl = getClass().getResource("style/darkmode.css ");
            secondScene.getStylesheets().clear();
            //  secondScene.getStylesheets().add(getClass().getResource("darkmode.css").toExternalForm());
            if (stylesheetUrl != null) {
                // Convert the URL to an external form (String)
                String darkModeStyleSheet = stylesheetUrl.toExternalForm();
                //secondScene.getStylesheets().remove(darkModeStyleSheet);
                secondScene.getStylesheets().add(darkModeStyleSheet);

                darkModeButton.setDisable(true);
                lightModeButton.setDisable(false);
            }
        }
    }

    private void processLight(ActionEvent event) {
        if (event.getSource() == lightModeButton) {
            secondScene.getStylesheets().clear();
            URL stylesheetUrl2 = getClass().getResource("style/lightmode.css");

            if (stylesheetUrl2 != null) {
                String darkModeStyleSheet2 = stylesheetUrl2.toExternalForm();
                secondScene.getStylesheets().add(darkModeStyleSheet2);
                //secondScene.getStylesheets().remove( darkModeStyleSheet2);
                // Add light mode stylesheet
                //secondScene.getStylesheets().add(getClass().getResource("lightmode.css").toExternalForm());
                darkModeButton.setDisable(false);
                lightModeButton.setDisable(true);

            }
        }
    }
    //private void handleHyperlinkClick(HostServices hostServices) {
     //   if (hostServices != null) {
            //hostServices.showDocument(linkedInURL);
    //    }
   // }
    public Label getBioSet() {
        return bioSet;
        //hostServices = getHostServices();

        // Create a Hyperlink
      //  Hyperlink hlink = new Hyperlink("Visit LinkedIn");

        // Set the action for the Hyperlink
      //  hlink.setOnAction(event -> {
            // Replace "https://www.linkedin.com/" with the actual LinkedIn profile URL
       //     String url = "https://www.linkedin.com/";
       //     hostServices.showDocument(url);
       // });

        // Add the Hyperlink to the VBox
       // getChildren().add(hlink);
    }

    private void processClear(ActionEvent event) {
        Name.name.clear();
        Education.edu.clear();
        Biography.bio.clear();
        WorkExperience.work.clear();

    }

   // public String getAccentColor() {
   //     return String.valueOf(accentColor.colorPick);
   // }


}






