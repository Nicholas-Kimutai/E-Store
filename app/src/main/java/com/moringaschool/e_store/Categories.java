package com.moringaschool.e_store;

public class Categories {
    int Image;
    String Tittle;

    public Categories(int image, String tittle, String details) {
        Image = image;
        Tittle = tittle;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String tittle) {
        Tittle = tittle;
    }

}
