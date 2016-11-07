package client.hatwo.mx.hatwoclient.configurations;

/**
 * Created by Pattyntel on 03/11/2016.
 */
public class Globals {
    /**
     * Constantes para el valor del modo en que este la app funcionando
     */
    public static int APP_SIN_SERVICIOS = 0;
    public static int APP_DESARROLLO = 1;
    public static int APP_PRODUCCION = 2;
    public static int APP_LOCAL = 3;
    public static int APP_OFFLINE = 4;



    /**
     * Constante para el control de la app, el modo en el cual este funcionando referiendonos a los socios
     * los valores de esta variable son enteros y su explicación son las variables
     * APPP_SIN_SERVICIOS =  la app no hace ninguna consulta a ningun servicio por lo tanto es posible navegar entre las actividades
     * APP_DESARROLLO = la app esta referenciada a socios que apuntan a desarrollo
     * APP_PRODUCCION = la app esta referenciada a socios que apuntan a produccion
     */
    public static int MODO_APP = APP_LOCAL;

    public static String PACKAGE = "helpme.casbe.mx.helpme";

    public static String LAYOUT_A_REGRESAR_EN_CASO_ERROR="login";

    public static String NOMBRE_USUARIO= "";
    public static String TOKEN = "";
    public static String USUARIO = "";
    public static String EMAIL = "";
    public static String TELEFONO =  "";
    public static String PAGO = "";
    public static String CANTIDAD = "";

    /**
     * Constantes para la conexión con los socios de producción
     */
    // private static String SERVER =  "http://server2012-7o7q8k0t.cloudapp.net";
    private static String SERVER = "http://helpme1.azurewebsites.net";
    private static String PORT =  "92";

    public static final String RUTA_SERVICIO_LOGIN = SERVER +  "/ServicioLogin.svc/loginUsuario";
    public static final String RUTA_SERVICIO_CONSULTAR_FACTURA = SERVER +  "/servicioFacturacion.svc/ConsultarFacturas";
    public static final String RUTA_SERVICIO_CONSULTA_FACTURA_MES = SERVER + "/servicioFacturacion.svc/ConsultarFacturaXfecha";
    public static final String RUTA_SERVICIO_CONSULTA_FACTURA_ID = SERVER + "/servicioFacturacion.svc/ConsultarFacturaXID";

    /**
     * Constantes para la conexión con los socios de desarrollo
     */
    private static String SERVER_DESARROLLO =  "http://10.50.1.119:";
    private static String PORT_DESARROLLO =  "92";

    public static final String RUTA_SERVICIO_LOGIN_DESARROLLO = SERVER_DESARROLLO + PORT_DESARROLLO + "/servicioLogin.svc/loginUsuario";
    public static final String RUTA_SERVICIO_CONSULTAR_FACTURA_DESARROLLO =  SERVER_DESARROLLO + PORT_DESARROLLO + "/servicioFacturacion.svc/ConsultarFacturaXfecha";

    /**
     * Constantes para la conexión con los socios locales
     */

    private static String SERVER_LOCAL =  "http://127.0.0.1:";
    private static String PORT_LOCAL =  "3235";

    public static final String RUTA_SERVICIO_LOGIN_LOCAL = SERVER_LOCAL + PORT_LOCAL + "/ServicioLogin.svc/loginUsuario";
    public static final String RUTA_SERVICIO_CONSULTAR_FACTURA_LOCAL = SERVER_LOCAL + PORT_LOCAL + "/servicioFacturacion.svc/ConsultarFacturaXfecha";

}
