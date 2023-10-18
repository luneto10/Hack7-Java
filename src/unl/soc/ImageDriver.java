package unl.soc;

public class ImageDriver {

    public static void main(String args[]) {

        RGB original[][] = ImageUtils.loadImage("images/pointers.png");

        // TODO: perform any method calls here; example:
        RGB copyImage[][] = ImageUtils.copyImage(original);
        ImageUtils.saveImage("images/copy.jpg", copyImage);

        ImageUtils.flipHorizontal(original);
        ImageUtils.saveImage("images/flipHorizontal.jpg", original);
        ImageUtils.flipHorizontal(original);

        ImageUtils.flipVertical(original);
        ImageUtils.saveImage("images/flipVertical.jpg", original);
        ImageUtils.flipVertical(original);

        RGB rotatedImage[][] = ImageUtils.rotateClockwise(original);
        ImageUtils.saveImage("images/rotatedImage.jpg", rotatedImage);

        RGB rotatedImage2[][] = ImageUtils.rotateClockwise(rotatedImage);
        ImageUtils.saveImage("images/rotatedImage2.jpg", rotatedImage2);
    }

}