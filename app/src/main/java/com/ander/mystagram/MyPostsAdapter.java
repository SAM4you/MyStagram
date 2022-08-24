package com.ander.mystagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.lang.annotation.Target;
import java.util.List;

public class MyPostsAdapter extends RecyclerView.Adapter<MyPostsAdapter.ViewHolder> {

    private Context context;
    private List<Post> posts;


    public MyPostsAdapter (Context context, List<Post> posts){
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_mypost, parent, false);
        return new MyPostsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
    // Clean all elements of the recycler
    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Post> postList) {
        posts.addAll(postList);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        //private TextView tvScreenName;
        private ImageView ivPostImage;
        //private TextView tvPostBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           // tvScreenName = itemView.findViewById(R.id.tvScreenName);
            ivPostImage = itemView.findViewById(R.id.ivPostImage);
            //tvPostBody = itemView.findViewById(R.id.tvPostBody);
        }

        public void bind(Post post) {
           // tvPostBody.setText(post.getDescription());
            //tvScreenName.setText(post.getUser().getUsername());
            ParseFile image = post.getImage();
            if (image != null){
                Glide.with(context)
                        .load(image.getUrl())
                        .placeholder(R.drawable.placeholder)
                        .override(300, 300)
                        .into(ivPostImage);
            }


        }
    }
}
