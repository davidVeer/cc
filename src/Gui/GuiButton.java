package Gui;

import Buildings.Buildings;
import Images.ImageFunctions;
import javafx.scene.control.Button;

import java.awt.*;

public class GuiButton {
    private int width;
    private int height;
    private String imageUrl;
    

    public GuiButton(int width, int height) {
        this.width = width;
        this.height = height;

    }

    public GuiButton(int width, int height, String imageUrl) {
        this.width = width;
        this.height = height;
        this.imageUrl = imageUrl;
    }

    public void addButton(Buildings building) {
        javafx.scene.control.Button button = new javafx.scene.control.Button("buildings" + building.getName() + " price : " + building.getPrice() + " amount : " + building.getHowMany());
        button.setPrefSize(this.width, this.height);
        ImageFunctions image = new ImageFunctions(imageUrl, this.height);
        button.setGraphic(image.getView());
    }
    public void help(){


    }

}
