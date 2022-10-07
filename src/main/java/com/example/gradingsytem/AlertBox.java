package com.example.gradingsytem;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;

public class AlertBox {

    public static void message(){
        try{
            //window -> stage
            Stage window = new Stage();
            window.setTitle("Grading System");
            InputStream stream = new FileInputStream("C:/Users/User/IdeaProjects/GradingSytem/src/images/icon/icon.png");
            InputStream stream1 = new FileInputStream("C:/Users/User/IdeaProjects/GradingSytem/src/images/icon/grades.png");
            Image image = new Image(stream);
            Image image1 = new Image(stream1);
            window.getIcons().add(image);
            window.setResizable(false);


            Text text = new Text("Don't be smart. Number 0-100");
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
