/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joansanchezuf6;

/**
 *
 * @author Joan
 */
public class Serie {
    String nombre;
    int temporadas;
    String genero;
    float gasto;
    
    public Serie() { }

    public Serie(String nombre, int temporadas, String genero, float gasto) {
        this.nombre = nombre;
        this.temporadas = temporadas;
        this.genero = genero;
        this.gasto = gasto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getGasto() {
        return gasto;
    }

    public void setGasto(float gasto) {
        this.gasto = gasto;
    }

    @Override
    public String toString() {
        return "Serie{" + "nombre=" + nombre + ", temporadas=" + temporadas + ", genero=" + genero + ", gasto=" + gasto + '}';
    }
}
