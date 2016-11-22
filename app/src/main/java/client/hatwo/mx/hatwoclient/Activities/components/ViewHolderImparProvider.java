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
public class ViewHolderImparProvider extends RecyclerView.ViewHolder
{
    protected ImageView imgvRowImparProviderFoto;
    protected TextView lblRowImparProviderId, lblRowImparProviderNombre;
//    protected TextView lblRowImparProviderTiempoLlegada;
//    protected RatingBar ratRowImparProviderCalif;

    public ViewHolderImparProvider(View itemView) {
        super(itemView);
        imgvRowImparProviderFoto = (ImageView) itemView.findViewById(R.id.imgv_row_impar_photo_provider);
        lblRowImparProviderId = (TextView) itemView.findViewById(R.id.lbl_row_impar_provider_id);
        lblRowImparProviderNombre = (TextView) itemView.findViewById(R.id.lbl_row_impar_provider_nombre);
//        lblRowImparTiempoLlegadaProvider = (TextView) itemView.findViewById(R.id.lbl_row_impar_tiempo_llegada_provider);
//        ratRowImparCalifProvider = (RatingBar) itemView.findViewById(R.id.rat_row_impar_calif_provider);
    }
}
