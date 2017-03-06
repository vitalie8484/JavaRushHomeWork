package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by fintest on 8/17/2016.
 */
public class ImageReaderFactory {

    public static ImageReader getReader(ImageTypes type) {
        ImageReader result = null;
        if (type == ImageTypes.BMP)
            result = new BmpReader();
        else if (type == ImageTypes.JPG)
            result = new JpgReader();
        else if (type == ImageTypes.PNG)
            result = new PngReader();
        else
            throw new IllegalArgumentException("Неизвестный тип картинки");
        return result;
    }

}
