package arquitectura

import flotas.Usuario
import flotas.Usuario
import flotas.Usuario
import flotas.Usuario
import grails.transaction.Transactional
import javax.jws.soap.*
import javax.jws.*
import javax.xml.ws.*

import javax.xml.bind.annotation.*
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter

@Transactional
class CompraPasajesService {
    
    static expose = ['cxfjax']
    
    //Retorna todos los viajes disponibles
    @WebMethod(operationName = "ConsultarViajes",action="http://terminal/ConsultarViajes")
    def Pasajes ConsultasViajes(){
        return Pasajes.list()
    }
    
    //Retorna true si existe la cantidad de pasajes que quiere el usuario
    @WebMethod(operationName = "TiquetesDisponibles",action="http://terminal/TiquetesDisponibles")
    def boolean TiquetesDisponibles(@WebParam(name='idPasaje') String idPasaje, @WebParam(name='numeroComprados') int numeroComprados) {
        def pasaje = Pasaje.findByIdPasaje(idPasaje)
        if (pasaje != null){
            if (pasaje.asiento > numeroComprados){
                return true
            }
        }
        return false
    }
    
    //crea el usuario en esta aplicacion y vende los pasajes solicitados
    @WebMethod(operationName = "ComprarTiquetes",action="http://terminal/ComprarTiquetes")
    def boolean ComprarTiquetes(@WebParam(name='usuario') String usuario, @WebParam(name='nombre') String nombre, @WebParam(name='apellido') String apellido, 
        @WebParam(name='email') String email, @WebParam(name='contrasena') String contrasena, @WebParam(name='idVenta') String idVenta,
        @WebParam(name='placa') String placa, @WebParam(name='empresa') String empresa, @WebParam(name='origen') String origen, @WebParam(name='destino') String destino,
        @WebParam(name='numeroCompra') int numeroCompra, @WebParam(name='viaje') String viaje, @WebParam(name='compra') String compra,
        @WebParam(name='precioT') int precioT, @WebParam(name='iden') int iden){
        //Registro del nuevo usuario
        def usuario = new Usuario (nombreUsuario: usuario, 
                            nombre: nombre, 
                            apellido: apellido, 
                            correo: email, 
                            contraseña: contrasena, 
                            rol: "usuario")
        //Valida el registro del nuevo usuario
        if (!usuario.validate()) return false
        //Compra de los tiquetes
        def c = new Usuario_Pasaje(nombreUsuario: usuario, 
                            idPasaje: idVenta, 
                            placaBus: placa, 
                            empresa: empresa,
                            origen: origen,
                            destino: destino,
                            numeroComprados: numerosCompra,
                            fechaViaje: viaje,
                            fechaVenta: compra,
                            precio: precioT,
                            id: iden)
        //Valida el registro de la nueva venta
        if(!c.validate()) return false
        //Si las dos se cumplen se retorna true
        return true
    }
}
