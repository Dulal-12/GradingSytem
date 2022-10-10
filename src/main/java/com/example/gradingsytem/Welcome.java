package com.example.gradingsytem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Welcome extends Application {
    public static void main(String[] args) {
        launch();
    }

    Stage window;
    public static String icon;
    public static String welcome;
    @Override
    public void start(Stage stage) throws IOException {

       try{

           //stage as window
           window = stage;
           window.setTitle("GradE Calculator");
           window.setResizable(false);

           icon = "C:/Users/User/IdeaProjects/GradingSytem/src/images/icon/icon.png";
           welcome = "C:/Users/User/IdeaProjects/GradingSytem/src/images/icon/grades.png";
           InputStream icon_stream = new FileInputStream(icon);
           InputStream welcome_image_stream = new FileInputStream(welcome);

           //window icon set
           Image icon_image = new Image(icon_stream);
           Image welcome_image = new Image(welcome_image_stream);
           window.getIcons().add(icon_image);



           //welcome text , welcome image , welcome button
           Text text = new Text();
           text.setText("You are welcome to our Grading Calculator");
           text.setFont(Font.font("Courier", FontWeight.BOLD , 16));

           ImageView imageView = new ImageView();
           imageView.setImage(welcome_image);
           imageView.setX(10);
           imageView.setY(10);
           imageView.setFitWidth(150);
           imageView.setPreserveRatio(true);

           Button button = new Button("Next");
           button.setFont(Font.font("Courier", FontWeight.BOLD , 16));
           button.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
           text.setFill(Color.WHITE);

           //event-Handler
           button.setOnAction(e -> {
               window.hide();
               SummerSemester.summerSemesterSite();
           });


           //Layout
           StackPane layout = new StackPane();
           layout.getChildren().addAll(text , imageView , button);
           layout.setPadding(new Insets(20,20,20,20));
           StackPane.setAlignment(text , Pos.TOP_CENTER);
           StackPane.setAlignment(imageView , Pos.CENTER);
           StackPane.setAlignment(button , Pos.BOTTOM_CENTER);
           layout.setStyle("-fx-background-color: yellowgreen;");

           //create a scene and set scene
           Scene scene = new Scene(layout,400,400);
           window.setScene(scene);
           window.show();

       }catch(Exception e){
           e.printStackTrace();
       }
    }
}