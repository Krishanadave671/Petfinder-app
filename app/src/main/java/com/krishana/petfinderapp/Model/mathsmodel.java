package com.krishana.petfinderapp.Model;

public class mathsmodel {
    String chaptername;
    String Description;
    Integer ImageUrl;

    public mathsmodel(String chaptername, String description, Integer imageUrl) {
        this.chaptername = chaptername;
        Description = description;
        ImageUrl = imageUrl;
    }

    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Integer getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        ImageUrl = imageUrl;
    }
}
