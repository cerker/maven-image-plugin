package de.akquinet.jbosscc.maven.plugin.image;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import java.awt.*;

public class ColorUtilTest
{
  @Test
  public void fromRgbOrNameCreatesCorrectColorWhenRgbValueIsGiven() throws Exception
  {
    Color fromString = ColorUtil.fromRgbOrName("#AA00FF");

    assertThat(fromString.getRed()).isEqualTo(170);
    assertThat(fromString.getGreen()).isEqualTo(0);
    assertThat(fromString.getBlue()).isEqualTo(255);
  }

  @Test
  public void fromRgbCreatesCorrectColorWhenMixedCaseRgbValueIsGiven() throws Exception
  {
    Color fromString = ColorUtil.fromRgbOrName("#aA00fF");

    assertThat(fromString.getRed()).isEqualTo(170);
    assertThat(fromString.getGreen()).isEqualTo(0);
    assertThat(fromString.getBlue()).isEqualTo(255);
  }

  @Test
  public void fromRgbOrNameCreatesCorrectColorWhenColorNameIsGiven() throws Exception
  {
    Color fromString = ColorUtil.fromRgbOrName("MAGENTA");

    assertThat(fromString).isEqualTo(Color.MAGENTA);
  }

  @Test(expected = IllegalArgumentException.class)
  public void fromNameThrowsIllegalArgumentExceptionWhenNonExistingColorNameIsGiven() throws Exception
  {
    Color fromString = ColorUtil.fromName("doesnotexist");
  }

  @Test(expected = IllegalArgumentException.class)
  public void fromNameThrowsIllegalArgumentExceptionWhenNullIsPassed() throws Exception
  {
    ColorUtil.fromName(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void fromRgbThrowsIllegalArgumentExceptionWhenNullIsPassed() throws Exception
  {
    ColorUtil.fromRgb(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void fromRgbThrowsIllegalArgumentExceptionWhenNameWithoutLeadingHashmarkIsPassed() throws Exception
  {
    ColorUtil.fromRgb("AA00FF");
  }

  @Test(expected = IllegalArgumentException.class)
  public void fromRgbThrowsIllegalArgumentExceptionWhenNameWithWrongFormatIsPassed() throws Exception
  {
    ColorUtil.fromRgb("#aa00ff55");
  }
}
