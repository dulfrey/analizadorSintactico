# Analizador Sintáctico

Analizador Sintáctico Desendente Recursivo para la materia lenguajes de programación de la Universidad Nacional de Colombia. Aquí se realizó una implementación de un ASDR  para el lenguaje [TLON](https://sites.google.com/unal.edu.co/wiki-lang-tlon).

El archivo a analizar se debe definir en */source/in01.txt*  , los tokens se encuentran definidos en el archivo */source/tokens.txt*  la salida del análisis lexico se puede encontrar en el archivo */source/out.txt* y el resultado del análisis sintáctico se muestra por consola.

### Nota
***
Este analizador esta implementado sobre una grámatica ambigua, por tanto se deben eliminar las ambiguedades de la grámatica para que el análisis sea correcto.
***