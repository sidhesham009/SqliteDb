package sidhesh.mr.sqlitedatabase;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name, email, passwrd;
    private Button register;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText) findViewById(R.id.etrname);
        email = (EditText) findViewById(R.id.etremail);
        passwrd = (EditText) findViewById(R.id.etrpassword);
        register = (Button) findViewById(R.id.btnsignup);

        register.setOnClickListener(this);
        inputValidation= new InputValidation(getApplicationContext());
        databaseHelper= new DatabaseHelper(getApplicationContext());

    }


    @Override
    public void onClick(View v) {
        DatabaseHelper databaseHelper= new DatabaseHelper(getApplicationContext());
        databaseHelper.addUser(databaseHelper.addUser(Register);
    }

    private void postDataToSQLite() {

    }
}