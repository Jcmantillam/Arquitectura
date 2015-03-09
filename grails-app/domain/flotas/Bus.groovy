package flotas

class Bus {
    String idBus
    String placaBus
    String conductorAsignado
    String idEmpresa
    String numeroSillas//Por definir tipo
    String tipoBus
   
    
    //static hasMany = [pasajes:Pasaje]
    //static belongsTo = [empresa:Empresa]
    
    static constraints = {
        //placaBus (blank:false, unique:true, matches:"[a-zA-Z][a-zA-Z][a-zA-Z]\\d{3}")//Placas con 3 letras y 3 dígitos
        //idEmpresa (blank:false, unique:true)
        idEmpresa (blank:false)
        conductorAsignado (blank:false)
        tipoBus (blank:false, inList:["microbus","minibus","midibus"])//microbus de 8 a 12 asientos, minibus de 20 a 35, midibus de 30 a 45 asientos
    }
    
    static mapping = {
        table "Buses"
        version false
        id generator: "assigned", name: "placaBus"//key debrá ser la mtrícula del bus
    }
}
