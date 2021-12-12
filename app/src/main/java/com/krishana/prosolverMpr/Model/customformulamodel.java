package com.krishana.prosolverMpr.Model;

public class customformulamodel {
    int profileImage, bookmark ;
    String Username,proffession, title,Formula, like , share, comment;

    public customformulamodel(int profileImage, int bookmark, String username, String proffession, String title, String formula, String like, String share, String comment) {
        this.profileImage = profileImage;
        this.bookmark = bookmark;
        Username = username;
        this.proffession = proffession;
        this.title = title;
        Formula = formula;
        this.like = like;
        this.share = share;
        this.comment = comment;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public int getBookmark() {
        return bookmark;
    }

    public void setBookmark(int bookmark) {
        this.bookmark = bookmark;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getProffession() {
        return proffession;
    }

    public void setProffession(String proffession) {
        this.proffession = proffession;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormula() {
        return Formula;
    }

    public void setFormula(String formula) {
        Formula = formula;
    }


    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
