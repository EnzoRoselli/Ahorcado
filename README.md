# Ahorcado

-Differencia entre Runnable y Thread

Las principales diferencias entre la clase Thread e implementar la interfaz Runnsable son:

Cuando extendemos de la clase Thread, no podemos extender de otra clase, mientras que implementando Runnable, permitimos que nuestra
clase extienda de cualquier otra clase en el futuro.

Cuando extendemos de la clase Thread, cada uno de nuestros hilos crea un objeto unico asociado con el. Mientras que con la inerfaz
Runnable, se comparte el mismo objeto en multiples hilos.

-Ciclo de vida de un Thread

El ciclo de vida de un Thread representa los estados por los cuales puede pasar un Thread desde que nace hsta que muere. 
Durante el ciclo de vida de un Thread, este se puede encontrar en diferentes estados.

1. Nuevo (New): El thread ha sido creado pero no inicializado, es decir, no se ha ejecutado todavía el método start(). Se producirá 
un mensaje de error (IllegalThreadStateException) si se intenta ejecutar cualquier método de la clase Thread distinto de start().

2. Ejecutable (Runnable): El thread puede estar ejecutándose, siempre y cuando se le haya asignado un determinado tiempo de CPU. 
En la práctica puede no estar siendo ejecutado en un instante determinado en beneficio de otro thread.

3. Bloqueado (Blocked o Not Runnable): El thread podría estar ejecutándose, pero hay alguna actividad interna suya que lo impide, 
como por ejemplo una espera producida por una operación de escritura o lectura de datos por teclado (E/S). Si un thread está en 
este estado, no se le asigna tiempo de CPU.

4. Muerto (Dead): La forma habitual de que un thread muera es finalizando el método run(). También puede llamarse al método stop() de 
la clase Thread, aunque dicho método es considerado “peligroso” y no se debe utilizar.

-Explique los metodos[start, sleep, yield, join]

start: provoca que el sistema operativo cambie el estado de la instancia utilizada a 'en ejecucion'.
sleep: este metodo puede ser usado para pausar la ejecucion de la instancia de hilo utilizada por un tiempo especifico de milisegundos.
yield: este metodo provoca que el hilo(si se esta ejecutando) se pause temporalmente y permita a otros hilos entrar en ejecucion.
join: este metodo pondra al hilo en espera hasta que el thread en el cual es llamado muera.

