package flotas

class Pasaje {
    int num_viaje
    String origen
    String destino
    boolean retorno
    String pasajero
    String empresa
    String placa
    String asiento
    Date fecha_viaje
    Date fecha_venta
    String precio
      
    static constraints = {
        num_viaje (blank:false, unique:true)
        origen (blank:false)
        destino (blank:false)
        pasajero (blank: false)
        empresa (blank: false)
        placa (blank: false, size: 6..9)
        fecha_viaje (blank: false)
        precio (blank: false)
    }
}
