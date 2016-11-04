package client.hatwo.mx.hatwoclient.core;

import client.hatwo.mx.hatwoclient.model.Servicio;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pattyntel on 02/11/2016.
 */
public class ControladorService {
        List<Servicio> servicios;

        public ControladorService()
        {
            servicios = new ArrayList<>();
            crearServiciosEnMemoria();
        }

    private void crearServiciosEnMemoria(){
        Servicio aTemp = new Servicio();
        try
        {
            aTemp.setId(1);
            aTemp.setServicio("Albañiles");
            servicios.add(aTemp);

            aTemp = new Servicio();
            aTemp.setId(2);
            aTemp.setServicio("Carpinteros");
            servicios.add(aTemp);

            aTemp = new Servicio();
            aTemp.setId(3);
            aTemp.setServicio("Electricistas");
            servicios.add(aTemp);

            aTemp = new Servicio();
            aTemp.setId(4);
            aTemp.setServicio("Fontaneros");
            servicios.add(aTemp);

            aTemp = new Servicio();
            aTemp.setId(5);
            aTemp.setServicio("Herreros");
            servicios.add(aTemp);

            aTemp = new Servicio();
            aTemp.setId(6);
            aTemp.setServicio("Jardineros");
            servicios.add(aTemp);

            aTemp = new Servicio();
            aTemp.setId(7);
            aTemp.setServicio("Mecanicos");
            servicios.add(aTemp);

            aTemp = new Servicio();
            aTemp.setId(8);
            aTemp.setServicio("Pintores");
            servicios.add(aTemp);

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    public List<Servicio> getServicios(){
        return servicios;
    }

    public Servicio validarServicio(String servicio)
    {
        for (Servicio u: servicios)
 //           if (u.getServicio().equals(nomServicio))
                return u;
        return null;
    }

}

