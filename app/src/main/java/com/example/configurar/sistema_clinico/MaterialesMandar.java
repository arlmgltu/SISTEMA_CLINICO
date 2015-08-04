package com.example.configurar.sistema_clinico;

public class MaterialesMandar {
    String cod_materiales,nom_material,marca,funcion,material_fabricacion;

    public String getMaterial_fabricacion() {
        return material_fabricacion;
    }

    public void setMaterial_fabricacion(String material_fabricacion) {
        this.material_fabricacion = material_fabricacion;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNom_material() {
        return nom_material;
    }

    public void setNom_material(String nom_material) {
        this.nom_material = nom_material;
    }

    public String getCod_materiales() {
        return cod_materiales;
    }

    public void setCod_materiales(String cod_materiales) {
        this.cod_materiales = cod_materiales;
    }
}
