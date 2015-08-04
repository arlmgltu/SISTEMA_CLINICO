package com.example.configurar.sistema_clinico;

public class TipoAnalisisMandar {
    String cod_tipo_analisis,nomb_analisis,descripcion_tipo_analisis,cod_area,num_especificacion,cod_tipo_muestra;
    Integer costo;

    public String getCod_tipo_analisis() {
        return cod_tipo_analisis;
    }

    public void setCod_tipo_analisis(String cod_tipo_analisis) {
        this.cod_tipo_analisis = cod_tipo_analisis;
    }

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

    public String getCod_area() {
        return cod_area;
    }

    public void setCod_area(String cod_area) {
        this.cod_area = cod_area;
    }

    public String getNum_especificacion() {
        return num_especificacion;
    }

    public void setNum_especificacion(String num_especificacion) {
        this.num_especificacion = num_especificacion;
    }

    public String getCod_tipo_muestra() {
        return cod_tipo_muestra;
    }

    public void setCod_tipo_muestra(String cod_tipo_muestra) {
        this.cod_tipo_muestra = cod_tipo_muestra;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }
}
