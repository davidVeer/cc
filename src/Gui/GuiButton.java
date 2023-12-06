package Gui;

import Buildings.Buildings;

import java.awt.*;

public class GuiButton {
    private int width;
    private int height;



    public GuiButton(int width, int height, ) {
        this.width = width;
        this.height = height;
    }

    public void addButton(Buildings building) {
        javafx.scene.control.Button button = new javafx.scene.control.Button("buildings" + building.getName() + " price : " + building.getPrice() + " amount : " + building.getHowMany());
        button.setPrefSize(this.width, this.height);
        button.setGraphic(cookieImage.getView());
    }


}
