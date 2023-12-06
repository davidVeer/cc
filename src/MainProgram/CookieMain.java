package MainProgram;

import Img.Image;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;


//

public class CookieMain extends Application {
    public static void main(String[] args) {
        launch(CookieMain.class);
    }


    @Override
    public void start(Stage primaryStage) {


        Img.Image cookieImage = new Img.Image("img/cookie.jpeg", 400);

        Img.Image fingerImage = new Img.Image("img/finger2.png", 50);

        Img.Image grandmaImage = new Img.Image("img/grandma.jpg", 50);

        Img.Image farmImage = new Image("img/farm.png", 50);




            CookieCount cookieCount = new CookieCount(0);

            Label label = new Label("cookie count");
            label.setMinSize(100, 100);
            label.setFont(Font.font(100));

            Button cookieButton = new Button();
            cookieButton.setPrefSize(400,400);
            cookieButton.setGraphic(cookieImage.getView());

            Button finger = new Button("Buildings Fingers Price: " + cookieCount.finger.getPrice() + "\nAmount: " +  cookieCount.finger.getHowMany());
            finger.setPrefSize(300,50);
            finger.setGraphic(fingerImage.getView());

            Button grandma = new Button("Buildings Grandma Price: " + cookieCount.grandma.getPrice() + "\n Amount: " +  cookieCount.grandma.getHowMany());
            grandma.setPrefSize(300,50);
            grandma.setGraphic(grandmaImage.getView());

            Button farm = new Button("Buildings farm Price: " + cookieCount.farms.getPrice() + "\n Amount: " +  cookieCount.farms.getHowMany());
            farm.setPrefSize(300,50);
            farm.setGraphic(farmImage.getView());


            cookieButton.setOnAction(event -> {
                label.setText(cookieCount.add());
            });
            finger.setOnAction(event -> {
                label.setText(cookieCount.finger.bought());
                finger.setText("Buildings.Fingers Price: " + cookieCount.finger.getPrice() + "\nAmount: " +  cookieCount.finger.getHowMany());

            });

              grandma.setOnAction(event -> {
            label.setText(cookieCount.grandma.bought());
            grandma.setText("Buildings Grandma Price: " + cookieCount.grandma.getPrice() + "\nAmount: " +  cookieCount.grandma.getHowMany());
              });

              farm.setOnAction(event -> {
            label.setText(cookieCount.farms.bought());
            farm.setText("Buildings Grandma Price: " + cookieCount.farms.getPrice() + "\nAmount: " +  cookieCount.farms.getHowMany());

            });


            VBox vBox = new VBox();
            vBox.setSpacing(20);
            vBox.getChildren().addAll(finger, grandma, farm);


            BorderPane borderPane = new BorderPane();

            borderPane.setTop(label);
            borderPane.setCenter(cookieButton);
            borderPane.setRight(vBox);


            Scene scene = new Scene(borderPane);
            primaryStage.setTitle("coomknie klicer");
            primaryStage.getIcons().add(new javafx.scene.image.Image("img/cookie.jpeg"));
            primaryStage.setScene(scene);
            primaryStage.show();
    }
}
