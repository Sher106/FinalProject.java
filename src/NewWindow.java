import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.control.ColorPicker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NewWindow extends ColorPick{
    ColorPicker colorPicker = new ColorPicker();

       // colorPicker.setOnAction(new EventHandler(){

     //   @Override
      //  public void handle(Event event) {
       //     Paint fill = colorPicker.getValue();
      //      BackgroundFill backgroundFill =
       //             new BackgroundFill(fill,
      //                      CornerRadii.EMPTY,
      //                      Insets.EMPTY);
        //    Background background = new Background(backgroundFill);
        //    root.setBackground(background);
     //   }
 //   });

  //      root.getChildren().add(colorPicker);

//    Scene scene = new Scene(root, 300, 250);
}
