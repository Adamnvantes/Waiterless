package com.example.waiterless.Objects

abstract class Person(name : String, birthday : String, email : String) {
    private var name = name
    private var birthday = birthday
    private var email = email

    fun getName() : String{
        return name;
    }

    fun getBirthday() : String{
        return birthday
    }

    fun getEmail() : String{
        return email
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

}