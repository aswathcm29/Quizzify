package com.example.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.MenuButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class HelloController {
    @FXML
    public TextField username;
    @FXML
    private Stage Primarystage;
    @FXML
    private PasswordField password;

    @FXML
    private  MenuButton usertype;

    @FXML
    private Label Username;

    public static String user_name;

    public void setCreator() throws Exception{
        usertype.setText("Quiz Creator");
    }
    public void setTaker() throws Exception{
        usertype.setText("Quiz Attendee");
    }



    @FXML
    private Text loginMessage;// use PasswordField instead of TextField for password input

    @FXML
    protected void onClickLogin() {
        System.out.printf("Trying to login using %s:%s\n", username.getText(), password.getText());
        loginMessage.setVisible(false);
        try{
            String loggedInUser = Login(username.getText(),password.getText());

        }
        catch(Exception e){
            loginMessage.setText(e.getMessage());
            loginMessage.setStroke(Color.RED);
            loginMessage.setVisible(true);
        }
    }
    public void setPrimarystage(Stage stage){
        this.Primarystage=stage;
    }

    public String toHome() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),1500,1500);
            HomeController loginController = fxmlLoader.getController();
            loginController.setPrimarystage(this.Primarystage);
            Primarystage.setTitle("Home coming!");
            Primarystage.setScene(scene);
        } catch (IOException e) {
            loginMessage.setText(e.getMessage());
            loginMessage.setStroke(Color.RED);
            loginMessage.setVisible(true);
        }
        return null;
    }


    private String Login(
            String user,
            String pass
    )throws Exception{
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();
        String connectQuery= "SELECT * FROM user WHERE username= '"+user+"' AND password = '"+pass+"'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);
            int i = 0;
            while (queryOutput.next()) {
                System.out.print("Username:");
                System.out.println(queryOutput.getString("username"));
                System.out.print("Password : ");
                System.out.println(queryOutput.getString("password"));
                i=1;
            }
            if(i==0)
                System.out.println("Invalid username or password");
            else{
//                Username.setText(user);
//                System.out.println(user);
//                if(Username.getText().isEmpty())
//                {
//                    System.out.println("Empty");
//                }
                this.user_name = user;
                toHome();

            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "aswath";
    }
}
