package com.axonactive.virtual_proxy;

public class RealBook implements BookViewer{
    private String name;
    private String author;
    private boolean available;

    public RealBook(String name, String author, boolean available) {
        this.name = name;
        this.author = author;
        this.available = available;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getAuthor() {
        return null;
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void showALargeContentOfTheBook(){
        System.out.println("This...is...a...massive...humongous...content...of...this...book");
    }
}
