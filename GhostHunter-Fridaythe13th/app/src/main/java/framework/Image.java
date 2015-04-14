package framework;

import framework.Graphics.ImageFormat;

/**
 * Created by Emily on 4/14/2015.
 */
public interface Image {
    public int getWidth();
    public int getHeight();
    public ImageFormat getFormat();
    public void dispose();
}
