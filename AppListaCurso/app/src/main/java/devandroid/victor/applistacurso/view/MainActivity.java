package devandroid.victor.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import devandroid.victor.applistacurso.R;
import devandroid.victor.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    Pessoa outraPessoa;

    String dadosPessoa;
    String dadosOutraPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        //Atribuir dados e valores ao objeto
        //Comforme o seu modelo
        pessoa.setPrimeiroNome("Victor");
        pessoa.setSobreNome("Rodrigues");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("98-984320139");

        outraPessoa = new Pessoa();
        //Atribuir dados e valores ao objeto
        //Comforme o seu modelo
        outraPessoa.setPrimeiroNome("Oliver");
        outraPessoa.setSobreNome("Rodrigues");
        outraPessoa.setCursoDesejado("Java");
        outraPessoa.setTelefoneContato("98-984320235");

        dadosPessoa = "Primeiro Nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa += " Sobrenome: ";
        dadosPessoa += pessoa.getSobreNome();
        dadosPessoa += " Curso Desejado: ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa += " Telefone de contato: ";
        dadosPessoa += pessoa.getTelefoneContato();

        dadosOutraPessoa = "Primeiro Nome: ";
        dadosOutraPessoa += pessoa.getPrimeiroNome();
        dadosOutraPessoa += " Sobrenome: ";
        dadosOutraPessoa += pessoa.getSobreNome();
        dadosOutraPessoa += " Curso Desejado: ";
        dadosOutraPessoa += pessoa.getCursoDesejado();
        dadosOutraPessoa += " Telefone de contato: ";
        dadosOutraPessoa += pessoa.getTelefoneContato();

        Log.i("POOAndroid", pessoa.toString());
        Log.i("POOAndroid", outraPessoa.toString());
    }
}