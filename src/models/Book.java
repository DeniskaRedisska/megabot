package models;

import javax.persistence.*;

@Entity
@Table(name = "booksee")
public class Book {

    public Book() {

    }

    public Book(String name,String author,int quantity) {
        this.name = name;
        this.author = author;
        this.quantity = quantity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_num")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "quantity")
    private int quantity;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }
}
