package client.hatwo.mx.hatwoclient.model;

/**
 * Created by Pattyntel on 02/11/2016.
 */
public class Proveedor {
    private int id_prov;
    private int servicio_id;
    private String name_prov;
    private String apPaterno_prov;
    private String apMaterno_prov;
    private String email_prov;
    private String password_prov;
    private String phone_prov;
    private String address_prov;
    private String photo_prov;
    private int arrivalTime_prov;
    private int rate_prov;

    public Proveedor(){

    }

    public Proveedor (int id_prov, int servicio_id, String name_prov, String apPaterno_prov,
                      String apMaterno_prov, String email_prov, String password_prov,
                      String phone_prov, String address_prov, String photo_prov,
                      int arrivalTime_prov, int rate_prov){
        this.id_prov = id_prov;
        this.servicio_id = servicio_id;
        this.name_prov = name_prov;
        this.apPaterno_prov = apPaterno_prov;
        this.apMaterno_prov = apMaterno_prov;
        this.email_prov = email_prov;
        this.password_prov = password_prov;
        this.phone_prov = phone_prov;
        this.address_prov = address_prov;
        this.photo_prov = photo_prov;
        this.arrivalTime_prov = arrivalTime_prov;
        this.rate_prov = rate_prov;
    }

    public int getId_prov() {
        return id_prov;
    }

    public void setId_prov(int id_prov) {
        this.id_prov = id_prov;
    }

    public int getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(int servicio_id) {
        this.servicio_id = servicio_id;
    }

    public String getName_prov() {
        return name_prov;
    }

    public void setName_prov(String name_prov) {
        this.name_prov = name_prov;
    }

    public String getApPaterno_prov() {
        return apPaterno_prov;
    }

    public void setApPaterno_prov(String apPaterno_prov) {
        this.apPaterno_prov = apPaterno_prov;
    }

    public String getApMaterno_prov() {
        return apMaterno_prov;
    }

    public void setApMaterno_prov(String apMaterno_prov) {
        this.apMaterno_prov = apMaterno_prov;
    }

    public String getEmail_prov() {
        return email_prov;
    }

    public void setEmail_prov(String email_prov) {
        this.email_prov = email_prov;
    }

    public String getPassword_prov() {
        return password_prov;
    }

    public void setPassword_prov(String password_prov) {
        this.password_prov = password_prov;
    }

    public String getPhone_prov() {
        return phone_prov;
    }

    public void setPhone_prov(String phone_prov) {
        this.phone_prov = phone_prov;
    }

    public String getAddress_prov() {
        return address_prov;
    }

    public void setAddress_prov(String address_prov) {
        this.address_prov = address_prov;
    }

    public String getPhoto_prov() {
        return photo_prov;
    }

    public void setPhoto_prov(String photo_prov) {
        this.photo_prov = photo_prov;
    }

    public int getArrivalTime_prov() {
        return arrivalTime_prov;
    }

    public void setArrivalTime_prov(int arrivalTime_prov) {
        this.arrivalTime_prov = arrivalTime_prov;
    }

    public int getRate_prov() {
        return rate_prov;
    }

    public void setRate_prov(int rate_prov) {
        this.rate_prov = rate_prov;
    }
}
