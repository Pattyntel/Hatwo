package client.hatwo.mx.hatwoclient.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import client.hatwo.mx.hatwoclient.R;
import client.hatwo.mx.hatwoclient.core.ControladorClient;

/**
 * Created by Pattyntel on 08/11/2016.
 */
public class FragmentHistory extends Fragment {

    View layoutFragment;
    TextView textoPrueba;
    ControladorClient controladorClient;
    Context context;

    public FragmentHistory() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        getActivity().setTitle("Historial");
        Log.i("Titulo","Historial");

        //Cargamos el xml correspondiente al fragmento necesario para hacer movimientos de alumnos.
        //container es donde se va a desplegar.
        //observador cuando se va a utilizar en otras aplicaciones o para debugin
        layoutFragment = inflater.inflate(R.layout.fragment_history, container, false);

        //Se utiliza el layoutFragment para encontrar los controles
        textoPrueba = (TextView) layoutFragment.findViewById(R.id.txt_texto_prueba);

        try
        {
            inicializar();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        controladorClient = new ControladorClient(getContext());
        context = container.getContext();
        
        getActivity().setTitle("Historial");
        Log.i("Titulo","Historial");
        return layoutFragment;
    }

    private void inicializar() throws Exception
    {
        Log.i("info","inicializar history");
        actualizar();
        //((ActivityRegister) ActivityRegister.GLOBALS.get("app")).mostrarMensaje("Clientes: " + alumnos.size(), Snackbar.LENGTH_LONG);
//        ((ActivityRegister) ActivityRegister.GLOBALS.get("app")).mostrarMensaje("Clientes: ", Snackbar.LENGTH_LONG);
    }

    public void actualizar() throws Exception
    {
        if (controladorClient == null)
            controladorClient = new ControladorClient(getContext());
        Log.i("info","actualizar history");
    }

}
