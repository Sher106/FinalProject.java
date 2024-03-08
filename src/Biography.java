import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.application.HostServices;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Biography extends HBox {
    static TextField bio;


    public Biography() {
        Label bioLabel = new Label("LinkedIn Profile:  ");


        bio = new TextField();
        bio.setFont(Font.font("Calibre", FontWeight.BOLD, FontPosture.REGULAR, 14));
        bio.setPrefWidth(200);
        bio.setAlignment(Pos.BASELINE_LEFT);
        bio.getText();
        String linkedInURL = "https://www.linkedin.com/in/" + bio;

        Hyperlink bioLink = new Hyperlink();

        //bioLink.
        bioLink.setOnAction(e -> {
            String linkedInURL2 = "https://www.linkedin.com/in/" + bio.getText();
            try {
                Desktop.getDesktop().browse(new URI(linkedInURL2));
            } catch (IOException | URISyntaxException ex) {
                System.out.println("Error opening LinkedIn profile: " + ex.getMessage());
            }
           // HostServices hostServices = getHostServices();
           // getHostServices().showDocument(bio);
            //try {
            //    java.awt.Desktop.getDesktop().browse(java.net.URI.create(linkedInURL));
           // } catch (java.io.IOException ex) {
            //    System.out.println("Error opening LinkedIn profile: " + ex.getMessage());
            //}
        });


        HBox bioBox = new HBox(bioLabel, bio);
        bioBox.setPadding(new Insets(15, 15, 15, 25));
        bioBox.setSpacing(10);

        getChildren().addAll(bioBox);
    }

    public static void setFontLabels(Font font) {
        if (bio != null) {
            bio.setFont(font);
        }
    }
}
