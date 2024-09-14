FROM postgres:latest
ENV POSTGRES_USER=heri
ENV POSTGRES_PASSWORD=Heriberto1995**
ENV POSTGRES_DB=mydb

# Copiar archivos SQL o scripts de inicialización si tienes alguno
# COPY ./init.sql /docker-entrypoint-initdb.d/

EXPOSE 5432