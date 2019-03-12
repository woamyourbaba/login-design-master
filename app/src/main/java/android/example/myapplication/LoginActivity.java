package android.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        email=(EditText)findViewById(R.id.email) ;
        password=(EditText)findViewById(R.id.password) ;
        preferences=super.getSharedPreferences("test",MODE_PRIVATE);
        Button register=(Button)findViewById(R.id.btnLinkToRegisterScreen);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenet=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intenet);
                finish();
            }
        });
        Button log=(Button)findViewById(R.id.btnLogin);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equals("")||password.getText().toString().equals(""))
                    Toast.makeText(LoginActivity.this, "email or passowoed is null", Toast.LENGTH_LONG).show();
               else{
                   String ea=preferences.getString("email","");

                String pw=preferences.getString("pw","");
                if(email.getText().toString().equals(ea)&&password.getText().toString().equals(pw)){
                    Intent intenet=new Intent(LoginActivity.this,ReActivity.class);
                    startActivity(intenet);
                    finish();
                }else
                    Toast.makeText(LoginActivity.this, "email or passowoed is wrong", Toast.LENGTH_LONG).show();
            }
            }
        });
    }
}
