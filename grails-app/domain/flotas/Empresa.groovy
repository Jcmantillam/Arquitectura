package flotas

class Empresa {
    
    int idEmpresa
    String representanteLegal

    static hasMany = [bus:Bus]
    
    static constraints = {
        idEmpresa (blank:false, unique:true)
        representanteLegal (blank:false)
    }
    
    static mapping={
        table "Empresas"
        version false
    }
}
