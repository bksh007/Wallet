package net.qpaysolutions.mywallet.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class RegisterEntity(

    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0,

    @ColumnInfo(name = "phone_number")
    var phoneNumber: String,

    @ColumnInfo(name = "password")
    var password: String


) {
    override fun toString(): String {
        return "RegisterEntity(userId=$userId, phoneNumber='$phoneNumber', password='$password')"
    }
}