
// Importing classes from java.awt package for
// painting graphics and images
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
// Importing input output classes
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// Main class
public class RotateImage {

    // To return rotated image
    public static BufferedImage rotate(BufferedImage img) {

        // Getting Dimensions of image
        int width = img.getWidth();
        int height = img.getHeight();

        // Creating a new buffered image
        BufferedImage newImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());

        // creating Graphics in buffered image
        Graphics2D g2 = newImage.createGraphics();

        // Rotating image by degrees using toradians()
        g2.rotate(Math.toRadians(90), width / 2, height / 2);
        g2.drawImage(img, null, 0, 0);

        // Return rotated buffer image
        return newImage;
    }

    // Main driver method
    public static void main(String[] args) {
        // try block to check for exceptions
        try {

            // Reading orignal image
            BufferedImage orignalImg = ImageIO.read(new File("./arrow-5.png"));

            // Getting and Printing dimensions of orignal
            // image
            System.out.println("Orignal Image Dimension: " + orignalImg.getWidth() + "x" + orignalImg.getHeight());

            // Creating a subimage of given dimensions
            BufferedImage SubImg = rotate(orignalImg);

            // Printing Dimensions of new image created
            // (Rotated image)
            System.out.println("Cropped Image Dimension: " + SubImg.getWidth() + "x" + SubImg.getHeight());

            // Creating new file for rotated image
            File outputfile = new File("./ImageRotated.png");

            // Writing image in new file created
            ImageIO.write(SubImg, "png", outputfile);

            // Printing executed message
            System.out.println("Image rotated successfully: " + outputfile.getPath());
        }

        // Catch block to handle the exception
        catch (IOException e) {

            // Print the line number where exception
            // occurred
            e.printStackTrace();
        }
    }
}