# Prova Nivel Android

Para este ejemplo de ha utilizado la API Rest de Posts del siguiente link: https://jsonplaceholder.typicode.com

Lo que se hace en el ejercicio es mostrar un listado de post mediante la llamada GET, y crear un nuevo Post mediante el POST.

Conceptos utilizados:
- ListView: https://developer.android.com/reference/android/widget/ListView
- Abrir una Activity desde otra: https://developer.android.com/training/basics/firstapp/starting-activity?hl=es-419
- Utilizar libreria Retrofit para las llamadas a la API: https://square.github.io/retrofit/
- Utilitzar listeners: https://guides.codepath.com/android/Creating-Custom-Listeners

Se han añadido comentarios en el código para una mejor comprensión.


AMPLIACIÓN del ejercicio (opcional):
- Al clicar en un Post de la lista, acceder a su detalle y mostrar el listado de comentarios de ESE post mediante GET /posts/{id_post}/comments
