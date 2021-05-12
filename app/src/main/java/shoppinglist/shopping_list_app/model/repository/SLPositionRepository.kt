package shoppinglist.shopping_list_app.model.repository

import android.util.Log
import io.reactivex.Completable
import io.reactivex.Single
import shoppinglist.shopping_list_app.model.dataModels.SLPosition
import javax.inject.Inject

class SLPositionRepository @Inject constructor(private var dao:SLPositionDAO): BaseRepository<SLPosition> {

    override fun create(param: SLPosition) = dao.create(param)

    override fun delete(id: Long) = dao.delete(id)

    override fun update(updated: SLPosition) = dao.update(updated)

    override fun get(id: Long)= dao.get(id)

    override fun getAll() = dao.getAll()

    override fun deleteAll() = dao.deleteAll()
}