package sidhesh.mr.sqlitedatabase;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by Felix-ITS on 23-02-2018.
 */

public class InputValidation {
    private Context context;

    public InputValidation(Context context){
        this.context = context;
    }

    public boolean ismail(EditText mail,String message){
        String value=mail.getText().toString().trim();
        if (value.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            mail.setError(message);
            hideKeyboardFrom(mail);
            return false;
        }
        return true;
    }
    public boolean isInputEditTextMatches(EditText name, EditText email, EditText password, String message) {
        String value1 = name.getText().toString().trim();
        String value2 = password.getText().toString().trim();
        if (!value1.contentEquals(value2)) {
            name.setError(message);
            hideKeyboardFrom(name);
            return false;
        }
        return true;
    }

    private void hideKeyboardFrom(View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}
