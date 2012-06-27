package de.akquinet.jbosscc.maven.plugin.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Tool to add some text to an Image at specified positions with a specified font and color.
 */
public final class AddTextToImage
{
  private BufferedImage image;
  private Graphics graphics;
  private int imageHeight;
  private String imageFormat = "jpg";

  private AddTextToImage()
  {
    // use factory method
  }

  public static AddTextToImage create()
  {
    return new AddTextToImage();
  }

  public AddTextToImage setImageFormat(final String imageFormat)
  {
    this.imageFormat = imageFormat;
    return this;
  }

  public void saveImage(final String targetImg) throws IOException
  {
    graphics.dispose();
    ImageIO.write(image, imageFormat, new File(targetImg));
  }

  public AddTextToImage addText(final String text, final Font font, final Color color, final int offsetX,
                                final int offsetY)
  {
    System.out.println(
      "Adding Text: text=" + text + ", font=" + font + ", color=" + color + ", offsetX=" + offsetX + ", offsetY="
        + offsetY);

    graphics.setFont(font);
    graphics.setColor(color);
    graphics.drawString(text, offsetX, imageHeight - font.getSize() / 2 - offsetY);
    return this;
  }

  public AddTextToImage openImage(final String sourceImagePath) throws IOException
  {
    File file = new File(sourceImagePath);
    Image srcImage = ImageIO.read(file);
    final int imageWidth = srcImage.getWidth(null);
    imageHeight = srcImage.getHeight(null);
    image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
    graphics = image.createGraphics();
    graphics.drawImage(srcImage, 0, 0, imageWidth, imageHeight, null);

    return this;
  }

  public static void main(String[] args) throws IOException
  {
/*
    String srcPath = "C:\\Projekte\\ubi-root\\vs\\vs-config\\vs-config-client-packaging\\src\\main\\resources-binary\\splash.jpg";
    String targetPath = "C:\\Temp\\splash.png";

    AddTextToImage.create()
      .setImageFormat("png")
      .openImage(srcPath)
      .addText("UBI ist toll", new Font("Arial", Font.BOLD, 16), Color.WHITE, 50, 500)
      .addText("UBI ist gut", new Font("Arial", Font.BOLD, 16), Color.WHITE, 50, 475)
      .saveImage(targetPath);
*/

    System.out.println(Arrays.asList(GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()));
  }
}
