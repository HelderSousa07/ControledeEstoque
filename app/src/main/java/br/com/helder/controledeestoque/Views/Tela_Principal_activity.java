package br.com.helder.controledeestoque.Views;

import android.app.ActivityOptions;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.List;

import br.com.helder.controledeestoque.Adapters.MyAdapter;
import br.com.helder.controledeestoque.Classes.Produto;
import br.com.helder.controledeestoque.Database.MyAppDatabase;
import br.com.helder.controledeestoque.R;

public class Tela_Principal_activity extends AppCompatActivity {

    public static MyAppDatabase myAppDatabase;
    private RecyclerView mRecyclerView;
    private List<Produto> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela__principal_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myAppDatabase = Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,
                "produtosdb").allowMainThreadQueries().build();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        mRecyclerView = findViewById(R.id.recycler_lista);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        lista = Tela_Principal_activity.myAppDatabase.myDao().getProduto();
        mRecyclerView.setAdapter(new MyAdapter(this,lista,listener()));


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent trocarDeTela = new Intent(Tela_Principal_activity.this,
                        CadastrarNovoProduto_Activity.class);
                startActivity(trocarDeTela);
            }
        });



    }

    protected MyAdapter.CervejaInClickListener listener(){
        final Intent intent = new Intent(getBaseContext(),CadastrarNovoProduto_Activity.class);

        return new MyAdapter.CervejaInClickListener() {
            @Override
            public void onClickCerveja(MyAdapter.AdapterViewHolder holder, int idx) {
                Produto p = lista.get(idx);
                ImageView img = holder.image;
                intent.putExtra("imgPlaneta",p.getFoto());
                String key = getString(R.string.transition_key);

                ActivityOptions opts = ActivityOptions.makeSceneTransitionAnimation(
                        Tela_Principal_activity.this, img, key
                );
                startActivity(intent,opts.toBundle());
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela__principal_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
