package client.hatwo.mx.hatwoclient.gui.components;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import client.hatwo.mx.hatwoclient.R;
/**
 * Created by Pattyntel on 02/11/2016.
 */
public class ViewHolderService extends RecyclerView.ViewHolder
{
    protected ImageView imgvRowServicioImg;
    protected TextView lblRowServicioId, lblRowServicioNombre;


       public ViewHolderService(View itemView) {
        super(itemView);
           imgvRowServicioImg = (ImageView) itemView.findViewById(R.id.imgv_row_servicio_img);
           lblRowServicioId = (TextView) itemView.findViewById(R.id.lbl_row_servicio_id);
           lblRowServicioNombre = (TextView) itemView.findViewById(R.id.lbl_row_servicio_nombre);
    }

}
