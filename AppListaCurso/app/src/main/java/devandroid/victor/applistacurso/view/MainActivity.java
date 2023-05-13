package devandroid.victor.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.victor.applistacurso.R;
import devandroid.victor.applistacurso.controller.PessoaController;
import devandroid.victor.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listavip";

    Pessoa pessoa;
    Pessoa outraPessoa;

    PessoaController controller;

    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editCursoDesejado;
    EditText editTelefone;

    Button btnlimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES,0);
        SharedPreferences.Editor listaVip = preferences.edit();

        controller = new PessoaController();
        controller.toString();

        pessoa = new Pessoa();

        outraPessoa = new Pessoa();
        outraPessoa.setPrimeiroNome("Oliver");
        outraPessoa.setSobreNome("Rodrigues");
        outraPessoa.setCursoDesejado("Java");
        outraPessoa.setTelefoneContato("98-984320235");

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editCursoDesejado = findViewById(R.id.editCursoDesejado);
        editTelefone = findViewById(R.id.editTelefone);

        btnlimpar = findViewById(R.id.btnlimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editPrimeiroNome.setText(outraPessoa.getPrimeiroNome());
        editSobrenome.setText(outraPessoa.getSobreNome());
        editCursoDesejado.setText(outraPessoa.getCursoDesejado());
        editTelefone.setText(outraPessoa.getTelefoneContato());

        btnlimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editCursoDesejado.setText("");
                editTelefone.setText("");
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editSobrenome.getText().toString());
                pessoa.setCursoDesejado(editCursoDesejado.getText().toString());
                pessoa.setTelefoneContato(editTelefone.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo Com Sucesso" + pessoa.toString(), Toast.LENGTH_LONG).show();

                listaVip.putString("PrimeiroNome", pessoa.getPrimeiroNome());
                listaVip.putString("SobreNome", pessoa.getSobreNome());
                listaVip.putString("CursoDesejado", pessoa.getCursoDesejado());
                listaVip.putString("Telefone", pessoa.getTelefoneContato());
                listaVip.apply();

                controller.salvar(pessoa);
            }
        });

        Log.i("POOAndroid", pessoa.toString());
        Log.i("POOAndroid", outraPessoa.toString());
    }
}