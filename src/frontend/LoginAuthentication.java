package frontend;

import java.io.IOException;

import com.example.hospitalapplication.R;

import manager.AccountManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;


public class LoginAuthentication extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_authentication);
	}
	
	public void authenticateUser(View view) throws IOException{
		Intent intent = new Intent(this, HomeScreen.class);
		//AccountManager access = new AccountManager();
		
		EditText UsernameText = (EditText) findViewById(R.id.user_name_field);
    	String username = UsernameText.getText().toString();
    	
    	EditText PasswordText = (EditText) findViewById(R.id.password_field);
    	String password = UsernameText.getText().toString();
    	
    	//if (access.authenticate(username, password)){
    		startActivity(intent);
    	//}
    	
	}

}
