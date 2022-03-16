# Yo programo - Módulo VII
## Práctica Sockets

Problema resuleto aceptando la conexión a un socket cliente en la funcion *main()* y pasando la instancia de dicho socket a un hilo diferente en el cual se
reciben los mensajes y se lleva la cuenta del número de clientes. De esta manera no se bloquea la funcion *main()* y la misma puede seguir aceptando conexiones a nuevos sockets y pasarlas a nuevos hilos.
