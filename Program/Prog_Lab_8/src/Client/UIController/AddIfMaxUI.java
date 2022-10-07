package Client.UIController;

import Client.Client;
import Collection.Address;
import Collection.Coordinates;
import Collection.Organization;
import Collection.OrganizationType;
import Exceptions.AbstractException;
import Exceptions.NoSuchTypeException;
import Exceptions.NullValueException;
import Exceptions.ValueOutOfRangeException;
import Tools.Tools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class AddIfMaxUI implements Initializable {

    @FXML
    private TextField streetField;

    @FXML
    private TextField xField;

    @FXML
    private Button clearButton;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField yField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField employeesCountField;

    @FXML
    private ChoiceBox<String> typeSelect;

    @FXML
    private TextField annualTurnOverField;

    @FXML
    private TextField zipCodeField;

    @FXML
    private Label errorMessage;

    @FXML
    private Button confirmButton;

    @FXML
    void confirm(ActionEvent event) {
        Organization organization = new Organization();
        try {
            String[] commandWithArgs = new String[]{"add"};

            organization.setOwner(Client.clientInformation.getUserName());
            organization.setName(nameField.getText());

            String x = xField.getText();
            String y = yField.getText();
            try {
                Coordinates coordinates = new Coordinates(x,y);
                organization.setCoordinates(coordinates);
            } catch (NumberFormatException e) {
                throw new ValueOutOfRangeException("Error: Coordinates format error!");
            }

            String annualTurnoverText = annualTurnOverField.getText();
            if (annualTurnoverText == null || annualTurnoverText.equals("")) {
                throw new NullValueException("Error: AnnualTurnover can not be empty!");
            } else {
                try {
                    Long annualTurnover = Long.valueOf(annualTurnoverText);
                    organization.setAnnualTurnover(annualTurnover);
                } catch (NumberFormatException e) {
                    throw new ValueOutOfRangeException("Error: AnnualTurnover format error!");
                }
            }
            organization.setFullName(fullNameField.getText());

            String employeesCountText = employeesCountField.getText();
            if (employeesCountText == null || employeesCountText.equals("")) {
                throw new NullValueException("Error: Employees Count can not be empty!");
            } else {
                try {
                    Long employeesCount = Long.valueOf(annualTurnoverText);
                    organization.setEmployeesCount(employeesCount);
                } catch (NumberFormatException e) {
                    throw new ValueOutOfRangeException("Error: Employees Count format error!");
                }
            }

            String type = typeSelect.getValue();
            switch (type) {
                case "Choose a type": {
                    organization.setType(OrganizationType.NULL);
                    break;
                }
                case "Public": {
                    organization.setType(OrganizationType.PUBLIC);
                    break;
                }
                case "Private Limit": {
                    organization.setType(OrganizationType.PRIVATE_LIMIT_COMPANY);
                    break;
                }
                case "Commercial": {
                    organization.setType(OrganizationType.COMMERCIAL);
                    break;
                }
                case "Trust": {
                    organization.setType(OrganizationType.TRUST);
                    break;
                }
                default: {
                    throw new NoSuchTypeException("Error: Type input error");
                }
            }

            String street = streetField.getText();
            String zipCode = zipCodeField.getText();
            Address address = new Address(street,zipCode);
            organization.setPostalAddress(address);

            organization.setCreationDate(new Date());

            Tools.handleCommand(commandWithArgs, organization);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.hide();
        } catch (AbstractException e) {
            errorMessage.setText(e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.toString());
            alert.showAndWait();
        }
    }

    @FXML
    void clear(ActionEvent event) {
        nameField.clear();
        xField.clear();
        yField.clear();
        annualTurnOverField.clear();
        fullNameField.clear();
        employeesCountField.clear();
        typeSelect.setValue("Choose a type");
        streetField.clear();
        zipCodeField.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //typeSelect = new ChoiceBox<>();
        typeSelect.getItems().addAll("Choose a type","Public","Private Limit","Trust","Commercial");
        typeSelect.setValue("Choose a type");
    }
}
