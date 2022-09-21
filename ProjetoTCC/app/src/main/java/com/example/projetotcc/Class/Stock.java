package com.example.projetotcc.Class;

public class Stock {
    private String id;
    private String profileId;

    public Stock(String id, String profileId) {
        this.id = id;
        this.profileId = profileId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }
}
