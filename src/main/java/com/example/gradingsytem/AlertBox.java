package com.example.gradingsytem;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;

import static com.example.gradingsytem.Welcome.icon;

public class AlertBox {

    public static void message(String message){
        try{
            /* stage as window
            set title
            set icon
            not resize window
             */
            Stage window = new Stage();
            window.setTitle("GradE Calculator");
            InputStream icon_image = new FileInputStream(icon);
            Image image = new Image(icon_image);
            window.getIcons().add(image);
            window.setResizable(false);


            Text text = new Text();
            text.setText(message);
            text.setFill(Color.RED);
            text.setFont(Font.font("Courier", FontWeight.BOLD , 13));

            VBox layout = new VBox(text);
            layout.setStyle("-fx-background-color: yellowgreen;");
            layout.setAlignment(Pos.CENTER);

            Scene scene = new Scene(layout , 400,400);
            window.setScene(scene);
            window.show();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
