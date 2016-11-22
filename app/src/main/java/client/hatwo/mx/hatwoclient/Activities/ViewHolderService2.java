package client.hatwo.mx.hatwoclient.Activities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import client.hatwo.mx.hatwoclient.R;

/**
 * Created by Pattyntel on 22/11/2016.
 */
public class ViewHolderService2 extends RecyclerView.ViewHolder
        //  implements View.OnClickListener
{
    public ImageView imgvRowServicioImg;
    public TextView lblRowServicioId, lblRowServicioNombre;

    public ViewHolderService2(View itemView) {
        super(itemView);
        imgvRowServicioImg = (ImageView) itemView.findViewById(R.id.imgv_row_servicio_img);
        lblRowServicioId = (TextView) itemView.findViewById(R.id.lbl_row_servicio_id);
        lblRowServicioNombre = (TextView) itemView.findViewById(R.id.lbl_row_servicio_nombre);

    }
}
