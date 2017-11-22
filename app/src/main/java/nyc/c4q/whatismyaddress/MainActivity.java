package nyc.c4q.whatismyaddress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private Button saveEmailButton;
    private Button recyclerIntentButton;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor prefEditor;
    private String emailAddress;
    private String addressPreferenceKey = "address_shared_preferences";
    private String intentExtraKey = "sharedpref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveEmailButton = (Button) findViewById(R.id.button_save_email);
        recyclerIntentButton = (Button) findViewById(R.id.button_recycler_activity);
        //instantiating the buttons isnt really necessary, but I added this for the sake of following instructions.

        email = (EditText) findViewById(R.id.edit_text_email);
        sharedPreferences = getSharedPreferences(addressPreferenceKey, MODE_PRIVATE);




    }
    public void setSaveEmailButton(View view){
        emailAddress = email.getText().toString();
        prefEditor = sharedPreferences.edit();
        prefEditor.putString(emailAddress, emailAddress);
        prefEditor.commit();
        email.setText(null);
    }
    public void setRecyclerIntentButton(View view){

        Intent recyclerActivityIntent = new Intent(MainActivity.this, RecyclerActivity.class);
        recyclerActivityIntent.putExtra(intentExtraKey,addressPreferenceKey );
        startActivity(recyclerActivityIntent);


    }
}
