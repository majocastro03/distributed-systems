package App01;
public interface Persona {
    String getNombre();
    void setNombre(String nombre);
    String getApellido();
    void setApellido(String apellido);
    String getIdentificacion();
    void setIdentificacion(String identificacion);
    int getEdad();
    void setEdad(int edad);
    void mostrarInformacion();
    String getTipoPersona();
    int calcularAntiguedad();  
    boolean esMayorDeEdad();  
    String obtenerNombreCompleto();
    void actualizarDatosContacto(String telefono, String correo);
}
