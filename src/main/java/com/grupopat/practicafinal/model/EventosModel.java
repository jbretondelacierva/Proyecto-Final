package com.grupopat.practicafinal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("EVENTOS")
public class EventosModel {
    private @Column("ID_EVENTO") @Id Integer id_evento;
    private @Column("USERNAME") String username;
    private @Column("NOMBRE") String nombre;
    private @Column("DESCRIPCION") String descripcion;
    private @Column("MES") String mes; 



    public EventosModel() {
    }

    public Integer getId_evento() {
        return id_evento;
    }

    public void setId_evento(Integer id_evento) {
        this.id_evento = id_evento;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventosModel that = (EventosModel) o;
        return Objects.equals(id_evento, that.id_evento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_evento);
    }

    @Override
    public String toString() {
        return "EventosModel [descripcion=" + descripcion + ", id_evento=" + id_evento + ", mes=" + mes + ", nombre="
                + nombre + ", username=" + username + "]";
    }
}
