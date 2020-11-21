package uteq.student.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
   public void btenviar(View view){
       Intent intent= new Intent(this, Bienvenido.class);
       EditText txtNombre = (EditText)findViewById(R.id.txtnombre);
       EditText txtcelular = (EditText)findViewById(R.id.txtcelular);
       EditText txtfecha = (EditText)findViewById(R.id.txtdate);
       RadioGroup radioGroupTipoLugar = findViewById(R.id.radiogroup);
       RadioButton btnmasculino=(RadioButton)findViewById(R.id.rbmasculino);
       RadioButton btfemenino=(RadioButton)findViewById(R.id.rbfemenino);
       Bundle b = new Bundle();
       b.putString("NOMBRE", txtNombre.getText().toString());
       b.putString("CELULAR", txtcelular.getText().toString());
       b.putString("FECHA", txtfecha.getText().toString());
       int idDeRadioButtonSeleccionado = radioGroupTipoLugar.getCheckedRadioButtonId();
       if (idDeRadioButtonSeleccionado == btnmasculino.getId()) {
           b.putString("GENERO", "MASCULINO");
       } else{
           b.putString("GENERO", "FEMENINO");
       }
       intent.putExtras(b);
       startActivity(intent);
   }
}