package shoppinglist.shopping_list_app.views.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import shoppinglist.shopping_list_app.application.SLApp
import shoppinglist.shopping_list_app.viewmodels.SLViewModel
import shoppinglist.shopping_list_app.views.adapters.SLAdapter
import shoppinglist.shopping_list_app.views.adapters.SLAdapterCallback
import shoppinglist.shopping_list_app.views.adapters.SwipeToDeleteCallback
import shoppinglist.shopping_list_app.views.base.BaseFragment
import shoppinglist.shopping_list_app.views.base.BaseItemDecoration
import shoppinglist.shoppinglistapp.databinding.SLFragmentBinding
import javax.inject.Inject

class SLFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<SLViewModel> { viewModelFactory }
    private var viewBinding: SLFragmentBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as SLApp).appComponent.slComponent()
            .create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = SLFragmentBinding.inflate(inflater, container, false)
        viewBinding?.let { binding ->
            val adapter = getAdapter()
            val touchHelper = ItemTouchHelper(SwipeToDeleteCallback(adapter))
            binding.SLRecyclerView.adapter = adapter
            touchHelper.attachToRecyclerView(binding.SLRecyclerView)
            binding.SLRecyclerView.layoutManager = LinearLayoutManager(activity)
            binding.SLRecyclerView.addItemDecoration(BaseItemDecoration())
            binding.goToCartBtn.setOnClickListener { navigateTo(SLFragmentDirections.goToCartFragment()) }
            binding.addPosition.setOnClickListener { navigateTo(SLFragmentDirections.goToSLPositionCreation()) }
            viewModel.updateList()
            return binding.root
        }
        return null
    }

    override fun onResume() {
        super.onResume()
        viewModel.updateList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
        viewModel.dispose()
    }

    private fun getAdapter(): SLAdapter{
        val adapter = SLAdapter()
        viewModel.currentList.observe(viewLifecycleOwner, {adapter.updateList(it)})
        adapter.viewCallback = object: SLAdapterCallback {
            override fun movePositionToCart(position:Long) { viewModel.movePositionToCart(position) }
            override fun editPosition(position:Long) { navigateTo(SLFragmentDirections.goToSLPositionEdition(position)) }
            override fun removePosition(position: Long) { viewModel.deleteSLPosition(position) }
        }
     return adapter
    }
}

