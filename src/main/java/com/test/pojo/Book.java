package com.test.pojo;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public class Book implements Serializable {

    private static final long serialVersionUID = -7512953920969176046L;

    private Integer id;

    private String name;

    private Integer price;

    private String author;

    private String isbn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("price=" + price)
                .add("author='" + author + "'")
                .add("isbn='" + isbn + "'")
                .toString();
    }
}
