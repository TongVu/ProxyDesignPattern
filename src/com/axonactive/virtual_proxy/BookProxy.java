package com.axonactive.virtual_proxy;

public class BookProxy implements BookViewer{
    private String name;
    private String author;
    private boolean available;

    public BookProxy(String name, String author, boolean available) {
        this.name = name;
        this.author = author;
        this.available = available;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public boolean isAvailable() {
        return this.available;
    }

    @Override
    public void showALargeContentOfTheBook(){
        System.out.println("This...is...a...massive...humongous...content...of...this...book");
    }

    public RealBook click(){
        return new RealBook(this.name, this.author, this.available);
    }

    public static void main(String[] args) {
        BookViewer book = new BookProxy("English Grammar In Use", "Murphy", true);
        book.showALargeContentOfTheBook();

        book = ((BookProxy)book).click();
        book.showALargeContentOfTheBook();
    }
}
