package com.axonactive.virtual_proxy;

public interface BookViewer {
    public String getName();
    public String getAuthor();
    public boolean isAvailable();
    public void showALargeContentOfTheBook();
}
