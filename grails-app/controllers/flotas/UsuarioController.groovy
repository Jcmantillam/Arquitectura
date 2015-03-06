package flotas

class UsuarioController {

    def index(){
        
    }
    
    def logueo(){
        init()
    }
    
    def init={
        def u = new Usuario(nombreUsuario: "usuario", 
                            nombre: "Richard", 
                            apellido: "Stallman", 
                            correo: "rstall@unix.com", 
                            contraseña: "abc123", 
                            rol: "usuario")
        u.save()
        
        def admin = new Usuario(nombreUsuario: "Admin", 
                            nombre: "Camilo", 
                            apellido: "Mantilla", 
                            correo: "jcmantillam@una.edu.co", 
                            contraseña: "Camilo_89", 
                            rol: "admin")
        admin.save()
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
                    session.rol = consult.rol
                    if(session.rol == "usuario"){
                        render view:"/usuario/vista_cliente"
                    }
                    if(session.rol == "admin"){
                        render view:"/usuario/admin"
                    }
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
        if(session.rol=="usuario"){
            render (view:"/usuario/vista_cliente")
        }else{
            render (view:"/usuario/admin")
        }
    }
    
    def nuevo_usuario={
        render (view:"/nuevo_usuario")
    }
    
    def Registrarse={
         def u = new Usuario(nombreUsuario: params.nameUser, 
                            nombre: params.name, 
                            apellido: params.lastname, 
                            correo: params.email, 
                            contraseña: params.password, 
                            rol: "usuario")
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
    
    def MostrarInfo={
        render (view:"/usuario/usuario")
    }
    
    def Atras={
        if(session.rol=="usuario"){
            render (view:"/usuario/vista_cliente")
        }else{
            render (view:"/usuario/admin")
        }
    }
    
    def listado={      
        def listadoUsuarios = Usuario.list()
        [usuarios:listadoUsuarios]
    }
    
    def Comprar={
        render (view:"/usuario/comprarBoleto")
    }
    
}
