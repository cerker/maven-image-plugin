package de.akquinet.jbosscc.maven.plugin.image;

import java.awt.*;

public class Default
{
  /**
   * Font name. Defaults to "Arial".
   *
   * @parameter default-value="Arial"
   */
  private String fontName = "Arial";

  /**
   * Font style. Defaults to 0, i.e. java.awt.Font.PLAIN.
   *
   * @parameter default-value=0
   */
  private int fontStyle = Font.PLAIN;

  /**
   * Font size. Defaults to 12 (point).
   *
   * @parameter default-value=12
   */
  private int fontSize = 12;

  /**
   * Font size. Defaults to 12 (point).
   *
   * @parameter default-value="GREY"
   */
  private String fontColor = "GRAY";


  public String getFontName()
  {
    return fontName;
  }

  public int getFontStyle()
  {
    return fontStyle;
  }

  public int getFontSize()
  {
    return fontSize;
  }

  public String getFontColor()
  {
    return fontColor;
  }

  @Override
  public String toString()
  {
    return "Default{" +
      "fontName='" + fontName + '\'' +
      ", fontStyle=" + fontStyle +
      ", fontSize=" + fontSize +
      ", color='" + fontColor + '\'' +
      '}';
  }
}
