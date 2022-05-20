package com.grupopat.practicafinal.repository;

import com.grupopat.practicafinal.model.PeriodoModel;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PeriodoRepository extends CrudRepository<PeriodoModel, Long> {
    
    @Query("SELECT * FROM PERIODO WHERE USERNAME =:username ")
    Iterable<PeriodoModel> getPeriodoByUsername(@Param("username") String username); 
}
