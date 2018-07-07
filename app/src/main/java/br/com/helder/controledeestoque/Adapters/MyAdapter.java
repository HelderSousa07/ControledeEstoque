package br.com.helder.controledeestoque.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.helder.controledeestoque.Classes.Produto;
import br.com.helder.controledeestoque.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.AdapterViewHolder> {

    protected static final String TAG = "androidTest";
    private Context context;
    private List<Produto> lista;
    private final CervejaInClickListener onClickListener;

    public interface CervejaInClickListener {
        public void onClickCerveja(AdapterViewHolder holder, int idx);
    }


    public MyAdapter(Context context, List<Produto> lista, CervejaInClickListener listener) {
        this.context = context;
        this.lista = lista;
        this.onClickListener = listener;
    }


    @NonNull
    @Override
    public MyAdapter.AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(context).inflate(R.layout.adapter_lista_produto,parent,false);
       AdapterViewHolder holder = new AdapterViewHolder(view);
       return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.AdapterViewHolder holder, final int position) {

        Produto produto = lista.get(position);

        holder.tvNome.setText(produto.getNome());
        holder.progress.setVisibility(View.VISIBLE);
        Picasso.get().load(R.drawable.cerveja).into(holder.image, new Callback() {
            @Override
            public void onSuccess() {
                holder.progress.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
                holder.progress.setVisibility(View.GONE);
            }
        });

        if (onClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClickCerveja(holder,position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder{

        public TextView tvNome;
        public ImageView image;
        ProgressBar progress;
        private View view;

        public AdapterViewHolder(View itemView) {
            super(itemView);
            this.view =view;
            //cria as views para salvar no viewHolder
            tvNome = view.findViewById(R.id.tvnome_produto);
            image = view.findViewById(R.id.img);
            progress = view.findViewById(R.id.progress);

        }
    }


}
