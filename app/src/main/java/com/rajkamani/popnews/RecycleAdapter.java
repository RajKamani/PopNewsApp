package com.rajkamani.popnews;

import android.content.Context;
import android.content.Intent;
import android.icu.util.DateInterval;
import android.os.Build;
import android.text.method.DateTimeKeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.zip.DataFormatException;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.HolderClass> {
    private Context context;
    private ArrayList<Article> articlesList;
    private List<Source> sourcesList;

    public RecycleAdapter(Context context, ArrayList<Article> articlesList, List<Source> sourcesList) {
        this.context = context;
        this.articlesList = articlesList;
        this.sourcesList = sourcesList;
    }

    @NonNull
    @Override
    public RecycleAdapter.HolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_layout, parent, false);
        return new HolderClass(view);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.HolderClass holder, int position) {
        final Article article = articlesList.get(position);
        Source source = sourcesList.get(position);
        String date = article.getPublishedAt();
        holder.textAuthor.setText(chekingNull(article.getAuthor()));
        holder.textTitle.setText(chekingNull(article.getTitle()));
        holder.textContent.setText(chekingNull(article.getDescription()));
        date = date.replace("T", " ");
        date = date.replace("Z", "");

        holder.textPublishedAt.setText(date);
        holder.textName.setText(chekingNull(source.getName()));

        Glide.with(context).load(article.urlToImage).placeholder(R.drawable.ic_baseline_image_search_24).into(holder.imageView);
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AboutArticleDetail.class);
                intent.putExtra("Url", article.getUrlToArticle());
                context.startActivity(intent);
            }
        });
        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TITLE, article.getTitle());
                intent.putExtra(Intent.EXTRA_TEXT, article.getUrlToArticle() + "\n" + "From : Pop News App");
                context.startActivity(Intent.createChooser(intent, "Share Article Via"));

            }
        });

    }

    private String chekingNull(String data) {
        String values = "";
        if (data.equals("null")) {
            values = "Not Provided | Go for Article";
        } else {
            return data;
        }
        return values;
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    static public class HolderClass extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textTitle, textContent, textPublishedAt, textName, textAuthor;
        AppCompatButton share;
        ImageButton imageButton;

        public HolderClass(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textTitle = itemView.findViewById(R.id.txtTitle);
            textContent = itemView.findViewById(R.id.txtContent);
            textPublishedAt = itemView.findViewById(R.id.txtPublishedAt);
            textName = itemView.findViewById(R.id.txtName);
            textAuthor = itemView.findViewById(R.id.txtAuthor);
            share = itemView.findViewById(R.id.btnShare);
            imageButton = itemView.findViewById(R.id.ImageGO);
        }
    }
}
