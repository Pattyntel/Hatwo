package client.hatwo.mx.hatwoclient.Activities.components;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import client.hatwo.mx.hatwoclient.Activities.ViewHolderService2;
import client.hatwo.mx.hatwoclient.R;
import client.hatwo.mx.hatwoclient.core.CodificadorImagenes;
import client.hatwo.mx.hatwoclient.model.Servicio;

/**
 * Created by Pattyntel on 22/11/2016.
 */
public class AdapterService2 extends RecyclerView.Adapter<RecyclerView.ViewHolder>

{

    Context context; //Necesitaremos el context para ubicar diferentes recursos de la Applicación.
    List<Servicio> servicios; //La lista que contiene los datos a desplegar.

    int renglon;

    public AdapterService2(List<Servicio> servicios)
    {
        this.servicios = servicios;
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

            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_service, parent, false);
            vh = new ViewHolderService2(v);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("info", "Seleccionaste un registro: " + renglon);
                }
            });

        this.context = parent.getContext();
        return vh;
    }


    /**
     * Este método es invocado por el RecyclerView para desplegar datos en una posición específica.
     * @param holder    El ViewHolder que será desplegado en una posicion específica.
     * @param position  La posición del objeto dentro del dataset. En este caso, la posición del
     *                  servicio dentro de la lista de servicios.
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        Servicio a = servicios.get(position);


        String rutaFoto;
        int idFoto;

        ViewHolderService2 vhs = (ViewHolderService2) holder;

        rutaFoto = "@drawable/ctoolx36_" + a.getId();
        idFoto = context.getResources().getIdentifier(rutaFoto, null, context.getPackageName());

        vhs.imgvRowServicioImg.setImageDrawable(context.getResources().getDrawable(idFoto));

        vhs.lblRowServicioNombre.setText(a.getServicio());
        renglon = position;
       //Log.i("Renglo:", renglon);
        //vhs.lblRowServicioNombre.setText(renglon);



    }

    /**
     * El RecyclerView necesita saber cuantos items debe desplegar, así que invocará a este
     * método para conocer el dato.
     * @return
     */
    @Override
    public int getItemCount()
    {
        return servicios.size();
    }
}
