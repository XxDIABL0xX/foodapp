package com.example.wetewterwetr.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wetewterwetr.databinding.ItemFruitBinding;
import com.example.wetewterwetr.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {

    List<Fruit> fruitList = new ArrayList<>();
    private OnItemClickListener listener = null;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.listener = onItemClickListener;
    }

    public void updateList(List<Fruit> newList){
        FruitDiffCallback callback = new FruitDiffCallback(fruitList, newList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(callback);
        fruitList = newList;
        diffResult.dispatchUpdatesTo(this);
    }
    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FruitViewHolder(
                ItemFruitBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
        holder.bind(fruitList.get(position));
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    public class FruitViewHolder extends RecyclerView.ViewHolder {
        private ItemFruitBinding binding;
        public FruitViewHolder(ItemFruitBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Fruit fruit){
            binding.tvName.setText(fruit.name);
            binding.tvFamily.setText(fruit.family);
            binding.getRoot().setOnClickListener(view -> {
                if (listener != null){
                    listener.onItemClick(fruit);
                }
            });
        }
    }

    public class FruitDiffCallback extends DiffUtil.Callback{

        public List<Fruit> oldList;
        public List<Fruit> newList;

        public FruitDiffCallback(List<Fruit> oldList, List<Fruit> newList) {
            this.oldList = oldList;
            this.newList = newList;
        }

        @Override
        public int getOldListSize() {
            return oldList.size();
        }

        @Override
        public int getNewListSize() {
            return newList.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {

            Fruit oldFruit = oldList.get(oldItemPosition);
            Fruit newFruit = newList.get(newItemPosition);
            return oldFruit.id == newFruit.id;
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            Fruit oldFruit = oldList.get(oldItemPosition);
            Fruit newFruit = newList.get(newItemPosition);
            return oldFruit.id == newFruit.id&&
                    oldFruit.name.equals(newFruit.name)&&
                    oldFruit.family.equals(newFruit.family);
        }
    }
    public interface OnItemClickListener {
        void onItemClick(Fruit fruit);
    }
}
