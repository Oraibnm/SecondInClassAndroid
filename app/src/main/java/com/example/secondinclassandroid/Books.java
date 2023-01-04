package com.example.secondinclassandroid;

public class Books {
    private  String book_title ;
    private  String author_name;
    private String pages ;

//    public static  final Books[] books = {
//            new Books("java" , "ali", "100"),
//            new Books("C" , "mohammad", "120"),
//            new Books("data" , "rami", "440"),
//
//    };
    public Books(String book_title, String author_name, String pages) {
        this.book_title = book_title;
        this.author_name = author_name;
        this.pages = pages;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Books{" +
                "book_title='" + book_title + '\'' +
                ", author_name='" + author_name + '\'' +
                ", pages=" + pages +
                '}';
    }
}
