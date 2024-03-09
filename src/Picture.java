import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


    public class Picture extends HBox {
        static Image image;
        //Method for Profile picture upload
        public Picture() {
            Label pictureLabel = new Label("Upload a Picture");

            Button uploadPic = new Button("Upload Picture");  //Upload button
            uploadPic.setAlignment(Pos.BASELINE_LEFT);


            ImageView img = new ImageView();
            img.setFitWidth(200);
            img.setPreserveRatio(true);
            img.setSmooth(true);
            img.setCache(true);


            //Action method to open file explorer to select desires picture
            EventHandler<ActionEvent> picPush = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    FileChooser picChooser = new FileChooser();

                    //Filtering file type
                    FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG Files(*.jpg)", "*.JPG");
                    FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG Files(*.png)", "*.PNG");

                    picChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

                    File heatshot = picChooser.showOpenDialog(null);

                    try {
                        BufferedImage bufferedImage = ImageIO.read(heatshot);

                        image = SwingFXUtils.toFXImage(bufferedImage, null);

                        img.setImage(image);

                    } catch (IOException ex){
                        ex.printStackTrace();
                        Logger.getLogger(FinalProject.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };

            uploadPic.setOnAction(picPush);

            HBox picBox = new HBox(pictureLabel, uploadPic);
            picBox.setPadding(new Insets(15, 15, 15, 25));
            picBox.setSpacing(10);

            getChildren().addAll(picBox);
        }
        public static Image getImage() {

            return image;
        }
    }







