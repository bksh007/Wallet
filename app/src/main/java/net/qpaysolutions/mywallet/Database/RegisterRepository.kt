package net.qpaysolutions.mywallet.Database

class RegisterRepository(private val dao: RegisterDatabaseDao) {

    val users = dao.getAllUsers()

    suspend fun insert(user: RegisterEntity) {
        return dao.insert(user)
    }

    suspend fun getUserEmail(userEmail: String):RegisterEntity?{
        return dao.getUseremail(userEmail)
    }
}