package br.com.helder.controledeestoque.Classes;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "produtos")
public class Produto {

    @ColumnInfo(name = "id_produto")
    @NonNull
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "nome_produto")
    String nome;

    @ColumnInfo(name = "categoria_produto")
    String categoria;

    @ColumnInfo(name = "tipo_produto")
    String tipo;

    @ColumnInfo(name = "foto_produto")
    String foto;

    @ColumnInfo(name = "qtd_produto")
    int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
