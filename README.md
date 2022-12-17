## Antecedentes
Proyecto spring boot, queryDSL, keycloak

## Primeros pasos
1. Clonar el proyecto enterprise-root
2. Ejecutar **gradlew clean build** para contruir en windows.
3. Definir variable de ambiente: SPRING_PROFILES_ACTIVE=CONSOLA
4. En el archivo application-CONSOLA.yaml, colocar las credenciales de la DB: 

   1. url: jdbc:postgresql://localhost:5432/sicpa
   2. username: postgres
   3. password: admin
   
## Creacion base de datos
1. Crear la base de datos con el nombre sicpa
2. Ejecutar el scrip crebas.sql adjunto
3. 


