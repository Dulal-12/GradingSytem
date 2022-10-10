package com.example.gradingsytem;
import javafx.css.converter.SizeConverter;
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
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.InputStream;

import static com.example.gradingsytem.Welcome.icon;

public class SummerSemester {

    public static void summerSemesterSite(){

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

            /*
            MenuBar
            Menu
            MenuItem
             */
            MenuBar mb = new MenuBar();
            Menu first_menu = new Menu("Semester");
            Menu second_menu = new Menu("Result");

            // create menuitems
            MenuItem menuItem_semester_summer = new MenuItem("Summer 2022");
            MenuItem menuItem_semester_fall = new MenuItem("Fall 2022");
            MenuItem semester_result = new MenuItem("Semester Result");

            // add menu items to menu
            first_menu.getItems().add(menuItem_semester_summer);
            first_menu.getItems().add(menuItem_semester_fall);
            second_menu.getItems().add(semester_result);

            //set menu into menubar
            mb.getMenus().addAll(first_menu , second_menu);



            //create number field and label
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
            button.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

            Text errorLabel = new Text();
            errorLabel.setFill(Color.RED);
            errorLabel.setFont(Font.font("Courier", FontWeight.BOLD , 13));

            // create a VBox
            VBox vb = new VBox(mb,summerLabel,userId , user_id,advanced_java , advanced_java_number ,
                               advanced_java_lab,advanced_java_lab_number , evs,environment_number ,
                               iit,iit_number,button,errorLabel);

            vb.setStyle("-fx-background-color: yellowgreen;");
            VBox.setMargin(mb, new Insets(10,10,10,10));
            VBox.setMargin(button,new Insets(20,20,20,20));
            vb.setAlignment(Pos.TOP_CENTER);

            //event-Handler
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
                    errorLabel.setText("");
                    while(i != arr.length){

                        condition = arr[i].matches("-?\\d+(.\\d+)?");
                        if(!condition){
                            break;
                        }
                        i++;
                    }
                    if(condition){

                       Calculation.calculateResult("summer",stu,aj , ajl , evss , iitn);
                       errorLabel.setText("");

                    }
                    else{
                        errorLabel.setText("All inputs should be Digit");
                    }

                }
                else{
                    errorLabel.setText("Your Input field is Empty");
                }
            });


            menuItem_semester_fall.setOnAction(e->{
                window.hide();
                FallSemester.fall();
            });
            semester_result.setOnAction(e->{
                window.close();
                Result.resultTable();
            });


            // create a scene
            Scene sc = new Scene(vb, 400, 400);
            window.setScene(sc);
            window.show();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
