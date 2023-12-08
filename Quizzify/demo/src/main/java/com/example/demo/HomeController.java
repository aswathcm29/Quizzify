package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class HomeController {
    public Stage Primarystage;
    public static int Topic_id;
    public void setPrimarystage(Stage stage){
        this.Primarystage=stage;
    }
    public void tocreateQ() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("createq.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Primarystage.setTitle("Create Quiz!");
        Primarystage.setScene(scene);
        CreateqController toQController = fxmlLoader.getController();
        toQController.setPrimarystage(this.Primarystage);
    }
    public void toQuiz() throws Exception{
// Topic_id = a;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("quiz.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Primarystage.setTitle("Attend Quiz");
        scene.setFill(Color.TRANSPARENT);
        Primarystage.setScene(scene);
        QuizController toQuizController = fxmlLoader.getController();
        toQuizController.setPrimarystage(this.Primarystage);
    }
//    public void onClickMath() throws Exception {
//        toQuiz(1);
//    }
//    public void onClickLog() throws Exception {
//        toQuiz(2);
//    }
//    public void onClickSci() throws Exception {
//        toQuiz(3);
//    }
}
