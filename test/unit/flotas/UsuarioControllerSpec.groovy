package flotas

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UsuarioController)
class UsuarioControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

        void "test User"() {
        

        
        setup:  
        mockForConstraintsTests(Usuario)
      
        when:
            String nameUser="andres"
            String name="andres"
            String apellido="rodriguez"
            String mail="andres@hotmail.com"
            String contra="123"
            def user = new Usuario(nombreUsuario: nameUser, nombre: name, apellido: apellido, correo: mail, contraseña: contra)

            user.validate()

        then:

            user.errors.errorCount==1

        

        when:
            nameUser=""
            name="andres"
            apellido="rodriguez"
            mail="andres@hotmail.com"
            contra="1234"
            user = new Usuario(nombreUsuario: nameUser, nombre: name, apellido: apellido, correo: mail, contraseña: contra)

            user.validate()

        then:

            user.errors.errorCount==1
            
        
        when:
            nameUser="andres"
            name="andres"
            apellido="rodriguez"
            mail="andres"
            contra="1234"
            user = new Usuario(nombreUsuario: nameUser, nombre: name, apellido: apellido, correo: mail, contraseña: contra)

            user.validate()

        then:

            user.errors.errorCount==1
            
        
        when:
            nameUser="andres"
            name="andres"
            apellido="rodriguez"
            mail="andres@.com"
            contra="1234"
            user = new Usuario(nombreUsuario: nameUser, nombre: name, apellido: apellido, correo: mail, contraseña: contra)

            user.validate()

        then:

            user.errors.errorCount==1
            
        when:
            nameUser="andres"
            name="andres"
            apellido="rodriguez"
            mail="andres@hotmail.com"
            contra="1234"
            user = new Usuario(nombreUsuario: nameUser, nombre: name, apellido: apellido, correo: mail, contraseña: contra)

            user.validate()

        then:

            user.errors.errorCount==0
            
        when:
            nameUser="juan34"
            name="juan"
            apellido="rodriguez"
            mail="andresfrancisc@hotmail.com"
            contra="123456789012"
            user = new Usuario(nombreUsuario: nameUser, nombre: name, apellido: apellido, correo: mail, contraseña: contra)

            user.validate()

        then:

            user.errors.errorCount==0
            
        when:
            nameUser="juan2"
            name="juan"
            apellido="rodriguez"
            mail="juan23@hotmail.com"
            contra="1234567890123"
            user = new Usuario(nombreUsuario: nameUser, nombre: name, apellido: apellido, correo: mail, contraseña: contra)

            user.validate()

        then:

            user.errors.errorCount==1
            
        when:
            nameUser="carlos2"
            name="carlos"
            apellido=""
            mail="carlos@.com"
            contra="asd"
            user = new Usuario(nombreUsuario: nameUser, nombre: name, apellido: apellido, correo: mail, contraseña: contra)

            user.validate()

        then:

            user.errors.errorCount==3
            
        
        when:
            nameUser="asdf"
            name="cesar"
            apellido="rodriguez"
            mail="cesar@hotmail.com"
            contra=""
            user = new Usuario(nombreUsuario: nameUser, nombre: name, apellido: apellido, correo: mail, contraseña: contra)

            user.validate()

        then:

            user.errors.errorCount==1
            
        when:
            nameUser="andres"
            name="andres"
            apellido="rodriguez"
            mail="andres@hotmail.com"
            contra="123"
            user = new Usuario(nombreUsuario: nameUser, nombre: name, apellido: apellido, correo: mail, contraseña: contra)

            user.validate()

        then:

            user.errors.errorCount==1
   
        
    }
}
