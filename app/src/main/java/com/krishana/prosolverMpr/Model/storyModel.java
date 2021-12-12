package com.krishana.prosolverMpr.Model;

public class storyModel {
    int story , storytype,profile;
    String name;

    public storyModel(int story, int storytype, int profile, String name) {
        this.story = story;
        this.storytype = storytype;
        this.profile = profile;
        this.name = name;
    }

    public int getStory() {
        return story;
    }

    public void setStory(int story) {
        this.story = story;
    }

    public int getStorytype() {
        return storytype;
    }

    public void setStorytype(int storytype) {
        this.storytype = storytype;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
