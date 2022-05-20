package com.grupopat.practicafinal.service;

import com.grupopat.practicafinal.model.GastoModel;

public interface GastoService{

    Iterable<GastoModel> getGastosByPeriodo(String gastos_name,String user_name);
    GastoModel create(GastoModel user);


}