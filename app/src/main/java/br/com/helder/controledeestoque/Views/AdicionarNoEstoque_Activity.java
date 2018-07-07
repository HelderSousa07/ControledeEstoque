package br.com.helder.controledeestoque.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.List;

import br.com.helder.controledeestoque.Classes.Produto;
import br.com.helder.controledeestoque.R;

public class AdicionarNoEstoque_Activity extends AppCompatActivity {

    Spinner spinner_produto;
    Spinner spinner_categoria;
    Spinner spinner_tipo;
    Spinner spinner_quantidade;
    Button btnSalvar;
    List<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionar_no_estoque_layout);

        spinner_produto = findViewById(R.id.spínner_produtos);
        spinner_categoria = findViewById(R.id.spínner_categoria);
        spinner_tipo = findViewById(R.id.spínner_tipo);
        spinner_quantidade = findViewById(R.id.spínner_qtd);
        btnSalvar = findViewById(R.id.btn_salvarNoEstoque);

        lista = Tela_Principal_activity.myAppDatabase.myDao().getNomeProduto();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_produto.setAdapter(adapter);

    }


}
