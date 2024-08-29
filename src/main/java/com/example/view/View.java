package com.example.view;

import com.example.model.Person;

import java.util.List;

public interface View {
    void displayPeople(List<Person> people);
    void displayError(String message);
    void displayMessage(String message);
    String getInput(String prompt);
}
