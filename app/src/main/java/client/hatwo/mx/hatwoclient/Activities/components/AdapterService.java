package client.hatwo.mx.hatwoclient.Activities.components;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import client.hatwo.mx.hatwoclient.Activities.ActivityListProvidersNear;
import client.hatwo.mx.hatwoclient.Activities.ActivityListServices;
import client.hatwo.mx.hatwoclient.R;
import client.hatwo.mx.hatwoclient.model.Servicio;

/**
 * Created by Pattyntel on 02/11/2016.
 */
public class AdapterService extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements ItemClickListener {

    private Context context; //Necesitaremos el context para ubicar diferentes recursos de la Applicación.
    private List<Servicio> servicios; //La lista que contiene los datos a desplegar.

    public AdapterService(List<Servicio> servicios)
    {
        this.servicios = servicios;
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

        View v;
        RecyclerView.ViewHolder vh;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_service, parent, false);
        vh = new ViewHolderService(v,this);
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

        ViewHolderService vhs = (ViewHolderService) holder;

                rutaFoto = "@drawable/ctoolx36_" + a.getId();
                idFoto = context.getResources().getIdentifier(rutaFoto, null, context.getPackageName());

                vhs.imgvRowServicioImg.setImageDrawable(context.getResources().getDrawable(idFoto));

    //Para mostrar la imagen redonda---Investigar despues
    /*    Glide.with(holder.avatar.getContext())
                .load(currentItem.getIdDrawable())
                .centerCrop()
                .into(holder.avatar);*/

        //no funciona con el Id no se por que
                //vhs.lblRowServicioId.setText(a.getId());
                vhs.lblRowServicioNombre.setText(a.getServicio());

    }

    /**
     * Sobrescritura del método de la interfaz {@link ItemClickListener}
     *
     * @param view     item actual
     * @param position posición del item actual
     */
    @Override
    public void onItemClick(View view, int position) {
        //ActivityListProvidersNear.createInstance(
        //        (Activity) context, servicios.get(position));

        //Agregar servicio que mande solo el listado de los proveedores mas cercanos al cliente
        //Solo se abre un listado provisional

       // Intent intent = new Intent(AdapterService.this, ActivityListProvidersNear.class);
       // startActivity(intent);
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

interface ItemClickListener {
    void onItemClick(View view, int position);
}
