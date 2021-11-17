package com.example.rquiz;

public class SubjectName {
    //Initialise variables
    int Image;
    String subject;
    String description;

    //Constructor
    public SubjectName(int image, String subject, String description) {
        Image = image;
        this.subject = subject;
        this.description = description;
    }

    //Get image
    public int getImage() {
        return Image;
    }

    //Set image
    public void setImage(int image) {
        Image = image;
    }

    //Get subject
    public String getSubject() {
        return subject;
    }

    //Set subject
    public void setSubject(String subject) {
        this.subject = subject;
    }

    //Get description
    public String getDescription() {
        return description;
    }

    //Set description
    public void setDescription(String description) {
        this.description = description;
    }
}