package com.grupopat.practicafinal.repository;

import com.grupopat.practicafinal.model.ContactosModel;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface ContactosRepository extends CrudRepository<ContactosModel, Long>{
    
    @Query("SELECT * FROM CONTACTOS WHERE CONTACTOS.USERNAME=:username")
    Iterable<ContactosModel> getContactosByUser(String username); 

}
