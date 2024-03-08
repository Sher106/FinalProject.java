import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Education extends HBox {
    static TextField edu;

    public Education() {
        Label eduLabel = new Label("Education: ");

        edu = new TextField();
        edu.setFont(Font.font("Calibre", FontWeight.BOLD, FontPosture.REGULAR, 14));
        edu.setPrefWidth(200);
        edu.setAlignment(Pos.BASELINE_LEFT);
        edu.getText();

        HBox eduBox = new HBox(eduLabel, edu);
        eduBox.setPadding(new Insets(15, 15, 15, 25));
        eduBox.setSpacing(10);

        getChildren().addAll(eduBox);
    }

    public static void setFontLabels(Font font) {
        if (edu != null) {
            edu.setFont(font);
        }

    }
}
