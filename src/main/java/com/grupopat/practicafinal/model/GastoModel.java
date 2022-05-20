package com.grupopat.practicafinal.model;

import java.sql.Date;
import java.util.Objects;

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
@Table("GASTO")
public class GastoModel {
    private @Column("ID_GASTO") @Id Integer id_gasto;
    private @Column("USERNAME") String username;

    private @Column("NOMBRE_PERIODO") String nombre_periodo;

    private @Column("CONCEPTO") String concepto;
    private @Column("IMPORTE") Float importe;
    private @Column("FECHA") Date fecha;
    public Integer getId_gasto() {
        return id_gasto;
    }
    public void setId_gasto(Integer id_gasto) {
        this.id_gasto = id_gasto;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getNombre_periodo() {
        return nombre_periodo;
    }
    public void setNombre_periodo(String nombre_periodo) {
        this.nombre_periodo = nombre_periodo;
    }
    public String getConcepto() {
        return concepto;
    }
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    public Float getImporte() {
        return importe;
    }
    public void setImporte(Float importe) {
        this.importe = importe;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GastoModel that = (GastoModel) o;
        return Objects.equals(id_gasto, that.id_gasto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_gasto);
    }
}
