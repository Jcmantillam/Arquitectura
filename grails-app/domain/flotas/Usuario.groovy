package flotas

class Usuario {
    String nombre
    String apellido
    String nombreUsuario
    String correo
    String contraseña
    
    static constraints = {
        nombreUsuario (blank:false, unique:true)
        nombre (blank:false)
        apellido (blank:false)
        correo (blank:false, unique:true, email:true)
        contraseña (blank:false, size:4..12, password:true)
    }
}
