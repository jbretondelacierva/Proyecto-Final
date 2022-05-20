package com.grupopat.practicafinal.service;

import com.grupopat.practicafinal.model.EventosModel;

public interface EventosService{
    Iterable<EventosModel> getEventosByUser(String username);
    EventosModel create(EventosModel user);

}
