package com.example.javafxdemo;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextArea questionArea;

    @FXML
    RadioButton answer1, answer2, answer3, answer4;

    @FXML
    ToggleGroup answers;

    private String[] questions = {
            "What is the capital of France?",
            "Which city is the capital of Australia?",
            "What is the capital of Canada?",
            "Which of these is the capital of Egypt?",
            "What city is the capital of Spain?"
    };

    private String[][] variants = {
            {"Rome", "London", "Paris", "Berlin"},
            {"Sydney", "Melbourne", "Canberra", "Brisbane"},
            {"New York", "Ottawa", "Toronto", "Montreal"},
            {"Cairo", "Istanbul", "Dubai", "Jerusalem"},
            {"Madrid", "Lisbon", "Barcelona", "Seville"}
    };

    private int[] correctAnswers = {2, 2, 1, 0, 0};

    private int currIndex = 0;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayQuestion(currIndex);
    }

    private void displayQuestion(int index) {
        questionArea.setText(questions[index]);
        answer1.setText(variants[index][0]);
        answer2.setText(variants[index][1]);
        answer3.setText(variants[index][2]);
        answer4.setText(variants[index][3]);
    }



    public void tryToAnswer(ActionEvent actionEvent) {
        RadioButton selectedRadioButton = (RadioButton) answers.getSelectedToggle();
        int selectedIndex = -1;
        if (selectedRadioButton == answer1) selectedIndex = 0;
        else if (selectedRadioButton == answer2) selectedIndex = 1;
        else if (selectedRadioButton == answer3) selectedIndex = 2;
        else if (selectedRadioButton == answer4) selectedIndex = 3;

        if (selectedIndex == correctAnswers[currIndex]) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Correct");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong");
            alert.showAndWait();
        }

        currIndex++;
        if (currIndex < questions.length) {
            displayQuestion(currIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "End");
            alert.showAndWait();
        }
    }
}