package uteq.student.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Bienvenido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);
        Bundle bundle = this.getIntent().getExtras();
        TextView txtnombre = (TextView)findViewById(R.id.lblnombre2);
        TextView txtgenero = (TextView)findViewById(R.id.lblgenero2);
        TextView txtfecha = (TextView)findViewById(R.id.lblfecha2);
        TextView txtcelular = (TextView)findViewById(R.id.lblcelular2);
        txtnombre.setText(bundle.getString("NOMBRE"));
        txtgenero.setText(bundle.getString("GENERO"));
        txtfecha.setText( bundle.getString("FECHA"));
        txtcelular.setText(bundle.getString("CELULAR"));
    }
}