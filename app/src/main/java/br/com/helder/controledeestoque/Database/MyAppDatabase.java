package br.com.helder.controledeestoque.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import br.com.helder.controledeestoque.Classes.Produto;

@Database(entities = {Produto.class},version = 1)
public abstract class MyAppDatabase extends RoomDatabase {

    public abstract MyDao myDao();

}
