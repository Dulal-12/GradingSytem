package com.example.gradingsytem;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;

import static com.example.gradingsytem.Welcome.icon;

public class Result {

    public static void resultTable(){
        try {
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


            Label userId = new Label("User Id");
            userId.setTextFill(Color.WHITE);
            userId.setFont(Font.font("Courier", FontWeight.BOLD , 12));

            TextField user_id = new TextField();
            user_id.setMaxWidth(150);

            Button button = new Button("Click");
            button.setFont(Font.font("Courier", FontWeight.BOLD , 16));
            button.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

            Text lastLabel = new Text();
            lastLabel.setFill(Color.RED);
            lastLabel.setFont(Font.font("Courier", FontWeight.BOLD , 13));


            //event-handler
            menuItem_semester_summer.setOnAction(e->{
                window.close();
                SummerSemester.summerSemesterSite();
            });

            menuItem_semester_fall.setOnAction(e->{
                window.hide();
                FallSemester.fall();
            });



            button.setOnAction(e->{

                String id = user_id.getText().toString();
                if(!id.isEmpty()){

                    lastLabel.setText("");
                    boolean   condition = id.matches("-?\\d+(.\\d+)?");

                    if(condition){
                        lastLabel.setText("");
                        VBox vbox = new VBox();
                        try{

                            String driver = "com.mysql.jdbc.Driver";
                            String url = "jdbc:mysql://localhost:3306/gradecalculator";
                            String user1 = "root";
                            String password = "";

                                    /*
                                    jdbc connection
                                     */
                            Class.forName(driver);
                            Connection conn= DriverManager.getConnection(url, user1,password);

                            Statement stmt  = conn.createStatement();
                            String sql = "SELECT * from result " ;
                            ResultSet rs    = stmt.executeQuery(sql);



                            while(rs.next()){

                                  String user = rs.getString(2);

                                  if(user.equals(id)){

                                      String sem = rs.getString(3);
                                      String gr = rs.getString(6);
                                      double tot = rs.getDouble(4);
                                      float avg = rs.getFloat(5);
                                      String ui = rs.getString(2);


                                      Label text = new Label(sem);
                                      text.setFont(Font.font("Courier", FontWeight.BOLD , 14));

                                      Label grade = new Label(gr);
                                      text.setFont(Font.font("Courier", FontWeight.BOLD , 14));

                                      Label total = new Label(""+tot);
                                      total.setFont(Font.font("Courier", FontWeight.BOLD , 14));

                                      Label average = new Label(""+avg);
                                      average.setFont(Font.font("Courier", FontWeight.BOLD , 14));

                                      Label userID = new Label(""+ui);
                                      userID.setFont(Font.font("Courier", FontWeight.BOLD , 14));



                                      HBox hb = new HBox(userID,text,grade,total,average);
                                      hb.setSpacing(20);
                                      hb.setPadding(new Insets(10,10,10,10));
                                      hb.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, null , null)));
                                      vbox.setSpacing(5);
                                      vbox.setPadding(new Insets(10, 10, 10, 10));
                                      vbox.getChildren().addAll(hb);
                                      vbox.setStyle("-fx-background-color: yellowgreen;");
                                      vbox.setAlignment(Pos.TOP_CENTER);

                                  }


                        }
                            rs.close();
                            conn.close();


                            Stage win = new Stage();
                            Scene scene = new Scene(vbox, 400, 400);
                            win.setScene(scene);
                            win.setResizable(false);
                            win.setTitle("GradE Calculator");
                            //Two image stream ->IMAGE AND ICON
                            try{
                                InputStream stream2 = new FileInputStream("C:/Users/User/IdeaProjects/GradingSytem/src/images/icon/icon.png");
                                Image image2 = new Image(stream2);
                                win.getIcons().add(image2);
                            }catch(Exception ex){
                                ex.printStackTrace();
                            }
                            win.show();

                        }catch(Exception ex){
                            ex.printStackTrace();
                        }
                    }
                    else{
                        lastLabel.setText("User id only digit");
                    }
                }
                else{
                    lastLabel.setText("Please fill up input box.");
                }
            });
            //window
            VBox vb = new VBox(mb , userId,user_id , button,lastLabel);
            vb.setStyle("-fx-background-color: yellowgreen;");
            VBox.setMargin(mb, new Insets(10,10,10,10));
            VBox.setMargin(button,new Insets(20,20,20,20));
            vb.setAlignment(Pos.TOP_CENTER);
            //Scene
            Scene scene = new Scene(vb,400,400);
            window.setScene(scene);
            window.show();

        }catch(Exception e){
            e.printStackTrace();
        }



    }

}
