package de.akquinet.jbosscc.maven.plugin.image;

import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class ColorUtil
{
  private ColorUtil()
  {
    // helper class with static methods
  }

  public static Color fromRgbOrName(final String rgbOrName) throws IllegalAccessException
  {
    if (rgbOrName == null)
    {
      throw new IllegalArgumentException("Parameter rgbOrName must not be null");
    }
    if (rgbOrName.startsWith("#"))
    {
      return fromRgb(rgbOrName);
    }
    return fromName(rgbOrName);
  }

  public static Color fromName(final String name) throws IllegalAccessException
  {
    Field[] fields = Color.class.getFields();
    for (Field field : fields)
    {
      boolean isTypeColor = field.getType().equals(Color.class);
      boolean hasSameName = field.getName().equals(name);
      boolean isStatic = Modifier.isStatic(field.getModifiers());

      if (isStatic && isTypeColor && hasSameName)
      {
        return (Color) field.get(null);
      }
    }

    throw new IllegalArgumentException(
      "Given color name '" + name + "' is not defined as a constant in java.awt.Color");
  }

  public static Color fromRgb(final String rgb)
  {
    if (rgb == null || !rgb.matches("^#[0-9a-hA-H]{6}$"))
    {
      throw new IllegalArgumentException(
        "RGB value must be represented as hexadecimal value with a length of 6 and a leading hashmark, but was: '" + rgb
          + "'");
    }

    Integer red = Integer.valueOf(rgb.substring(1, 3), 16);
    Integer green = Integer.valueOf(rgb.substring(3, 5), 16);
    Integer blue = Integer.valueOf(rgb.substring(5, 7), 16);

    return new Color(red, green, blue);
  }
}
