/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author macbookpro
 */
public class Estudiante extends Persona{
    
    private String tipo_est;
    private String clave;

    public Estudiante() {
    }

    public Estudiante(String tipo_est, String clave) {
        this.tipo_est = tipo_est;
        this.clave = clave;
    }

    public Estudiante(String tipo_est, String clave, String cedula, String pnombre, String snombre, String papellido, String mapellido, String fnac, String genero, String ciudad, String correo) {
        super(cedula, pnombre, snombre, papellido, mapellido, fnac, genero, ciudad, correo);
        this.tipo_est = tipo_est;
        this.clave = clave;
    }

 

    public String getTipo_est() {
        return tipo_est;
    }

    public void setTipo_est(String tipo_est) {
        this.tipo_est = tipo_est;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    
    
}
