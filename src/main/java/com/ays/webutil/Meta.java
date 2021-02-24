package com.ays.webutil;

public class Meta {
    private int firstPage;
    private int lastPage;
    private int count;

    public Meta(int firstPage, int lastPage, int count) {
        this.firstPage = firstPage;
        this.lastPage = lastPage;
        this.count = count;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public int getCount() {
        return count;
    }
}
