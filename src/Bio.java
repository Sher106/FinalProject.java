
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bio extends HBox {
    static Text content;
    Bio() {
        Label bioLabel = new Label("Biography");
        Label noBio = new Label();
        content = new Text("");

        Button uploadBio = new Button("Upload Biography");
        uploadBio.setAlignment(Pos.BASELINE_LEFT);

        EventHandler<ActionEvent> bioPush = event -> {


            FileChooser bioChooser = new FileChooser();

            FileChooser.ExtensionFilter extFilterTXT = new FileChooser.ExtensionFilter("TXT files(*.txt)", "*.TXT");
            bioChooser.getExtensionFilters().addAll(extFilterTXT);

            File selectBio = bioChooser.showOpenDialog(null);
            noBio.setText(selectBio.getAbsolutePath());

            if (selectBio != null){
                try {
                    Scanner scan = new Scanner(selectBio);
                    String info = "";
                    while (scan.hasNext()) {
                        info += scan.nextLine() + "\n";
                    }
                    content.setText(info);
                }catch
                (FileNotFoundException e){
                    throw new RuntimeException(e);
                }
            }
        };
        uploadBio.setOnAction(bioPush);
        HBox bioBox = new HBox(bioLabel, uploadBio, noBio);
        bioBox.setPadding(new Insets(15, 15, 15, 25));
        bioBox.setSpacing(10);

        getChildren().addAll(bioBox);
    }
}


