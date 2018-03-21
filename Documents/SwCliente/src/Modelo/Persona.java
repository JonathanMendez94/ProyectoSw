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
public class Persona {
    
    private String cedula;
    private String pnombre;
    private String snombre;
    private String papellido;
    private String mapellido;
    private String fnac;
    private String genero;
    private String ciudad;
    private String correo;

    public Persona() {
    }

    public Persona(String cedula, String pnombre, String snombre, String papellido, String mapellido, String fnac, String genero, String ciudad, String correo) {
        this.cedula = cedula;
        this.pnombre = pnombre;
        this.snombre = snombre;
        this.papellido = papellido;
        this.mapellido = mapellido;
        this.fnac = fnac;
        this.genero = genero;
        this.ciudad = ciudad;
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPnombre() {
        return pnombre;
    }

    public void setPnombre(String pnombre) {
        this.pnombre = pnombre;
    }

    public String getSnombre() {
        return snombre;
    }

    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }

    public String getPapellido() {
        return papellido;
    }

    public void setPapellido(String papellido) {
        this.papellido = papellido;
    }

    public String getMapellido() {
        return mapellido;
    }

    public void setMapellido(String mapellido) {
        this.mapellido = mapellido;
    }

    public String getFnac() {
        return fnac;
    }

    public void setFnac(String fnac) {
        this.fnac = fnac;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Persona{" + "cedula=" + cedula + ", pnombre=" + pnombre + ", snombre=" + snombre + ", papellido=" + papellido + ", mapellido=" + mapellido + ", fnac=" + fnac + ", genero=" + genero + ", ciudad=" + ciudad + ", correo=" + correo + '}';
    }
    
          
    
    
}
