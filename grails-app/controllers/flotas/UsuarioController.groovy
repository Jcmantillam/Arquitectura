package flotas

class UsuarioController {

    def index() {
        
    }
    
    def init={
        String nameUser="usuario"
        String name="Pepito"
        String apellido="Jajaja"
        String mail="usuario@user.com"
        String contra="abc123"
        def u = new Usuario(nombreUsuario: nameUser, nombre: name, apellido: apellido, correo: mail, contraseña: contra)
        u.save(flush:true)
        //Usuario de la monitora
        nameUser="Yessika"
        name="Yesika Marlén"
        apellido="Ramírez"
        mail="yemramirezca@unal.edu.co"
        contra="yesiramirez1"
        u = new Usuario(nombreUsuario: nameUser, nombre: name, apellido: apellido, correo: mail, contraseña: contra)
        u.save(flush:true)
    }
    
    def Entrar={
        init()
        if(session.Usuario){
            flash.messageL="Hay un usuario logueado"
            render (view:"/logueosalir")
        }else{
            def consult = Usuario.findByNombreUsuario(params.nameUser)
            if(consult==null){
                flash.messageL="El usuario no existe"
                render (view:"/logueo")
            }else{
                if(consult.contraseña == params.password){
                    session.Usuario = consult.nombreUsuario
                    session.Nombre = consult.nombre
                    session.Apellido = consult.apellido
                    session.Correo = consult.correo
                    render view:"/usuario/usuario"
                }else{
                    flash.messageL="Contraseña incorrecta"
                    render (view:"/logueo")
                }
            }
        }
        
    }
    
    def Salir={
        session.invalidate()
        render (view:"/logueo")
    }
    
    def VolveraSesion={
        render view:"/usuario/usuario"
    }
    
    def nuevo_usuario={
        init()
        render (view:"/nuevo_usuario")
    }
    
    def Registrarse={
        def u = new Usuario(nombreUsuario: params.nameUser, nombre: params.name, apellido: params.lastname, correo: params.email, contraseña: params.password)
        if (u.validate()) {
            flash.messageM = "Usuario registrado exitosamente"
            render view:"/logueo"
            u.save(flush:true)
        }
        else {
            def error = ""
                if (u.errors.hasFieldErrors("nombreUsuario")) {
                    def consult = Usuario.findByNombreUsuario(params.nameUser)
                    if(consult!=null){
                        flash.message1 = "El nombre de usuario ya existe"
                        render view: ("/nuevo_usuario")
                    }else{
                        flash.message1 = "Debes escribir un nombre de usuario"
                        render view: ("/nuevo_usuario")
                    }
                }
                if (u.errors.hasFieldErrors("nombre")) {
                    flash.message2 = "El campo nombre es obligatorio."
                    render view: ("/nuevo_usuario")
                }
                if (u.errors.hasFieldErrors("apellido")) {
                    flash.message3 = "El campo apellido es obligatorio."
                    render view: ("/nuevo_usuario")
                }
                if (u.errors.hasFieldErrors("correo")) {
                    def consult = Usuario.findByCorreo(params.email)
                    if(consult!=null){
                        flash.message4 = "El correo ya ha sido registrado"
                        render view: ("/nuevo_usuario")
                    }else{
                        flash.message4 = "Correo no válido"
                        render view: ("/nuevo_usuario")
                    }
                }
                if (u.errors.hasFieldErrors("contraseña")) {
                    flash.message5 = "Debe ser una contraseña alfanumérica de 4 a 12 caracteres."
                    render view: ("/nuevo_usuario")
                }
        }
    }
    
    def Volver={
        render (view:"/logueo")
    }
}
