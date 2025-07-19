package App01;
import java.time.Year;

public class Estudiante implements Persona {
    private String nombre;
    private String apellido;
    private String identificacion;
    private int edad;
    private String carrera;
    private int semestre;
    private double promedio;
    private String telefono;
    private String correo;
    private int anioIngreso;

    public Estudiante(String nombre, String apellido, String identificacion, int edad,
                      String carrera, int semestre, int anioIngreso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.edad = edad;
        this.carrera = carrera;
        this.semestre = semestre;
        this.anioIngreso = anioIngreso;
        this.promedio = 0.0;
    }

    // Métodos interfaz Persona
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getIdentificacion() {
        return identificacion;
    }

    @Override
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public int getEdad() {
        return edad;
    }

    @Override
    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("=== INFORMACIÓN DEL ESTUDIANTE ===");
        System.out.println("Nombre: " + obtenerNombreCompleto());
        System.out.println("Identificación: " + identificacion);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Carrera: " + carrera);
        System.out.println("Semestre: " + semestre);
        System.out.println("Promedio: " + promedio);
        System.out.println("Antigüedad: " + calcularAntiguedad() + " años");
        System.out.println("Teléfono: " + telefono);
        System.out.println("Correo: " + correo);
    }

    @Override
    public String getTipoPersona() {
        return "Estudiante";
    }

    @Override
    public int calcularAntiguedad() {
        return Year.now().getValue() - anioIngreso;
    }

    @Override
    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String obtenerNombreCompleto() {
        return nombre + " " + apellido;
    }

    @Override
    public void actualizarDatosContacto(String telefono, String correo) {
        this.telefono = telefono;
        this.correo = correo;
    }
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public void estudiar() {
        System.out.println(nombre + " está estudiando para " + carrera);
    }

    public void presentarExamen() {
        System.out.println(nombre + " está presentando un examen");
    }
}
