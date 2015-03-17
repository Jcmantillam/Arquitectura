package flotas

class Usuario {
    
    String nombre
    String apellido
    String nombreUsuario
    String correo
    String rol
    String contraseña
    
    static hasMany = [usuarioPasaje: Usuario_Pasaje]
    
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
        id generator: 'assigned', name: "nombreUsuario", type: 'string'
        version false
        columns{
            nombreUsuario column: 'Nomn'
            nombre column: 'Nombre'
            apellido column: 'Apellido'
            correo column: 'Correo'
            rol column: 'Rol'
        }
    }
}
