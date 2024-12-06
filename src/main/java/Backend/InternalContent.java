package Backend;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * The InternalContent class represents content that can contain both text and an optional image.
 * The class handles the storage and manipulation of text and images, with the ability to load images
 * from a specified path. If the image path is invalid or null, the image will not be set.
 */
public class InternalContent {

    // Field to store the text content
    private String text;

    // Field to store the image object
    private Image image;

    // Field to store the path of the image file
    private String imagePath;

    /**
     * Constructor to create an InternalContent object with text and an optional image.
     * If the imagePath is valid, the image will be loaded, otherwise, it will be set to null.
     * 
     * @param text the text content of the InternalContent
     * @param imagePath the path to the image file (can be null or "null" to indicate no image)
     */
    public InternalContent(String text, String imagePath) {
        this.text = text;
        this.imagePath = imagePath;
<<<<<<< Updated upstream
        if(imagePath!=null || !"null".equals(imagePath)){ // checking for "null" because of file reading
            ImageIcon icon = new ImageIcon(imagePath);
            this.image = icon.getImage(); // turning save path to icon to image
        }
        else{
            imagePath = null; // to prevent errors if imagePath is used elsewhere
=======

        // If the imagePath is valid, load the image from the path
        if (imagePath != null && !"null".equals(imagePath)) {
            ImageIcon icon = new ImageIcon(imagePath);
            this.image = icon.getImage();
        } else {
            // If imagePath is null or "null", set imagePath to null and no image will be loaded
            this.image = null;
>>>>>>> Stashed changes
        }
    }

    // Getter and Setter methods

    /**
     * Gets the path of the image associated with this content.
     * 
     * @return the image path
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Sets the path of the image associated with this content.
     * 
     * @param imagePath the new image path
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * Gets the text content of this InternalContent.
     * 
     * @return the text content
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text content of this InternalContent.
     * 
     * @param text the new text content
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets the image associated with this content.
     * 
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets the image associated with this content.
     * 
     * @param image the new image
     */
    public void setImage(Image image) {
        this.image = image;
    }
}
