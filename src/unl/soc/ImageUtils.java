package unl.soc;
/*
 * Name: Luciano Carvalho (lguedesdecarvalhon2@huskers.unl.edu)
 *
 * Date: 2023 - 10 - 12
 *
 * FUNCTIONS TO MANIPULATE THE ORIENTATION FROM A IMAGE.
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * This is a collection of utility methods for manipulating images in a variety
 * of formats (jpg, bmp, gif, png, etc.).
 * <p>
 * For the purposes of these utilities, images are represented by a
 * 2-dimensional array of {@link RGB} elements (pixels).
 * <p>
 * The dimensions are assumed to be height x width (h x w). The first dimension
 * is considered to be the height (number of rows of pixels) and the second is
 * considered to be the width (number of columns of pixels). It is assumed that
 * all rows and all columns are uniform in their length.
 */
public class ImageUtils {

    /**
     * Loads an image from the file specified by the given <code>filePath</code>.
     *
     * @param filePath
     * @return
     */
    public static RGB[][] loadImage(String filePath) {
        File file = new File(filePath);
        BufferedImage img = null;
        try {
            img = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RGB pixels[][] = new RGB[img.getHeight()][img.getWidth()];
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                int p = img.getRGB(x, y);
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
                pixels[y][x] = new RGB(r, g, b);
            }
        }
        return pixels;
    }

    /**
     * Saves the given image to the file specified by the given
     * <code>filePath</code>
     *
     * @param filePath
     * @param image
     */
    public static void saveImage(String filePath, RGB image[][]) {
        String extension = filePath.substring(filePath.lastIndexOf(".") + 1);
        BufferedImage newImg = new BufferedImage(image[0].length, image.length, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < newImg.getHeight(); y++) {
            for (int x = 0; x < newImg.getWidth(); x++) {
                int p = (image[y][x].getRed() << 16) + (image[y][x].getGreen() << 8) + image[y][x].getBlue();
                newImg.setRGB(x, y, p);
            }
        }

        File f = new File(filePath);
        try {
            ImageIO.write(newImg, extension, f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a new copy of the image.
     */
    public static RGB[][] copyImage(RGB[][] image) {
        if (image == null) {
            throw new IllegalArgumentException();
        }

        RGB[][] imageCopy = new RGB[image.length][image[0].length];
//        imageCopy = image.clone();
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                imageCopy[i][j] = image[i][j];
            }
        }
        return imageCopy;
    }

    /**
     * Flip the image in the horizontal line.
     */
    public static void flipHorizontal(RGB image[][]) {
        if (image == null) {
            throw new IllegalArgumentException();
        }

        RGB[][] tempImage = new RGB[image.length][image[0].length];
        tempImage = copyImage(image);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                image[i][j] = tempImage[i][(image[0].length - 1) - j];
            }
        }
    }

    /**
     * Flip the image in the vertical line.
     */
    public static void flipVertical(RGB image[][]) {
        if (image == null) {
            throw new IllegalArgumentException();
        }

        RGB[][] tempImage = new RGB[image.length][image[0].length];
        tempImage = copyImage(image);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                image[i][j] = tempImage[(image.length - 1) - i][j];
            }
        }
    }

    /**
     * Rotates the image in a clock wise direction.
     */
    public static RGB[][] rotateClockwise(RGB image[][]) {
        if (image == null) {
            throw new IllegalArgumentException();
        }
        RGB[][] imageRotated = new RGB[image[0].length][image.length];

        for (int i = 0; i < image[0].length; i++) {
            for (int j = 0; j < image.length; j++) {
                imageRotated[i][j] = image[(image.length - 1) - j][i];
            }
        }

        return imageRotated;
    }

}