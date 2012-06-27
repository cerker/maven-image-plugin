package de.akquinet.jbosscc.maven.plugin.image;

import static java.util.Arrays.asList;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Goal which adds text to an image file. The source file is left untouched. The target file will be saved to
 * a configured folder under the Maven target directory.
 *
 * @goal add-text
 * @phase process-resources
 */
public class AddTextToImageMojo extends AbstractMojo
{
  /**
   * Path to the source image file; relative to the module's base dir.
   *
   * @parameter
   * @required
   */
  private File sourceImage;

  /**
   * Path for the target image file; relative to the module's base dir.
   *
   * @parameter
   * @required
   */
  private File targetImage;

  /**
   * The format of the target image. Will be passed on to javax.imageio.ImageIO.write() as parameter formatName.
   *
   * @parameter default-value="jpg"
   */
  private String targetFormat;

  /**
   * Default values for the Font properties.
   *
   * @parameter
   */
  private Default defaults = new Default();

  /**
   * The Text and its properties.
   *
   * @parameter
   * @required
   */
  private Text[] texts;


  public void execute()
    throws MojoExecutionException
  {
    logParameters();

    targetImage.getParentFile().mkdirs();

    try
    {
      AddTextToImage textToImage = AddTextToImage.create()
        .openImage(sourceImage.getPath())
        .setImageFormat(targetFormat);

      for (Text text : texts)
      {
        textToImage.addText(text.getText(), getFont(text), getFontColor(text), text.getOffsetX(), text.getOffsetY());
      }

      textToImage.saveImage(targetImage.getPath());
    }
    catch (IOException e)
    {
      throw new MojoExecutionException("Error working with image", e);
    }
    catch (IllegalAccessException e)
    {
      throw new MojoExecutionException("Error working with image", e);
    }

  }

  private Color getFontColor(final Text text) throws IllegalAccessException
  {
    return ColorUtil.fromRgbOrName(text.getFontColor() == null ? defaults.getFontColor() : text.getFontColor());
  }

  private Font getFont(final Text text)
  {
    String fontName = text.getFontName() == null ? defaults.getFontName() : text.getFontName();
    int fontSize = text.getFontSize() == null ? defaults.getFontSize() : text.getFontSize();
    int fontStyle = text.getFontStyle() == null ? defaults.getFontStyle() : text.getFontStyle();
    return new Font(fontName, fontStyle, fontSize);
  }

  private void logParameters()
  {
    getLog().info("sourceImage=" + sourceImage);
    getLog().info("targetImage=" + targetImage);
    getLog().info("defaults=" + defaults);
    if (texts != null)
    {
      getLog().info("texts=" + asList(texts));
    }
  }
}
