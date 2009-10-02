package ar.edu.uade.ingsoft.model;

import ar.edu.uade.ingsoft.beans.Direccion;
import ar.edu.uade.ingsoft.beans.Persona;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    public static DataProvider INSTANCE = new DataProvider();

    private List<Persona> personas = new ArrayList<Persona>();


    private DataProvider() {
        for (int i = 1; i <= 3; i++) {
            Direccion direccion = new Direccion();
            direccion.setCalle("calle " + i);
            direccion.setNumero(i);
            direccion.setProvincia("provincia " + i);

            Persona persona = new Persona();
            persona.setNombre("nombre " + i);
            persona.setApellido("apellido " + i);
            persona.setDireccion(direccion);

            personas.add(persona);
        }
    }


    public List<Persona> getPersonas() {
        return personas;
    }


    public void addPersona(Persona p) {
        personas.add(p);
    }
}
