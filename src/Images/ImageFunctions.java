package Images;

import javafx.scene.image.ImageView;


// hello siem

public class ImageFunctions {
    private String img;
    private javafx.scene.image.Image image;
    private ImageView view;
    private int height;


    public ImageFunctions(String img, int height) {
        this.img = img;
        this.height = height;

        this.image = new javafx.scene.image.Image(this.img);
        this.view = new ImageView(this.image);
        view.setFitHeight(height);
        view.setPreserveRatio(true);
    }

    public ImageView getView() {
        return view;
    }
}
