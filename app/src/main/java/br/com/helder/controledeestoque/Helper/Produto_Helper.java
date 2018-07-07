package br.com.helder.controledeestoque.Helper;

import android.widget.EditText;
import android.widget.ImageView;

import br.com.helder.controledeestoque.Classes.Produto;
import br.com.helder.controledeestoque.R;
import br.com.helder.controledeestoque.Views.CadastrarNovoProduto_Activity;

public class Produto_Helper {

    private EditText edtNome;
    private EditText edtCategoria;
    private EditText edtTipo;
    private EditText edtQtd;
    private ImageView img_foto;

    private Produto produto;

    public Produto_Helper(CadastrarNovoProduto_Activity form_produto){

        edtNome = form_produto.findViewById(R.id.edt_Nome_Produto);
        edtCategoria = form_produto.findViewById(R.id.edt_Categoria_Produto);
        edtTipo = form_produto.findViewById(R.id.edt_tipo_Produto);
        img_foto = form_produto.findViewById(R.id.image_foto_produto);
        edtQtd = form_produto.findViewById(R.id.edt_qtd_Produto);

        produto = new  Produto();
    }

    public Produto getProduto() {

        produto.setNome(edtNome.getText().toString());
        produto.setCategoria(edtCategoria.getText().toString());
        produto.setTipo(edtCategoria.getText().toString());
        produto.setQuantidade(Integer.parseInt(edtQtd.getText().toString()));

        return produto;
    }

    public void setProduto(Produto produto) {
        edtNome.setText(produto.getNome());
        edtCategoria.setText(produto.getCategoria());
        edtTipo.setText(produto.getTipo());
        edtQtd.setText(String.valueOf(produto.getQuantidade()));
        this.produto = produto;
    }
}