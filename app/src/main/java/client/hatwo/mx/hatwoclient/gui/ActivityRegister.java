package client.hatwo.mx.hatwoclient.gui;

/**
 * Created by Pattyntel on 01/11/2016.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.io.InputStream;

import client.hatwo.mx.hatwoclient.R;

public class ActivityRegister extends AppCompatActivity {

    private EditText inputName, inputEmail, inputPassword, inputPhone, inputSex;
    private TextInputLayout inputLayoutName, inputLayoutEmail, inputLayoutPassword, inputLayoutPhone, inputLayoutSex;
    private Button btnSaveUser;
    private ImageView imgAvatar;
    private ImageButton btnEditAvatar;
    private MenuInflater inflater;
    Toolbar toolbar;

    String[] SEXO_SPINNERLIST = {"Femenino", "Masculino", "Otro"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
// Permite navegar a la activity padre que se indico en el manifest (no funciona)
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inicializarComponentes();
    }

    private void inicializarComponentes(){
        inputLayoutName = (TextInputLayout) findViewById(R.id.input_layout_name);
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);
        inputLayoutPhone = (TextInputLayout) findViewById(R.id.input_layout_phone);
        inputLayoutSex = (TextInputLayout) findViewById(R.id.input_layout_sex);

        inputName = (EditText) findViewById(R.id.input_name);
        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPassword = (EditText) findViewById(R.id.input_password);
        inputPhone = (EditText) findViewById(R.id.input_phone);
        inputSex = (EditText) findViewById(R.id.input_sex);

        btnSaveUser = (Button) findViewById(R.id.btn_save_user);
        imgAvatar = (ImageView) findViewById(R.id.img_avatar);
        btnEditAvatar = (ImageButton) findViewById(R.id.btn_edit_avatar);

        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));
        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayAdapter<String> arrayAdapter_sex = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SEXO_SPINNERLIST);
        MaterialBetterSpinner materialDesignSpinner_sex = (MaterialBetterSpinner)
                findViewById(R.id.input_sex);
        materialDesignSpinner_sex.setAdapter(arrayAdapter_sex);

        btnSaveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AltaUsuario()==true){
                    Intent intent = new Intent(ActivityRegister.this, ActivityMain.class);
                    startActivity(intent);
                };
            }
        });

        btnEditAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditImagen(v);
            }
        });
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
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

    private boolean AltaUsuario(){

        return true;

    }

    private void EditImagen(View v){
        PopupMenu popup = new PopupMenu(this, v);
        // Inflate the menu from xml
        popup.getMenuInflater().inflate(R.menu.popup_imagenes, popup.getMenu());
        // Setup menu item selection
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_tomar_foto:
                        Toast.makeText(ActivityRegister.this, "Keyword!", Toast.LENGTH_SHORT).show();
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
            //Segundo parametro es un valor arbitrario se pone 100 por C++ como un codigo con el que se va a conocer de donde viene la respuesta.
            //Se puede utilizar para identificar los id, por ejemplo si se modifica un alumno conocer que alumno se modifico.

            //Iniciamos una Activity nueva para seleccionar la imagen y
            //establecemos como codigo "arbitrario" de respuesta el valor 100: (este valor arbitrario puede ser cualquiera mientras sea entero)
            startActivityForResult(intentSeleccionImagen, 100);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    //Metodo del activity que Atrapa la totalidad de los resultados de las diferentes Activitys
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        InputStream isImagen = null;
        Drawable imagen = null;
        Uri rutaImagen = null;
        mostrarMensaje("RequestCode: " + requestCode);
        //En caso de que sean varios Activity se puede poner un switch o varios if
        if (requestCode == 100)
        {
            try
            {
                //getData me devuelve una Uri que es la ruta de la Imagen
                //que el usuario selecciono:
                rutaImagen = intent.getData();

                //getContentResolver verifica que la imagen exista
                //openInputStream lo habre si existe.
                //Resolvemos el recurso (imagen) y lo abrimos como un flujo:
                isImagen = getContentResolver().openInputStream(rutaImagen);

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
    }


    private void mostrarMensaje(String mensaje)
    {
        Context context = getApplicationContext();
        Snackbar.make(findViewById(android.R.id.content), mensaje, Snackbar.LENGTH_LONG)
                .show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        //return true;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_register, menu);
   //     MenuItem item = menu.findItem(R.id.action_save);
   /*     SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
  //              adapter.getFilter().filter(newText);

                return false;
            }
        });*/
        return super.onCreateOptionsMenu(menu);
    }
}

