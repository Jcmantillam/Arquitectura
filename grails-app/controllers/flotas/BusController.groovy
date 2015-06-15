package flotas

class BusController {
    
    static scaffolding = true
    
    def index() { }
    def init() { }
    def vistaBus={
        render (view: "/bus/crearBus")
    }
    def crearBus={
        def b = new Bus(idBus: params.id,
                        placaBus:params.placa,
                        conductorAsignado: params.cond,
                        idEmpresa:params.idemp,
                        numeroSillas: params.num,
                        tipoBus: params.btipo )
        def e = Empresa.findByIdEmpresa(params.idemp)
        b.setEmpresa(e)
        if (b.validate()) {
            flash.messageB = "Bus Creado"
            b.save(flush:true)
            render (view:"/usuario/admin")
        }
        else{
            def error= ""
            if(b.errors.hasFieldErrors("id")){
                flash.messajeCO="ID duplicado o con formato equivocado"
            }
            if(b.errors.hasFieldErrors("placa")){
                flash.messajePL="error en la placa"
            }
            if(b.errors.hasFieldErrors("num")){
                flash.messajeNM="error en en numero de sillas"
            }
            if(b.errors.hasFieldErrors("cond")){
                flash.messajeCO="error en el nombre del conductor"
            }
            if(b.errors.hasFieldErrors("btipo")){
                flash.messajeBT="error en el tipo de bus"
            }
            if(b.errors.hasFieldErrors("idemp")){
                flash.messajeID="error en el ID de la Empresa"
            }
            render (view: "/bus/crearBus")
            
            
        }
    }
   
}
