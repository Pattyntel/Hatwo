package client.hatwo.mx.hatwoclient.Activities;

//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import client.hatwo.mx.hatwoclient.R;
import client.hatwo.mx.hatwoclient.core.ControladorClient;

/**
 * Created by Pattyntel on 06/11/2016.
 */
public class FragmentAddressClient extends Fragment {
    View layoutFragment;
    TextView txtAlumnoId;
    TextView txtAlumnoMatricula;
    TextView txtAlumnoNombre;
    TextView txtAlumnoApellidoPaterno;
    TextView txtAlumnoApellidoMaterno;
    TextView txtAlumnoGeneracion;
    TextView txtAlumnoFechaNacimiento;
    ImageView imgvAlumnoFoto;
    Button btnAlumnoGuardar;
    Button btnAlumnoBorrar;
    ControladorClient controladorClient;

    public FragmentAddressClient() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Cargamos el xml correspondiente al fragmento necesario para hacer movimientos de alumnos.
        //container es donde se va a desplegar.
        //observador cuando se va a utilizar en otras aplicaciones o para debugin
        layoutFragment = inflater.inflate(R.layout.fragment_address_client, container, false);

        //Se utiliza el layoutFragment para encontrar los controles
        txtAlumnoApellidoMaterno = (TextView) layoutFragment.findViewById(R.id.txtAlumnoApellidoMaterno);
        txtAlumnoApellidoPaterno = (TextView) layoutFragment.findViewById(R.id.txtAlumnoApellidoPaterno);
        txtAlumnoFechaNacimiento = (TextView) layoutFragment.findViewById(R.id.txtAlumnoFechaNacimiento);
        txtAlumnoGeneracion = (TextView) layoutFragment.findViewById(R.id.txtAlumnoGeneracion);
        txtAlumnoId = (TextView) layoutFragment.findViewById(R.id.txtAlumnoId);
        txtAlumnoMatricula = (TextView) layoutFragment.findViewById(R.id.txtAlumnoMatricula);
        txtAlumnoNombre = (TextView) layoutFragment.findViewById(R.id.txtAlumnoNombre);
        imgvAlumnoFoto = (ImageView) layoutFragment.findViewById(R.id.imgvAlumnoFoto);

        controladorClient = new ControladorClient(getContext());

        return layoutFragment;
    }
}