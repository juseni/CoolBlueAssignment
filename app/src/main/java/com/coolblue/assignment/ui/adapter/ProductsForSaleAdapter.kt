package com.coolblue.assignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.coolblue.assignment.R
import com.coolblue.assignment.databinding.ViewProductForSaleBinding
import com.coolblue.assignment.utils.loadImageFromUrl
import com.coolblue.domain.model.ProductForSale

/**
 * @author Juan Sebastian Niño
 */
class ProductsForSaleAdapter(
    private var onSelected: (Int) -> Unit,
    var data: List<ProductForSale> = emptyList()
) : RecyclerView.Adapter<ProductsForSaleAdapter.MyViewHolder>()  {

    inner class MyViewHolder(private val binding: ViewProductForSaleBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val productForSale = getItem(position)
            binding.apply {
                loadImageFromUrl(this.root.context, imageViewProduct, productForSale.productImage)
                textViewProductPrice.text = productForSale.price.toString()
                textViewProductName.text = productForSale.productName ?: ""
                textViewProductAvialability.compoundDrawables[2].setTint(
                    if (productForSale.availabilityState == 2 && productForSale.nextDayDelivery == true) {
                        ContextCompat.getColor(root.context, R.color.green)
                    } else {
                        ContextCompat.getColor(root.context, R.color.red)
                    }
                )
                root.setOnClickListener {
                    onSelected.invoke(productForSale.productId ?: 0)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ViewProductForSaleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = data.size

    private fun getItem(position: Int): ProductForSale = data[position]

    fun updateList(data: List<ProductForSale>) {
        this.data = data
        notifyDataSetChanged()
    }
}