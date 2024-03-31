Proyecto personal. Blog donde los usuarios, pueden publicar articulos, agregar etiquetas a esos articulos e interactuar haciendo comentarios.

Se implementa un proyecto Maven utilizada en el entorno de Java, para mapear se utiliza Hibernate. En el proyecto tenemos 3 paquetes el paquete principal por defecto donde esta tenemos el main con la clase App, otro paquete llamado entidad donde tenemos las clases Usuario, Articulo, Comentarios y Etiquetas. Y por ultimo la configuración de Hibernate en el paquete llamado dao. En este ultimo paquete armamos la configuracion de modo tal que podamos hacer las funciones basicas de la base de datos, es decir, el acronimo CRUD (create, read, update, delete).

En este proyecto me costo incorporar ademas de la parte de abstraccion, el tema de como mapear las entidades. Los dos usuarios que simule para crear pueden interactuar entre si, es decir, los dos usuarios publicaron un articulo cada uno, y entre ambos interactuaron comentando sus respectivos articulos. El tema de la fecha y la hora para que pueda aparecer en MySql es una de las cosas que tengo que reforzar en mi conocimiento. En Spring Boot hay una anotacion que lo soluciona @JsonFormat.

Utilizo JUnit5 para testear la aplicacion, en este caso lo que testeo es que ningun campo sea nulo.
