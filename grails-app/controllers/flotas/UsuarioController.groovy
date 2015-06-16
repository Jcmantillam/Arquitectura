package flotas

class UsuarioController {
    
    static scaffolding = true
        
    def Entrar={
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
                    session.saldo= consult.saldo
                    if(session.rol == "usuario"){
                        flash.messageB = consult.nombre
                        render view:"/usuario/vista_cliente"
                    }
                    if(session.rol == "admin"){
                        flash.messageB = consult.nombre
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
        init()
         def u = new Usuario(nombreUsuario: params.nameUser, 
                            nombre: params.name, 
                            apellido: params.lastname, 
                            correo: params.email, 
                            contraseña: params.password, 
                            rol: "usuario",
                            saldo: 1000000)
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
    
    def confCompra={
        sPasaje = params.sPasaje
        def num = Pasaje.findByIdPasaje(params.sPasaje)
        def u = new Usuario_Pasaje(nombreUsuario: session.nombreUsuario, 
                            idPasaje: num.id, 
                            placaBus: num.bus, 
                            empresa: num.empresa,
                            origen: num.origen,
                            destino: num.destino,
                            numeroComprados: 23,
                            fechaViaje: num.fechaViaje,
                            fechaVenta: num.fechaVenta,
                            precio: num.precio,
                            id: 1
                        )
        if (u.validate()) {
            flash.message = "creado"
            u.save(flush:true)
            render (view:"/usuario/admin")
        }
        [numero:num]
        
        
    }
    
    def Lista_Tiquetes={
        def tiquetes
        tiquetes = Usuario_Pasaje.findAllByNombreUsuario(session.Nombre)
        [comprados:tiquetes]
        render(view:"/usuario/consultarTiquetes")
    }
    
    def Modificar={
        
    }
    
    def ConsultCancelar={
        def tiquetes
        tiquetes = Usuario_Pasaje.findAllByNombreUsuario(session.Nombre)
        [comprados:tiquetes]
        render(view:"/usuario/cancelarBoleto")
    }
    
    def Cancelar={
        render("Cancelado")
    }
    
    def comprarPasajes={
        def num = Pasaje.findById(params.sPasaje)
        [numero:num]
    }
    
    def confirmarCompra={
        
        def pas = Pasaje.findByBus(params.getPasaje)
        int valor = 0
        if(!pas.retorno){
            valor = pas.precio
        }else{
            valor = 2*pas.precio
        }
        if(session.saldo>=valor){
            def c = new Usuario_Pasaje(nombreUsuario: session.Usuario, 
                            idPasaje: pas.id, 
                            placaBus: pas.bus, 
                            empresa: pas.bus,
                            origen: pas.origen,
                            destino: pas.destino,
                            numeroComprados: params.numPasajes,
                            precio: valor)
            //Valida el registro de la nueva venta
            c.save(flush:true)
            int numPas = pas.asiento -Integer.parseInt(params.numPasajes)
            def consult = Usuario.findByNombreUsuario(session.Usuario)
            def aux = new Usuario(nombreUsuario: consult.nombreUsuario, 
                              nombre: consult.nombre, 
                              apellido: consult.apellido, 
                              correo: consult.correo,
                              contraseña: consult.contraseña, 
                              rol: consult.rol, 
                              saldo: consult.saldo - valor)
            consult.delete(flush:true)
            aux.save(flush:true)
//            consult.saldo = consult.saldo - valor
//            println "Saldo: "+consult.saldo
//            consult.save(flush:true)
            pas.asiento = numPas
            pas.save(flush:true)
            flash.messageP="Compra exitosa"
            render view:"/usuario/vista_cliente"
        } else{
            flash.messageP="Compra Fallida"
            render view:"/usuario/vista_cliente"
        }       
    }
}
