
= = = = = = = = = = = = = = = = = =
TSE - Práctico 1 - Anthony Mallada
Ejercicio 1
= = = = = = = = = = = = = = = = = =

1. Instalar Wildfly
2. En Eclipse ir a Window -> Show View -> Servers
		- Click derecho en la ventana -> New -> Server
		- Filtrar por 'Wildfly' e instalar la versión deseada, en este caso, Wildfly 24+
		- Elegir servidor LOCAL
		- Crear un Wildfly Server runtime utilizando Java 11
		- Crear el servidor
3. Creado el servidor lo que faltaría es crear un proyecto Maven cuyo POM tenga las dependencias necesarias para
		utilizar Wildfly. Para saltear este paso se crea un proyecto Maven con arquetipo 'wildfly-jakartaee-ear-archetype',
		este arquetipo contiene el POM con todas las dependencias necesarias para utilizar el servidor Wildfly.
4. Para correr la aplicación en el servidor se hace click derecho sobre el proyecto de la vista web -> Run As -> Run on Server
