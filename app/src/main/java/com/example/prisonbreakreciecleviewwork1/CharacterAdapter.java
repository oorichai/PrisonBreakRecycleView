package com.example.prisonbreakreciecleviewwork1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    private List<Character> characters;
    private Context context;

    public CharacterAdapter(Context context, List<Character> characters) {
        this.context = context;
        this.characters = characters;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.character_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Character character = characters.get(position);
        holder.name.setText(character.getName());
        holder.description.setText(character.getDescription());
        holder.image.setImageResource(character.getImageResId());

        holder.itemView.setOnClickListener(v ->
                Toast.makeText(context, "Clicked: " + character.getName(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public void filterList(List<Character> filteredList) {
        this.characters = filteredList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.character_name);
            description = itemView.findViewById(R.id.character_description);
            image = itemView.findViewById(R.id.character_image);
        }
    }
}
