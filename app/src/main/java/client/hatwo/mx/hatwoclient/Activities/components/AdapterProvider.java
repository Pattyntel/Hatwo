package client.hatwo.mx.hatwoclient.Activities.components;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import client.hatwo.mx.hatwoclient.R;
import client.hatwo.mx.hatwoclient.model.Proveedor;
import client.hatwo.mx.hatwoclient.core.CodificadorImagenes;
import java.util.List;

/**
 * Created by Pattyntel on 09/11/2016.
 */
public class AdapterProvider extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    Context context; //Necesitaremos el context para ubicar diferentes recursos de la Applicación.
    List<Proveedor> proveedores; //La lista que contiene los datos a desplegar.

    int renglon;

    public AdapterProvider(List<Proveedor> proveedores)
    {
        this.proveedores = proveedores;
        renglon = -1;
    }

    @Override
    public int getItemViewType(int position) {
        // Devuelve 0 o 2 dependiendo de la posicion
        return position % 2;
    }

    /**
     * Este método se indicará cuando el RecyclerView necesite de un ViewHolder para mostrar
     * un determinado elemento.
     *
     * @param parent    Representa la vista "padre" a la que se va a agregar la nueva vista que
     *                  contendrá los datos que serán desplegados en la lista.
     * @param viewType  Este valor de tipo int nos sirve para poder dar al RecyclerView
     *                  diferentes vistas, dependiendo de este valor.
     *
     * @return          Este método devolverá el ViewHolder que necesita el RecyclerView para
     *                  desplegar los datos.
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = null;
        RecyclerView.ViewHolder vh = null;
        if(viewType==0) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_par_provider, parent, false);
            vh = new ViewHolderParProvider(v);
          v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("info", "Seleccionaste un registro: " + renglon);
                }
            });
        }
        else {

            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_impar_provider, parent, false);
            vh = new ViewHolderImparProvider(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("info", "Seleccionaste un registro: " + renglon);
                }
            });
        }
        this.context = parent.getContext();
        return vh;
    }


    /**
     * Este método es invocado por el RecyclerView para desplegar datos en una posición específica.
     * @param holder    El ViewHolder que será desplegado en una posicion específica.
     * @param position  La posición del objeto dentro del dataset. En este caso, la posición del
     *                  proveedor dentro de la lista de proveedores.
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        Proveedor a = proveedores.get(position);
        ViewHolderParProvider vpa = null;
        ViewHolderImparProvider via = null;
        Drawable drw = null;

        if(a.getPhoto_prov() != null && !a.getPhoto_prov().isEmpty())
        {
            try
            {
                drw = CodificadorImagenes.decodificar(a.getPhoto_prov());
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if(position %2 == 0) {
            vpa = (ViewHolderParProvider) holder;
            if (drw != null)
                vpa.imgvRowParProviderFoto.setImageDrawable(drw);
            //no funciona con el Id no se por que
        //    vpa.lblRowParProviderId.setText(a.getId_prov());
            vpa.lblRowParProviderNombre.setText(a.getName_prov());
 //           vpa.lblRowParTiempoLlegadaProvider.setText(a.getArrivalTime_prov());
 //           vpa.ratRowParCalifProvider.setRating(a.getRate_prov());

        }
        else
        {
            via = (ViewHolderImparProvider) holder;
            if (drw != null)
                via.imgvRowImparProviderFoto.setImageDrawable(drw);
            //no funciona con el Id no se por que
//            via.lblRowImparProviderId.setText(a.getId_prov());
            via.lblRowImparProviderNombre.setText(a.getName_prov());
//            via.lblRowImparTiempoLlegadaProvider.setText(a.getArrivalTime_prov());
//            via.ratRowImparCalifProvider.setRating(a.getRate_prov());
        }

        renglon = position;
    }

    /**
     * El RecyclerView necesita saber cuantos items debe desplegar, así que invocará a este
     * método para conocer el dato.
     * @return
     */
    @Override
    public int getItemCount()
    {
        return proveedores.size();
    }
}

