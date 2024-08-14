# Conclusiones del Proyecto de Pruebas Automatizadas

## Hallazgos

1. **Manejo de Alertas y Esperas**:
   - Durante la ejecución de las pruebas, se observó la necesidad de manejar alertas y esperas explícitas para asegurar la estabilidad de la prueba. Es importante asegurarse de que los elementos están presentes y visibles antes de interactuar con ellos para evitar errores como `NoSuchElementException`.

2. **Patrón Screenplay**:
   - El uso del patrón Screenplay proporcionó una estructura clara y mantenible para el proyecto, permitiendo un flujo de trabajo bien definido y fácil de entender. Este patrón facilita la extensión de las pruebas y la adición de nuevos escenarios.

3. **Manejo de Formularios Emergentes**:
   - Se identificó que el manejo de formularios emergentes requiere una interacción cuidadosa, especialmente en términos de esperar a que los elementos sean interactuables antes de realizar acciones como llenar formularios o hacer clic en botones.

## Conclusiones

- **Estabilidad de las Pruebas**:
   - La implementación de esperas explícitas y la verificación de la visibilidad de los elementos antes de interactuar con ellos mejoró significativamente la estabilidad de las pruebas. Esto es especialmente crucial en pruebas automatizadas de interfaces de usuario donde el tiempo de carga y la interacción del usuario pueden variar.

- **Estructura y Mantenibilidad**:
   - La estructura del proyecto basada en Screenplay resultó ser efectiva para mantener un código limpio y modular. Este enfoque facilita la adaptación del proyecto a nuevos requisitos y la adición de nuevas funcionalidades.

- **Recomendaciones**:
   - Se recomienda la revisión periódica de las dependencias y herramientas utilizadas (como ChromeDriver) para asegurar la compatibilidad con las últimas versiones del navegador. Además, se sugiere seguir utilizando el patrón Screenplay para futuros desarrollos de pruebas automatizadas, dado su enfoque modular y orientado a la reutilización de código.
