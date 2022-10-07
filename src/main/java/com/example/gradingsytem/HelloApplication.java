package com.example.gradingsytem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    Stage window;
    @Override
    public void start(Stage stage) throws IOException {

       try{

           //window -> stage
           window = stage;
           window.setTitle("GradE Calculator");
           //Two image stream ->IMAGE AND ICON
           InputStream stream = new FileInputStream("C:/Users/User/IdeaProjects/GradingSytem/src/images/icon/icon.png");
           InputStream stream1 = new FileInputStream("C:/Users/User/IdeaProjects/GradingSytem/src/images/icon/grades.png");
           //setIcon
           Image image = new Image(stream);
           Image image1 = new Image(stream1);
           window.getIcons().add(image);
           window.setResizable(false);

           //setText , image , Button
           Text text = new Text();
           text.setText("You are welcome to our Grading Calculator");
           text.setFont(Font.font("Courier", FontWeight.BOLD , 16));

           ImageView imageView = new ImageView();
           imageView.setImage(image1);
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
               DashBoard.MenuBarSite();
           });


           //Layout
           StackPane layout = new StackPane();
           layout.getChildren().addAll(text , imageView , button);
           layout.setPadding(new Insets(20,20,20,20));
           StackPane.setAlignment(text , Pos.TOP_CENTER);
           StackPane.setAlignment(imageView , Pos.CENTER);
           StackPane.setAlignment(button , Pos.BOTTOM_CENTER);
           layout.setStyle("-fx-background-color: yellowgreen;");

           //Scene
           Scene scene = new Scene(layout,400,400);
           //window
           window.setScene(scene);
           window.show();
       }catch(Exception e){
           e.printStackTrace();
       }
    }
}