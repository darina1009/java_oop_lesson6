package com.example.presenter;

import com.example.model.FamilyTree;
import com.example.model.Person;
import com.example.service.FileService;
import com.example.view.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private FamilyTree<Person> familyTree;
    private FileService fileService;

    public Presenter(View view, FamilyTree<Person> familyTree, FileService fileService) {
        this.view = view;
        this.familyTree = familyTree;
        this.fileService = fileService;
    }

    public void loadData(String filePath) {
        List<Person> people = fileService.loadFromFile(filePath);
        if (people != null) {
            familyTree.getPeople().addAll(people);
            view.displayPeople(people);
        } else {
            view.displayError("Failed to load data");
        }
    }

    public void saveData(String filePath) {
        fileService.saveToFile(familyTree.getPeople(), filePath);
    }

    public void sortByName() {
        familyTree.sortByName();
        view.displayPeople(familyTree.getPeople());
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
        view.displayPeople(familyTree.getPeople());
    }

    public void addPerson() {
        String name = view.getInput("Enter name");
        String surname = view.getInput("Enter surname");
        LocalDate birthDate = LocalDate.parse(view.getInput("Enter birth date (YYYY-MM-DD)"));

        Person person = new Person(name, surname, birthDate);
        familyTree.addPerson(person);
        view.displayMessage("Person added successfully");
    }

    public void createFamilyRelation() {
        String parentName = view.getInput("Enter parent's name");
        String childName = view.getInput("Enter child's name");

        Person parent = findPersonByName(parentName);
        Person child = findPersonByName(childName);

        if (parent != null && child != null) {
            parent.addChild(child);
            view.displayMessage("Family relation created successfully");
        } else {
            view.displayError("Person not found");
        }
    }

    private Person findPersonByName(String name) {
        for (Person person : familyTree.getPeople()) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }

    public void displayPeople() {
        view.displayPeople(familyTree.getPeople());
    }
}
