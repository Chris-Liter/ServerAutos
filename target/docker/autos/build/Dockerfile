# Usar la imagen base de WildFly
FROM jboss/wildfly:latest

# Copiar el archivo de configuración de WildFly
COPY standalone-microprofile-jaeger.xml /opt/jboss/wildfly/standalone/configuration/

# Copiar la aplicación WAR al directorio de despliegues de WildFly
COPY target/autos.war /opt/jboss/wildfly/standalone/deployments/


RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#70365 --silent

# Exponer los puertos necesarios
EXPOSE 8080
#EXPOSE 9990

# Comando para iniciar WildFly con la configuración específica
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
