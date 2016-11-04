package client.hatwo.mx.hatwoclient.model;

/**
 * Created by Pattyntel on 02/11/2016.
 */
public class Servicio {
    //Los datos del servicio:
    private int id;
    private String servicio;

    public Servicio(){

    }

    public Servicio(int id, String servicio){
        this.id =id;
        this.servicio=servicio;
    }

    //Getters y Setters:
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
}

