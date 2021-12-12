package com.krishana.prosolverMpr.Model;

public class UserModel {
    private String name,Profession, email , password,profile_photo,cover_photo, UserId;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public  UserModel(){

  }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }

    public String getCover_photo() {
        return cover_photo;
    }

    public void setCover_photo(String cover_photo) {
        this.cover_photo = cover_photo;
    }

    public UserModel(String name, String Profession, String email, String password) {
        this.name = name;
        this.Profession = Profession;
        this.email = email;
        this.password = password;
    };

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProffession() {
        return Profession;
    }

    public void setProffession(String Profession) {
        this.Profession = Profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
