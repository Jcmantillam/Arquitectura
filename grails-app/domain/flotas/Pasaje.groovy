package flotas

class Pasaje {
    
    String nombreUsuario
    String placaBus
    String origen
    String destino
    boolean retorno
    boolean disponible
    String pasajero
    String empresa
    String placa
    int asiento //Por definir si es un int o un String
    Date fechaViaje
    Date fechaVenta
    int precio
    
    static belongsTo = [bus:Bus]
      
    static constraints = {
        nombreUsuario (unique:true)
        placaBus (matches:"[a-zA-Z][a-zA-Z][a-zA-Z]\\d{3}", unique:true)//valida que la palca sea 3 l3tras consecutivas y 3 números consecutivos
        fechaViaje (min: new Date())//el viaje debe ser de al menos la fecha de compra
    }
    
    static mapping={
        table "Pasajes"
        version false
    }
}
