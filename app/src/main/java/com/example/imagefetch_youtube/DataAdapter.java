package com.example.imagefetch_youtube;


public class DataAdapter
{
    public String ImageURL;
    public String ImageTitle;
    public String ImagePrice;
    public String ImageDesc;

    public String getImageUrl() {
        return ImageURL;
    }

    public void setImageUrl(String imageServerUrl) {
        this.ImageURL = imageServerUrl;
    }

    public String getImageTitle() {
        return ImageTitle;
    }

    public String getImagePrice() {
        return ImagePrice;
    }

    public String getImageDesc() {
        return ImageDesc;
    }



    public void setImageTitle(String Imagetitlename) {
        this.ImageTitle = Imagetitlename;
    }

    public void setImagePrice(String Imagetitleprice) {
        this.ImagePrice = Imagetitleprice;
    }

    public void setImageDesc(String Imagetitledesc) {
        this.ImageDesc = Imagetitledesc;
    }


}