package com.example.configurar.sistema_clinico;

public class ResultadosMandar {
    String nomb_analisis, descripcion_tipo_analisis,descripcion_resultado,fecha_resultado,nomb_cliente,apell_cliente;

    public String getNomb_analisis() {
        return nomb_analisis;
    }

    public void setNomb_analisis(String nomb_analisis) {
        this.nomb_analisis = nomb_analisis;
    }

    public String getDescripcion_tipo_analisis() {
        return descripcion_tipo_analisis;
    }

    public void setDescripcion_tipo_analisis(String descripcion_tipo_analisis) {
        this.descripcion_tipo_analisis = descripcion_tipo_analisis;
    }

    public String getFecha_resultado() {
        return fecha_resultado;
    }

    public void setFecha_resultado(String fecha_resultado) {
        this.fecha_resultado = fecha_resultado;
    }

    public String getDescripcion_resultado() {
        return descripcion_resultado;
    }

    public void setDescripcion_resultado(String descripcion_resultado) {
        this.descripcion_resultado = descripcion_resultado;
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
}
