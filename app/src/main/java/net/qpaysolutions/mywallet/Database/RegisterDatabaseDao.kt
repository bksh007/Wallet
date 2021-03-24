package net.qpaysolutions.mywallet.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RegisterDatabaseDao {


    @Insert
    fun insertUser(registerentity: RegisterEntity)


    @Query("SELECT * FROM users WHERE phone_number = (:phonenumber)")
     fun getUser(phonenumber: String): RegisterEntity?

    @Query("SELECT * FROM users WHERE password = (:password)")
    fun getUserPass(password: String): RegisterEntity?

    @Delete
    fun getDeleteById(id:Int)

}
