package flotas

class PasajeController {

    def index() { }
    def crear={
         def u = new Pasaje( id: params.id, 
                            origen: params.origen, 
                            destino: params.destino, 
                            retorno: params.retorno, 
                            empresa:params.empresa,
                            placa: params.placa,
                            asiento:params.asiento,
                            fecha_viaje: params.fecha,
                            precio: params.precio, )
        if (u.validate()) {
            flash.messageM = "creado"
            render view:"/usuario/admin"
            print (u.asiento)
            u.save(flush:true)
        }
        else {
            flash.messageM = "error!"
            /*def error = ""
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
                }*/
        }
    }
}
