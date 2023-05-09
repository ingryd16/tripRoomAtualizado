package br.senai.sp.jandira.triproom.repository

import android.content.Context
import br.senai.sp.jandira.triproom.dao.TripDb
import br.senai.sp.jandira.triproom.model.User

class UserRepository(context: Context) {

    //Variável que representa nosso banco de dados
    private val db = TripDb.getDataBase(context)

    fun save(user: User): Long{
        return db.userDao().save(user)
    }

    //Responsável pela autenticação do usuário
    fun authenticate (email: String, password: String, context: Context): User{
        return db.userDao().authenticate(email, password)
    }

    fun findUserByEmail(email: String): User {
        return db.userDao().findUserByEmail(email)
    }
    fun findUserById(id: String): User {
        return db.userDao().findUserById(id)
    }
}