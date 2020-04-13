package models;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id_num")
    private long id;

    @Column(name = "exp")
    private int exp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public User(long id,int exp) {
        this.id=id;
        this.exp = exp;
    }

    public User() {
    }


}
