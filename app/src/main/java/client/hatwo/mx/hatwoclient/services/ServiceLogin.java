package client.hatwo.mx.hatwoclient.services;

import client.hatwo.mx.hatwoclient.configurations.CodigosErrorGenerales;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Pattyntel on 03/11/2016.
 */
public class ServiceLogin extends AsyncTask<String, String, Integer> {


    JSONObject responseJSON;
    ProgressDialog progressDialog;
    Activity mActivity;
    String mActivity_succesful;
    String mActivity_error;
    String mPackage;
    String[] mValores_int;
    String[] mValores_out;


    public ServiceLogin(Activity activity, String[] valoresInt, String[] valoresOut, String mPackageV, String mActivityError, String mActivitySuccelful)
    {
        mActivity = activity;

        mValores_int = valoresInt;

        mValores_out = valoresOut;

        mPackage =  mPackageV;

        mActivity_error = mActivityError;

        mActivity_succesful =  mActivitySuccelful;
    }

    //Antes de que se ejecute
    @Override
    protected void onPreExecute()
    {
        progressDialog = ProgressDialog.show(mActivity,
                "Cargando Información", "Espere un momento.", false, false);
    }

    //Se ejecuta en un hilo diferente al principal es decir background
    @Override
    protected Integer doInBackground(String... params)
    {

      Integer error = CodigosErrorGenerales.getCodeDefault();
        //para hacer la llamada Post
   /*       HttpPost post;
        post = new HttpPost(params[0]);

        post.setHeader("content-type", "application/json");
        JSONObject dato = new JSONObject();
        try
        {

            String[] valores = mValores_int[0].split("::");

            for(String valor : valores)
            {
                String[] parametro = valor.split(",");

                dato.put(parametro[0], parametro[1]);
            }

            StringEntity entity = new StringEntity(dato.toString());
            post.setEntity(entity);
            try
            {

                HttpParams httpParameters = new BasicHttpParams();
                //HttpConnectionParams.setConnectionTimeout(httpParameters, Globals.TIMEOUT);
                //HttpConnectionParams.setSoTimeout(httpParameters, Globals.HTTP_TIMEOUT);

                HttpClient httpClient = new DefaultHttpClient(httpParameters);

                HttpResponse resp = httpClient.execute(post);
                String respStr = EntityUtils.toString(resp.getEntity());
                JSONObject respJSON = new JSONObject(respStr);

                if (respJSON.equals(""))
                {
                    error = CodigosErrorGenerales.getCodeJsonVacio();
                }
                else
                {
                    responseJSON = respJSON;
                }
            }
            catch (ConnectTimeoutException e)
            {
                Log.d(e.getMessage(), "Entre a ConnectTimeoutException ");

                error = CodigosErrorGenerales.getCodeTimeout();

                return error;
            }
        }
        catch (JSONException e)
        {
            Log.d(e.getMessage(),"Entre a JSONException");

            return CodigosErrorGenerales.getCodeJson();
        }
        catch (UnsupportedEncodingException e)
        {
            Log.d(e.getMessage(),"Entre a UnsupportedEncodingException");

            return CodigosErrorGenerales.getCodeExcepcionNoSoportada();
        }
        catch (ClientProtocolException e)
        {

            Log.d(e.getMessage(), "Entre a ClientProtocolException");

            return CodigosErrorGenerales.getCodeExcepcionProtocolo();
        }
        catch (IOException e)
        {
            Log.d(e.getMessage(), "Entre a IOException");

            return CodigosErrorGenerales.getCodeExcepcionInternet();
        }
*/
        return error;
    }


    @Override
    protected void onPostExecute(Integer result)
    {

        try
        {
            if(result != CodigosErrorGenerales.getCodeDefault())
            {
                if(result == CodigosErrorGenerales.getCodeTimeout())
                {
                    Toast.makeText(mActivity, "Error en el servicio, es probable que no este disponible", Toast.LENGTH_LONG).show();

                }
                else
                {
                    if(result ==CodigosErrorGenerales.getCodeExcepcionInternet())
                    {
                        Toast.makeText(mActivity, "Se ha detectado un problema con el internet, verifica tu conexión ", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(mActivity, "Error " + result + " Reporte a sistemas ", Toast.LENGTH_LONG).show();
                    }
                }

                progressDialog.dismiss();
            }
            else
            {
                String json = responseJSON.getString("d");
                try {
                    JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
                    String Error = object.getString("Error");
                    if (Error == "true")
                    {
                        String Mensaje = object.getString("UltimoMensaje");

                        Toast.makeText(mActivity, Mensaje, Toast.LENGTH_LONG).show();

                        progressDialog.dismiss();
                    } else {
                        String aaData = object.getString("Resultado");

                        String resultado_login = "";

                        resultado_login += aaData.replace("\\", " ");
                        resultado_login = resultado_login.replace("[", " ");
                        resultado_login = resultado_login.replace("]", " ");
                        resultado_login = resultado_login.replace("\n", " ");
                        resultado_login = resultado_login.replace("\"", "");

                        String[] registro = resultado_login.split(",");

                        Intent u = new Intent();

                        u.setClassName(mActivity, mPackage +  ".Activities." + mActivity_succesful);

                        String[] valores = mValores_out[0].split("::");

                        int contadorKey = 0;

                        int contadorValue = 0;

                        String concatVal;

                        String[] valores_out = new String[valores.length];

                        for(String key : valores)
                        {
                            for (String value : registro)
                            {
                                String valor = value.replace("{","");
                                String[] values = valor.split(":");
                                String llave = key.replaceAll(" ","");
                                if(values[0].equals(llave))
                                {
                                    concatVal  = llave + "::" + values[1];
                                    valores_out[contadorValue] = concatVal;
                                    contadorValue = contadorValue+1;
                                }
                                else
                                {
                                    continue;
                                }

                            }
                            contadorKey = contadorKey+1;
                        }

                        u.putExtra("datos", valores_out);

                        mActivity.startActivity(u);

                        progressDialog.dismiss();
                    }
                }
                catch (JSONException e)
                {
                    Toast.makeText(mActivity,"Error interno, Reporte", Toast.LENGTH_SHORT) .show();
                    in_regresar_activity_error();
                }
            }
        }
        catch (Exception e)
        {
            in_regresar_activity_error();
        }
    }





    private  void  in_regresar_activity_error()
    {
        Intent u = new Intent();

        u.setClassName(mActivity, mPackage +  ".Activities." + mActivity_error);

        mActivity.finish();

        mActivity.startActivity(u);
    }


}

