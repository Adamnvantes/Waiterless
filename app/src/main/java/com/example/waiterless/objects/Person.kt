package com.example.waiterless.objects

abstract class Person(name : String, birthday : String, email : String, password : String) {
    private var name = name
    private var birthday = birthday
    private var email = email
    private var password = password

    fun getName() : String{
        return name;
    }

    fun getBirthday() : String{
        return birthday
    }

    fun getEmail() : String{
        return email
    }

    fun getPassword() : String{
        return password
    }

    fun setName(name : String){
        this.name = name
    }

    fun setBirthday(birthday: String){
        this.birthday = birthday
    }

    fun setEmail(email: String){
        this.email = email
    }

    fun setPassword(password: String){
        this.password = password
    }

    abstract fun getID() : Int

}