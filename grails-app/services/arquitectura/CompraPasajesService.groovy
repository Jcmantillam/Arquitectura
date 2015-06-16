package arquitectura

import flotas.*
import grails.transaction.Transactional
import javax.jws.soap.*
import javax.jws.*
import javax.xml.ws.*

import javax.xml.bind.annotation.*
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter

@WebService (targetNamespace="http://Flotas/")
@SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE)
class CompraPasajesService {
    
    static expose = ['cxfjax']
    
    //crea el usuario en esta aplicacion y vende los pasajes solicitados
    @WebMethod(operationName = "ComprarTiquetes",action="http://terminal/ComprarPasajes")
    def boolean ComprarTiquetes(@WebParam(name='usuario') String usuario){
        //Compra de los tiquetes
        def c = new Usuario_Pasaje(nombreUsuario: usuario, 
                            idPasaje: "1", 
                            placaBus: "huk123", 
                            empresa: "0",
                            origen: "Bogotá",
                            destino: "Cali",
                            numeroComprados: 1,
                            precio: "150000")
        //Valida el registro de la nueva venta
        //c.save(flush:true)
        //Valida el registro de la nueva venta
        if(!c.validate()) return false
        //Si las dos se cumplen se guarda y se retorna true
        c.save(flush:true)
        return true
    }
    
    @WebMethod(operationName = "CrearUsuario",action="http://terminal/CrearUsuario")
    def boolean CrearUsuario(@WebParam(name='usuario') String usuario, @WebParam(name='nombre') String nombre,
        @WebParam(name='apellido') String apellido, @WebParam(name='email') String email, @WebParam(name='password') String password){
        def u = new Usuario (nombreUsuario: usuario, 
                    nombre: nombre, 
                    apellido: apellido, 
                    correo: email, 
                    contraseña: password, 
                    rol: "usuario",
                    saldo: 1000000)
        //Valida el registro del nuevo usuario
        if (!u.validate()){
            return false
        }
        u.save(flush:true)
        return true
    }
    
    //Se consulta si el usuario existe o no en el sistema
    @WebMethod(operationName = "ExisteUsuario",action="http://terminal/ExisteUsuario")
    def boolean ExisteUsuario(@WebParam(name='user') String user, @WebParam(name='password') String password){
        def consult = Usuario.findByNombreUsuario(user)
            if(consult==null){
                return false
            }
            if(consult.contraseña != password){
                return false
            }
            return true
    }
}
