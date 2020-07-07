package test.task.targsoft.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import test.task.targsoft.R
import test.task.targsoft.databinding.ItemBreedBinding
import test.task.targsoft.model.BreedItem

class BreedsAdapter (private val data : ArrayList<BreedItem>) : RecyclerView.Adapter<BreedsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedsViewHolder {
        val itemBreedBinding : ItemBreedBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_breed,
            parent,
            false
        )
        return BreedsViewHolder(itemBreedBinding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: BreedsViewHolder, position: Int) {
        holder.itemBreedBinding.data = data[position]
    }

    fun setUpData (breeds : List<BreedItem>) {
        data.clear()
        data.addAll(breeds)
        notifyDataSetChanged()
    }

}

class BreedsViewHolder(
    val itemBreedBinding: ItemBreedBinding
) : RecyclerView.ViewHolder (itemBreedBinding.root)