package Client.UIController;

import Client.Client;
import Client.ClientRun;
import Collection.ObservableOrganization;
import Tools.Tools;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MapUI implements Initializable {

    @FXML
    private Label usernameField;

    @FXML
    private Label usernameLabel;

    @FXML
    private Button exitButton;

    @FXML
    private Button tableButton;

    @FXML
    private Canvas mapCanvas;

    GraphicsContext pen;

    List<ObjectShape> shapes = new ArrayList<>();

    @FXML
    void exit(ActionEvent event) {
        try {
            String[] commandWithArgs = new String[]{"exit"};

            Tools.handleCommand(commandWithArgs, null);
            System.exit(0);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void table(ActionEvent event) {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("Client/FXML/labels",ClientRun.locale);
            Parent root = FXMLLoader.load(getClass().getResource("../FXML/ManagerUI.fxml"),bundle);
            //Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            //stage.hide();
            ClientRun.stage.setScene(new Scene(root,1280,800));
            ClientRun.stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameLabel.setText(usernameLabel.getText() + Client.clientInformation.getUserName());
        pen = mapCanvas.getGraphicsContext2D();

        ManagerUI.organizationList.forEach((ObservableOrganization organization) -> {
            ObjectShape objectShape = new ObjectShape(organization);
            shapes.add(objectShape);
            objectShape.draw();
        });

        mapCanvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                double x = event.getX();
                double y = event.getY();
                Tools.MessageL("Clicked!");
                
                double minDistance = Double.MAX_VALUE;
                ObjectShape selectedObject = null;
                for (ObjectShape objectShape : shapes) {//calculate distances between object and mouse
                    objectShape.distant = Math.pow(objectShape.x - x, 2) + Math.pow(objectShape.y - y, 2);
                    if (objectShape.distant < minDistance) {
                        minDistance = objectShape.distant;
                        selectedObject = objectShape;
                    }
                }
                
                if (minDistance < 60) {
                    for (ObjectShape objectShape : shapes) {
                        objectShape.reset();
                    }
                    selectedObject.show();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Selected object information");
                    alert.setContentText(selectedObject.organization.toString());
                    alert.showAndWait();
                }
            }
        });
    }

    class ObjectShape {
        int x;
        int y;
        ObservableOrganization organization;
        Color color;
        double distant;

        public ObjectShape(ObservableOrganization organization) {
            this.organization = organization;
            float x = organization.getX();
            double y = organization.getY();
            this.x = (int) x;
            this.y = (int) y;
            this.color = setColor(organization.getOwner());
        }

        public void draw() {
            pen.setFill(color);
            pen.fillOval(x, y, 10, 10);
        }

        public void show() {
            pen.clearRect(x, y, 15, 15);
            pen.setFill(color);
            pen.fillOval(x, y, 15, 15);
        }

        public void reset() {
            pen.clearRect(x, y, 15, 15);
            pen.setFill(color);
            pen.fillOval(x, y, 10, 10);
        }
    }

    public Color setColor(String name) {
        int[] RGB = new int[3];
        for (int i = 0; i < name.length(); i++) {
            switch (i % 3) {
                case 0: {
                    RGB[0] += Character.getNumericValue(name.charAt(i)) * (10+i);
                    break;
                }
                case 1: {
                    RGB[1] += Character.getNumericValue(name.charAt(i)) * 10 * i;
                    break;
                }
                case 2: {
                    RGB[2] += Character.getNumericValue(name.charAt(i)) * (10-i);
                    break;
                }
            }
        }
        RGB[0] %= 255;RGB[1] %= 255;RGB[2] %= 255;
        return Color.rgb(RGB[0],RGB[1],RGB[2]);
    }
}
