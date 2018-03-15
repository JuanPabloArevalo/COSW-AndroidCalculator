package calculator.cosw.eci.edu.calculadorapolacainversacosw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_prueba;
    private TextView txt_vista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Calculadora");
        btn_prueba=(Button)findViewById(R.id.btn_next);
        txt_vista= (TextView)findViewById(R.id.txt_operation) ;


        btn_prueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_vista.setText("342222222222222222222ASG");
            }
        });
    }
}
