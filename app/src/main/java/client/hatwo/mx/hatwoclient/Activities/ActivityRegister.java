package client.hatwo.mx.hatwoclient.Activities;

/**
 * Created by Pattyntel on 01/11/2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.HashMap;

import client.hatwo.mx.hatwoclient.Activities.components.ViewPagerAdapterClient;
import client.hatwo.mx.hatwoclient.R;


public class ActivityRegister extends AppCompatActivity
{
    public static HashMap<String, Object> GLOBALS = new HashMap<>();
//    private MenuInflater inflater;

    Toolbar tlbRegister;
    TabLayout tabLayout;
    ViewPager viewPagerClient;

    ViewPagerAdapterClient vpac;
    MenuInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        inicializarComponentes();
    }

    private void inicializarComponentes(){

        GLOBALS.put("app", this);

        tlbRegister = (Toolbar) findViewById(R.id.tlb_register);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout_register);
        viewPagerClient = (ViewPager) findViewById(R.id.view_pager_client);

        //ViewPager se le asigna el cordinador
        vpac = new ViewPagerAdapterClient(getSupportFragmentManager());
        viewPagerClient.setAdapter(vpac);

        setSupportActionBar(tlbRegister);

        //Te permite que funcione el gesto horizontal para cambiarte de fragment
        //Es decir esta configurando el tabLayout como ViewPager
        tabLayout.setupWithViewPager(viewPagerClient);

        //Los iconos de la tab se agregan por codigo no por diseño
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_perm_identity_white_18dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_home_white_18dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_credit_card_white_18dp);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {

            //es para que se cargue la primera vez los datos de la primera tab, si no se pone no
            //se va
            //si no se utiliza el viewpager se deben validar todos los tabs
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                if (tab.getPosition() == 0)
                {
                    try
                    {
                        vpac.getFragmentGeneralClient().actualizar();
                        Log.i("info","onTabSelect aqui");
                     // aqui va el codigo de limpiar o actualizar que no se ha hecho en FragmentGeneralClient
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                        mostrarMensaje("Error al actualizar listado de alumnos.", Snackbar.LENGTH_LONG);
                    }
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });

    }

    /**
     * Muestra un mensaje a través de un "SnackBar".
     * @param mensaje
     */
    public void mostrarMensaje(String mensaje, int length)
    {
        Snackbar.make(findViewById(android.R.id.content), mensaje, length)
                .show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        //return true;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_register, menu);
        //     MenuItem item = menu.findItem(R.id.action_save);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_guardar:
                Log.i("ActionBar", "Nuevo!");
                //FragmentGeneralClient.submitForm();
                //Validar todos los campos
                    Intent intent = new Intent(this, ActivityMain.class);
                    startActivity(intent);
                return true;

            case R.id.action_settings:
                Log.i("ActionBar", "Settings!");;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




}

