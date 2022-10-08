package com.example.gradingsytem;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class Result {

    public static void resultTable(){
        try {
            Stage window = new Stage();
            window.setTitle("GradE Calculator");
            //Two image stream ->IMAGE AND ICON
            InputStream stream = new FileInputStream("C:/Users/User/IdeaProjects/GradingSytem/src/images/icon/icon.png");
            InputStream stream1 = new FileInputStream("C:/Users/User/IdeaProjects/GradingSytem/src/images/icon/grades.png");
            //setIcon
            Image image = new Image(stream);
            Image image1 = new Image(stream1);
            window.getIcons().add(image);
            window.setResizable(false);


            Menu m = new Menu("Semester");
            Menu res = new Menu("Result");

            // create menuitems
            MenuItem m1 = new MenuItem("Summer 2022");
            MenuItem m2 = new MenuItem("Fall 2022");


            // add menu items to menu
            m.getItems().add(m1);
            m.getItems().add(m2);


            //set menu into menubar
            MenuBar mb = new MenuBar();
            mb.getMenus().addAll(m, res);

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





            //event
            m1.setOnAction(e->{
                window.close();
                DashBoard.MenuBarSite();
            });

            m2.setOnAction(e->{
                window.hide();
                FallSemester.fall();
            });

            String semster[] = {};

            button.setOnAction(e->{



                String id = user_id.getText().toString();
                if(!id.isEmpty()){

                    lastLabel.setText("");
                    boolean   condition = id.matches("-?\\d+(.\\d+)?");
                    if(condition){
                        lastLabel.setText("");
                        VBox vbox = new VBox();

                        try{
                            Class.forName("com.mysql.jdbc.Driver");

                            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/gradecalculator","root","");

                            Statement stmt  = conn.createStatement();
                            String sql = "SELECT * from result " ;
                            ResultSet rs    = stmt.executeQuery(sql);



                            while(rs.next()){

                                  String user = rs.getString(2);
                                  int i = 0;

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

    public static ObservableList<FileData> getData(String id, String sem,double tot,float avg,String  gr){

        ObservableList<FileData>data = FXCollections.observableArrayList();
        data.add(new FileData(id,sem,tot,avg,gr));

        return data;
    }



}
