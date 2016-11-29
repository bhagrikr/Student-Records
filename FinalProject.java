package finalproject;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class FinalProject extends Application {

    private ArrayList<String> employeeList = new ArrayList(100);

    Label employeeID = new Label("EmployeeID");
    Label name = new Label("Name");
    Label city = new Label("City");
    Label address = new Label("Address");
    Label pay = new Label("Pay");
    Label gender = new Label("Gender");

    TextField employeID = new TextField();
    TextField nme = new TextField();
    TextField cty = new TextField();
    TextField adress = new TextField();
    TextField payy = new TextField();
    TextField gnder = new TextField();
    TextField[] txt = {nme, cty, adress, payy, gnder};

    Button first = new Button("First");

    Button last = new Button("Last");
    Button next = new Button("Next");
    Button previous = new Button("Previous");
    Button add = new Button("Add");
    Button update = new Button("Update");
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete");
    Button searchButton = new Button("Search");
    Button edit = new Button("Edit");

    //Stage s = new Stage();
    @Override
    public void start(Stage primaryStage) {
        //first.setId("first"

        File fCustomer = new File("Records.txt");
        if (fCustomer.exists()) {
            try {
                if (fCustomer.length() > 0) {
                    FileReader one = new FileReader("Records.txt");
                    BufferedReader two = new BufferedReader(one);
                    String line = two.readLine();
                    while (line != null) {
                        employeeList.add(line);
                        line = two.readLine();
                    }
                    employeID.setEditable(false);
                    String firstRecord = employeeList.get(0);
                    String[] firstRecords = firstRecord.split(",");

                    employeID.setText(firstRecords[0]);
                    nme.setText(firstRecords[1]);
                    cty.setText(firstRecords[2]);
                    adress.setText(firstRecords[3]);
                    payy.setText(firstRecords[4]);
                    gnder.setText(firstRecords[5]);
                    for (int i = 0; i < txt.length; i++) {
                        txt[i].setEditable(false);
                    }

                    first.setMinWidth(50);
                    last.setMinWidth(50);
                    previous.setMinWidth(50);
                    next.setMinWidth(50);
                    edit.setMinWidth(50);
                    update.setMinWidth(50);
                    add.setMinWidth(50);
                    delete.setMinWidth(50);
                    searchButton.setMinWidth(50);

                } else {
                    JOptionPane.showMessageDialog(null, "File is Empty", "Error Message", JOptionPane.INFORMATION_MESSAGE);
                    first.setDisable(true);
                    last.setDisable(true);
                    previous.setDisable(true);
                    next.setDisable(true);
                    delete.setDisable(true);
                    edit.setDisable(true);
                    searchButton.setDisable(true);
                    add.setDisable(true);
                    update.setDisable(true);
                    cancel.setDisable(true);
                    for (int i = 0; i < txt.length; i++) {
                        txt[i].setEditable(false);

                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println(e);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        update.setDisable(true);

        //employeID.setDisable(true);
        employeeID.relocate(0, 60);
        name.relocate(0, 90);
        address.relocate(0, 120);
        city.relocate(0, 150);
        pay.relocate(0, 180);
        gender.relocate(0, 210);

        employeID.relocate(100, 60);
        nme.relocate(100, 90);
        cty.relocate(100, 120);
        adress.relocate(100, 150);
        payy.relocate(100, 180);
        gnder.relocate(100, 210);

        add.relocate(0, 250);
        delete.relocate(60, 250);

        update.relocate(125, 250);
        cancel.relocate(320, 250);

        edit.relocate(190, 250);

        searchButton.relocate(255, 250);

        last.setOnAction(e -> {
            lastButton();
        });

        first.setOnAction(e -> {
            firstButton();
        });

        next.setOnAction(e -> {
            nextButton();
        });

        previous.setOnAction(e -> {
            previousButton();
        });

        add.setOnAction(e -> {
            first.setDisable(true);
            last.setDisable(true);
            previous.setDisable(true);
            next.setDisable(true);
            delete.setDisable(true);
            edit.setDisable(true);
            searchButton.setDisable(true);
            //.setDisable(true);
            update.setDisable(false);
            for (int i = 0; i < txt.length; i++) {
                txt[i].setEditable(true);
            }
            addButton();

        });

        update.setOnAction(e -> {
            updateButton();
            /*update.setDisable(true);
            for (int i = 0; i < txt.length; i++) {
                txt[i].setEditable(false);
            }*/

        });

        cancel.setOnAction(e -> {
            cancelButton();
           
            
        });

        delete.setOnAction(e -> {
            deleteButton();
        });

        searchButton.setOnAction(e
                -> {
            showStage("Search Records");
        }
        );

        edit.setOnAction(e
                -> {
            first.setDisable(true);
            last.setDisable(true);
            previous.setDisable(true);
            next.setDisable(true);
            delete.setDisable(true);
            // edit.setDisable(true);
            searchButton.setDisable(true);
            //cancel.setDisable(true);
            add.setDisable(true);
            nme.requestFocus();
            for (int i = 0; i < txt.length; i++) {
                txt[i].setEditable(true);
                update.setDisable(false);
                check = 2;

            }
        });

        HBox buttons = new HBox(first, last, next, previous);
        buttons.setId("buttons");

        Pane pane = new Pane();
        pane.setId("pane");
        pane.getChildren().addAll(employeeID, name, city, address, pay, gender, employeID,
                nme, cty, adress, payy, gnder, buttons, add, delete, update, cancel, searchButton, edit);

        buttons.setSpacing(10);

        Scene scene = new Scene(pane, 500, 500);
        scene.getStylesheets().add("finalproject/finalcss.css");
        primaryStage.setScene(scene);

        primaryStage.setTitle("Final Project");
        primaryStage.show();

    }
    int counter = 0;
    int check = 0;
    int search = 0;

    public void firstButton() {
        if (employeeList.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Empty List", "Error Message", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String firstRecord = employeeList.get(0);
            String[] firstRecords = firstRecord.split(",");
            employeID.setText(firstRecords[0]);
            nme.setText(firstRecords[1]);
            cty.setText(firstRecords[2]);
            adress.setText(firstRecords[3]);
            payy.setText(firstRecords[4]);
            gnder.setText(firstRecords[5]);
            counter = 0; //not chanange this
        }
    }

    public void lastButton() {
        if (employeeList.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Empty List", "Error Message", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String lastRecord = employeeList.get(employeeList.size() - 1);
            String[] lastRecords = lastRecord.split(",");
            employeID.setText(lastRecords[0]);
            nme.setText(lastRecords[1]);
            cty.setText(lastRecords[2]);
            adress.setText(lastRecords[3]);
            payy.setText(lastRecords[4]);
            gnder.setText(lastRecords[5]);
            counter = employeeList.size() - 1;
        }
    }

    public void nextButton() {

        counter++;

        try {
            if (counter >= employeeList.size() && !employeeList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "This is the last racord,"
                        + " cannot go further", "Error Message", JOptionPane.INFORMATION_MESSAGE);
                counter--;
                throw new ArrayIndexOutOfBoundsException("");

            } else if (employeeList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Empty List", "Error Message", JOptionPane.INFORMATION_MESSAGE);
            } else {

                String firstRecord = employeeList.get(counter);
                String[] firstRecords = firstRecord.split(",");
                employeID.setText(firstRecords[0]);
                nme.setText(firstRecords[1]);
                cty.setText(firstRecords[2]);
                adress.setText(firstRecords[3]);
                payy.setText(firstRecords[4]);
                gnder.setText(firstRecords[5]);
            }

        } catch (ArrayIndexOutOfBoundsException e) {

        }

    }

    public void previousButton() {
        try {
            counter--;
            if (counter < 0 && !employeeList.isEmpty()) {
                counter = 0;
                JOptionPane.showMessageDialog(null, "This is the first record,"
                        + " cannot go back one record", "Error Message", JOptionPane.INFORMATION_MESSAGE);
                throw new ArrayIndexOutOfBoundsException("less records");
            } else if (employeeList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Empty List", "Error Message", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String firstRecord = employeeList.get(counter);
                String[] firstRecords = firstRecord.split(",");
                employeID.setText(firstRecords[0]);
                nme.setText(firstRecords[1]);
                cty.setText(firstRecords[2]);
                adress.setText(firstRecords[3]);
                payy.setText(firstRecords[4]);
                gnder.setText(firstRecords[5]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

    public void addButton() {

        check = 1;
        String value = employeeList.get(employeeList.size() - 1);
        String[] values = value.split(",");
        String autoId = "" + (Integer.parseInt(values[0]) + 1);
        employeID.setText(autoId);
        nme.setText("");
        cty.setText("");
        adress.setText("");
        payy.setText("");
        gnder.setText("");
        nme.requestFocus();

        /*employeID.setOnKeyReleased(e -> {
            if (isNumeric(e.getCode())) {

            } else {
                employeID.selectBackward();
                JOptionPane.showMessageDialog(null, "Number is Required",
                        "Error Message", JOptionPane.INFORMATION_MESSAGE);
                //employeID.clear();
            }

        });*/

        payy.setOnKeyReleased(e -> {
            if (isNumeric(e.getCode())) {

            } else {
                payy.selectBackward();
                JOptionPane.showMessageDialog(null, "Number is Required",
                        "Error Message", JOptionPane.INFORMATION_MESSAGE);
                //payy.clear();
            }

        });

        gnder.setOnKeyReleased(e -> {
            if (!isAlphabetic(e.getCode())) {
                gnder.selectBackward();
                JOptionPane.showMessageDialog(null, "Letters are Required",
                        "Error Message", JOptionPane.INFORMATION_MESSAGE);
                //gnder.clear();
            } else {

            }
        });

        nme.setOnKeyReleased(e
                -> {
            if (!isAlphabetic(e.getCode())) {
                nme.selectBackward();
                JOptionPane.showMessageDialog(null, "Letters are Required",
                        "Error Message", JOptionPane.INFORMATION_MESSAGE);
                //gnder.clear();
            } else {

            }
        });
    }

    public void updateButton() {
        // incomplete

        if (check == 1) {
            try {
                if ((employeID.getText().length() > 0) && (nme.getText().length() > 0)
                        && (cty.getText().length() > 0) && (adress.getText().length() > 0)
                        && (payy.getText().length() > 0)
                        && ((gnder.getText().length() > 0))) {

                    String textField1 = employeID.getText();
                    String textField2 = nme.getText();
                    String textField3 = cty.getText();
                    String textField4 = adress.getText();
                    String textField5 = payy.getText();
                    String textField6 = gnder.getText();
                    String allTextFields = textField1 + "," + textField2 + ","
                            + textField3 + "," + textField4 + "," + textField5 + "," + textField6;
                    employeeList.add(allTextFields);

                    FileWriter one = new FileWriter("Records.txt");
                    BufferedWriter buff = new BufferedWriter(one);

                    for (int sub = 0; sub < employeeList.size(); sub++) {
                        buff.write(employeeList.get(sub) + '\n');
                    }

                    buff.close();
                    counter = employeeList.size() - 1;

                    String firstRecord = employeeList.get(counter);
                    String[] firstRecords = firstRecord.split(",");
                    employeID.setText(firstRecords[0]);
                    nme.setText(firstRecords[1]);
                    cty.setText(firstRecords[2]);
                    adress.setText(firstRecords[3]);
                    payy.setText(firstRecords[4]);
                    gnder.setText(firstRecords[5]);

                    JOptionPane.showMessageDialog(null, "Record added Successfully",
                            "Message", JOptionPane.INFORMATION_MESSAGE);
                    //counter++;
                    update.setDisable(true);
                    for (int i = 0; i < txt.length; i++) {
                        txt[i].setEditable(false);

                    }
                    first.setDisable(false);
                    last.setDisable(false);
                    previous.setDisable(false);
                    next.setDisable(false);
                    delete.setDisable(false);
                    edit.setDisable(false);
                    searchButton.setDisable(false);
                    //update.setDisable(true);

                } else if ((nme.getText().length() == 0)
                        && (cty.getText().length() == 0) && (adress.getText().length() == 0)
                        && (payy.getText().length() == 0)
                        && ((gnder.getText().length() == 0))) {
                    update.setDisable(false);
                    for (int i = 0; i < txt.length; i++) {
                        txt[i].setEditable(true);

                    }

                    JOptionPane.showMessageDialog(null, "Fill all the records",
                            "Error Message", JOptionPane.INFORMATION_MESSAGE);
                    nme.requestFocus();

                }

            } catch (IOException e) {

            }

        } else if (check == 2) {
            try {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Look, a Confirmation Dialog");
                alert.setContentText("Are you sure, you want to change the record?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    editAndSave(counter);
                    FileWriter one = new FileWriter("Records.txt");
                    BufferedWriter buff = new BufferedWriter(one);
                    for (int sub = 0; sub < employeeList.size(); sub++) {
                        buff.write(employeeList.get(sub) + '\n');
                    }

                    buff.close();
                    first.setDisable(false);
                    last.setDisable(false);
                    previous.setDisable(false);
                    next.setDisable(false);
                    delete.setDisable(false);
                    add.setDisable(false);
                    searchButton.setDisable(false);
                    update.setDisable(true);
                    cancel.setDisable(false);
                    for (int i = 0; i < txt.length; i++) {
                        txt[i].setEditable(false);

                    }

                    //cancel.setDisable(false);
                } else {
                    first.setDisable(false);
                    last.setDisable(false);
                    previous.setDisable(false);
                    next.setDisable(false);
                    delete.setDisable(false);
                    edit.setDisable(false);
                    searchButton.setDisable(false);
                    add.setDisable(false);
                    update.setDisable(true);
                    cancel.setDisable(true);

                }

            } catch (IOException e) {

            } catch (ArrayIndexOutOfBoundsException e) {

            }

        }
    }

    public void cancelButton() {

        if (check == 1 || check == 2) {
            String firstRecord = employeeList.get(counter);
            String[] firstRecords = firstRecord.split(",");
            employeID.setText(firstRecords[0]);
            nme.setText(firstRecords[1]);
            cty.setText(firstRecords[2]);
            adress.setText(firstRecords[3]);
            payy.setText(firstRecords[4]);
            gnder.setText(firstRecords[5]);
            first.setDisable(false);
            last.setDisable(false);
            previous.setDisable(false);
            next.setDisable(false);
            delete.setDisable(false);
            edit.setDisable(false);
            searchButton.setDisable(false);
            update.setDisable(true);
            add.setDisable(false);
        } else {

        }
    }

    private boolean isNumeric(KeyCode code) {
        switch (code) {
            case DIGIT0:
            case DIGIT1:
            case DIGIT2:
            case DIGIT3:
            case DIGIT4:
            case DIGIT5:
            case DIGIT6:
            case DIGIT7:
            case DIGIT8:
            case DIGIT9:
            case NUMPAD0:
            case BACK_SPACE:
            case ENTER:
            case CAPS:
            case TAB:
            case PERIOD:
            case SPACE:

                return true;
        }

        return false;
    }

    private boolean isAlphabetic(KeyCode code1) {
        switch (code1) {
            case DIGIT0:
            case DIGIT1:
            case DIGIT2:
            case DIGIT3:
            case DIGIT4:
            case DIGIT5:
            case DIGIT6:
            case DIGIT7:
            case DIGIT8:
            case DIGIT9:
            case NUMPAD0:

                return false;
        }

        return true;
    }

    public void deleteButton() {
        try {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Look, a Confirmation Dialog");
            alert.setContentText("Are you sure, you want to delete the record?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {

                if (counter == employeeList.size() - 1) {

                    if (counter == 0) {
                        employeeList.remove(employeeList.get(counter));
                        employeID.setText("");
                        nme.setText("");
                        cty.setText("");
                        adress.setText("");
                        payy.setText("");
                        gnder.setText("");
                        employeID.requestFocus();

                    } else {
                        String firstRecord = employeeList.get(counter - 1);
                        String[] firstRecords = firstRecord.split(",");
                        employeID.setText(firstRecords[0]);
                        nme.setText(firstRecords[1]);
                        cty.setText(firstRecords[2]);
                        adress.setText(firstRecords[3]);
                        payy.setText(firstRecords[4]);
                        gnder.setText(firstRecords[5]);
                        employeeList.remove(employeeList.get(counter));
                        counter--;
                    }

                } else if (employeeList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "List is Empty. Click on add button to add records",
                            "Error Message", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    employeeList.remove(employeeList.get(counter));
                    //counter++;
                    String firstRecord = employeeList.get(counter);
                    String[] firstRecords = firstRecord.split(",");
                    employeID.setText(firstRecords[0]);
                    nme.setText(firstRecords[1]);
                    cty.setText(firstRecords[2]);
                    adress.setText(firstRecords[3]);
                    payy.setText(firstRecords[4]);
                    gnder.setText(firstRecords[5]);
                }

                FileWriter one = new FileWriter("Records.txt");
                BufferedWriter buff = new BufferedWriter(one);
                for (int sub = 0; sub < employeeList.size(); sub++) {
                    buff.write(employeeList.get(sub) + '\n');
                }

                buff.close();

            } else {
                String firstRecord = employeeList.get(counter);
                String[] firstRecords = firstRecord.split(",");
                employeID.setText(firstRecords[0]);
                nme.setText(firstRecords[1]);
                cty.setText(firstRecords[2]);
                adress.setText(firstRecords[3]);
                payy.setText(firstRecords[4]);
                gnder.setText(firstRecords[5]);
            }
        } catch (IOException e) {

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("last record");

        }

    }

    public void showStage(String title) {

        Stage searchStage = new Stage();
        Pane searchPane = new Pane();
        searchPane.setId("searchPane");

        ToggleButton srchButton = new ToggleButton("Search");
        ToggleGroup group = new ToggleGroup();

        Label searchEmployeeID = new Label("EmployeeID");
        Label searchName = new Label("Name");
        Label searchCity = new Label("City");
        Label searchAddress = new Label("Address");
        Label searchPay = new Label("Pay");
        Label searchGender = new Label("Gender");
        Label header = new Label("");
        header.setVisible(false);

        Label stuName = new Label("");
        stuName.setId("stuName");
        stuName.setVisible(false);

        TextField searchEmployeID = new TextField();
        TextField searchNme = new TextField();
        TextField searchCty = new TextField();
        TextField searchAdress = new TextField();
        TextField searchPayy = new TextField();
        TextField searchGnder = new TextField();
        TextField srchFor = new TextField();

        GridPane grdPane = new GridPane();
        grdPane.setId("grdPane");
        //grdPane.getStyleClass().add("grdPane");
        ColumnConstraints clm1 = new ColumnConstraints();
        ColumnConstraints clm2 = new ColumnConstraints();
        clm1.setPercentWidth(40);
        clm2.setPercentWidth(60);
        grdPane.setVgap(5);
        grdPane.getColumnConstraints().addAll(clm1, clm2);
        grdPane.add(searchEmployeeID, 0, 0);
        grdPane.add(searchName, 0, 1);
        grdPane.add(searchAddress, 0, 2);
        grdPane.add(searchCity, 0, 3);
        grdPane.add(searchPay, 0, 4);
        grdPane.add(searchGender, 0, 5);

        grdPane.add(searchEmployeID, 1, 0);
        grdPane.add(searchNme, 1, 1);
        grdPane.add(searchAdress, 1, 2);
        grdPane.add(searchCty, 1, 3);
        grdPane.add(searchPayy, 1, 4);
        grdPane.add(searchGnder, 1, 5);

        grdPane.relocate(0, 150);

        searchEmployeID.setDisable(true);
        searchNme.setDisable(true);
        searchCty.setDisable(true);
        searchAdress.setDisable(true);
        searchPayy.setDisable(true);
        searchGnder.setDisable(true);

        Label searchLabel = new Label("Search By:");
        //TextArea namesOfStud = new TextArea();
        Label searchFor = new Label("Search for record by selected Field");
        RadioButton radioEmployeeID = new RadioButton("EmployeeID");
        RadioButton radioName = new RadioButton("Name");
        RadioButton radioAddress = new RadioButton("Address");
        RadioButton radioCity = new RadioButton("City");
        RadioButton radioPay = new RadioButton("Pay");
        RadioButton radioGender = new RadioButton("Gender");
        Button srrchFor = new Button("Search"); // Button in second stage

        radioEmployeeID.relocate(80, 0);
        radioName.relocate(80, 20);
        radioAddress.relocate(80, 40);
        radioCity.relocate(80, 60);
        radioPay.relocate(80, 80);
        radioGender.relocate(80, 100);
        searchLabel.relocate(0, 0);
        searchFor.relocate(200, 0);
        srchFor.relocate(220, 30);
        srrchFor.relocate(220, 60);
        header.relocate(10, 200);
        stuName.relocate(10, 220);

        radioEmployeeID.setToggleGroup(group);
        radioName.setToggleGroup(group);
        radioAddress.setToggleGroup(group);
        radioCity.setToggleGroup(group);
        radioPay.setToggleGroup(group);
        radioGender.setToggleGroup(group);

        searchPane.getChildren().addAll(radioEmployeeID,
                radioName, radioAddress, radioCity, radioPay, radioGender, searchLabel,
                searchFor, srchFor, srrchFor, grdPane, header, stuName
        );

        Scene scene = new Scene(searchPane, 500, 500);
        scene.getStylesheets().add("finalproject/finalcss.css");
        searchStage.setScene(scene);

        searchStage.setTitle(title);
        searchStage.show();
        srrchFor.setOnAction(e
                -> {
            searchEmployeID.setText("");
            searchNme.setText("");
            searchAdress.setText("");
            searchCty.setText("");
            searchPayy.setText("");
            searchGnder.setText("");
            if (radioEmployeeID.isSelected()) {
                header.setVisible(false);
                stuName.setVisible(false);
                grdPane.setVisible(true);
                String s = srchFor.getText();

                for (int dex = 0; dex < employeeList.size(); dex++) {
                    String[] firstRecords = employeeList.get(dex).split(",");
                    String sIp = firstRecords[0];
                    //System.out.println(sIp);
                    if (s.equals(sIp)) {
                        searchEmployeID.setText(sIp);
                        searchNme.setText(firstRecords[1]);
                        searchAdress.setText(firstRecords[2]);
                        searchCty.setText(firstRecords[3]);
                        searchPayy.setText(firstRecords[4]);
                        searchGnder.setText(firstRecords[5]);
                        srchFor.requestFocus();
                    }
                }

                if (searchEmployeID.getText().isEmpty() && searchNme.getText().
                        isEmpty() && searchPayy.getText().isEmpty()
                        && searchAdress.getText().isEmpty() && searchGnder.getText().isEmpty()
                        && searchCty.getText().isEmpty() && s.length() != 0) {
                    JOptionPane.showMessageDialog(null, "Match Not Found",
                            "Error Message", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //System.out.println("bhagruia");
                }

                if (s.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Enter somethimg for search",
                            "Error Message", JOptionPane.INFORMATION_MESSAGE);
                    searchEmployeID.setText("");
                    searchNme.setText("");
                    searchAdress.setText("");
                    searchCty.setText("");
                    searchPayy.setText("");
                    searchGnder.setText("");
                    srchFor.requestFocus();

                }

            } else if (radioName.isSelected()) {

                header.setVisible(false);
                stuName.setVisible(false);
                grdPane.setVisible(true);
                String s = srchFor.getText();

                for (int dex = 0; dex < employeeList.size(); dex++) {
                    String[] firstRecords = employeeList.get(dex).split(",");
                    String sIp = firstRecords[1];
                    //System.out.println(sIp);
                    if (s.equalsIgnoreCase(sIp)) {
                        searchEmployeID.setText(firstRecords[0]);
                        searchNme.setText(firstRecords[1]);
                        searchAdress.setText(firstRecords[2]);
                        searchCty.setText(firstRecords[3]);
                        searchPayy.setText(firstRecords[4]);
                        searchGnder.setText(firstRecords[5]);
                        srchFor.requestFocus();
                    }
                }

                if (searchEmployeID.getText().isEmpty() && searchNme.getText().
                        isEmpty() && searchPayy.getText().isEmpty()
                        && searchAdress.getText().isEmpty() && searchGnder.getText().isEmpty()
                        && searchCty.getText().isEmpty() && s.length() != 0) {
                    JOptionPane.showMessageDialog(null, "Match Not Found",
                            "Error Message", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    //System.out.println("bhagruia");
                }

                if (s.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Enter somethimg for search",
                            "Error Message", JOptionPane.INFORMATION_MESSAGE);
                    searchEmployeID.setText("");
                    searchNme.setText("");
                    searchAdress.setText("");
                    searchCty.setText("");
                    searchPayy.setText("");
                    searchGnder.setText("");
                    srchFor.requestFocus();

                }

            } else if (radioCity.isSelected()) {
                grdPane.setVisible(false);
                header.setVisible(true);
                stuName.setVisible(true);

                String s = srchFor.getText();

                String names = "";

                for (int dex = 0; dex < employeeList.size(); dex++) {
                    String[] firstRecords = employeeList.get(dex).split(",");
                    String sIp = firstRecords[3];

                    if (s.equalsIgnoreCase(sIp)) {
                        names = names + firstRecords[1] + "\n";
                        stuName.setText(names);

                    }
                }

                if (names.length() > 0) {
                    header.setText("Students living in " + s + " is/are");
                } else {

                }
                if (srchFor.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter somethimg for search",
                            "Error Message", JOptionPane.INFORMATION_MESSAGE);
                } else if (names.length() == 0) {
                    JOptionPane.showMessageDialog(null, "No match Found",
                            "Error Message", JOptionPane.INFORMATION_MESSAGE);
                    header.setText("Students living in " + s + " is/are 0");

                    stuName.setText("");
                } else {

                }

            } else if (radioAddress.isSelected()) {
                header.setVisible(false);
                stuName.setVisible(false);
                grdPane.setVisible(true);
                String s = srchFor.getText();

                for (int dex = 0; dex < employeeList.size(); dex++) {
                    String[] firstRecords = employeeList.get(dex).split(",");
                    String sIp = firstRecords[2];
                    //System.out.println(sIp);
                    if (s.equalsIgnoreCase(sIp)) {
                        searchEmployeID.setText(firstRecords[0]);
                        searchNme.setText(firstRecords[1]);
                        searchAdress.setText(firstRecords[2]);
                        searchCty.setText(firstRecords[3]);
                        searchPayy.setText(firstRecords[4]);
                        searchGnder.setText(firstRecords[5]);
                        srchFor.requestFocus();
                    }
                }

                if (searchEmployeID.getText().isEmpty() && searchNme.getText().
                        isEmpty() && searchPayy.getText().isEmpty()
                        && searchAdress.getText().isEmpty() && searchGnder.getText().isEmpty()
                        && searchCty.getText().isEmpty() && s.length() != 0) {
                    JOptionPane.showMessageDialog(null, "Match Not Found",
                            "Error Message", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //System.out.println("bhagruia");
                }

                if (s.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Enter somethimg for search",
                            "Error Message", JOptionPane.INFORMATION_MESSAGE);
                    searchEmployeID.setText("");
                    searchNme.setText("");
                    searchAdress.setText("");
                    searchCty.setText("");
                    searchPayy.setText("");
                    searchGnder.setText("");
                    srchFor.requestFocus();

                }

            } else if (radioPay.isSelected()) {
                grdPane.setVisible(false);
                header.setVisible(true);
                stuName.setVisible(true);

                String s = srchFor.getText();

                String names = "";

                for (int dex = 0; dex < employeeList.size(); dex++) {
                    String[] firstRecords = employeeList.get(dex).split(",");
                    String sIp = firstRecords[4];

                    if (s.equalsIgnoreCase(sIp)) {
                        names = names + firstRecords[1] + "\n";
                        stuName.setText(names);

                    }
                }

                if (names.length() > 0) {
                    header.setText("Students having pay  " + s + " is/are:");
                } else {

                }

                if (srchFor.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter somethimg for search",
                            "Error Message", JOptionPane.INFORMATION_MESSAGE);
                } else if (names.length() == 0) {
                    JOptionPane.showMessageDialog(null, "No match Found",
                            "Error Message", JOptionPane.INFORMATION_MESSAGE);
                    stuName.setText("");
                    header.setText("Students having pay " + s + " is/are 0");
                } else {

                }

            } else if (radioGender.isSelected()) {
                grdPane.setVisible(false);
                header.setVisible(true);
                stuName.setVisible(true);

                String s = srchFor.getText();

                String names = "";

                for (int dex = 0; dex < employeeList.size(); dex++) {
                    String[] firstRecords = employeeList.get(dex).split(",");
                    String sIp = firstRecords[5];

                    if (s.equalsIgnoreCase(sIp)) {
                        names = names + firstRecords[1] + "\n";
                        stuName.setText(names);

                    }
                }

                if (names.length() > 0) {
                    header.setText("Students who is/are " + s + " is/are");
                } else {

                }

                if (srchFor.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter somethimg for search",
                            "Error Message", JOptionPane.INFORMATION_MESSAGE);
                } else if (names.length() == 0) {
                    JOptionPane.showMessageDialog(null, "No match Found",
                            "Error Message", JOptionPane.INFORMATION_MESSAGE);
                    stuName.setText("");
                    header.setText("Students who is/are " + s + " is/are 0");
                } else {

                }

            } else {
                JOptionPane.showMessageDialog(null, "Nothing Selected",
                        "Error Message", JOptionPane.INFORMATION_MESSAGE);
            }

        });

    }

    public void editAndSave(int one) {
        //employeeList.remove(one);
        if (((nme.getText().length() > 0)
                && (cty.getText().length() > 0) && (adress.getText().length() > 0)
                && (payy.getText().length() > 0)
                && ((gnder.getText().length() > 0)))) {
            employeeList.remove(one);
            String textField1 = employeID.getText();
            String textField2 = nme.getText();
            String textField3 = cty.getText();
            String textField4 = adress.getText();
            String textField5 = payy.getText();
            String textField6 = gnder.getText();
            String allTextFields = textField1 + "," + textField2 + ","
                    + textField3 + "," + textField4 + "," + textField5 + "," + textField6;
            employeeList.add(one, allTextFields);
        } else if ((nme.getText().length() == 0)
                && (cty.getText().length() == 0) && (adress.getText().length() == 0)
                && (payy.getText().length() == 0)
                && ((gnder.getText().length() == 0))) {
            update.setDisable(false);
            for (int i = 0; i < txt.length; i++) {
                txt[i].setEditable(true);

            }

            JOptionPane.showMessageDialog(null, "Fill all the records",
                    "Error Message", JOptionPane.INFORMATION_MESSAGE);
            nme.requestFocus();

        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
