package br.com.helder.controledeestoque.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.helder.controledeestoque.Classes.Produto;
import br.com.helder.controledeestoque.Helper.Produto_Helper;
import br.com.helder.controledeestoque.R;

public class CadastrarNovoProduto_Activity extends AppCompatActivity {

    private Button btn_salvar;
    Produto_Helper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form__produto_layout);


        btn_salvar = findViewById(R.id.btn_Salvar);

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acao_BotaoSalvar();
            }
        });

    }

    private void acao_BotaoSalvar(){

        helper = new Produto_Helper(this);

        Produto produto = helper.getProduto();

        Tela_Principal_activity.myAppDatabase.myDao().addProduto(produto);
        Toast.makeText(getApplicationContext(),"Produto Cadastrado: "+produto.getNome(),
                Toast.LENGTH_SHORT).show();

        helper.setProduto(new Produto());

        finish();

    }

}
