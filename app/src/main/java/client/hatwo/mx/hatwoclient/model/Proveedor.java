package client.hatwo.mx.hatwoclient.model;

/**
 * Created by Pattyntel on 02/11/2016.
 */
public class Proveedor {
    private int id;
    private String name_prov;
    private String email_prov;
    private String password_prov;
    private String phone_prov;
    private String address_prov;


    public Proveedor(){

    }

    public Proveedor (int id, String name_prov, String email_prov, String password_prov,
                         String phone_prov, String address_prov){
        this.id=id;
        this.name_prov=name_prov;
        this.email_prov=email_prov;
        this.password_prov=password_prov;
        this.phone_prov=phone_prov;
        this.address_prov=address_prov;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_prov() {
        return name_prov;
    }

    public void setName_prov(String name_prov) {
        this.name_prov = name_prov;
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
}
