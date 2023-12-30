package com.example.login;

public class User {
    protected String fullName;
    protected String userName;
    protected String password;
    static final User DEFAULT_USER =new User("admin","admin","admin");
    public User(String fullName, String userName,String password){
        this.fullName= fullName;
        this.userName= userName;
        this.password= password;
    }



    @Override
    public String toString(){
        return String.format("%9s ==> %15s %15s %8s",fullName,userName,password);
    }


}
