package client.hatwo.mx.hatwoclient.Activities.components;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import client.hatwo.mx.hatwoclient.R;
import client.hatwo.mx.hatwoclient.Activities.components.AdapterService;
/**
 * Created by Pattyntel on 02/11/2016.
 */
public class ViewHolderService extends RecyclerView.ViewHolder
        implements View.OnClickListener {
    protected ImageView imgvRowServicioImg;
    protected TextView lblRowServicioId, lblRowServicioNombre;
    public ItemClickListener listener;


       public ViewHolderService(View itemView, ItemClickListener listener) {
        super(itemView);
           imgvRowServicioImg = (ImageView) itemView.findViewById(R.id.imgv_row_servicio_img);
           lblRowServicioId = (TextView) itemView.findViewById(R.id.lbl_row_servicio_id);
           lblRowServicioNombre = (TextView) itemView.findViewById(R.id.lbl_row_servicio_nombre);
           this.listener = listener;
           itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        listener.onItemClick(v, getAdapterPosition());
    }

}
