package com.example.javafxdemo;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextArea questionArea;

    @FXML
    RadioButton answer1, answer2, answer3, answer4;

    @FXML
    ToggleGroup answers;

    private String question = "Your favourite fruit?";

    private String[] variants = {
            "Banana", "Orange", "Apple", "Pineapple"
    };

    private String correctVariant = "Apple";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        questionArea.setText(question);
        answer1.setText(variants[0]);
        answer2.setText(variants[1]);
        answer3.setText(variants[2]);
        answer4.setText(variants[3]);
    }

    public void tryToAnswer(ActionEvent actionEvent) {
        if (((RadioButton)answers.getSelectedToggle()).getText().equals(correctVariant)) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Correct");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong");
            alert.showAndWait();
        }
    }
}