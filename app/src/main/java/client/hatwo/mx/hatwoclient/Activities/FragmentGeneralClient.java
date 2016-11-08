package client.hatwo.mx.hatwoclient.Activities;

//import android.app.Fragment;
import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentContainer;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.io.File;
import java.io.InputStream;

import client.hatwo.mx.hatwoclient.R;
import client.hatwo.mx.hatwoclient.core.ControladorClient;
import client.hatwo.mx.hatwoclient.model.Cliente;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;


/**
 * Created by Pattyntel on 05/11/2016.
 */
public class FragmentGeneralClient extends Fragment
{

    View layoutFragment;
    private EditText inputName, inputEmail, inputPassword, inputPhone, inputSex;
    private TextInputLayout inputLayoutName, inputLayoutEmail, inputLayoutPassword, inputLayoutPhone, inputLayoutSex;
    private Button btnSaveUser;
    private ImageView imgAvatar;
    private ImageButton btnEditAvatar;
    ControladorClient controladorClient;
    Context context;

    String[] SEXO_SPINNERLIST = {"Femenino", "Masculino", "Otro"};

    private static String APP_DIRECTORY ="MyPictureHaTWo/";
    private static String MEDIA_DIRECTORY=APP_DIRECTORY + "PictureHaTWo";
    private final int MY_PERMISSIONS=100;
    private final int PHOTO_CODE =200;
    private final int SELECT_PICTURE =300;
    private String mPath;


    public FragmentGeneralClient()
    {
        super();
    }

    private void inicializar() throws Exception
    {
        Log.i("info","inicializar");
        actualizar();
        //((ActivityRegister) ActivityRegister.GLOBALS.get("app")).mostrarMensaje("Clientes: " + alumnos.size(), Snackbar.LENGTH_LONG);
//        ((ActivityRegister) ActivityRegister.GLOBALS.get("app")).mostrarMensaje("Clientes: ", Snackbar.LENGTH_LONG);
    }

    public void actualizar() throws Exception
    {
        if (controladorClient == null)
            controladorClient = new ControladorClient(getContext());
        Log.i("info","actualizar");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

   // @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Cargamos el xml correspondiente al fragmento necesario para hacer movimientos de alumnos.
        //container es donde se va a desplegar.
        //observador cuando se va a utilizar en otras aplicaciones o para debugin
        layoutFragment = inflater.inflate(R.layout.fragment_general_client, container, false);

        //Se utiliza el layoutFragment para encontrar los controles
        inputLayoutName = (TextInputLayout) layoutFragment.findViewById(R.id.input_layout_name);
        inputLayoutEmail = (TextInputLayout) layoutFragment.findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout) layoutFragment.findViewById(R.id.input_layout_password);
        inputLayoutPhone = (TextInputLayout) layoutFragment.findViewById(R.id.input_layout_phone);
        inputLayoutSex = (TextInputLayout) layoutFragment.findViewById(R.id.input_layout_sex);

        inputName = (EditText) layoutFragment.findViewById(R.id.input_name);
        inputEmail = (EditText) layoutFragment.findViewById(R.id.input_email);
        inputPassword = (EditText) layoutFragment.findViewById(R.id.input_password);
        inputPhone = (EditText) layoutFragment.findViewById(R.id.input_phone);
        inputSex = (EditText) layoutFragment.findViewById(R.id.input_sex);

//        btnSaveUser = (Button) layoutFragment.findViewById(R.id.btn_save_user);
        imgAvatar = (ImageView) layoutFragment.findViewById(R.id.img_avatar);
        btnEditAvatar = (ImageButton) layoutFragment.findViewById(R.id.btn_edit_avatar);

        inputName.addTextChangedListener(new MyTextWatcher(inputName));
        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));
        inputPhone.addTextChangedListener(new MyTextWatcher(inputPhone));
        inputSex.addTextChangedListener(new MyTextWatcher(inputSex));

        try
        {
            inicializar();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        controladorClient = new ControladorClient(getContext());

        context = container.getContext();

        ArrayAdapter<String> arrayAdapter_sex = new ArrayAdapter<String>(context,
                android.R.layout.simple_dropdown_item_1line, SEXO_SPINNERLIST);
        MaterialBetterSpinner materialDesignSpinner_sex = (MaterialBetterSpinner)
                layoutFragment.findViewById(R.id.input_sex);
        materialDesignSpinner_sex.setAdapter(arrayAdapter_sex);


/*        btnSaveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                submitForm();
                if(AltaUsuario()==true){
                    //error context en lugar de this
                  Intent intent = new Intent(context, ActivityMain.class);
                    startActivity(intent);
                };
            }
        });*/

       btnEditAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myRequestStoragePermission())
                    EditImagen(v);
            }
        });

        return layoutFragment;
    }

    /**
     * Validating form
     */
    public void submitForm() {
        if (!validateName()) {
            return;
        }

        if (!validateEmail()) {
            return;
        }

        if (!validatePassword()) {
            return;
        }

        if (!validatePhone()) {
            return;
        }

        if (!validateSex()) {
            return;
        }

        Toast.makeText(context.getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
    }

    private boolean validateName() {
        if (inputName.getText().toString().trim().isEmpty()) {
            inputLayoutName.setError(getString(R.string.err_msg_name));
            requestFocus(inputName);
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateEmail() {
        String email = inputEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            inputLayoutEmail.setError(getString(R.string.err_msg_email));
            requestFocus(inputEmail);
            return false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePassword() {
        if (inputPassword.getText().toString().trim().isEmpty()) {
            inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePhone() {
        if (inputPhone.getText().toString().trim().isEmpty()) {
            inputLayoutPhone.setError(getString(R.string.err_msg_phone));
            requestFocus(inputPhone);
            return false;
        } else {
            inputLayoutPhone.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateSex() {
        if (inputSex.getText().toString().trim().isEmpty()) {
            inputLayoutSex.setError(getString(R.string.err_msg_sex));
            requestFocus(inputSex);
            return false;
        } else {
            inputLayoutSex.setErrorEnabled(false);
        }
        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {

//            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {

            switch (view.getId()) {
                case R.id.input_name:
                    validateName();
                    break;
                case R.id.input_email:
                    validateEmail();
                    break;
                case R.id.input_password:
                    validatePassword();
                    break;
                case R.id.input_phone:
                    validatePhone();
                    break;
                case R.id.input_sex:
                    validateSex();
                    break;
            }
        }
    }

    private boolean AltaUsuario(){

        return true;

    }

    private void EditImagen(View v){
        controladorClient = new ControladorClient(getContext());
        //error anterior PopupMenu popup = new PopupMenu(this, v);
        PopupMenu popup = new PopupMenu(context, v);

        // Inflate the menu from xml
        popup.getMenuInflater().inflate(R.menu.popup_imagenes, popup.getMenu());
        // Setup menu item selection
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_tomar_foto:
                        tomarFoto();
                        //Toast.makeText(context, "Tomar foto con Camara!", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu_elegir_foto:
                        seleccionarImagen();
                        //Toast.makeText(ActivityRegister.this, "Popularity!", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
        // Handle dismissal with: popup.setOnDismissListener(...);
        // Show the menu
        popup.show();
    }

    private boolean myRequestStoragePermission()
    {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if ((context.checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) &&
                    (context.checkSelfPermission(CAMERA) == PackageManager.PERMISSION_GRANTED)) {
                Log.i("info","Permission is granted");
                return true;
            } else {

                Log.i("info","Permission is revoked");
               requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE, CAMERA}, MY_PERMISSIONS);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.i("info","Permission is granted");
            return true;
        }


        //La version 6 es la que ocupa esta configuración de permisos
/*        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if ((context.checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) &&
                    (context.checkSelfPermission(CAMERA) == PackageManager.PERMISSION_GRANTED))
                return true;
            if ((shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE)) ||
                    (shouldShowRequestPermissionRationale(CAMERA))) {
                Snackbar.make(layoutFragment.findViewById(android.R.id.content), "Son necesarios los permisos",
                        Snackbar.LENGTH_INDEFINITE).setAction(android.R.string.ok, new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        //requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1);
                        requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE, CAMERA}, MY_PERMISSIONS);
                    }
                }).show();
            } else {
                requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE, CAMERA}, MY_PERMISSIONS);
                return false;
            }
        }

      return true;*/
    }

    private void tomarFoto()
    {
        File file = new File(Environment.getExternalStorageDirectory(),MEDIA_DIRECTORY);
        boolean isDirectoryCreated =file.exists();

        if(!isDirectoryCreated)
            isDirectoryCreated = file.mkdirs();

        if(isDirectoryCreated) {
            Long timestamp =  System.currentTimeMillis() / 1000;
            String imageName = timestamp.toString() + ".jpg";

            mPath = Environment.getExternalStorageDirectory() + File.separator +
                    MEDIA_DIRECTORY + File.separator + imageName;

            File newFile = new File(mPath);

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(newFile));
            startActivityForResult(intent, PHOTO_CODE);
        }
    }

    private void seleccionarImagen()
    {
        //ACTION_GET_CONTENT ->Constante que sirve para indicar que el usuario va a seleccionar un contenido.
        //Generamos un nuevo Intent en el cual indicamos
        //que deseamos seleccionar un recurso del dispositivo(no de la aplicación):
        Intent intentSeleccionImagen = new Intent(Intent.ACTION_GET_CONTENT);


        //Indicamos que solo deseamos seleccionar archivos de tipo imagen:
        //(en este caso imagenes de cualquier tipo, si fuera png seria "image/png", etc.
        // Si son mas de un tipo ->)
        intentSeleccionImagen.setType("image/*");

        //Se crea una bandera en el intent que va a seleccionar la imagenc (explicacion en OneNote)
        //"Limpiamos" la bandera del status del intent para permitir seleccionar
        //una imagen mas de una vez:
        intentSeleccionImagen.setFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        try
        {
            //La primera activity espera el resultado de la segunda activity
            //Segundo parametro es un valor arbitrario se pone 300 por C++ como un codigo con el que se va a conocer de donde viene la respuesta.
            //Se puede utilizar para identificar los id, por ejemplo si se modifica un alumno conocer que alumno se modifico.

            //Iniciamos una Activity nueva para seleccionar la imagen y
            //establecemos como codigo "arbitrario" de respuesta el valor 300: (este valor arbitrario puede ser cualquiera mientras sea entero)
            //SELECT_PICTURE vale 300
            startActivityForResult(intentSeleccionImagen, SELECT_PICTURE);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /*Estos metodos permite guardar la ruta, ya que al pedir que se abra la configuración de
     los permisos, la aplicación se termina y se borra el dato de la ruta
     El metodo onSaveInstanceState permite guardar dicho dato
     El metodo onViewStateRestored nos permite recuperarlo cuando vuelve a la aplicación.
      */
/*    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("file_path", mPath);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mPath = savedInstanceState.getString("file_path");
    }
*/
    //Metodo del activity que Atrapa la totalidad de los resultados de las diferentes Activitys
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        InputStream isImagen = null;
        Drawable imagen = null;
        Uri rutaImagen = null;
        //        mostrarMensaje("RequestCode: " + requestCode);
        //En caso de que sean varios Activity se puede poner un switch o varios if
        if (requestCode == SELECT_PICTURE)
        {
            try
            {
                //getData me devuelve una Uri que es la ruta de la Imagen
                //que el usuario selecciono:
                rutaImagen = intent.getData();

                //getContentResolver verifica que la imagen exista
                //openInputStream lo habre si existe.
                //Resolvemos el recurso (imagen) y lo abrimos como un flujo:
               isImagen = context.getContentResolver().openInputStream(rutaImagen);

                //Convertimos ese flujo de bytes en una imagen (Drawable):
                //por seguridad en linux se debe asegurar de que es una imagen ya que en linux puede ser una imagen con codigo.
                imagen = Drawable.createFromStream(isImagen, rutaImagen.toString());

                //Insertamos la imagen en el control correspondiente:
                imgAvatar.setImageDrawable(imagen);


/*                String codigoImagen=CodificadorImagenes.codificar(imagen);
                txtImagenCodificada.setText(codigoImagen.substring(0,1000));

                Drawable imagenResult = CodificadorImagenes.codificar(codigoImagen);
                imgvResult.setImageDrawable(imagenResult);
*/
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

       if(requestCode == PHOTO_CODE)
        {
            MediaScannerConnection.scanFile(context,
                    new String[]{mPath}, null,
                    new MediaScannerConnection.OnScanCompletedListener(){
                        @Override
                        public void onScanCompleted(String path, Uri uri){
                            Log.i("External Storage","Scanned" + path + ":");
                            Log.i("External Storage","-> Uri = " + uri);
                        }
            });
            Bitmap bitmap = BitmapFactory.decodeFile(mPath);
            imgAvatar.setImageBitmap(bitmap);

        }
    }

    private void mostrarMensaje(String mensaje)
    {
        Context context2 = context.getApplicationContext();
        Snackbar.make(layoutFragment.findViewById(android.R.id.content), mensaje, Snackbar.LENGTH_LONG)
                .show();
    }

    /**
     * Este método se invoca al momento que el usuario da permiso a la aplicación de acceder al
     * sistema de archivos.
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == MY_PERMISSIONS){
            if(grantResults != null && grantResults.length == 2 &&
                    grantResults[0]== PackageManager.PERMISSION_GRANTED &&
                    grantResults[1]== PackageManager.PERMISSION_GRANTED){
                Log.i("info","Permission: "+ permissions[0] + "was "+grantResults[0]);
                Log.i("info","Permission: "+ permissions[1] + "was "+grantResults[0]);
                Toast.makeText(context, "Permisos aceptados", Toast.LENGTH_SHORT).show();
            }
            else
            {
                showExplanation();
            }
        }
    }

    private void showExplanation() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Permisos denegados");
        builder.setMessage("Para usar las funciones de la app necesitas aceptar los permisos");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", context.getPackageName(), null);
                intent.setData(uri);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
//                finish();
            }
        });

        builder.show();
    }

}
