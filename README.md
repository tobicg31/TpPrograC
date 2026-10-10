# TPG Programación C 2C 2026, Grupo 1  
**Integrantes:** Lucas Panasia, Lourdes Victoria Luna, Juan Cruz Paez, Tobias Alejandro Gilardi  

**Resumen del TP:** El Trabajo Practico consiste, en la primer parte, en modelar el comportamiento de una nave interestelar. Tuvimos que diseñar en base a los contenidos vistos en la materia
como se operan y como se le encomiendan misiones a una nave.   
En esta primera parte, para poder verificar que las clases cumplen con lo requerido, hemos hecho una clase Main que imprima por pantalla
lo necesario.  
### Verificaciones realizadas
* Ciclo correcto de transiciones en el estado del motor Warp
* Una transicion incorrecta en el estado del motor Warp
* Creacion de los tres tipos de misiones y su correcta ejecucion
* Creacion de una tripulacion y calculo de sus respectivos haberes

### Requisitos de sistema
* Java: **JDK 25**
* Maven: **Apache Maven 3.10.0**

### Compilación y ejecución
El comando `mvn clean package` prepara el proyecto desde cero y en caso que todo salga bien, genera el archivo .jar correspondiente.
Luego, el comando `java -cp target/classes Main` ejecuta las acciones establecidas en el método *main* de la clase de prueba.