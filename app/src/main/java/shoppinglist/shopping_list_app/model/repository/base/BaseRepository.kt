package shoppinglist.shopping_list_app.model.repository.base

abstract class BaseRepository<T, D:BaseDao<T>>(val dao:D) {

    fun create(param:T) = dao.create(param)
    fun delete(id:Long) = dao.delete(id)
    fun update(updated:T) = dao.update(updated)
    fun get(id:Long) = dao.get(id)
    fun getAll() = dao.getAll()
    fun deleteAll() = dao.deleteAll()

}