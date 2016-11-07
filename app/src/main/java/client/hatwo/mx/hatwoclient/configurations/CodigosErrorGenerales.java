package client.hatwo.mx.hatwoclient.configurations;

/**
 * Created by Pattyntel on 03/11/2016.
 */
public class CodigosErrorGenerales {
    /**
     * Manejo de errores de frameworks
     */

    private static int CODE_DEFAULT = -1;
    private static int CODE_TIMEOUT = 0;
    private static int CODE_JSON = 1;
    private static int CODE_JSON_VACIO = 2;
    private static int CODE_EXCEPCION_NO_SOPORTADA = 3;
    private static int CODE_EXCEPCION_PROTOCOLO = 4;
    private static int CODE_EXCEPCION_INTERNET = 5;

    private static int CODE_ERROR_DB_NO_CONNECTION = 6;
    private static int CODE_ERROR_PROCESO = 7;
    private static int CODE_ERROR_INFORMATIVO = 8;
    private static int CODE_ERROR_FATAL = 9;
    private static int CODE_ERROR_ADVERTENSIA = 10;
    private static int CODE_ERROR_INFORMACION_INCOMPLETA = 11;
    private static int CODE_SUCCESS_REGISTRO = 50;

    public static int getCodeSuccessRegistro() {
        return CODE_SUCCESS_REGISTRO;
    }

    public static void setCodeSuccessRegistro(int codeSuccessRegistro) {
        CODE_SUCCESS_REGISTRO = codeSuccessRegistro;
    }

    public static int getCodeSuccessActualiza() {
        return CODE_SUCCESS_ACTUALIZA;
    }

    public static void setCodeSuccessActualiza(int codeSuccessActualiza) {
        CODE_SUCCESS_ACTUALIZA = codeSuccessActualiza;
    }

    public static int getCodeSuccessConsulta() {
        return CODE_SUCCESS_CONSULTA;
    }

    public static void setCodeSuccessConsulta(int codeSuccessConsulta) {
        CODE_SUCCESS_CONSULTA = codeSuccessConsulta;
    }

    private static int CODE_SUCCESS_ACTUALIZA = 51;
    private static int CODE_SUCCESS_CONSULTA = 52;





    /**
     * Constructor
     */
    public CodigosErrorGenerales()
    {
    }

    public static int getCodeDefault()
    {
        return CODE_DEFAULT;
    }

    public static int getCodeTimeout() {
        return CODE_TIMEOUT;
    }

    public static int getCodeJsonVacio() {
        return CODE_JSON_VACIO;
    }

    public static int getCodeExcepcionNoSoportada() {
        return CODE_EXCEPCION_NO_SOPORTADA;
    }

    public static int getCodeExcepcionProtocolo() {
        return CODE_EXCEPCION_PROTOCOLO;
    }

    public static int getCodeExcepcionInternet() {
        return CODE_EXCEPCION_INTERNET;
    }


    public static int getCodeJson() {
        return CODE_JSON;
    }

    public static int getCodeErrorDbNoConnection() {
        return CODE_ERROR_DB_NO_CONNECTION;
    }

    public static void setCodeErrorDbNoConnection(int codeErrorDbNoConnection) {
        CODE_ERROR_DB_NO_CONNECTION = codeErrorDbNoConnection;
    }

    public static int getCodeErrorProceso() {
        return CODE_ERROR_PROCESO;
    }

    public static void setCodeErrorProceso(int codeErrorProceso) {
        CODE_ERROR_PROCESO = codeErrorProceso;
    }

    public static int getCodeErrorInformativo() {
        return CODE_ERROR_INFORMATIVO;
    }

    public static void setCodeErrorInformativo(int codeErrorInformativo) {
        CODE_ERROR_INFORMATIVO = codeErrorInformativo;
    }

    public static int getCodeErrorFatal() {
        return CODE_ERROR_FATAL;
    }

    public static void setCodeErrorFatal(int codeErrorFatal) {
        CODE_ERROR_FATAL = codeErrorFatal;
    }

    public static int getCodeErrorAdvertensia() {
        return CODE_ERROR_ADVERTENSIA;
    }

    public static void setCodeErrorAdvertensia(int codeErrorAdvertensia) {
        CODE_ERROR_ADVERTENSIA = codeErrorAdvertensia;
    }

    public static int getCodeErrorInformacionIncompleta() {
        return CODE_ERROR_INFORMACION_INCOMPLETA;
    }

    public static void setCodeErrorInformacionIncompleta(int codeErrorInformacionIncompleta) {
        CODE_ERROR_INFORMACION_INCOMPLETA = codeErrorInformacionIncompleta;
    }
}
