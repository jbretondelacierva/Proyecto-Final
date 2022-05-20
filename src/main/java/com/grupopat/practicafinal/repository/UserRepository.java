package com.grupopat.practicafinal.repository;

import com.grupopat.practicafinal.model.UserModel;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<UserModel, Long> {
    
    public UserModel findByUsername(String username);


    @Query("SELECT * FROM USER WHERE USERNAME =: userid")
    Iterable<UserModel> getUserByUsername(@Param("userid") String userid); 

    @Query("SELECT CONTRASENA FROM USER WHERE USERNAME =:userid ")
    String getPasswordFromUsername (@Param("userid") String userid); 

    //creacion de users 
    @Modifying
    @Query("INSERT INTO USER (username, first_name, last_name, gender, contrasena)" + "VALUES(:username, :first_name, :last_name, :gender, :contrasena)")
    void crearUser(String username, String first_name, String last_name, String gender, String password); 

}



