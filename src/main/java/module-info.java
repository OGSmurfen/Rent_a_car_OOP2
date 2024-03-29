module com.papasmurfie.rent_a_car_oop2 {

    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires postgresql;
    requires org.apache.logging.log4j;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.persistence;


    opens com.papasmurfie.rent_a_car_oop2 to javafx.fxml, org.hibernate.commons.annotations;
    exports com.papasmurfie.rent_a_car_oop2;
    exports com.papasmurfie.rent_a_car_oop2.controllers;
    opens com.papasmurfie.rent_a_car_oop2.controllers to javafx.fxml;
    opens com.papasmurfie.rent_a_car_oop2.entity;
    exports com.papasmurfie.rent_a_car_oop2.controllers.admin;
    opens com.papasmurfie.rent_a_car_oop2.controllers.admin to javafx.fxml;
    exports com.papasmurfie.rent_a_car_oop2.controllers.login;
    opens com.papasmurfie.rent_a_car_oop2.controllers.login to javafx.fxml;

    exports com.papasmurfie.rent_a_car_oop2.controllers.operator;
    opens com.papasmurfie.rent_a_car_oop2.controllers.operator to javafx.fxml;

    exports com.papasmurfie.rent_a_car_oop2.controllers.admin.company;
    opens com.papasmurfie.rent_a_car_oop2.controllers.admin.company to javafx.fxml;
    exports com.papasmurfie.rent_a_car_oop2.controllers.admin.operators;
    opens com.papasmurfie.rent_a_car_oop2.controllers.admin.operators to javafx.fxml;
    exports com.papasmurfie.rent_a_car_oop2.controllers.operator.clients;
    opens com.papasmurfie.rent_a_car_oop2.controllers.operator.clients to javafx.fxml;
    exports com.papasmurfie.rent_a_car_oop2.controllers.operator.cars;
    opens com.papasmurfie.rent_a_car_oop2.controllers.operator.cars to javafx.fxml;
    exports com.papasmurfie.rent_a_car_oop2.controllers.operator.rents;
    opens com.papasmurfie.rent_a_car_oop2.controllers.operator.rents to javafx.fxml;


}