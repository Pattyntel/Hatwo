package client.hatwo.mx.hatwoclient.Activities;

//import android.app.Fragment;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import client.hatwo.mx.hatwoclient.R;
import client.hatwo.mx.hatwoclient.core.ControladorClient;

/**
 * Created by Pattyntel on 06/11/2016.
 */
public class FragmentAddressClient extends Fragment {
    View layoutFragment;
    private EditText inputStreet, inputNum, inputUnit, inputCountry, inputState, inputCity, inputZipCode;
    private TextInputLayout inputLayoutStreet, inputLayoutNum, inputLayoutUnit, inputLayoutCountry, inputLayoutState, inputLayoutCity, inputLayoutZipCode;

    ControladorClient controladorClient;

    public FragmentAddressClient() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getActivity().setTitle("Dirección");
        Log.i("Titulo","Dirección");

        //Cargamos el xml correspondiente al fragmento necesario para hacer movimientos de alumnos.
        //container es donde se va a desplegar.
        //observador cuando se va a utilizar en otras aplicaciones o para debugin
        layoutFragment = inflater.inflate(R.layout.fragment_address_client, container, false);

        //Se utiliza el layoutFragment para encontrar los controles
        inputLayoutStreet = (TextInputLayout) layoutFragment.findViewById(R.id.input_layout_street);
        inputLayoutNum = (TextInputLayout) layoutFragment.findViewById(R.id.input_layout_num);
        inputLayoutUnit = (TextInputLayout) layoutFragment.findViewById(R.id.input_layout_unit);
        inputLayoutCountry = (TextInputLayout) layoutFragment.findViewById(R.id.input_layout_country);
        inputLayoutState = (TextInputLayout) layoutFragment.findViewById(R.id.input_layout_state);
        inputLayoutCity = (TextInputLayout) layoutFragment.findViewById(R.id.input_layout_city);
        inputLayoutZipCode = (TextInputLayout) layoutFragment.findViewById(R.id.input_layout_zip_code);

        inputStreet = (EditText) layoutFragment.findViewById(R.id.input_street);
        inputNum = (EditText) layoutFragment.findViewById(R.id.input_num);
        inputUnit = (EditText) layoutFragment.findViewById(R.id.input_unit);
        inputCountry = (EditText) layoutFragment.findViewById(R.id.input_country);
        inputState = (EditText) layoutFragment.findViewById(R.id.input_state);
        inputCity = (EditText) layoutFragment.findViewById(R.id.input_city);
        inputZipCode = (EditText) layoutFragment.findViewById(R.id.input_zip_code);

        inputStreet.addTextChangedListener(new MyTextWatcher(inputStreet));
        inputNum.addTextChangedListener(new MyTextWatcher(inputNum));
        inputUnit.addTextChangedListener(new MyTextWatcher(inputUnit));
        inputCountry.addTextChangedListener(new MyTextWatcher(inputCountry));
        inputState.addTextChangedListener(new MyTextWatcher(inputState));
        inputCity.addTextChangedListener(new MyTextWatcher(inputCity));
        inputZipCode.addTextChangedListener(new MyTextWatcher(inputZipCode));



        controladorClient = new ControladorClient(getContext());
        getActivity().setTitle("Dirección");
        Log.i("Titulo","Dirección2");
        return layoutFragment;
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
                case R.id.input_street:
                    validateStreet();
                    break;
                case R.id.input_num:
                    validateNum();
                    break;
                case R.id.input_unit:
                    validateUnit();
                    break;
                case R.id.input_country:
                    validateCountry();
                    break;
                case R.id.input_state:
                    validateState();
                    break;
                case R.id.input_city:
                    validateCity();
                    break;
                case R.id.input_zip_code:
                    validateZipCode();
                    break;

            }
        }
    }

    private boolean validateStreet() {
        if (inputStreet.getText().toString().trim().isEmpty()) {
            inputLayoutStreet.setError(getString(R.string.err_msg_street));
            requestFocus(inputStreet);
            return false;
        } else {
            inputLayoutStreet.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateNum() {
        if (inputNum.getText().toString().trim().isEmpty()) {
            inputLayoutNum.setError(getString(R.string.err_msg_num));
            requestFocus(inputNum);
            return false;
        } else {
            inputLayoutNum.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateUnit() {
        if (inputUnit.getText().toString().trim().isEmpty()) {
            inputLayoutUnit.setError(getString(R.string.err_msg_unit));
            requestFocus(inputUnit);
            return false;
        } else {
            inputLayoutUnit.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateCountry() {
        if (inputCountry.getText().toString().trim().isEmpty()) {
            inputLayoutCountry.setError(getString(R.string.err_msg_country));
            requestFocus(inputCountry);
            return false;
        } else {
            inputLayoutCountry.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateState() {
        if (inputState.getText().toString().trim().isEmpty()) {
            inputLayoutState.setError(getString(R.string.err_msg_state));
            requestFocus(inputState);
            return false;
        } else {
            inputLayoutState.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateCity() {
        if (inputCity.getText().toString().trim().isEmpty()) {
            inputLayoutCity.setError(getString(R.string.err_msg_city));
            requestFocus(inputCity);
            return false;
        } else {
            inputLayoutCity.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateZipCode() {
        if (inputZipCode.getText().toString().trim().isEmpty()) {
            inputLayoutZipCode.setError(getString(R.string.err_msg_zip_code));
            requestFocus(inputZipCode);
            return false;
        } else {
            inputLayoutZipCode.setErrorEnabled(false);
        }
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {

//            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

}