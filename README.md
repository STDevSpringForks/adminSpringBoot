# AdminSpringBoot

Proyecto de ejemplo basado en Spring Boot utilizado para pruebas y aprendizaje.

## Compilación

Este proyecto usa Maven. Para generar el artefacto ejecuta:

```bash
mvn package
```

## Ejecución

```bash
java -jar target/adminSpringBoot-0.0.1.jar
```

## Documentación con Swagger

Con la aplicación en ejecución puedes consultar y probar los endpoints desde el navegador accediendo a:

```
http://localhost:8080/web/common/swagger-ui.html
```

Por ejemplo, el controlador de Bitso expone la vista de libro de órdenes en:

```
http://localhost:8080/web/common/bitso/viewBitsoOrderBook
```

## Requisitos

Se necesita JDK 21 para compilar y ejecutar el proyecto.


