package vn.edu.usth.moodlenew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {
    private EditText user_name, pass_word;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        //get values by id
        user_name=findViewById(R.id.email);
        pass_word=findViewById(R.id.password);
        //get values of button
        Button btn_login = findViewById(R.id.btn_login);
        Button btn_sign = findViewById(R.id.btn_signup);
        //Firebase Req,Res
        mAuth=FirebaseAuth.getInstance();
        btn_login.setOnClickListener(v -> {
            String email= user_name.getText().toString().trim();
            String password=pass_word.getText().toString().trim();
            //check Empty Email
            if(email.isEmpty())
            {
                user_name.setError("Email is empty");
                user_name.requestFocus();
                return;
            }
            //If Email match with database
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            {
                user_name.setError("Enter the valid email");
                user_name.requestFocus();
                return;
            }
            //check Password
            if(password.isEmpty())
            {
                pass_word.setError("Password is empty");
                pass_word.requestFocus();
                return;
            }
            //check Length
            if(password.length()<6)
            {
                pass_word.setError("Length of password is more than 6");
                pass_word.requestFocus();
                return;
            }
            //While True then Access
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if(task.isSuccessful())
                {
                    startActivity(new Intent(LoginPage.this, MainActivity.class));
                }
                else
                {
                    Toast.makeText(LoginPage.this,
                            "Please Check Your login Credentials",
                            Toast.LENGTH_SHORT).show();
                }

            });
        });
        btn_sign.setOnClickListener(v -> startActivity(new Intent(LoginPage.this,RegistrationPage.class )));
    }

}