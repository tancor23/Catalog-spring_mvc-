package com.itrexgroup.vydrasergei.springmvcproject.domain.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user", schema = "catalog_mysql")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false, unique=true)
    private long id = -1;

    @Basic
    @Column(name = "first_name", nullable=false)
    private String firstName;

    @Basic
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "created_at")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String createdAt;

    private Set<Book> mappedBooks = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "user_book",
            //foreign key for CarsEntity in employee_car table
            joinColumns = @JoinColumn(name = "user_id"),
            //foreign key for other side - EmployeeEntity in employee_car table
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> getMappedBooks(){
        return mappedBooks;
    }

    public User (){}
    public User (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(createdAt, user.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, createdAt);
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}

