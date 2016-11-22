package client.hatwo.mx.hatwoclient.Activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import client.hatwo.mx.hatwoclient.Activities.components.AdapterService2;
import client.hatwo.mx.hatwoclient.R;
import client.hatwo.mx.hatwoclient.core.ControladorService;

/**
 * Created by Pattyntel on 22/11/2016.
 */
public class ActivityListServices2 extends AppCompatActivity {


    private RecyclerView rclvServices;
    private LinearLayoutManager lManager;
    private CollapsingToolbarLayout collapser;

    AdapterService2 adapterService;
    ControladorService controladorService;

    RecyclerView.LayoutManager myLayoutManager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_services2);
        inicializarComponentes();
    }

    private void inicializarComponentes() {

        rclvServices = (RecyclerView) findViewById(R.id.rclv_services);

        myLayoutManager = new LinearLayoutManager(this);
        rclvServices.setLayoutManager(myLayoutManager);

        controladorService = new ControladorService();
        adapterService = new AdapterService2(controladorService.getServicios());
        rclvServices.setAdapter(adapterService);

        //Añadir un toolbar
        toolbar = (Toolbar) findViewById(R.id.tlb_service);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_search:
                showSnackBar("Comenzar a buscar...");
                return true;
            case R.id.action_settings:
                showSnackBar("Se abren los ajustes");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Proyecta una {@link Snackbar} con el string usado
     *
     * @param msg Mensaje
     */
    private void showSnackBar(String msg) {
        Snackbar
                .make(findViewById(R.id.coordinator), msg, Snackbar.LENGTH_LONG)
                .show();
    }


/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
*/

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
