package Gui;

import Images.*;
import MainProgram.CookieCount;
import MainProgram.CookieMain;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class GuiMain extends Application {

    @Override
    public void start(Stage primaryStage) {


        ImageFunctions cookieImage = new ImageFunctions("Images/cookie.jpeg", 400);

        ImageFunctions fingerImage = new ImageFunctions("Images/finger2.png", 50);

        ImageFunctions grandmaImage = new ImageFunctions("Images/grandma.jpg", 50);

        ImageFunctions farmImage = new ImageFunctions("Images/farm.png", 50);




        CookieCount cookieCount = new CookieCount(0);


        Label label = new Label(String.valueOf(cookieCount.getCookieCounter()));
        label.setMinSize(100, 100);
        label.setFont(Font.font(100));

        javafx.scene.control.Button cookieButton = new javafx.scene.control.Button();
        cookieButton.setPrefSize(400,400);
        cookieButton.setGraphic(cookieImage.getView());


        javafx.scene.control.Button finger = new javafx.scene.control.Button("Buildings Fingers Price: " + cookieCount.getFinger().getPrice() + "\nAmount: " +  cookieCount.getFinger().getHowMany());
        finger.setPrefSize(300,50);
        finger.setGraphic(fingerImage.getView());

//        GuiButton fingerButton = new GuiButton(400,400, "Images/cookie.jpeg");
//        fingerButton.addButton(cookieCount.getFinger());

        javafx.scene.control.Button grandma = new javafx.scene.control.Button("Buildings Grandma Price: " + cookieCount.getGrandma().getPrice() + "\n Amount: " +  cookieCount.getGrandma().getHowMany());
        grandma.setPrefSize(300,50);
        grandma.setGraphic(grandmaImage.getView());

        javafx.scene.control.Button farm = new Button("Buildings farm Price: " + cookieCount.getFarms().getPrice() + "\n Amount: " +  cookieCount.getFarms().getHowMany());
        farm.setPrefSize(300,50);
        farm.setGraphic(farmImage.getView());

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                System.out.println(cookieCount.getProductionCache());
                System.out.println(cookieCount.getCookieCounter());
                cookieCount.updateProduction();


            }
        },0, 17);

        cookieButton.setOnAction(event -> {
            label.setText(cookieCount.add());
        });
        finger.setOnAction(event -> {
            cookieCount.getFinger().bought();
            label.setText(String.valueOf(cookieCount.getCookieCounter()));
            finger.setText("Buildings.Fingers Price: " + cookieCount.getFinger().getPrice() + "\nAmount: " +  cookieCount.getFinger().getHowMany());

        });

        grandma.setOnAction(event -> {
            cookieCount.getGrandma().bought();
            label.setText(String.valueOf(cookieCount.getCookieCounter()));
            grandma.setText("Buildings Grandma Price: " + cookieCount.getGrandma().getPrice() + "\nAmount: " +  cookieCount.getGrandma().getHowMany());
        });

        farm.setOnAction(event -> {
            cookieCount.getFarms().bought();
            label.setText(String.valueOf(cookieCount.getCookieCounter()));
            farm.setText("Buildings Grandma Price: " + cookieCount.getFarms().getPrice() + "\nAmount: " +  cookieCount.getFarms().getHowMany());

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
        primaryStage.getIcons().add(new javafx.scene.image.Image("Images/cookie.jpeg"));
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void launch(){
        launch(GuiMain.class);
    }

}
