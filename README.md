# Yo programo - Módulo VII
## Práctica Sockets

Problema resuleto aceptando la conexión a un socket cliente en la funcion *main()* y pasando la instancia de dicho socket a un hilo de ejecución diferente en el cual se reciben los mensajes y se lleva la cuenta del número de clientes. De esta manera no se bloquea la funcion *main()* y la misma puede seguir aceptando conexiones a nuevos sockets y creando nuevas clases **ClientHandler** que manejan los sockets clientes y cuyo constructor recibe como argumento la instancia del nuevo socket para poder manejarlo.

La clase que se encarga de manejar cada cliente extiende a la clase **Thread** ya que se ejectura en otro hilo y cuenta con un miembro estático de tipo *int* que lleva la cuenta del número de clientes. Así, todas las clases que manejan los clientes tienen acceso al mismo tiempo a la cantidad de clientes.
