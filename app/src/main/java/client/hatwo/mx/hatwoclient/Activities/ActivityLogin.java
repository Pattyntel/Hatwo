package client.hatwo.mx.hatwoclient.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import client.hatwo.mx.hatwoclient.R;
import client.hatwo.mx.hatwoclient.configurations.Globals;
import client.hatwo.mx.hatwoclient.services.ServiceLogin;
import client.hatwo.mx.hatwoclient.Tools.ValidarConexion;

import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Pattyntel on 01/11/2016.
 */
public class ActivityLogin extends AppCompatActivity {

    //region VARIABLES
    private EditText inputEmail, inputPassword;
    private TextInputLayout inputLayoutEmail, inputLayoutPassword;
    private Button btnSignUp;
    private Button btnRegister;

    public String usuario_;
    public String userName;
    public String userPassword;
    public String name;
    ValidarConexion conexion = new ValidarConexion();
    //endregion

    //region METODO onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inicializarComponentes();
    }
    //endregion


    private void inicializarComponentes(){

        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);

        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPassword = (EditText) findViewById(R.id.input_password);

        btnSignUp = (Button) findViewById(R.id.btn_signup);
        btnRegister = (Button) findViewById(R.id.btn_register);

        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
    }



    /**
     * Validating form
     */
    private void submitForm() {
        if (!validateEmail()) {
            return;
        }

        if (!validatePassword()) {
            return;
        }

        //region VARIABLES
//        usuario =  (TextView) findViewById(R.id.input_email);

//        password = (TextView) findViewById(R.id.input_password);

        userName = inputEmail.getText().toString();

        userPassword = inputPassword.getText().toString();

        usuario_ = userName;

        Globals.USUARIO = usuario_;
        //endregion
        in_consultar_usuario();
//            Toast.makeText(getApplicationContext(), "Bienvenido!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ActivityMain.class);
        startActivity(intent);

    }

    //region METODO EJECUTA EL METODO PARA VALIDAR CREDENCIALES
    public void in_consultar_usuario()
    {
        //region DECLARACIÓN DE VARIABLES PARA EL METODO
        ServiceLogin Servicios;

        String[] valores_int= {"user," + userName + "::" + "password," + userPassword};

        String[] valores_out= {"nombre :: telefono :: email  :: Token :: pago_mes_actual :: cantidad_servicios"};

        Servicios = new ServiceLogin(this, valores_int,valores_out,Globals.PACKAGE,Globals.LAYOUT_A_REGRESAR_EN_CASO_ERROR, "menus");
        //endregion

        if(!conexion.verificaConexion(this))
        {
            // in_verifica_app_trabaja_offline();
        }
        //endregion
        else
        {
            //region PROCESO A REALIZAR
            if (Globals.MODO_APP == Globals.APP_PRODUCCION)
            {
                Servicios.execute(Globals.RUTA_SERVICIO_LOGIN);
            }
            else if (Globals.MODO_APP == Globals.APP_DESARROLLO)
            {
                Servicios.execute(Globals.RUTA_SERVICIO_LOGIN_DESARROLLO);
            }
            else if (Globals.MODO_APP == Globals.APP_LOCAL)
            {
                Servicios.execute(Globals.RUTA_SERVICIO_LOGIN_LOCAL);
            }
            else
            {
                Intent u = new Intent(ActivityLogin.this, ActivityMain.class);

                startActivity(u);
            }
            //endregion
        }

    }
    //endregion

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

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void Register(){
        Intent intent = new Intent(this, ActivityRegister.class);
        startActivity(intent);
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
                case R.id.input_email:
                    validateEmail();
                    break;
                case R.id.input_password:
                    validatePassword();
                    break;
            }
        }
    }


}
