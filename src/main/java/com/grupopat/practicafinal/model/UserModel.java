package com.grupopat.practicafinal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("USER")
public class UserModel {

    private @Column("USER_ID") @Id Integer user_id;
    private @Column("USERNAME") String username;
    private @Column("FIRST_NAME") String first_name;
    private @Column("LAST_NAME") String last_name;
    private @Column("GENDER") String gender;
    private @Column("CONTRASENA") String contrasena;
   

    
    

    public UserModel(String username, String first_name, String last_name, String gender) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
       
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


}


