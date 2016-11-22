package client.hatwo.mx.hatwoclient.Activities.components;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import client.hatwo.mx.hatwoclient.R;

/**
 * Created by Pattyntel on 09/11/2016.
 */
public class ViewHolderParProvider extends RecyclerView.ViewHolder
{
    public ImageView imgvRowParProviderFoto;
    public TextView lblRowParProviderId, lblRowParProviderNombre;
 //   protected TextView lblRowParProviderTiempoLlegada;
 //   protected RatingBar ratRowParProviderCalif;

    public ViewHolderParProvider(View itemView) {
        super(itemView);
        imgvRowParProviderFoto = (ImageView) itemView.findViewById(R.id.imgv_row_par_photo_provider);
        lblRowParProviderId = (TextView) itemView.findViewById(R.id.lbl_row_par_provider_id);
        lblRowParProviderNombre = (TextView) itemView.findViewById(R.id.lbl_row_par_provider_nombre);
    //    lblRowParTiempoLlegadaProvider = (TextView) itemView.findViewById(R.id.lbl_row_par_tiempo_llegada_provider);
    //    ratRowParCalifProvider = (RatingBar) itemView.findViewById(R.id.rat_row_par_calif_provider);
    }
}
