package client.hatwo.mx.hatwoclient.core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import client.hatwo.mx.hatwoclient.model.Proveedor;

/**
 * Created by Pattyntel on 09/11/2016.
 */
public class ControladorProvider {
    List<Proveedor> proveedores;

    String foto = "iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAABHNCSVQICAgIfAhkiAAAAAlwSFlz\n" +
            "AAALEwAACxMBAJqcGAAABfRJREFUeJztm2uMXGUZx3/Pc2bbZXd2t4td2UZDjEUujTWiiQleICYW\n" +
            "TDAagW4IcbdbiTaszLY08YOpqbTGEBSh3V2raYLbcdXAFEMin4TYlFuMMSFqarDUW9JIKa0L3dnL\n" +
            "zM6c5/HD7jSzMBTafc8MDfP79M455/3P//zP7T3POwNNmjR5LyON+NL24V9flpLiNTjvw9TjyE9j\n" +
            "8YvTo3eeqreXugXQPZy9vIx/U/CNoFfW3MjsRVc5WI7YP/fQ4H/r4SvxAC7NTHSWsd0IQ0DLO+pk\n" +
            "No/I6Mq47d5T+/qmk/SXaABdwwc+GZs8psqHAMyYFPGcujxlzhFZMX8awK21Ry1eby4bHPpUWQVg\n" +
            "bv9IeXTb62MDf0nKY2IBdGUOfD52f0JV281sBo12dxTmxk7s3zJ7rn49Q7l0MTU7jPl3Ub3EjDyR\n" +
            "f2l67+AzSfhMJICuTPba2O1ZVW3H/Ki7fDn/k00vnY9GOjOxDrHfKqw1I+8qn54ZGTgS2mvwAHqG\n" +
            "cum51NyfFdaCvRTPR5+b+dnAqxei1TY03quqz6vyYcyPts8XP/F2Z9D5oiHFAIqp2Z0KazGbM+Mr\n" +
            "F7rzALP7Nr+SUv8qUETlqunW1u8EtAoEDqBtaLwXJLOgrPdNj23++3I1Xx8Z/KvjDwA4bE9v/9Xq\n" +
            "5WpWEzSAVEq+DrSakU+57g2lK1HpQczmFNqkVB4IpQuBAzDnVgAVHp8c7Z8KpTv10DcmXfUJAMFu\n" +
            "C6ULAQPoGcqlVfxaABcOhdKtoPjvARA+xabx1nC6gZhfUbwSVAAk5m+hdCvE5ouaGrV3y9pQuuEu\n" +
            "ASt3V5oi8r9guotEKoVKO2XeG0o3XAAudradKgUfX8QiZ5//TtQTSjdYAGWz05W2xS3BjlCFqOqo\n" +
            "e+wvhNINFsDMtBzDrAwg4h8LpVvBhIpmIV8q/DuUbrhLILu5gMofAHC/KZjuIoLcBODYc+zfUgql\n" +
            "G3Yo7PooACI3t22bWBNKtns4eznYjQBO9EgoXQg9EkQmDHsNaIks3hFKN3bfCRoBp9pbePcGMDna\n" +
            "PyXoDwDE5K50JnvDcjU7MwduROTOhU++++SPB2aWq1lN8LfBfKEwgtkfUVTdHktvzV5zoVrt3/r5\n" +
            "ehNfOOJmz02daPtpMKOLBA+A/VtKkWof8DKqq9Xt2a67s184X5nOzPgXRaJnFO1253ipRW7nYF8c\n" +
            "2m5iJbF0ZmKduj2J8gEAnHFx+f6ZsYFzPsI67/nFFZT9ewhfA3DnOKob8nv7jybhM9Gi6KWZiQ+W\n" +
            "xR4BPrOwxNzRw+L+lKNHUF7FYkHl/WKyHrENwPWVdwp3DseR3jG7p/9EUh6TnxfYmIs618xtwXwn\n" +
            "Kpe9w14vi3DvmVX/ephdu+ztN79w6jczdM+jl3TEc7cK9BlyvUJX9WrDXlOXp3FyU3l/nOzmwltJ\n" +
            "haQhU2Pg0rbtl71SKq0mSrmX49Oz+wZPgni9nZwzgI6t2evE/S6Q/qrFxYQ9LRvDSmocd5VDbj52\n" +
            "rtpk7QA25qKO3pkRER1KzGW9MCubRjumR/p/VOsMS9Xqk+6d21O18887/hvABCmayCtJ+g2Bmq0A\n" +
            "+Qjid6C6TvH7OzJZy4/ywBu3fdMZkM5kb1DhMIDj2/Ijm0YacW0GYWMu6lwz80PQ7ZiV45R8fGbP\n" +
            "4JJyXY2RoO8AcMjlRwb3XrQ7D3CwL57q/s+3wZ5GNSUmb3pBWxJAOvNwj4ovDFtFHqyTzWTZtcvc\n" +
            "5H4AhVt6hnLp6tVLzwCJPgsqhk3lV/3zT3W0mSh5OXMIs3lgZTFVuK563ZIA1Ll6sXUs6RFYXRnd\n" +
            "WkT0GIBjH61e9YZ7gFSqrcHL2o3GYfH3R0uH40sCcPEVAGperpexeuHCPIA4S2aVatcD9CK+878V\n" +
            "bjX3KXxB5CKjGUCjDTSaZgCNNtBomgE02kCjaQbQaAONphlAow00mmYAjTbQaN7zAdQsiwM3p+8e\n" +
            "T/SvKvVGRdtrLV8SgJytmoBq7Q4XP36y+tOSAKa62+7rmCy8oNjK+pqqDyZSyBeLv2u0jyZNmrx7\n" +
            "+D/xICpSyjvCwQAAAABJRU5ErkJggg==";
    /**
     * Creamos un objeto de tipo ControladorProveedor.
     */
    public ControladorProvider()
    {
        proveedores = new ArrayList<>();
        crearProveedoresEnMemoria();
    }

    /**
     * Genera una lista en memoria con objetos de tipo
     * Proveedor
     */
    private void crearProveedoresEnMemoria()
    {
    //    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Proveedor aTemp = new Proveedor();

        try
        {
            aTemp.setId_prov(1);
            aTemp.setServicio_id(1);
            aTemp.setName_prov("Manuel");
            aTemp.setApPaterno_prov("Miranda");
            aTemp.setApMaterno_prov("Ramos");
            //aTemp.setFechaNacimiento(sdf.parse("10/05/1987"));
            aTemp.setEmail_prov("manuel@gmail.com");
            aTemp.setPassword_prov("123456");
            aTemp.setPhone_prov("477-183-54-35");
            aTemp.setAddress_prov("Calle tal");
            aTemp.setPhoto_prov(foto);
            proveedores.add(aTemp);

            aTemp = new Proveedor();
            aTemp.setId_prov(2);
            aTemp.setServicio_id(1);
            aTemp.setName_prov("Manuel");
            aTemp.setApPaterno_prov("Miranda");
            aTemp.setApMaterno_prov("Ramos");
            //aTemp.setFechaNacimiento(sdf.parse("10/05/1987"));
            aTemp.setEmail_prov("manuel@gmail.com");
            aTemp.setPassword_prov("123456");
            aTemp.setPhone_prov("477-183-54-35");
            aTemp.setAddress_prov("Calle tal");
            aTemp.setPhoto_prov(foto);
            proveedores.add(aTemp);

            aTemp = new Proveedor();
            aTemp.setId_prov(3);
            aTemp.setServicio_id(2);
            aTemp.setName_prov("Manuel");
            aTemp.setApPaterno_prov("Miranda");
            aTemp.setApMaterno_prov("Ramos");
            //aTemp.setFechaNacimiento(sdf.parse("10/05/1987"));
            aTemp.setEmail_prov("manuel@gmail.com");
            aTemp.setPassword_prov("123456");
            aTemp.setPhone_prov("477-183-54-35");
            aTemp.setAddress_prov("Calle tal");
            aTemp.setPhoto_prov(foto);
            proveedores.add(aTemp);

            aTemp = new Proveedor();
            aTemp.setId_prov(4);
            aTemp.setServicio_id(2);
            aTemp.setName_prov("Manuel");
            aTemp.setApPaterno_prov("Miranda");
            aTemp.setApMaterno_prov("Ramos");
            //aTemp.setFechaNacimiento(sdf.parse("10/05/1987"));
            aTemp.setEmail_prov("manuel@gmail.com");
            aTemp.setPassword_prov("123456");
            aTemp.setPhone_prov("477-183-54-35");
            aTemp.setAddress_prov("Calle tal");
            aTemp.setPhoto_prov(foto);
            proveedores.add(aTemp);

            aTemp = new Proveedor();
            aTemp.setId_prov(5);
            aTemp.setServicio_id(2);
            aTemp.setName_prov("Manuel");
            aTemp.setApPaterno_prov("Miranda");
            aTemp.setApMaterno_prov("Ramos");
            //aTemp.setFechaNacimiento(sdf.parse("10/05/1987"));
            aTemp.setEmail_prov("manuel@gmail.com");
            aTemp.setPassword_prov("123456");
            aTemp.setPhone_prov("477-183-54-35");
            aTemp.setAddress_prov("Calle tal");
            aTemp.setPhoto_prov(foto);
            proveedores.add(aTemp);

            aTemp = new Proveedor();
            aTemp.setId_prov(6);
            aTemp.setServicio_id(3);
            aTemp.setName_prov("Manuel");
            aTemp.setApPaterno_prov("Miranda");
            aTemp.setApMaterno_prov("Ramos");
            //aTemp.setFechaNacimiento(sdf.parse("10/05/1987"));
            aTemp.setEmail_prov("manuel@gmail.com");
            aTemp.setPassword_prov("123456");
            aTemp.setPhone_prov("477-183-54-35");
            aTemp.setAddress_prov("Calle tal");
            aTemp.setPhoto_prov(foto);
            proveedores.add(aTemp);

            aTemp = new Proveedor();
            aTemp.setId_prov(7);
            aTemp.setServicio_id(4);
            aTemp.setName_prov("Manuel");
            aTemp.setApPaterno_prov("Miranda");
            aTemp.setApMaterno_prov("Ramos");
            //aTemp.setFechaNacimiento(sdf.parse("10/05/1987"));
            aTemp.setEmail_prov("manuel@gmail.com");
            aTemp.setPassword_prov("123456");
            aTemp.setPhone_prov("477-183-54-35");
            aTemp.setAddress_prov("Calle tal");
            aTemp.setPhoto_prov(foto);
            proveedores.add(aTemp);


            aTemp = new Proveedor();
            aTemp.setId_prov(8);
            aTemp.setServicio_id(4);
            aTemp.setName_prov("Manuel");
            aTemp.setApPaterno_prov("Miranda");
            aTemp.setApMaterno_prov("Ramos");
            //aTemp.setFechaNacimiento(sdf.parse("10/05/1987"));
            aTemp.setEmail_prov("manuel@gmail.com");
            aTemp.setPassword_prov("123456");
            aTemp.setPhone_prov("477-183-54-35");
            aTemp.setAddress_prov("Calle tal");
            aTemp.setPhoto_prov(foto);
            proveedores.add(aTemp);

            aTemp = new Proveedor();
            aTemp.setId_prov(9);
            aTemp.setServicio_id(4);
            aTemp.setName_prov("Manuel");
            aTemp.setApPaterno_prov("Miranda");
            aTemp.setApMaterno_prov("Ramos");
            //aTemp.setFechaNacimiento(sdf.parse("10/05/1987"));
            aTemp.setEmail_prov("manuel@gmail.com");
            aTemp.setPassword_prov("123456");
            aTemp.setPhone_prov("477-183-54-35");
            aTemp.setAddress_prov("Calle tal");
            aTemp.setPhoto_prov(foto);
            proveedores.add(aTemp);

            aTemp = new Proveedor();
            aTemp.setId_prov(10);
            aTemp.setServicio_id(4);
            aTemp.setName_prov("Manuel");
            aTemp.setApPaterno_prov("Miranda");
            aTemp.setApMaterno_prov("Ramos");
            //aTemp.setFechaNacimiento(sdf.parse("10/05/1987"));
            aTemp.setEmail_prov("manuel@gmail.com");
            aTemp.setPassword_prov("123456");
            aTemp.setPhone_prov("477-183-54-35");
            aTemp.setAddress_prov("Calle tal");
            aTemp.setPhoto_prov(foto);
            proveedores.add(aTemp);

        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }

    }

    /**
     * Devuelve la lista de Proveedores actual.
     * @return
     */
    public List<Proveedor> getProveedores()
    {
        return proveedores;
    }

    /**
     * Busca un Proveedor por su matrícula y devuelve
     * todos sus datos.
     * @param servicio_id La categoria del servicio del Proveedor a buscar.
     * @return  Un objeto de tipo Proveedor si éste es encontrado.
     *          Si no se encuentra el Proveedor, se devolverá <code></code><i>null</i></code>.
     */
    public List<Proveedor> buscar(int servicio_id)
    {
        for (Proveedor a : proveedores)
            if (a.getServicio_id() == (servicio_id)) {
                proveedores.add(a);
                return proveedores;
            }
        return null;
    }

}

