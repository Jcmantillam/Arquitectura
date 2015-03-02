package flotas

class Pasaje {
    
    int id
    String origen
    String destino
    boolean retorno
    boolean disponible
    String pasajero
    String empresa
    String placa
    String asiento
    Date fecha_viaje
    Date fecha_venta
    String precio
      
    static constraints = {
        id (blank:false, unique:true)
        origen (blank:false)
        destino (blank:false)
        empresa (blank: false)
        asiento (blank:false)
        placa (blank: false, size: 6..9)
        fecha_viaje (blank: false)
        precio (blank: false)
    }
}
