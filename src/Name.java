import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class Name extends HBox {
    static TextField name;

    //Method that takes name that's typed into TextField. Also, setting initial text font and positioning
    public Name() {
        Label inputLabel = new Label("What is your name?");

        name = new TextField();
        name.setFont(Font.font("Calibre", FontWeight.BOLD, FontPosture.REGULAR, 14));
        name.setPrefWidth(200);
        name.setAlignment(Pos.BASELINE_LEFT);
        name.getText();

        HBox nameBox = new HBox(inputLabel, name);
        nameBox.setPadding(new Insets(15, 15, 15, 25));
        nameBox.setSpacing(10);

        getChildren().addAll(nameBox);
    }

    //Method to change name font
    public static void setFontLabels(Font font) {
        if (name != null) {
            name.setFont(font);

        }

    }

}

