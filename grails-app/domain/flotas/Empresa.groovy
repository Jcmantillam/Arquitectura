package flotas

class Empresa {
    
    String idEmpresa
    String nombreEmpresa

    //static hasMany = [buses:Bus]
    
    static constraints = {
       // id (blank:false, unique:true)
        //nombreEmpresa (blank:false, unique:true)
    }
    
    static mapping={
        table "Empresa"
        id generator: 'assigned', name: "idEmpresa", type: 'string'
        version false
        columns{
            idEmpresa column: 'idEmpresa'
            nombreEmpresa column: 'nombreEmpresa'
        }
    }
}
