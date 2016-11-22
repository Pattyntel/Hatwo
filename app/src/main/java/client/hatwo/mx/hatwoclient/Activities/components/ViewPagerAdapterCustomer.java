package client.hatwo.mx.hatwoclient.Activities.components;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import client.hatwo.mx.hatwoclient.Activities.FragmentHistory;

/**
 * Created by Pattyntel on 08/11/2016.
 */
public class ViewPagerAdapterCustomer extends FragmentPagerAdapter {
    FragmentManager fragmentManager;

    FragmentHistory fragmentHistory;
//    FragmentAddressClient fragmentAddressClient;
//    FragmentWayPayClient fragmentWayPayClient;

    public ViewPagerAdapterCustomer(FragmentManager fragmentManager)
    {
        super(fragmentManager);
        this.fragmentManager = fragmentManager;
        inicializar();
    }

    private void inicializar()
    {
        fragmentHistory = new FragmentHistory();
//        fragmentAddressClient = new FragmentAddressClient();
//        fragmentWayPayClient = new FragmentWayPayClient();
    }


    public FragmentHistory getFragmentHistory()
    {
        return fragmentHistory;
    }

/*    public FragmentAddressClient getFragmentAddressClient()
    {
        return fragmentAddressClient;
    }
*/
/*    public FragmentWayPayClient getFragmentWayPayClient()
    {
        return fragmentWayPayClient;
    }
*/
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
            case 0 : return fragmentHistory;
//            case 1 : return fragmentAddressClient;
//            case 2 : return fragmentWayPayClient;
            default : return null;
        }
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        //Regresamos 3, porque ahorita solo tenemos 3 tabs:
        return 1;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //Si se quiere asignar un titulo al tab, dependiendo de la posición.
        // Regresamos null para desplegar únicamente el ícono.
/*      switch (position)
        {
            case 0 : getActivity().setTitle("Datos Generales");
                Log.i("Titulo","General");
                break;
            case 1 : "Dirección";
            case 2 : "Forma de Pago";
            default : return null;
        }   */
        Log.i("Titulos","Todos");
        return null;

    }
}
