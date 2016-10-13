package virgosys.com.ohmygift;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by vinod on 6/10/16.
 */
public class LoginFragment extends Fragment {

    private ProgressDialog progressDialog;
    private LinearLayout loginBaseForm;
    private LinearLayout loginRegistrationForm;
    private LinearLayout loginEmailForm;
    private LinearLayout loginEmailForgottenForm;
    private FormState actualFormState = FormState.BASE;
    private TextInputLayout loginRegistrationEmailWrapper;
    private TextInputLayout loginRegistrationPasswordWrapper;
    private RadioButton loginRegistrationGenderWoman;
    private TextInputLayout loginEmailEmailWrapper;
    private TextInputLayout loginEmailPasswordWrapper;
    private TextInputLayout loginEmailForgottenEmailWrapper;



    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.loginfragment, container, false);
        loginBaseForm = (LinearLayout) view.findViewById(R.id.login_base_form);
        loginRegistrationForm = (LinearLayout) view.findViewById(R.id.login_registration_form);
        loginEmailForm = (LinearLayout) view.findViewById(R.id.login_email_form);
        loginEmailForgottenForm = (LinearLayout) view.findViewById(R.id.login_email_forgotten_form);
        prepareLoginFormNavigation(view);
        return view;

    }




    private void prepareLoginFormNavigation(View view) {
        // Login email
        Button loginFormEmailButton = (Button) view.findViewById(R.id.login_form_email_btn);
        loginFormEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVisibilityOfEmailForm(true);
            }
        });
        ImageButton closeEmailBtn = (ImageButton) view.findViewById(R.id.login_email_close_button);
        closeEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Slow to display ripple effect
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setVisibilityOfEmailForm(false);
                    }
                }, 200);
            }
        });

        // Registration
        TextView loginFormRegistrationButton = (TextView) view.findViewById(R.id.login_form_registration_btn);
        loginFormRegistrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVisibilityOfRegistrationForm(true);
            }
        });
        ImageButton closeRegistrationBtn = (ImageButton) view.findViewById(R.id.login_registration_close_button);
        closeRegistrationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Slow to display ripple effect
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setVisibilityOfRegistrationForm(false);
                    }
                }, 200);
            }
        });

        // Email forgotten password
        TextView loginEmailFormForgottenButton = (TextView) view.findViewById(R.id.login_email_forgotten_password);
        loginEmailFormForgottenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVisibilityOfEmailForgottenForm(true);
            }
        });
        ImageButton closeEmailForgottenFormBtn = (ImageButton) view.findViewById(R.id.login_email_forgotten_back_button);
        closeEmailForgottenFormBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Slow to display ripple effect
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setVisibilityOfEmailForgottenForm(false);
                    }
                }, 200);
            }
        });
    }

    private void setVisibilityOfEmailForm(boolean setVisible) {
        if (setVisible) {
            actualFormState = FormState.EMAIL;
            loginBaseForm.setVisibility(View.INVISIBLE);
            loginEmailForm.setVisibility(View.VISIBLE);
        } else {
            actualFormState = FormState.BASE;
            loginBaseForm.setVisibility(View.VISIBLE);
            loginEmailForm.setVisibility(View.INVISIBLE);
            hideSoftKeyboard();
        }
    }
    private void setVisibilityOfEmailForgottenForm(boolean setVisible) {
        if (setVisible) {
            actualFormState = FormState.FORGOTTEN_PASSWORD;
            loginEmailForm.setVisibility(View.INVISIBLE);
            loginEmailForgottenForm.setVisibility(View.VISIBLE);
        } else {
            actualFormState = FormState.EMAIL;
            loginEmailForm.setVisibility(View.VISIBLE);
            loginEmailForgottenForm.setVisibility(View.INVISIBLE);
        }
        hideSoftKeyboard();
    }


    private void setVisibilityOfRegistrationForm(boolean setVisible) {
        if (setVisible) {
            actualFormState = FormState.REGISTRATION;
            loginBaseForm.setVisibility(View.INVISIBLE);
            loginRegistrationForm.setVisibility(View.VISIBLE);
        } else {
            actualFormState = FormState.BASE;
            loginBaseForm.setVisibility(View.VISIBLE);
            loginRegistrationForm.setVisibility(View.INVISIBLE);
            hideSoftKeyboard();
        }
    }


    private void hideSoftKeyboard() {
        if (getActivity() != null && getView() != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
        }
    }

    private enum FormState {
        BASE, REGISTRATION, EMAIL, FORGOTTEN_PASSWORD
    }

}
