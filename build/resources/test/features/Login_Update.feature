Feature: Login y Update
  yo como usuario registrado en la plataforma web
  deseo autenticarme y acceder a la aplicacion web
  para poder comprobar el funcionamiento del sistema login y update

  Scenario: login Unsuccesful
    Given el usuario accede a iniciar sesion con el correo de usuario
    When  el usuario logra iniciar sesion
    Then el usuario debera ver un codigo de respuesta erronea


  Scenario: Actualizar informacion
    Given el usuario ingresa las credenciales nombre de usuario y el trabajo que desempena
    When  el usuario logra actualizar sus datos
    Then el usuario debera ver un codigo de respuesta exitosa

