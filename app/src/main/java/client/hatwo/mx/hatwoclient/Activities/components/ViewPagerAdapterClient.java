package client.hatwo.mx.hatwoclient.Activities.components;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import client.hatwo.mx.hatwoclient.Activities.FragmentAddressClient;
import client.hatwo.mx.hatwoclient.Activities.FragmentGeneralClient;
import client.hatwo.mx.hatwoclient.Activities.FragmentWayPayClient;
//import client.hatwo.mx.hatwoclient.Activities.FragmentWayPayClient;

/**
 * Created by Pattyntel on 06/11/2016.
 */
public class ViewPagerAdapterClient extends FragmentPagerAdapter {
    FragmentManager fragmentManager;

    FragmentGeneralClient fragmentGeneralClient;
    FragmentAddressClient fragmentAddressClient;
    FragmentWayPayClient fragmentWayPayClient;

    public ViewPagerAdapterClient(FragmentManager fragmentManager)
    {
        super(fragmentManager);
        this.fragmentManager = fragmentManager;
        inicializar();
    }

    private void inicializar()
    {
        fragmentGeneralClient = new FragmentGeneralClient();
        fragmentAddressClient = new FragmentAddressClient();
        fragmentWayPayClient = new FragmentWayPayClient();
    }


    public FragmentGeneralClient getFragmentGeneralClient()
    {
        return fragmentGeneralClient;
    }

    public FragmentAddressClient getFragmentAddressClient()
    {
        return fragmentAddressClient;
    }

   public FragmentWayPayClient getFragmentWayPayClient()
    {
        return fragmentWayPayClient;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0 : return fragmentGeneralClient;
            case 1 : return fragmentAddressClient;
            case 2 : return fragmentWayPayClient;
            default : return null;
        }
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        //Regresamos 3, porque ahorita solo tenemos 3 tabs:
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //Si se quiere asignar un titulo al tab, dependiendo de la posición.
        // Regresamos null para desplegar únicamente el ícono.
    /*    switch (position)
        {
            case 0 : "Datos Generales";
            case 1 : "Dirección";
            case 2 : "Forma de Pago";
            default : return null;
        }   */
        return null;

    }
}
