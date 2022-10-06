package com.example.gradingsytem;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;

public class DashBoard {

    public static void MenuBarSite(){

        try{

            Stage window = new Stage();
            window.setTitle("Grading System");
            InputStream stream = new FileInputStream("C:/Users/User/IdeaProjects/GradingSytem/src/images/icon/icon.png");
            Image image = new Image(stream);
            window.getIcons().add(image);
            window.initModality(Modality.APPLICATION_MODAL);



            window.showAndWait();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
