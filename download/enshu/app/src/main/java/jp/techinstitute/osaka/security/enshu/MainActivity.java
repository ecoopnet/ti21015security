package jp.techinstitute.osaka.security.enshu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * ログイン画面
 */
public class MainActivity extends Activity {
    // ログインパスワード
    private static final String PASSWORD = "himitsu";
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.login_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // パスワードチェック
                EditText editText = (EditText) findViewById(R.id.input_password);
                String inputPassword = editText.getText().toString();

                if(inputPassword.equals(PASSWORD)){
                    // 認証OK
                    Toast.makeText(getApplicationContext(), "ログインしました", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), WebActivity.class);
                    startActivity(intent);
                    return;
                }

                // 認証NG
                Toast.makeText(getApplicationContext(), "パスワードが違います", Toast.LENGTH_SHORT).show();
            }
        });

        Log.d(TAG, "value:"+MySettings.getValue());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
