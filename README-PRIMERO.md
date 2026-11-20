# ARCANA — NeoForge 1.21.1

## Qué contiene esta entrega
Esta es la **base inicial del proyecto**, preparada para que GitHub Actions compile con Java 21, Gradle 8.10.2 y NeoForge 21.1.172. El flujo instala Gradle explícitamente porque este ZIP no incluye Gradle Wrapper.

Todavía NO contiene el hechizo I AM ATOMIC terminado, ni el Maestro Arcano, misiones, rueda de hechizos, sonidos o efectos visuales. No instales este JAR como si fuese la versión jugable final.

## Cómo generar el JAR mañana desde el PC

1. Descarga y descomprime este ZIP.
2. En GitHub crea un repositorio nuevo llamado `ARCANA` (vacío).
3. Sube el contenido de esta carpeta al repositorio, manteniendo la carpeta `.github`.
4. Abre la pestaña **Actions** del repositorio.
5. Si GitHub pide habilitar Actions, acepta.
6. Ejecuta **Build ARCANA** con **Run workflow**, o espera a que termine el primer push.
7. Abre la ejecución terminada y descarga el artefacto `ARCANA-1.21.1`.

El JAR compilado estará dentro del artefacto descargado, en `build/libs/`.

## Requisitos
- Minecraft 1.21.1
- NeoForge 21.1.x
- Java 21 para compilar (GitHub Actions lo instala automáticamente)
- Para jugar en multijugador, cuando existan las funciones de juego, todos los clientes y el servidor deberán usar la misma versión del mod.

## Plan técnico acordado para I AM ATOMIC
- Catalizador y selección del hechizo.
- Carga mantenida con clic derecho.
- Cancelación si se suelta antes de terminar la frase; liberación después de «ATOMIC».
- Estructura circular de líneas moradas que nace del suelo, se eleva y forma pilares/anillos.
- Secuencia de voz, carga y explosión sincronizada.
- Sonido con atenuación por distancia.
- Efectos visuales por niveles de detalle y límites de partículas.
- El servidor valida el lanzamiento y aplica daño; la preferencia de destrucción del lanzador se consulta en el servidor.

## Comprobaciones
Esta entrega es un esqueleto de proyecto y un flujo de compilación. La compilación real depende de que GitHub Actions pueda descargar Gradle y las dependencias de NeoForge. He corregido en esta revisión un problema del flujo anterior: se configuraba Gradle sin indicar una versión y después se ejecutaba `gradle`, aunque el proyecto no incluye Wrapper. Ahora la acción instala explícitamente Gradle 8.10.2. La sintaxis y estructura se han revisado, pero no he podido ejecutar una compilación real desde este entorno porque no tiene acceso de red a Maven/NeoForge. Hasta que una ejecución de Actions termine correctamente, no se debe afirmar que el JAR está probado.
