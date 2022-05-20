package com.grupopat.practicafinal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Table("PERIODO")
public class PeriodoModel {
    
    private @Column("PERIODO_CODE") @Id Integer periodo_code;
    private @Column("USERNAME") String username;

    private @Column("NOMBRE_PERIODO") String nombre_periodo;
    private @Column("MES") String mes;
    public PeriodoModel(Integer periodo_code, String username, String nombre_periodo, String mes) {
        this.periodo_code = periodo_code;
        this.username = username;
        this.nombre_periodo = nombre_periodo;
        this.mes = mes;
    }
    public PeriodoModel() {
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mes == null) ? 0 : mes.hashCode());
        result = prime * result + ((nombre_periodo == null) ? 0 : nombre_periodo.hashCode());
        result = prime * result + ((periodo_code == null) ? 0 : periodo_code.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PeriodoModel other = (PeriodoModel) obj;
        if (mes == null) {
            if (other.mes != null)
                return false;
        } else if (!mes.equals(other.mes))
            return false;
        if (nombre_periodo == null) {
            if (other.nombre_periodo != null)
                return false;
        } else if (!nombre_periodo.equals(other.nombre_periodo))
            return false;
        if (periodo_code == null) {
            if (other.periodo_code != null)
                return false;
        } else if (!periodo_code.equals(other.periodo_code))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "PeriodoModel [mes=" + mes + ", nombre_periodo=" + nombre_periodo + ", periodo_code=" + periodo_code
                + ", user_id=" + username + "]";
    }
    public Integer getPeriodo_code() {
        return periodo_code;
    }
    public void setPeriodo_code(Integer periodo_code) {
        this.periodo_code = periodo_code;
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
    public String getMes() {
        return mes;
    }
    public void setMes(String mes) {
        this.mes = mes;
    }
}