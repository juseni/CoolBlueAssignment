package com.coolblue.assignment.ui.activities

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.coolblue.assignment.databinding.ActivityObjectForSaleDetailBinding
import com.coolblue.assignment.utils.BUNDLE_PRODUCT_ID_KEY
import com.coolblue.assignment.utils.loadImageFromUrl
import com.coolblue.assignment.viewmodels.ObjectsForSaleDetailViewModel
import com.coolblue.domain.model.ProductForSale
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * @author Juan Sebastian Niño
 */
class ObjectForSaleDetailActivity : DaggerAppCompatActivity() {

    companion object {
        private const val YES_LABEL = "YES"
        private const val NO_LABEL = "NO"
        private const val SEPARATOR = ": "
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: ObjectsForSaleDetailViewModel by lazy {
        ViewModelProvider(
            this,
            viewModelFactory
        )[ObjectsForSaleDetailViewModel::class.java]
    }

    private lateinit var binding: ActivityObjectForSaleDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObjectForSaleDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setupObserver()
        viewModel.getProductForSale(getProductIdExtra())
    }

    private fun getProductIdExtra() = intent.getIntExtra(BUNDLE_PRODUCT_ID_KEY, 0)

    private fun setupObserver() {
        viewModel.productForSaleMutableLiveData.observe(this) {
            setupViews(it)
        }
    }

    private fun setupViews(productForSale: ProductForSale) {
        binding.apply {
            loadImageFromUrl(applicationContext, imageViewProduct, productForSale.productImage)
            textViewProductName.text = productForSale.productName
            textViewProductPrice.text = productForSale.price.toString()
            textViewAvailable.text =
            if (productForSale.availabilityState == 2 && productForSale.nextDayDelivery == true) {
                YES_LABEL
            } else {
               NO_LABEL
            }
            var features = ""
            productForSale.specifications?.forEachIndexed { index, spec ->
                features = features + (index + 1).toString() + SEPARATOR  + spec + "\n"
            }
            textViewSpecs.text = features
            textViewRating.text = productForSale.reviewInformation?.reviewSummary?.reviewAverage.toString()
            textViewPeopleCounts.text = productForSale.reviewInformation?.reviewSummary?.reviewCount.toString()
        }
    }
}