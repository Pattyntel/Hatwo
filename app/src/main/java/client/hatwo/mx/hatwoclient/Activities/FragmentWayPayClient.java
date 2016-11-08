package client.hatwo.mx.hatwoclient.Activities;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import client.hatwo.mx.hatwoclient.R;
import client.hatwo.mx.hatwoclient.core.ControladorClient;

/**
 * Created by Pattyntel on 06/11/2016.
 */
public class FragmentWayPayClient extends Fragment {
    View layoutFragment;
    private EditText inputCardNumber, inputMonthCard, inputYearCard, inputSecurityCode, inputFirstName, inputLastName;;
    private TextInputLayout inputLayoutCardNumber, inputLayoutMonthCard, inputLayoutYearCard, inputLayoutSecurityCode, inputLayoutFirstName, inputLayoutLastName;

    ControladorClient controladorClient;

    public FragmentWayPayClient() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Cargamos el xml correspondiente al fragmento necesario para hacer movimientos de alumnos.
        //container es donde se va a desplegar.
        //observador cuando se va a utilizar en otras aplicaciones o para debugin
        layoutFragment = inflater.inflate(R.layout.fragment_way_pay_client, container, false);

        //Se utiliza el layoutFragment para encontrar los controles
        inputLayoutCardNumber = (TextInputLayout) layoutFragment.findViewById(R.id.input_layout_card_number);
        inputLayoutMonthCard = (TextInputLayout) layoutFragment.findViewById(R.id.input_layout_month);
        inputLayoutYearCard = (TextInputLayout) layoutFragment.findViewById(R.id.input_layout_year);
        inputLayoutSecurityCode = (TextInputLayout) layoutFragment.findViewById(R.id.input_layout_security_code);
        inputLayoutFirstName = (TextInputLayout) layoutFragment.findViewById(R.id.input_layout_first_name);
        inputLayoutLastName = (TextInputLayout) layoutFragment.findViewById(R.id.input_layout_last_name);

        inputCardNumber = (EditText) layoutFragment.findViewById(R.id.input_card_number);
        inputMonthCard = (EditText) layoutFragment.findViewById(R.id.input_month);
        inputYearCard = (EditText) layoutFragment.findViewById(R.id.input_year);
        inputSecurityCode = (EditText) layoutFragment.findViewById(R.id.input_security_code);
        inputFirstName = (EditText) layoutFragment.findViewById(R.id.input_first_name);
        inputLastName = (EditText) layoutFragment.findViewById(R.id.input_last_name);

        inputCardNumber.addTextChangedListener(new MyTextWatcher(inputCardNumber));
        inputMonthCard.addTextChangedListener(new MyTextWatcher(inputMonthCard));
        inputYearCard.addTextChangedListener(new MyTextWatcher(inputYearCard));
        inputSecurityCode.addTextChangedListener(new MyTextWatcher(inputSecurityCode));
        inputFirstName.addTextChangedListener(new MyTextWatcher(inputFirstName));
        inputLastName.addTextChangedListener(new MyTextWatcher(inputLastName));

        controladorClient = new ControladorClient(getContext());

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
                case R.id.input_card_number:
                    validateCardNumber();
                    break;
                case R.id.input_month:
                    validateMonthCard();
                    break;
                case R.id.input_year:
                    validateYearCard();
                    break;
                case R.id.input_security_code:
                    validateSecurityCode();
                    break;
                case R.id.input_first_name:
                    validateFirstName();
                    break;
                case R.id.input_last_name:
                    validateLastName();
                    break;
            }
        }
    }

    private boolean validateCardNumber() {
        if (inputCardNumber.getText().toString().trim().isEmpty()) {
            inputLayoutCardNumber.setError(getString(R.string.err_msg_card_number));
            requestFocus(inputCardNumber);
            return false;
        } else {
            inputLayoutCardNumber.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateMonthCard() {
        if (inputMonthCard.getText().toString().trim().isEmpty()) {
            inputLayoutMonthCard.setError(getString(R.string.err_msg_month_card));
            requestFocus(inputMonthCard);
            return false;
        } else {
            inputLayoutMonthCard.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateYearCard() {
        if (inputYearCard.getText().toString().trim().isEmpty()) {
            inputLayoutYearCard.setError(getString(R.string.err_msg_year_card));
            requestFocus(inputYearCard);
            return false;
        } else {
            inputLayoutYearCard.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateSecurityCode() {
        if (inputSecurityCode.getText().toString().trim().isEmpty()) {
            inputLayoutSecurityCode.setError(getString(R.string.err_msg_security_code));
            requestFocus(inputSecurityCode);
            return false;
        } else {
            inputLayoutSecurityCode.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateFirstName() {
        if (inputFirstName.getText().toString().trim().isEmpty()) {
            inputLayoutFirstName.setError(getString(R.string.err_msg_first_name));
            requestFocus(inputFirstName);
            return false;
        } else {
            inputLayoutFirstName.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateLastName() {
        if (inputLastName.getText().toString().trim().isEmpty()) {
            inputLayoutLastName.setError(getString(R.string.err_msg_last_name));
            requestFocus(inputLastName);
            return false;
        } else {
            inputLayoutLastName.setErrorEnabled(false);
        }
        return true;
    }



    private void requestFocus(View view) {
        if (view.requestFocus()) {

//            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

}
