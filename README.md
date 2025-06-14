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

Al iniciar la aplicación puedes navegar por todas las vistas usando el menú superior.
Selecciona **Browse** para desplegar las secciones (Utils, Exercises, Finance, Bitso y Testing API)
y accede a la página correspondiente de cada controlador.

## Documentación con Swagger

Con la aplicación en ejecución puedes consultar y probar los endpoints desde el navegador accediendo a:

```
http://localhost:8080/web/common/swagger-ui.html
```

Por ejemplo, el controlador de Bitso expone la vista de libro de órdenes en:

```
http://localhost:8080/web/common/bitso/viewBitsoOrderBook
```

### Enviar datos al endpoint `/bitso/viewBitso`

La vista `viewBitso` también acepta una petición POST con los datos del formulario
`FormBitsoBalance`. Puedes enviar los valores desde un formulario HTML o con `curl`.
Un ejemplo utilizando `curl` sería:

```bash
curl -X POST \
  -d "precioEspeculativoETH=1000" \
  -d "precioEspeculativoXRP=2" \
  -d "precioEspeculativoBTC=100000" \
  http://localhost:8080/web/common/bitso/viewBitso
```

Esto calculará el balance con los precios indicados y mostrará la vista actualizada.

## Requisitos

Se necesita JDK 21 para compilar y ejecutar el proyecto.

## Reportes en PDF

La generación de reportes ahora se realiza usando la biblioteca **OpenHTML to PDF**.
Desde el menú *Browse* selecciona "PDF Reports" para crear un archivo en
`<usuario>/tools/sample_report.pdf` (carpeta `tools` dentro del directorio de usuario)
a partir de una plantilla HTML sencilla.


