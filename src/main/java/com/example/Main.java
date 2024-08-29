package com.example;

import com.example.model.FamilyTree;
import com.example.model.Person;
import com.example.presenter.Presenter;
import com.example.presenter.UserInteraction;
import com.example.service.FileService;
import com.example.view.ConsoleView;
import com.example.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleView();
        FamilyTree<Person> familyTree = new FamilyTree<>();
        FileService fileService = new FileService();
        Presenter presenter = new Presenter(view, familyTree, fileService);
        UserInteraction userInteraction = new UserInteraction(presenter, view);

        userInteraction.start();
    }
}
