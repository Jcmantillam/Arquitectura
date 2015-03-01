package flotas

class Pasaje {
    String id
    int num_viaje
    String origen
    String destino
    boolean retorno
    boolean diponible
    String pasajero
    String empresa
    String placa
    String asiento
    Date fecha_viaje
    Date fecha_venta
    String precio
      
    static constraints = {
        id (blank:false, unique:true)
        num_viaje (blank:false, unique:true)
        origen (blank:false)
        destino (blank:false)
        empresa (blank: false)
        placa (blank: false, size: 6..9)
        fecha_viaje (blank: false)
        precio (blank: false)
    }
}
