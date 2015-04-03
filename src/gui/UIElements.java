package gui;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 21/03/2015)
*/

/*
this class was created to allow reuse of various user interface elements throughout the UI
attributes are set to static to allow access without the need for reference object creation
*/

import org.omg.CORBA.portable.ApplicationException;
import sun.misc.IOUtils;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Color;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class UIElements {

    // DGA banner
    public final static String banner = "src/res/images/UI Elements/banner.png";

    // 16 pixel icons
    public final static String save16 = "src/res/images/UI Elements/save16.png";
    public final static String cancel6 = "src/res/images/UI Elements/cancel16.png";
    public final static String edit16 = "src/res/images/UI Elements/edit16.png";
    public final static String plus16 = "src/res/images/UI Elements/plus16.png";
    public final static String minus16 = "src/res/images/UI Elements/minus16.png";
    public final static String search16 = "src/res/images/UI Elements/search16.png";
    public final static String product16 = "src/res/images/UI Elements/product16.png";
    public final static String delete16 = "src/res/images/UI Elements/delete16.png";
    public final static String logout16 = "src/res/images/UI Elements/logout16.png";
    public final static String open16 = "src/res/images/UI Elements/open16.png";
    public final static String remove16 = "src/res/images/UI Elements/remove16.png";
    public final static String person16 = "src/res/images/UI Elements/person16.png";
    public final static String report16 = "src/res/images/UI Elements/report16.png";
    public final static String info16 = "src/res/images/UI Elements/info16.png";
    public final static String print16 = "src/res/images/UI Elements/print16.png";

    // 32 pixel icons
    public final static String person32 = "src/res/images/UI Elements/person32.png";
    public final static String product32 = "src/res/images/UI Elements/product32.png";
    public final static String report32 = "src/res/images/UI Elements/report32.png";
    public final static String info32 = "src/res/images/UI Elements/info32.png";

    // 64 pixel icons
    public final static String person64 = "src/res/images/UI Elements/person64.png";

    // 128 pixel icons
    public final static String person128 = "src/res/images/UI Elements/person128.png";
    public final static String product128 = "src/res/images/UI Elements/product128.png";

    // 150 pixel icons
    public final static String login150 = "src/res/images/UI Elements/login150.png";
    public final static String shoppingCart150 = "src/res/images/UI Elements/shoppingCart150.png";

    // UI colour
    public static Color color = new Color(98, 169, 221);

    public static Color getColour() {
        return color;
    }
}