package flotas

class Pasaje {
    
    String nombreUsuario
    String origen
    String destino
    boolean retorno
    boolean disponible
    //String pasajero
    String empresa
    String bus
    String asiento //Por definir si es un int o un String
    Date fechaViaje
    Date fechaVenta
    String precio
    
    //static belongsTo = [bus:Bus]
      
    static constraints = {
        //nombreUsuario (unique:true)
        //fechaViaje (min: new Date())//el viaje debe ser de al menos la fecha de compra
    }
    
    static mapping={
        table "Pasajes"
        version false
    }
}
