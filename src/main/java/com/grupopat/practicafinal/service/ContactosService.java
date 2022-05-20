package com.grupopat.practicafinal.service;

import com.grupopat.practicafinal.model.ContactosModel;

public interface ContactosService{
    Iterable<ContactosModel> getContactosByUser(String username);
    ContactosModel create(ContactosModel user);


}