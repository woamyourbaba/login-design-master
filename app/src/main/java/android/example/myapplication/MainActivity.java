package android.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
        //setContentView(R.layout.layout_login);
        //setContentView(R.layout.activity_main);
        final EditText name=(EditText)findViewById(R.id.name);
        final EditText email=(EditText)findViewById(R.id.email);
        final EditText password=(EditText)findViewById(R.id.password);
        preferences=super.getSharedPreferences("test",MODE_PRIVATE);
        Button login=(Button)findViewById(R.id.btnLinkToLoginScreen);
        Button create=(Button)findViewById(R.id.btnRegister) ;
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().equals("")||email.getText().toString().equals("")||password.getText().toString().equals(""))
                    Toast.makeText(MainActivity.this, "email or passowoed or username is null", Toast.LENGTH_LONG).show();
                else {
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("name",name.getText().toString());
                editor.putString("email",email.getText().toString());
                editor.putString("pw",password.getText().toString());
                editor.commit();
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();}
            }
        });
    }
}
