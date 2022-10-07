package com.example.gradingsytem;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.InputStream;

public class DashBoard {

    public static void MenuBarSite(){

        try{
            //setWindow and it's name and icon
            Stage window = new Stage();
            window.setTitle("Grading System");
            InputStream stream = new FileInputStream("C:/Users/User/IdeaProjects/GradingSytem/src/images/icon/icon.png");
            Image image = new Image(stream);
            window.getIcons().add(image);
            //window.initModality(Modality.APPLICATION_MODAL);

            // create two menu
            Menu m = new Menu("Semester");
            Menu res = new Menu("Result");

            // create menuitems
            MenuItem m1 = new MenuItem("Summer 2022");
            MenuItem m2 = new MenuItem("Fall 2022");
            MenuItem m3 = new MenuItem("Spring 2022");

            // add menu items to menu
            m.getItems().add(m1);
            m.getItems().add(m2);
            m.getItems().add(m3);

            MenuBar mb = new MenuBar();
            mb.getMenus().addAll(m , res);

            //Create label , TextField

            Label summerLabel = new Label("SUMMER 2022");
            summerLabel.setTextFill(Color.DARKSLATEBLUE);
            summerLabel.setFont(Font.font("Courier", FontWeight.BOLD , 20));

            Label userId = new Label("User Id");
            userId.setTextFill(Color.WHITE);
            userId.setFont(Font.font("Courier", FontWeight.BOLD , 12));

            TextField user_id = new TextField();
            user_id.setMaxWidth(150);


           Text advanced_java = new Text("Advanced Java");
           advanced_java.setFill(Color.WHITESMOKE);
           advanced_java.setFont(Font.font("Courier", FontWeight.BOLD , 13));

           TextField advanced_java_number = new TextField();
           advanced_java_number.setMaxWidth(150);


            Text advanced_java_lab = new Text("Advanced Java Lab");
            advanced_java_lab.setFill(Color.WHITESMOKE);
            advanced_java_lab.setFont(Font.font("Courier", FontWeight.BOLD , 13));

            TextField advanced_java_lab_number = new TextField();
            advanced_java_lab_number.setMaxWidth(150);

            Text evs = new Text("Environmental Science");
            evs.setFill(Color.WHITESMOKE);
            evs.setFont(Font.font("Courier", FontWeight.BOLD , 13));

            TextField environment_number = new TextField();
            environment_number.setMaxWidth(150);

            Text iit = new Text("Internet & Internet Technology");
            iit.setFill(Color.WHITESMOKE);
            iit.setFont(Font.font("Courier", FontWeight.BOLD , 13));

            TextField iit_number = new TextField();
            iit_number.setMaxWidth(150);

            Button button = new Button("Click");
            button.setFont(Font.font("Courier", FontWeight.BOLD , 16));

            Text lastLabel = new Text();
            lastLabel.setFill(Color.RED);
            lastLabel.setFont(Font.font("Courier", FontWeight.BOLD , 13));


            //css
            //Styling nodes
            button.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");



            // create a VBox
            VBox vb = new VBox(mb,summerLabel,userId , user_id,advanced_java , advanced_java_number ,advanced_java_lab,advanced_java_lab_number , evs,environment_number ,iit,iit_number,button,lastLabel);
            vb.setStyle("-fx-background-color: yellowgreen;");
            VBox.setMargin(mb, new Insets(10,10,10,10));
            VBox.setMargin(button,new Insets(20,20,20,20));
            vb.setAlignment(Pos.TOP_CENTER);

            //eventHandaling

            button.setOnAction(e->{
                String stu = user_id.getText().toString();
                String aj = advanced_java_number.getText().toString();
                String ajl = advanced_java_lab_number.getText().toString();
                String evss = environment_number.getText().toString();
                String iitn = iit_number.getText().toString();

                if(!stu.isEmpty()&&!aj.isEmpty() && !ajl.isEmpty() && !evss.isEmpty() && !iitn.isEmpty()){

                    boolean condition = false;
                    String[] arr = {stu , aj,ajl,evss,iitn};
                    int i = 0;
                    lastLabel.setText("");
                    while(i != arr.length){

                        condition = arr[i].matches("-?\\d+(.\\d+)?");
                        if(!condition){
                            break;
                        }
                        i++;
                    }
                    if(condition){

                       Calculation.calculateResult(aj , ajl , evss , iitn);
                       lastLabel.setText("");

                    }
                    else{
                        lastLabel.setText("All inputs should be Digit");
                    }

                }
                else{
                    lastLabel.setText("Your Input field is Empty");
                }
            });





            // create a scene
            Scene sc = new Scene(vb, 400, 400);

            window.setResizable(false);
            window.setScene(sc);


            //Event handaling
            window.showAndWait();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
