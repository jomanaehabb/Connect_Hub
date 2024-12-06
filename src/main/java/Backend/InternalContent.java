package Backend;

import java.awt.Image;
import javax.swing.ImageIcon;

public class InternalContent {
    private String text;
    private Image image;
    private String imagePath;

    public InternalContent(String text, String imagePath) {
        this.text = text;
        this.imagePath = imagePath;
        if(imagePath!=null || !"null".equals(imagePath)){
            ImageIcon icon = new ImageIcon(imagePath);
            this.image = icon.getImage();
        }
        else{
            imagePath = null;
        }
    }
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
