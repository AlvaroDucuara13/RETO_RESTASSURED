Feature: obtener  y eliminar datos
  como usuario registrado en la plataforma web
  deseo obtener una lista de recursos y eliminar datos de un usuario
  para poder comprobar el funcionamiento del sistema

  Scenario: Obtener lista datos de usuario
    Given se desea requerir la lista de datos de un usuario
    When  se obtiene la informacion
    Then se obtendra un mensaje como respuesta exitoso y ademas, los datos del usuario

  Scenario: Eliminar datos de usuario
    Given se desea eliminar los datos de un  usuario
    When  se logra la accion requerida
    Then se obtendra un mensaje como respuesta exitosa