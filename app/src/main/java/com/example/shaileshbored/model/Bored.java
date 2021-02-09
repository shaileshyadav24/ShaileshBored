package com.example.shaileshbored.model;

public class Bored {
    String activity;
    String type;
    String link;

    public Bored(String activity, String type, String link) {
        this.activity = activity;
        this.type = type;
        this.link = link;
    }

    public Bored() {
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
