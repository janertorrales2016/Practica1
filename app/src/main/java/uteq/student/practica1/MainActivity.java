package uteq.student.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    DatePickerDialog picker;
    EditText eText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eText=(EditText) findViewById(R.id.editText1);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
    }
   public void btenviar(View view){
       Intent intent= new Intent(this, Bienvenido.class);
       EditText txtNombre = (EditText)findViewById(R.id.txtnombre);
       EditText txtcelular = (EditText)findViewById(R.id.txtcelular);
       RadioGroup radioGroupTipoLugar = findViewById(R.id.radiogroup);
       RadioButton btnmasculino=(RadioButton)findViewById(R.id.rbmasculino);
       RadioButton btfemenino=(RadioButton)findViewById(R.id.rbfemenino);
       Bundle b = new Bundle();

       EditText usernameEditText = (EditText) findViewById(R.id.txtnombre);
       String sUsername = usernameEditText.getText().toString();
       if (sUsername.matches("")) {
           Toast.makeText(this, "Necesita ingresar el Nombre", Toast.LENGTH_SHORT).show();
           return;
       }
       EditText celularEditText = (EditText) findViewById(R.id.txtcelular);
       String sUscelu = celularEditText.getText().toString();
       if (sUscelu.matches("")) {
           Toast.makeText(this, "Necesita ingresar el Celular", Toast.LENGTH_SHORT).show();
           return;
       }
       RadioGroup grupoun = (RadioGroup) findViewById(R.id.radiogroup);
       if (grupoun.getCheckedRadioButtonId() == -1)
       {
           Toast.makeText(this, "Necesita Seleccionar un Género", Toast.LENGTH_SHORT).show();
           return;
       }
       b.putString("NOMBRE", txtNombre.getText().toString());
       b.putString("CELULAR", txtcelular.getText().toString());
       b.putString("FECHA",  eText.getText().toString());
       int idDeRadioButtonSeleccionado = radioGroupTipoLugar.getCheckedRadioButtonId();
       if (idDeRadioButtonSeleccionado == btnmasculino.getId()) {
           b.putString("GENERO", "Masculino");
       } else{
           b.putString("GENERO", "Femenino");
       }
       intent.putExtras(b);
       startActivity(intent);
   }



}