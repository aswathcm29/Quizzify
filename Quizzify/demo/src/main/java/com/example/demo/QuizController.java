package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuizController {
    private Stage Primarystage;

    public void setPrimarystage(Stage stage) {
        this.Primarystage = stage;
    }

    List<Question> questionList = new ArrayList<>(10);

    List<Options> OptionsList = new ArrayList<>(4);

    String answer = new String();



    public void getQuestion(int topic_id) {
        questionList.clear();
        com.example.demo.DatabaseConnection connectNow = new com.example.demo.DatabaseConnection();
        try {
            Connection connection = connectNow.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT Question_id ,QuestionText, topic_id FROM questions"
            );

            ResultSet rs = preparedStatement.executeQuery();
            {
                while (rs.next()) {
//                    HomeController h1 = new HomeController();

                    if (rs.getInt("topic_id") == topic_id) {
                        Question Tq = new Question(
                                rs.getInt("Question_id"),
                                rs.getString("QuestionText"),
                                rs.getInt("topic_id")
                        );
                        questionList.add(Tq);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Question x : questionList) {
            System.out.println(x.quiz);
        }
    }


    @FXML
    public Label question;
    @FXML
    public Button opt1, opt2, opt3, opt4;
    static int Qno = 0;
    static int correct = 0;
    static int wrong = 0;

    @FXML
    private void initialize() {
        int topic_id = HomeController.Topic_id;
        getQuestion(topic_id);
        loadQuestions();
    }
    private void loadQuestions() {


        if (Qno == 0) {
            getOptions(questionList.get(Qno).id);
            question.setText(questionList.get(Qno).quiz);
            opt1.setText(OptionsList.get(0).option_var);
            opt2.setText(OptionsList.get(1).option_var);
            opt3.setText(OptionsList.get(2).option_var);
            opt4.setText(OptionsList.get(3).option_var);
        }
        if (Qno == 1) {
            getOptions(questionList.get(Qno).id);
            question.setText(questionList.get(Qno).quiz);
            opt1.setText(OptionsList.get(0).option_var);
            opt2.setText(OptionsList.get(1).option_var);
            opt3.setText(OptionsList.get(2).option_var);
            opt4.setText(OptionsList.get(3).option_var);
        }
        if (Qno == 2) {
            getOptions(questionList.get(Qno).id);
            question.setText(questionList.get(Qno).quiz);
            opt1.setText(OptionsList.get(0).option_var);
            opt2.setText(OptionsList.get(1).option_var);
            opt3.setText(OptionsList.get(2).option_var);
            opt4.setText(OptionsList.get(3).option_var);
        }
        if (Qno == 3) {
            getOptions(questionList.get(Qno).id);
            question.setText(questionList.get(Qno).quiz);
            opt1.setText(OptionsList.get(0).option_var);
            opt2.setText(OptionsList.get(1).option_var);
            opt3.setText(OptionsList.get(2).option_var);
            opt4.setText(OptionsList.get(3).option_var);
        }
        if (Qno == 4) {
            getOptions(questionList.get(Qno).id);
            question.setText(questionList.get(Qno).quiz);
            opt1.setText(OptionsList.get(0).option_var);
            opt2.setText(OptionsList.get(1).option_var);
            opt3.setText(OptionsList.get(2).option_var);
            opt4.setText(OptionsList.get(3).option_var);
        }
        if (Qno == 5) {
            getOptions(questionList.get(Qno).id);
            question.setText(questionList.get(Qno).quiz);
            opt1.setText(OptionsList.get(0).option_var);
            opt2.setText(OptionsList.get(1).option_var);
            opt3.setText(OptionsList.get(2).option_var);
            opt4.setText(OptionsList.get(3).option_var);
        }
        if (Qno == 6) {
            getOptions(questionList.get(Qno).id);
            question.setText(questionList.get(Qno).quiz);
            opt1.setText(OptionsList.get(0).option_var);
            opt2.setText(OptionsList.get(1).option_var);
            opt3.setText(OptionsList.get(2).option_var);
            opt4.setText(OptionsList.get(3).option_var);
        }
        if (Qno == 7) {
            getOptions(questionList.get(Qno).id);
            question.setText(questionList.get(Qno).quiz);
            opt1.setText(OptionsList.get(0).option_var);
            opt2.setText(OptionsList.get(1).option_var);
            opt3.setText(OptionsList.get(2).option_var);
            opt4.setText(OptionsList.get(3).option_var);
        }
        if (Qno == 8) {
            getOptions(questionList.get(Qno).id);
            question.setText(questionList.get(Qno).quiz);
            opt1.setText(OptionsList.get(0).option_var);
            opt2.setText(OptionsList.get(1).option_var);
            opt3.setText(OptionsList.get(2).option_var);
            opt4.setText(OptionsList.get(3).option_var);
        }
        if (Qno == 9) {
            getOptions(questionList.get(Qno).id);
            question.setText(questionList.get(Qno).quiz);
            opt1.setText(OptionsList.get(0).option_var);
            opt2.setText(OptionsList.get(1).option_var);
            opt3.setText(OptionsList.get(2).option_var);
            opt4.setText(OptionsList.get(3).option_var);
        }

    }

    @FXML
    public void opt1clicked(ActionEvent event) {
        checkAnswer(opt1.getText().toString());
        if (checkAnswer(opt1.getText().toString())) {
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (Qno == 9) {
            try {
                System.out.println(correct);
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("result.fxml"));
                Scene quizscene = new Scene(quiz.load());
                quizscene.setFill(Color.TRANSPARENT);
                Stage quizstage = new Stage();
                quizstage.setScene(quizscene);
                quizstage.initStyle(StageStyle.TRANSPARENT);
                quizstage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Qno++;
            loadQuestions();
        }

    }

    boolean checkAnswer(String answer) {

        if (Qno == 0) {
            if (answer.equals("21")) {
                return true;
            } else {
                return false;
            }
        }
        if (Qno == 1) {
            if (answer.equals("Thomas Alva Edison")) {
                return true;
            } else {
                return false;
            }
        }
        if (Qno == 2) {
            if (answer.equals("Neptune")) {
                return true;
            } else {
                return false;
            }
        }
        if (Qno == 3) {
            if (answer.equals("Ganymede")) {
                return true;
            } else {
                return false;
            }
        }
        if (Qno == 4) {
            if (answer.equals("Non Ductile")) {
                return true;
            } else {
                return false;
            }
        }
        if (Qno == 5) {
            if (answer.equals("Louis Pasteur")) {
                return true;
            } else {
                return false;
            }
        }
        if (Qno == 6) {
            if (answer.equals("Stomach")) {
                return true;
            } else {
                return false;
            }
        }
        if (Qno == 7) {
            if (answer.equals("Cheetah")) {
                return true;
            } else {
                return false;
            }
        }
        if (Qno == 8) {
            if (answer.equals("Green")) {
                return true;
            } else {
                return false;
            }
        }
        if (Qno == 9) {
            if (answer.equals("5th June")) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @FXML
    public void opt2clicked(ActionEvent event) {
        checkAnswer(opt2.getText().toString());
        if (checkAnswer(opt2.getText().toString())) {
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (Qno == 9) {
            try {
                System.out.println(correct);
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("result.fxml"));
                Scene quizscene = new Scene(quiz.load());
                quizscene.setFill(Color.TRANSPARENT);
                Stage quizstage = new Stage();
                quizstage.setScene(quizscene);
                quizstage.initStyle(StageStyle.TRANSPARENT);
                quizstage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Qno++;
            loadQuestions();
        }
    }

    @FXML
    public void opt3clicked(ActionEvent event) {
        checkAnswer(opt3.getText().toString());
        if (checkAnswer(opt3.getText().toString())) {
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (Qno == 9) {
            try {
                System.out.println(correct);
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("result.fxml"));
                Scene quizscene = new Scene(quiz.load());
                quizscene.setFill(Color.TRANSPARENT);
                Stage quizstage = new Stage();
                quizstage.setScene(quizscene);
                quizstage.initStyle(StageStyle.TRANSPARENT);
                quizstage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Qno++;
            loadQuestions();
        }
    }

    @FXML
    public void opt4clicked(ActionEvent event) {
        checkAnswer(opt4.getText().toString());
        if (checkAnswer(opt4.getText().toString())) {
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (Qno == 9) {
            try {
                System.out.println(correct);
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("result.fxml"));
                Scene quizscene = new Scene(quiz.load());
                quizscene.setFill(Color.TRANSPARENT);
                Stage quizstage = new Stage();
                quizstage.setScene(quizscene);
                quizstage.initStyle(StageStyle.TRANSPARENT);
                quizstage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Qno++;
            loadQuestions();
        }
    }

    public void getOptions(int parent_id) {
        OptionsList.clear();
        com.example.demo.DatabaseConnection connectNow = new com.example.demo.DatabaseConnection();
        System.out.println("parent id"+parent_id);
        try {
            Connection connection = connectNow.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT option_id , optionText , Question_id FROM options WHERE Question_id = ?"
            );
            preparedStatement.setInt(1,parent_id);
            System.out.println("SELECT option_id , optionText , Question_id FROM options WHERE Question_id = "+parent_id);
            ResultSet rs = preparedStatement.executeQuery();
            {
                while (rs.next()) {
                    Options Op = new Options(
                            rs.getInt("option_id"),
                            rs.getString("optionText"),
                            rs.getInt("Question_id")
                    );
                    OptionsList.add(Op);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
