package com.papasmurfie.rent_a_car_oop2.controllers.operator.rents;

import com.papasmurfie.rent_a_car_oop2.controllers.operator.cars.CarController;
import com.papasmurfie.rent_a_car_oop2.entity.*;
import com.papasmurfie.rent_a_car_oop2.repository.impl.CarRepositoryImpl;
import com.papasmurfie.rent_a_car_oop2.repository.impl.RentsRepositoryImpl;
import com.papasmurfie.rent_a_car_oop2.service.CarService;
import com.papasmurfie.rent_a_car_oop2.service.RentsService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.stream.Collectors;

public class OperatorRentsTabController {
    public Button DeleteCarButton;
    public Button RentCarButton;
    public TextField insertCarModelTextField;
    public TextField carCharacteristicsTextField;
    public CheckBox smokerCheckButton;
    public TableColumn isRentedColumn;
    public CheckBox availableCarsCheckBox;
    public TableColumn rentedDateColumn;
    public TableColumn returnedDateColumn;
    public TableColumn kmColumn;
    public TableColumn descrTajkeColumn;
    public TableColumn descriptionReturnColumn;
    @FXML
    private ComboBox SelectClassComboBox;
    @FXML
    private ComboBox SelectCategoryComboBox;
    @FXML
    private ComboBox<String> SelectBrandComboBox;
    @FXML
    public TableView<Cars> CarsTableView;
    public TableColumn<Cars, Integer> CarIdColumn;
    public TableColumn<Cars, String> CarBrandColumn;
    public TableColumn<Cars, String> CarModelColumn;
    public TableColumn<Cars, String> CarClassColumn;
    public TableColumn<Cars, String> CarCategoryColumn;
    public TableColumn<Cars, String> CarCharacteristicsColumn;
    public TableColumn<Cars, Boolean> CarSmokerColumn;
    public Button AddCarButton;

// TODO: Populate the other combo boxes.

    private final CarController carController = new CarController(new CarService(new CarRepositoryImpl()), new RentsService(new RentsRepositoryImpl()));
    private final RentController rentController = new RentController(new RentsService(new RentsRepositoryImpl()));
    private ObservableList<Cars> carsDataList;
    private ObservableList<Rents> rentsDataList;
    private ObservableList<CarBrand> carBrandsDataList;

    public void initialize() {
        populateTable();
        //populateComboBoxes();

        CarsTableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) { // Check for a single click

                Cars selectedCar = CarsTableView.getSelectionModel().getSelectedItem();

                if (selectedCar != null) {
                    if(selectedCar.isIsrented()){
                        RentCarButton.setText("Return");
                    }
                    if(!selectedCar.isIsrented()){
                        RentCarButton.setText("Rent");
                    }
                }

                if(selectedCar == null){
                    RentCarButton.setText("Rent/Return");
                }
            }

        });
    }

    private void populateComboBoxes() {
        populateBrandCB();
        populateClassCB();
        populateCategoryCB();
    }

    private void populateCategoryCB() {
        List<CarCategory> carCategories = carController.findAllCategories();
        ObservableList<CarCategory> carCategoryDataList = FXCollections.observableArrayList(carCategories);
        List<String> categoryNames = carCategories.stream()
                .map(CarCategory::getName)
                .collect(Collectors.toList());
        SelectCategoryComboBox.setItems(FXCollections.observableArrayList(categoryNames));
    }

    private void populateClassCB() {
        List<CarClass> carClasses = carController.findAllClasses();
        ObservableList<CarClass> carClassesDataList = FXCollections.observableArrayList(carClasses);

        List<String> classNames = carClasses.stream()
                .map(CarClass::getName)
                .collect(Collectors.toList());
        SelectClassComboBox.setItems(FXCollections.observableArrayList(classNames));
    }

    private void populateBrandCB() {
        List<CarBrand> carBrands = carController.findAllBrands();
        carBrandsDataList = FXCollections.observableArrayList(carBrands);

        List<String> brandNames = carBrands.stream()
                .map(CarBrand::getName)
                .collect(Collectors.toList());
        SelectBrandComboBox.setItems(FXCollections.observableArrayList(brandNames));
    }

    private  void populateTable() {
        List<Cars> carsList = carController.findAll();
        if(carsDataList != null){carsDataList.clear();}
        carsDataList = FXCollections.observableArrayList(carsList);
        CarsTableView.setItems(carsDataList);
        setupColumns();
    }
    private  void populateTable(List<Cars> carsList) {
        //List<Cars> carsList = carController.findAll();
        if(carsDataList != null) {
            carsDataList.clear();
        }
        carsDataList = FXCollections.observableArrayList(carsList);
        CarsTableView.setItems(carsDataList);
        setupColumns();
    }

    private void setupColumns() {
        CarIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        CarBrandColumn.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getCarBrand().getName()));
        CarModelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        CarClassColumn.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getCarClass().getName()));
        CarCategoryColumn.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getCarCategory().getName()));
        CarCharacteristicsColumn.setCellValueFactory(new PropertyValueFactory<>("characteristics"));
        CarSmokerColumn.setCellValueFactory(new PropertyValueFactory<>("smoker"));
        isRentedColumn.setCellValueFactory(new PropertyValueFactory<>("isrented"));
    }

    public void onCarClassCheckboxChecked(ActionEvent actionEvent) {

    }

    public void onCarCategoryCheckboxChecked(ActionEvent actionEvent) {

    }

    public void onCarModelCheckboxChecked(ActionEvent actionEvent) {

    }
}