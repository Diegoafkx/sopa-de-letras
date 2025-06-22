sopa-de-letras
Estudiantes: Diego Arreaza
Link del Github: https://github.com/Diegoafkx/sopa-de-letras.git

Este proyecto es la codificacion de una sopa de letras con el uso de grafos adyacentes y diagonales, y que se arma usando metodos de busqueda DFS Y BFS

Pasos de a seguir para inicar el programa

1- Iniciar el rpograama con la clase Ventana1
2- Darle al boton Buscar (Aparecera un buscador de archivos del dispositivo)
3- Ir a la dirrecion de la carpeta del archivo y darle click al archivo Diccionario.txt
4-Darle a Continuar

Instrucciones de como funciona el programa

Despues de seguir los "Pasos para inciar el programa" saldra la interface del menu, y apareceran 3 botones con tres opciones:
    1- Ver Diccionario

        Aqui se mostrarn todas las palabras que se pueden encontrar en la sopa de letras

    2- Iniciar Sopa de Letras

        Aqui empezara la Sopa de Letras

    3- Agregrar Palabras al Diccionario

        Aqui podras agregar una palabra al diccionario sin necesidad de que que se busque en la sopa de letras antes

En Iniciar Sopa de Letras, se generara la sopa de letras alatorizando la ubicacion de las letras que estan en esta, asi realizando que en cada turno es posible que se encuentres diferentes palabras en diferentes     posiciones. Esta se basa en que el usuario debe de selecionar uno de los metodos de busqueda, Breadth First Searching o Depth First Searching, luego hacer click en el boton de buscar y al instante las letras que forman las palabras tendran un fondo verde y se mostrara tanto el tiempo en que se tardo en buscar las palabras, en milisegundos, como estas mismas en el lado izquierdo de la pantalla. Tambien existe la opcion de buscar una palabra en especifico o una que no se encuentre en el diccionario, el usuario debera de ingresar la palabra que se desea buscar abajo de donde dice "Escribe una palabra", esta debe de ser de 3 a 4 letras, debera luego selecionar una de los 2 metodos de busqueda, luego si la palabra es encontrada las letras que forman esta tendra un fondo amarillo y se mostraraa el tiempo en que se tardo en hallarse, si es una palabra nueva, es decir, si no se encuentra en el diccionario, se agregara en este(Si seleciona el metodo BFS (Breadth First Searching) se mostrara una nueva ventana que mostrara el arbol de busqueda de la palabra), si no se encontro la palbra se avisara que no se encunetra en la sopa de letras y asu vez no se agregara en este

