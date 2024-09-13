# Usa una imagen base de JDK para la construcción
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app

# Copia el archivo pom.xml y el código fuente al contenedor
COPY pom.xml .
COPY src ./src

# Empaqueta la aplicación como un archivo WAR
RUN mvn clean package -DskipTests

# Usa una imagen base de Tomcat para desplegar el archivo WAR
FROM tomcat:10.1-jdk17

# Elimina las aplicaciones de Tomcat por defecto
RUN rm -rf /usr/local/tomcat/webapps/*

# Copia el WAR generado al directorio webapps de Tomcat
COPY --from=build /app/target/herp.war /usr/local/tomcat/webapps/herp.war

# Exponer el puerto 8080 para Tomcat
EXPOSE 8080

# Comando para iniciar Tomcat
CMD ["catalina.sh", "run"]
