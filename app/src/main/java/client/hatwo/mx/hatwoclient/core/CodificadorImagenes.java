package client.hatwo.mx.hatwoclient.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
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
        //String strImg = URLDecoder.decode(str);
        byte[] bytes = Base64.decode(str, Base64.DEFAULT);
        Drawable drw = new BitmapDrawable(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
        return drw;
    }

    public static String codificar(Drawable drw) throws Exception
    {
        Bitmap bitmap = ((BitmapDrawable) drw).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        byte[] bytes = null;
        String strOut = null;

        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        bytes = stream.toByteArray();
        strOut = Base64.encodeToString(bytes, Base64.DEFAULT);
        strOut = strOut.replaceAll("\n", "");
        strOut = URLEncoder.encode(strOut, "UTF-8");
        return strOut;
        }

    public static Drawable resizeImage(Bitmap mBitmap, float newWidth, float newHeigth) {
        //public static Drawable resizeImage(Context ctx, int resId, int w, int h) {

        // cargamos la imagen de origen
        //Bitmap BitmapOrg = BitmapFactory.decodeResource(ctx.getResources(), resId);


        int width = mBitmap.getWidth();
        int height = mBitmap.getHeight();

        // calculamos el escalado de la imagen destino
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeigth) / height;

        // para poder manipular la imagen
        // debemos crear una matriz

        Matrix matrix = new Matrix();
        // resize the Bitmap
        matrix.postScale(scaleWidth, scaleHeight);

        // volvemos a crear la imagen con los nuevos valores
        Bitmap resizedBitmap = Bitmap.createBitmap(mBitmap, 0, 0,
                width, height, matrix, true);

        // si queremos poder mostrar nuestra imagen tenemos que crear un
        // objeto drawable y así asignarlo a un botón, imageview...
        return new BitmapDrawable(resizedBitmap);

    }

    public static Bitmap cropBitmap(Bitmap original, int height, int width) {

        Bitmap croppedImage = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

        Canvas canvas = new Canvas(croppedImage);

        Rect srcRect = new Rect(0, 0, original.getWidth(), original.getHeight());
        Rect dstRect = new Rect(0, 0, width, height);

        int dx = (srcRect.width() - dstRect.width()) / 2;
        int dy = (srcRect.height() - dstRect.height()) / 2;

// If the srcRect is too big, use the center part of it.
        srcRect.inset(Math.max(0, dx), Math.max(0, dy));

// If the dstRect is too big, use the center part of it.
        dstRect.inset(Math.max(0, -dx), Math.max(0, -dy));

// Draw the cropped bitmap in the center
        canvas.drawBitmap(original, srcRect, dstRect, null);

        original.recycle();

        return croppedImage;
    }

}
