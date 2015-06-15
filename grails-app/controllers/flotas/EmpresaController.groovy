package flotas

class EmpresaController {
    
    static scaffolding = true
    
    def index() {
    init()
    }
    def init() { 
        def e = new Empresa (idEmpresa:'0',
                            nombreEmpresa:'generic')
        e.save(flush:true)
    }
    def vistaCrear={
        render (view: "/empresa/crearEmpresa")
    }
    def crearEmpresa={
        //init()
        def e= new Empresa (idEmpresa:params.idemp,
                            nombreEmpresa:params.nmemp)
        if (e.validate()) {
            flash.messageB = "Empresa registrada"
            e.save(flush:true)
            render (view:"/usuario/admin")
            
        }
        else{
            //flash.messajeID="algo sin razon salio mal"
            def error = ""
                if (e.errors.hasFieldErrors("idemp")) {
                    flash.messageID = "error en el campo ID"
                    render (view: "/empresa/crearEmpresa")
                }
                if (e.errors.hasFieldErrors("nmemp")) {
                    flash.messageNE = "error en el campo nombre"
                    render (view: "/empresa/crearEmpresa")
                }
               
        }
    }
}
        
    
