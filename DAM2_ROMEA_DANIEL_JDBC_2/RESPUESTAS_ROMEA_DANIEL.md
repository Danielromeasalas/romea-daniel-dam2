PREGUNTA 1: Explica cómo funciona la relación 1:N entre CentroForense y MuestraForense tanto en SQL como en Java. 

En java la clase Muestra Forense tiene un atributo que hace refernecia a un centro mientras que en 
SQL se relacionan mediante una foreign key en la tabal de muestras forenses.

PREGUNTA 2 Explica por qué en Java utilizamos: private CentroForense centro; y no: private int centroId; 

Usamos private CentroForense centro ya que asi podemos acceder directamente a toda la informacion del centro sin necesidad de 
hacer un find.

PREGUNTA 3 Explica qué ventaja aporta PreparedStatement frente a concatenar SQL manualmente. 

PreparedStatement presenta una gran ventaja ya que podemos reutilizar consultas siempre que queramos ya que solamente se cambian los 
valores introducidos por el usuario

