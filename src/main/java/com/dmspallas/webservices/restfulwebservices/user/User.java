package com.dmspallas.webservices.restfulwebservices.user;

import com.dmspallas.webservices.restfulwebservices.database.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel(description = "Details about the user")
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 5, message = "Name should have at least 5 characters")
    @ApiModelProperty(notes = "Name should have at least 5 characters")
    private String name;
    @Past
    private Date birthDate;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    protected User() {
    }

    public List<Post> getPosts() {
        return posts;
    }

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

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + birthDate +
                '}';
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
}
