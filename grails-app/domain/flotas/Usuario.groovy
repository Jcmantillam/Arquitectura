package flotas

class Usuario {
    String nombre
    String apellido
    String nombreUsuario
    String correo
    String rol
    String contraseña
    
    static constraints = {
        nombreUsuario (blank:false, unique:true)
        nombre (blank:false)
        apellido (blank:false)
        correo (blank:false, unique:true, email:true)
        contraseña (blank:false, size:4..12, password:true)
        rol (inList:["usuario","admin"])
    }
    
    static mapping={
        table "Usuario"
        version false
        columns{
            id nombreUsuario: 'Nombre_de_usuario'
            nombre column: 'Nombre'
            apellido column: 'Apellido'
            correo column: 'Correo'
            rol column: 'Rol'
        }
    }
}
