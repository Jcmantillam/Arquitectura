package flotas

class Pasaje {
    
    String origen
    String destino
    boolean retorno
    boolean disponible
    String empresa
    String bus
    int asiento //Por definir si es un int o un String
    Date fechaViaje
    Date fechaVenta
    int precio
    
    
    static hasMany = [usuarioPasaje: Usuario_Pasaje]
    static belongsTo = [bus:Bus]
    
    static constraints = {
        //nombreUsuario (unique:true)
        //fechaViaje (min: new Date())//el viaje debe ser de al menos la fecha de compra
    }
    
    static mapping={
        table "Pasajes"
        version false
    }
    public String getOrigenAndDestino() { return "$origen, $destino" }
}
