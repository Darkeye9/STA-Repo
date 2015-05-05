Prácticas de Sistemas Telemáticos Avanzados
======================================
Grado Ing.Tecnología de Telecomunicación en ETSIB

Práctica 6 con mejoras en la interfaz
-------------------------------------
Se ha utilizado la librería de diseño web [Semantic-UI](http://semantic-ui.com/)
con algunas personalizaciones extras a la hora de compilar.

* Se han sustituido cada uno de los mensajes de validación de los elementos del
formulario por el elemento de JSF `<h:messages />` que imprime todos los mensajes
pendientes en dicha vista.  
* También se ha añadido el atributo `rendered="#{not empty facesContext.messageList}"` al `<h:PanelGroup>` que los contiene para que sólo
se muestre en el caso de que existan errores.  
* Se ha hecho un uso intensivo del atributo `styleClass` de JSF para proveer a los
elementos dinámicos de las clases necesarias para el estilado de Semantic-UI.
