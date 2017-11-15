package pb.fr.cinescope2017;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class SQLitePays extends Activity implements View.OnClickListener {

    private Button buttonBDCreate;
    private TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bd_create);

        buttonBDCreate = (Button) findViewById(R.id.buttonBDCreate);
        buttonBDCreate.setOnClickListener(this);

        textViewMessage = (TextView) findViewById(R.id.textViewMessage);
    }

    @Override
    public void onClick(View v) {

        new TAExterneSQLite(this, textViewMessage).execute();
    } /// onClick
} //// classe