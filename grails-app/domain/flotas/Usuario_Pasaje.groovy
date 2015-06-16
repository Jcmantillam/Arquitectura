package flotas

class Usuario_Pasaje {
    
    String nombreUsuario
    String idPasaje
    String placaBus
    String empresa
    String origen
    String destino
    int numeroComprados
    
    static constraints = {
        //id (unique:true)
        //numeroComprados (range: 1..5)
    }
    
    static mapping = {
        table "Usuario_Pasaje" 
    }
}
