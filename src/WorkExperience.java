import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class WorkExperience extends HBox {
    static TextField work;

    public WorkExperience() {
        Label workLabel = new Label("Work Experience: ");

        work = new TextField();
        work.setFont(Font.font("Calibre", FontWeight.BOLD, FontPosture.REGULAR, 14));
        work.setPrefWidth(200);
        work.setAlignment(Pos.BASELINE_LEFT);
        work.getText();

        HBox workBox = new HBox(workLabel, work);
        workBox.setPadding(new Insets(15, 15, 15, 25));
        workBox.setSpacing(10);

        getChildren().addAll(workBox);
    }

    public static void setFontLabels(Font font) {
        if (work != null) {
            work.setFont(font);
        }
    }
}
