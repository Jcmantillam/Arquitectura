package flotas

class Usuario_Pasaje {
    
    String nombreUsuario
    String idPasaje
    String placaBus
    String empresa
    String origen
    String destino
    int numeroComprados
    int id
    
    static belongsTo = [pasaje:Pasaje, usuario:Usuario]
    
    static constraints = {
        //id (unique:true)
        //numeroComprados (range: 1..5)
    }
    
    static mapping = {
        table "Usuario_Pasaje" 
        version false
        id generator: "assigned", name: "id" 
    }
}
