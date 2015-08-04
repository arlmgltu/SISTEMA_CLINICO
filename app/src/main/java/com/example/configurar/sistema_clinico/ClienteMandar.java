package com.example.configurar.sistema_clinico;


import java.util.Date;

public class ClienteMandar {
    String cod_cliente,dni_cliente,nomb_cliente,apell_cliente,ciudad_cliente,sexo_cliente,distrito_cliente;
    Date fecha_nac;

    public String getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(String cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getDni_cliente() {
        return dni_cliente;
    }

    public void setDni_cliente(String dni_cliente) {
        this.dni_cliente = dni_cliente;
    }

    public String getNomb_cliente() {
        return nomb_cliente;
    }

    public void setNomb_cliente(String nomb_cliente) {
        this.nomb_cliente = nomb_cliente;
    }

    public String getApell_cliente() {
        return apell_cliente;
    }

    public void setApell_cliente(String apell_cliente) {
        this.apell_cliente = apell_cliente;
    }

    public String getSexo_cliente() {
        return sexo_cliente;
    }

    public void setSexo_cliente(String sexo_cliente) {
        this.sexo_cliente = sexo_cliente;
    }

    public String getCiudad_cliente() {
        return ciudad_cliente;
    }

    public void setCiudad_cliente(String ciudad_cliente) {
        this.ciudad_cliente = ciudad_cliente;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getDistrito_cliente() {
        return distrito_cliente;
    }

    public void setDistrito_cliente(String distrito_cliente) {
        this.distrito_cliente = distrito_cliente;
    }
}

