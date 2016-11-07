package client.hatwo.mx.hatwoclient.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import client.hatwo.mx.hatwoclient.R;
import client.hatwo.mx.hatwoclient.core.ControladorService;
import client.hatwo.mx.hatwoclient.Activities.components.AdapterService;

/**
 * Created by Pattyntel on 02/11/2016.
 */
public class ActivityListServices extends AppCompatActivity
{
    EditText txtServicio;
    Button btnBuscarServicio;
    RecyclerView rclvServicios;

    ControladorService controladorServicio;
    AdapterService adapterServicio;

    RecyclerView.LayoutManager myLayoutManager;
    Toolbar toolbar;

    private MenuItem mSearchAction;
    private boolean isSearchOpened = false;
    private EditText editSearch;

//    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_services);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inicializarComponentes();
    }

    private void inicializarComponentes()
    {
        txtServicio = (EditText) findViewById(R.id.txt_servicio);
        btnBuscarServicio = (Button) findViewById(R.id.btn_buscar_servicio);

        // Obtener el Recycler
        rclvServicios = (RecyclerView) findViewById(R.id.rclv_servicios);

        // Usar un administrador para LinearLayout
        myLayoutManager = new LinearLayoutManager(this);
        rclvServicios.setLayoutManager(myLayoutManager);

        // Crear un nuevo adaptador
        controladorServicio = new ControladorService();
        adapterServicio = new AdapterService(controladorServicio.getServicios());
        rclvServicios.setAdapter(adapterServicio);

        //Añadir un toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

     //  adapter = a

        btnBuscarServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarService();
            }
        });
    }

    /**
     * Este método lo invicamos cuando el usuario pulsa el botón "Buscar"
     */
    private void buscarService()
    {
        String mat = txtServicio.getText().toString();
       // Intent intent = new Intent(this, ActivityDatosService.class);
       // intent.putExtra("matricula", mat);
        // startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        //return true;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
  //      MenuItem item = menu.findItem(R.id.action_search);
   /*     SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
  //              adapter.getFilter().filter(newText);

                return false;
            }
        });*/
        return super.onCreateOptionsMenu(menu);
    }





}

