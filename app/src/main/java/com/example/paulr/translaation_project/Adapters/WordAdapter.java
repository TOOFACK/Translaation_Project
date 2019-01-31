package com.example.paulr.translaation_project.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.paulr.translaation_project.R;

import java.io.Serializable;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordVH> {
    List<Word> wordList;


    public WordAdapter(List<Word> wordList) {
        this.wordList = wordList;
    }



    @NonNull
    @Override
    public WordVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View view = inflater.inflate(R.layout.word, viewGroup, false);

        return new WordVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final WordVH wordVH, final int i) {
        final Word word = wordList.get(i);


        wordVH.word.setText(word.getWord());

        wordVH.wordCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
               wordList.remove(i);
                notifyItemRemoved(i);
                notifyItemChanged(i);
                return false;
            }
        });
       // wordVH.wordCard.setOnClickListener(new View.OnClickListener() {


         //   @Override
        //    public void onClick(View v) {

         //       Intent intent = new Intent(v.getContext(), Description.class);
         //       intent.putExtra("musicObject", music);
        //        v.getContext().startActivity(intent);
        //    }
       // });
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }


    class WordVH extends RecyclerView.ViewHolder implements Serializable {

        private CheckBox Favorite;
        private TextView word;
        private CardView wordCard;

        public WordVH(@NonNull View itemView, TextView word, CheckBox Favorite) {
            super(itemView);
            this.word = word;
            this.Favorite = Favorite;

        }

        public WordVH(@NonNull View itemView) {
            super(itemView);




            word= itemView.findViewById(R.id.word);
            Favorite = itemView.findViewById(R.id.Favorite);
            wordCard = itemView.findViewById(R.id.wordCard);

        }
    }
}

