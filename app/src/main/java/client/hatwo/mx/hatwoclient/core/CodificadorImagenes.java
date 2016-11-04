package client.hatwo.mx.hatwoclient.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Pattyntel on 02/11/2016.
 */
public class CodificadorImagenes {

        public static Drawable decodificar(String str)
        {
            String strImg = URLDecoder.decode(str);
            byte[] bytes = Base64.decode(strImg, Base64.DEFAULT);
            Drawable drw = new BitmapDrawable(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
            return drw;
        }

        public static String codificar(Drawable drw)
        {
            Bitmap bitmap = ((BitmapDrawable) drw).getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] bytes = null;
            String strOut = null;

            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            bytes = stream.toByteArray();

            strOut = Base64.encodeToString(bytes, Base64.DEFAULT);
            strOut = URLEncoder.encode(strOut);
            return strOut;
        }
}
