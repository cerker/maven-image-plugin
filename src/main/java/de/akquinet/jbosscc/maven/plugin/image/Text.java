package de.akquinet.jbosscc.maven.plugin.image;

public class Text
{
  /**
   * The text to insert into the image.
   *
   * @parameter
   * @required
   */
  private String text;

  /**
   * Font name. Defaults to "Arial".
   *
   * @parameter
   */
  private String fontName;

  /**
   * Font style. Defaults to 0, i.e. java.awt.Font.PLAIN.
   *
   * @parameter
   */
  private Integer fontStyle;

  /**
   * Font size. Defaults to 12 (point).
   *
   * @parameter
   */
  private Integer fontSize;

  /**
   * The font color. May be an RGB value with a leading hash mark followed by two-digit hexadecimal values for
   * red, green and blue values respectively. E.g., "#AA23FB"
   *
   * @parameter
   */
  private String fontColor;

  /**
   * The x-axis position of the text, in relation to the left of the image.
   *
   * @parameter
   */
  private int offsetX;

  /**
   * The y-axis position of the text, in relation to the bottom of the image.
   *
   * @parameter
   */
  private int offsetY;


  public String getText()
  {
    return text;
  }

  public String getFontName()
  {
    return fontName;
  }

  public Integer getFontStyle()
  {
    return fontStyle;
  }

  public Integer getFontSize()
  {
    return fontSize;
  }

  public String getFontColor()
  {
    return fontColor;
  }

  public int getOffsetX()
  {
    return offsetX;
  }

  public int getOffsetY()
  {
    return offsetY;
  }

  @Override
  public String toString()
  {
    return "Text{" +
      "text='" + text + '\'' +
      ", fontName='" + fontName + '\'' +
      ", fontStyle=" + fontStyle +
      ", fontSize=" + fontSize +
      ", fontColor='" + fontColor + '\'' +
      ", offsetX=" + offsetX +
      ", offsetY=" + offsetY +
      '}';
  }
}
