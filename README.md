# Proyecto de Pruebas Automatizadas: Demoblaze

## Descripción

Este proyecto implementa un flujo de compra automatizado en la página web https://www.demoblaze.com utilizando Serenity BDD con el patrón Screenplay. La prueba automatizada abarca la selección de dos productos, la adición de estos al carrito, la verificación del contenido del carrito y la finalización de la compra a través de un formulario emergente.

## Requisitos Previos

- Java JDK 8 o superior
- Maven 3.6.3 o superior
- Google Chrome (última versión)
- ChromeDriver compatible con la versión de Chrome instalada

## Configuración del Entorno

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/eperez7666/Sofka-Demoblaze.git
   cd demoblaze-project
   ```

2. **Configurar ChromeDriver:**
    - Asegúrate de que `chromedriver.exe` esté en la ruta especificada en el código (`C:/WebDriver/chromedriver.exe`) o ajusta la ruta según tu configuración local.

3. **Instalar dependencias:**
   Navega a la carpeta raíz del proyecto y ejecuta:
   ```bash
   mvn clean install
   ```

## Ejecución de las Pruebas

1. **Ejecución desde la línea de comandos:**
    - Para ejecutar las pruebas, utiliza el siguiente comando:
   ```bash
   mvn test
   ```

2. **Resultados:**
    - Los resultados de las pruebas se almacenarán en la carpeta `target/site/serenity/`. Puedes abrir el archivo `index.html` en un navegador para ver los resultados detallados.

## Estructura del Proyecto

- **src/main/java/com/erickperez/demoblaze/**: Contiene las clases principales del proyecto, incluyendo modelos, tareas y preguntas.
- **src/test/java/com/erickperez/demoblaze/runners/**: Contiene la clase de ejecución de las pruebas.
- **target/site/serenity/**: Carpeta donde se generan los reportes de Serenity BDD.

## Instrucciones Adicionales

- Si se encuentra algún problema durante la ejecución, asegúrate de que todas las dependencias estén correctamente instaladas y que la versión de `ChromeDriver` sea compatible con la versión de Chrome instalada en tu sistema.
