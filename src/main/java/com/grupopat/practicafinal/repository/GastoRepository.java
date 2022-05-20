package com.grupopat.practicafinal.repository;


import com.grupopat.practicafinal.model.GastoModel;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface GastoRepository extends CrudRepository<GastoModel, Long>{

    
    @Query("SELECT * FROM GASTO WHERE GASTO.NOMBRE_PERIODO =:gastos_name AND GASTO.USERNAME =:user_name")
    Iterable<GastoModel> getGastosByPeriodo(String gastos_name,String user_name);

    

}


