# Especificación de I AM ATOMIC

## Secuencia de carga
1. El cliente solicita iniciar la carga al servidor.
2. El servidor valida jugador, objeto equipado, estado y coste.
3. El servidor crea un identificador de lanzamiento y sincroniza el evento con los clientes cercanos.
4. Los clientes representan la carga localmente: líneas moradas dibujándose desde el suelo, anillos y pilares circulares ascendentes.
5. Al llegar al evento de voz «ATOMIC», el servidor marca el lanzamiento como liberable.
6. Soltar antes de ese punto cancela; soltar después solicita liberar.
7. El servidor valida de nuevo y calcula impactos/daño. Los clientes reproducen el efecto visual y sonoro sincronizado.

## Rendimiento
- No crear una entidad por cada partícula.
- Geometría procedural/renderizado por lotes para líneas y anillos.
- Reducir segmentos, partículas y detalle según distancia y ajuste del cliente.
- Limitar frecuencia de actualizaciones de red; enviar inicio, hitos y final, no cada partícula.
- Separar radio visual y radio de efecto.
- La destrucción de bloques es una decisión del jugador que lanza, pero se aplica exclusivamente en el servidor con validaciones y límites.

## Recursos pendientes
- Modelos/texturas del Catalizador Arcano.
- Audio original o con licencia para carga, voz y liberación.
- Renderizador de geometría mágica.
- Red de sincronización y estados de lanzamiento.
- Menú de configuración cliente.
- Pruebas en mundo dedicado y con dos clientes.
