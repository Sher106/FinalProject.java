
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ColorPick extends HBox {
    //Declaring variables
    public static ColorPicker accentColor;
    Paint newColor;

    public ColorPick(){
        Label accentLabel = new Label("Choose an accent color?");

        accentColor = new ColorPicker(Color.BLACK);

        //Action method to change accent color
        accentColor.setOnAction( new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Color newColor = accentColor.getValue();
                accentLabel.setTextFill(newColor);
            }

        });

        HBox colBox = new HBox(accentLabel, accentColor);
        colBox.setPadding(new Insets(15,15,15,25));
        colBox.setSpacing(10);

        getChildren().addAll(colBox);
    }


    //Creating method to change color of text(doesn't really work though. problems reaching other class)
    public Paint getAccentColor() {
        //if (newColor != null) {
       //     return accentColor.getValue();
       // }
        return accentColor.getValue();
    }
}


