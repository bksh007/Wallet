package net.qpaysolutions.mywallet.Database

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface RegisterDatabaseDao {


    @Insert
    fun insert(registerentity: RegisterEntity)


//    @Query("SELECT * FROM Register_users_table WHERE phone_number LIKE :phonenumber")
//    suspend fun getPhonenumber(phonenumber: String): RegisterEntity?

}
