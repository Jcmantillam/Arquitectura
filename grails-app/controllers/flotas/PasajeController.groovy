package flotas

class PasajeController {

    def index() { }
    def vistaPasaje={
        render (view: "/pasaje/crear")
    }
    
    def crear={
        println params.origen
        println params.destino
        println params.empresa
        println params.bus
        println params.asiento
        println params.fecha
        println params.precio
         def u = new Pasaje(nombreUsuario: 'default', 
                            origen: params.origen, 
                            destino: params.destino, 
                            retorno: 0,
                            disponible: 1,
                            empresa: "23",
                            bus: params.bus,
                            asiento:params.asiento,
                            fechaViaje: params.fecha,
                            fechaVenta: params.fecha,
                            precio: params.precio)
        println params.bus
        def b = Bus.findByPlacaBus(params.bus)
        b.
        println b

      //  u.setBus(b)
        if (u.validate()) {
            flash.message = "creado"
            //print (u.asiento)
            u.save(flush:true)
            render (view:"/usuario/admin")
        }
        else {
            //flash.message = "error!"
            
            def error = ""
                if (u.errors.hasFieldErrors("origen")) {
                    flash.message = "origen"
                }
                if (u.errors.hasFieldErrors("destino")) {
                    flash.message = "destino"
                }
                if (u.errors.hasFieldErrors("empresa")) {
                    flash.message = "empresa"
                }
                if (u.errors.hasFieldErrors("bus")) {
                    flash.message = "bus"
                }
                if (u.errors.hasFieldErrors("asiento")) {
                    flash.message = "asiento"
                }
                if (u.errors.hasFieldErrors("fecha")) {
                    flash.message = "fecha"
                }
                if (u.errors.hasFieldErrors("precio")) {
                    flash.message = "precio"
                }
                if (u.errors.hasFieldErrors("retorno")) {
                    flash.message = "retorno"
                }
                if (u.errors.hasFieldErrors("nombreUsuario")) {
                    flash.message = "NU"
                }
                else flash.message="en otros"
                render view:"/pasaje/crear"
        }
    }
    
}
