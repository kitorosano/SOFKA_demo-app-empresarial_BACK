# SOFKA_demo-app-empresarial

Esto es una aplicación de ejemplo que consume una API de numeros aleatorios y guarda en MongoDB su uso.
En este caso, se proveera de una api para generar Fechas de Tiempo aleatorias.
Dado un rango, un intervalo y la cantidad de horarios a conseguir.

Es un proyecto creado en Java utilizando Springboot como framework.

## Ejecutar la app

    mvnw.cmd spring-boot:run

# API REST

La API REST de la aplicación se explica a continuación

| METODO HTTP | POST            | GET         | PUT         | DELETE |
| ----------- | --------------- | ----------- | ----------- | ------ |
| CRUD OP     | CREATE          | READ        | UPDATE      | DELETE |
| /r       | Crear nuevo random | Listar randoms   | Error | Error |

## Obtener listado de randoms

`GET /r`

![GET /r](src/main/resources/images/getRandoms.jpg)

## Crear nuevo random

`POST /r`

![POST /r](src/main/resources/images/postRandom.jpg)