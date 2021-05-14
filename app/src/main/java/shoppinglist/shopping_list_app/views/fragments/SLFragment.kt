package shoppinglist.shopping_list_app.views.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import shoppinglist.shopping_list_app.application.SLApp
import shoppinglist.shopping_list_app.viewmodels.SLViewModel
import shoppinglist.shopping_list_app.views.adapters.SwipeToDeleteCallback
import shoppinglist.shopping_list_app.views.adapters.SLAdapter
import shoppinglist.shopping_list_app.views.adapters.SLAdapterCallback
import shoppinglist.shoppinglistapp.databinding.SLFragmentBinding
import javax.inject.Inject

class SLFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<SLViewModel> {viewModelFactory}
    private var viewBinding: SLFragmentBinding? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as SLApp).appComponent.slComponent()
            .create().inject(this)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        SLFragmentBinding.inflate(inflater, container, false).also { binding ->
                binding.SLRecyclerView.adapter = SLAdapter().also { adapter ->
                    adapter.viewCallback = object: SLAdapterCallback {
                        override fun movePositionToCart(position:Long) {
                            viewModel.movePositionToCart(position)
                        }
                        override fun editPosition(position:Long) {
                            SLFragmentDirections.goToSLPositionEdition(position).also { findNavController().navigate(it) }
                        }

                        override fun removePosition(position: Long) {
                            viewModel.deleteSLPosition(position)
                        }
                    }
                    viewModel.currentList.observe(viewLifecycleOwner, {adapter.updateList(it)})
                    ItemTouchHelper(SwipeToDeleteCallback(adapter)).also { helper -> helper.attachToRecyclerView(binding.SLRecyclerView) }
                }
                binding.SLRecyclerView.layoutManager = LinearLayoutManager(activity)
                binding.SLRecyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
                    override fun getItemOffsets(
                        outRect: Rect,
                        view: View,
                        parent: RecyclerView,
                        state: RecyclerView.State
                    ) {
                        super.getItemOffsets(outRect, view, parent, state)
                        outRect.left = 10
                        outRect.right = 10
                        outRect.bottom = 15
                        outRect.top = 15
                    }
                })
                binding.goToCartBtn.setOnClickListener {SLFragmentDirections.goToCartFragment().also { findNavController().navigate(it) }}
                binding.addPosition.setOnClickListener { SLFragmentDirections.goToSLPositionCreation()
                    .also { findNavController().navigate(it) } }
                viewModel.updateList()
                return binding.root
        }
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
}

