package com.krishana.prosolverMpr.Model;

public class DashboardModel {

    int profile , postimage , save;
    String name , like , comment, about, share;

    public DashboardModel(int profile, int postimage, int save, String name, String like, String comment, String about, String share) {
        this.profile = profile;
        this.postimage = postimage;
        this.save = save;
        this.name = name;
        this.like = like;
        this.comment = comment;
        this.about = about;
        this.share = share;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public int getPostimage() {
        return postimage;
    }

    public void setPostimage(int postimage) {
        this.postimage = postimage;
    }

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }
}
