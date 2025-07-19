package App01;
import java.time.Year;

public class Docente implements Persona {
    private String nombre;
    private String apellido;
    private String identificacion;
    private int edad;
    private String departamento;
    private String especialidad;
    private double salario;
    private int anosExperiencia;
    private String telefono;
    private String correo;
    private int anioIngreso;

    public Docente(String nombre, String apellido, String identificacion, int edad,
                   String departamento, String especialidad, int anosExperiencia, int anioIngreso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.edad = edad;
        this.departamento = departamento;
        this.especialidad = especialidad;
        this.anosExperiencia = anosExperiencia;
        this.anioIngreso = anioIngreso;
        this.salario = 0.0;
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
        System.out.println("=== INFORMACIÓN DEL DOCENTE ===");
        System.out.println("Nombre: " + obtenerNombreCompleto());
        System.out.println("Identificación: " + identificacion);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Departamento: " + departamento);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Años de experiencia: " + anosExperiencia);
        System.out.println("Antigüedad: " + calcularAntiguedad() + " años");
        System.out.println("Teléfono: " + telefono);
        System.out.println("Correo: " + correo);
        System.out.println("Salario: $" + salario);
    }

    @Override
    public String getTipoPersona() {
        return "Docente";
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public void darClase() {
        System.out.println("El profesor " + nombre + " está dando clase de " + especialidad);
    }

    public void calificarExamenes() {
        System.out.println("El profesor " + nombre + " está calificando exámenes");
    }

    public void investigar() {
        System.out.println("El profesor " + nombre + " está realizando investigación en " + especialidad);
    }
}
