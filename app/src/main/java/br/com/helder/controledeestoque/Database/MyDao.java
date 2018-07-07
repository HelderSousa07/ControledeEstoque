package br.com.helder.controledeestoque.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.helder.controledeestoque.Classes.Produto;

@Dao
public interface MyDao {

    @Insert
    public void addProduto(Produto... produto);

    @Query("SELECT * FROM PRODUTOS")
    public List<Produto> getProduto();

    @Query("SELECT nome_produto FROM PRODUTOS")
    public List<String> getNomeProduto();

}
