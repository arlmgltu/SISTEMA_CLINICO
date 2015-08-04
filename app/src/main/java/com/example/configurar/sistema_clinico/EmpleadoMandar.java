package com.example.configurar.sistema_clinico;


public class EmpleadoMandar {
    String cod_empleado, dni_empleado, nombre_empleado, apellidos_empleado,direccion,sueldo,sexo;
    java.util.Date fecha_ingreso;

    public String getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(String cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    public String getDni_empleado() {
        return dni_empleado;
    }

    public void setDni_empleado(String dni_empleado) {
        this.dni_empleado = dni_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellidos_empleado() {
        return apellidos_empleado;
    }

    public void setApellidos_empleado(String apellidos_empleado) {
        this.apellidos_empleado = apellidos_empleado;
    }

    public java.util.Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(java.util.Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
