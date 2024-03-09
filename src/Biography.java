import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Biography extends HBox {
    //Declaring TextField so it can be accessed throughout method
    static TextField bio;

    //Method
    public Biography() {
        Label bioLabel = new Label("Web Profile:  ");


        bio = new TextField();
        bio.setFont(Font.font("Calibre", FontWeight.BOLD, FontPosture.REGULAR, 14));
        bio.setPrefWidth(200);
        bio.setAlignment(Pos.BASELINE_LEFT);
        bio.getText();

        //Creating hyperlink
        Hyperlink bioLink = new Hyperlink();

        //bioLink
        bioLink.setOnAction(e -> {

            //Hyperlink path and exception
            String linkedInURL2 = bio.getText();
            try {
                Desktop.getDesktop().browse(new URI(linkedInURL2));
            } catch (IOException | URISyntaxException ex) {
                System.out.println("Error opening profile: " + ex.getMessage());
            }
        });

        //HBox to place variables created. Also, positioning HBox
        HBox bioBox = new HBox(bioLabel, bio);
        bioBox.setPadding(new Insets(15, 15, 15, 25));
        bioBox.setSpacing(10);

        getChildren().addAll(bioBox);
    }

    //Method to change bio font
    public static void setFontLabels(Font font) {
        if (bio != null) {
            bio.setFont(font);
        }
    }
}
