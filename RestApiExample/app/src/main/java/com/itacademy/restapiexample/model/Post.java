package com.itacademy.restapiexample.model;

public class Post {

    int userId;
    int id;
    String title;
    String body;

    public Post(int id, String title, String body) {
        this.userId = 1; //Usuario por defecto (no relevante para el ejercicio)
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post( String title, String body) {
        this.userId = 1; //Usuario por defecto (no relevante para el ejercicio)

        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
