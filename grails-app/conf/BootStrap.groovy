
import flotas.*

class BootStrap {

    def init = { servletContext ->
        //Creacion de un cliente
        new Usuario(nombreUsuario: "usuario", nombre: "Richard", apellido: "Stallman", 
            correo: "rstall@unix.com", contraseña: "abc123", rol: "usuario", saldo: 1000000).save()
        
        //Creacion del administrador
        new Usuario(nombreUsuario: "Admin",nombre: "Camilo", apellido: "Mantilla", 
            correo: "jcmantillam@una.edu.co", contraseña: "Camilo_89", rol: "admin", saldo: 0).save()
        
        //Creacion de una empresa
        new Empresa(idEmpresa: "0", nombreEmpresa: "transColombia").save()
        new Empresa(idEmpresa: "1", nombreEmpresa: "uP").save()
        
        //Creacion de un bus
        new Bus(idBus: "1", placaBus: "huk123", conductorAsignado: "Eduardo", 
            idEmpresa: "0", numeroSillas: "30", tipoBus: "Microbus").save()
        new Bus(idBus: "2", placaBus: "abc124", conductorAsignado: "Pepito", 
            idEmpresa: "1", numeroSillas: "30", tipoBus: "Microbus").save()
        //Creacion de un viaje
        new Pasaje(origen: "Bogotá", destino: "Cali", retorno: false, disponible: true,
            empresa: "0", bus: "huk123", asiento: 30, fechaViaje: new Date(2015, 8, 10, 8, 30, 00), 
            fechaVenta: new Date(), precio: 150000).save()
        new Pasaje(origen: "Bogotá", destino: "Barranquilla", retorno: false, disponible: true,
            empresa: "1", bus: "abc124", asiento: 30, fechaViaje: new Date(2015, 7, 20, 8, 30, 00), 
            fechaVenta: new Date(), precio: 10000).save()
    }
    def destroy = {
    }
}
