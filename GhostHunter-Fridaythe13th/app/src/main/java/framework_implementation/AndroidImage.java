package framework_implementation;

/**
 * Created by Christian on 4/14/2015.
 */
import android.graphics.Bitmap;

import framework.Image;
import framework.Graphics.ImageFormat;

public class AndroidImage implements Image {
    Bitmap bitmap;
    ImageFormat format;

    public AndroidImage(Bitmap bitmap, ImageFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }

    public void scaleImage(int width, int height) {
        bitmap = bitmap.createScaledBitmap(bitmap, width, height, true);
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public ImageFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }
}
