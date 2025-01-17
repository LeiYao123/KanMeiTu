package com.kanmeitu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kanmeitu.R;
import com.kanmeitu.utils.ImageUtil;

import java.util.List;

// 图片 adapter
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private final Context context;
    private final List<String> images;
    private final LayoutInflater infalter;
    private OnItemClickListener listener;

    public ImageAdapter(Context context, List<String> images) {
        this.context = context;
        this.images = images;
        infalter = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(infalter.inflate(R.layout.item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(images.get(position));

        if (listener != null) {
            holder.itemView.setOnClickListener(v -> listener.onItemClick(position));
        }
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public void setOnItemClick(OnItemClickListener listener) {
        this.listener = listener;
    }

    public String getData(Object position) {
        return images.get((Integer) position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }

        public void bind(String s) {
            ImageUtil.show((ImageView) imageView, s);
        }
    }
}
