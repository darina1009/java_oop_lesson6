package com.example.presenter;

import com.example.view.View;

public class UserInteraction {
    private Presenter presenter;
    private View view;

    public UserInteraction(Presenter presenter, View view) {
        this.presenter = presenter;
        this.view = view;
    }

    public void start() {
        while (true) {
            view.displayMessage("Choose an action:");
            view.displayMessage("1. Display people");
            view.displayMessage("2. Sort by name");
            view.displayMessage("3. Sort by birth date");
            view.displayMessage("4. Add person");
            view.displayMessage("5. Create family relation");
            view.displayMessage("6. Load data");
            view.displayMessage("7. Save data");
            view.displayMessage("8. Exit");

            int choice = Integer.parseInt(view.getInput("Enter your choice"));

            switch (choice) {
                case 1:
                    presenter.displayPeople();
                    break;
                case 2:
                    presenter.sortByName();
                    break;
                case 3:
                    presenter.sortByBirthDate();
                    break;
                case 4:
                    presenter.addPerson();
                    break;
                case 5:
                    presenter.createFamilyRelation();
                    break;
                case 6:
                    String loadFilePath = view.getInput("Enter file path to load data");
                    presenter.loadData(loadFilePath);
                    break;
                case 7:
                    String saveFilePath = view.getInput("Enter file path to save data");
                    presenter.saveData(saveFilePath);
                    break;
                case 8:
                    view.displayMessage("Exiting...");
                    return;
                default:
                    view.displayError("Invalid choice. Please try again.");
            }
        }
    }
}
