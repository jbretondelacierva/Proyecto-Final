package com.grupopat.practicafinal.repository;


import com.grupopat.practicafinal.model.EventosModel;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface EventosRepository extends CrudRepository<EventosModel, Long>{

    @Query("SELECT * FROM EVENTOS WHERE EVENTOS.USERNAME=:username")
    Iterable<EventosModel> getEventosByUser(String username); 

}
