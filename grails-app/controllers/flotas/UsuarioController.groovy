package flotas

class UsuarioController {
    
    def gen
    
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
        u.save(flush:true)
        
        def admin = new Usuario(nombreUsuario: "Admin", 
                            nombre: "Camilo", 
                            apellido: "Mantilla", 
                            correo: "jcmantillam@una.edu.co", 
                            contraseña: "Camilo_89",
                            rol: "admin")
        admin.save(flush:true)
        
        //Para guardar con relaciones:
        //int id = 1
        //def bus = new Bus(placaBus:"huk123", numeroSillas:30, conductorAsignado:"Raúl", tipoBus:"midibus")
        
        //def empresa = new Empresa(idEmpresa:"2", nombreEmpresa:"mic")
        //empresa.addToBuses(bus)
        //bus.setEmpresa(empresa)
        
        //empresa.save(flush:true)
        //bus.save(flush:true)
        
       // print(empresa.idEmpresa)
//    String placaBus
//    int idEmpresa
//    int numeroSillas//Por definir tipo
//    String conductorAsignado
//    String tipoBus        
    }
    
    def Entrar={
        //init()
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
        
       println num.id
       println num.bus
       println num.empresa
       println num.origen
       println num.destino
       println num.fechaViaje
       println num.fechaVenta
       println num.precio
       println u.validate()
        if (u.validate()) {
            flash.message = "creado"
            //print (u.asiento)
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
        println params.sPasaje
        [numero:num]
    }
    
    def confirmarCompra={
        def pas = Pasaje.findByBus(params.getPasaje)
        int numPas = Integer.parseInt(pas.asiento) -Integer.parseInt(params.numPasajes)
        pas.asiento = Integer.toString(numPas)
        pas.save(flush:true)
        flash.messageP="Compra exitosa"
        render view:"/usuario/vista_cliente"
        
    }
}
