# TP3

Ce Tp nous demande de créer une application simple qui permet la gestion de fichiers au sein du repertoire de l'application.

Vous trouverez dans l'application les différentes parties du Tp sous forme de methodes.

# Fonctionnement

Nous sommes partit d'un Relative layout, avec un bouton et un EditText. Le bouton une fois cliqué permettera de créer un fichier avec le nom entré dans l'EditText.

Le fichier créer se trouvera ensuite dans le repertoire de l'application. 

Dans l'application ce fichier sera affiché dans une ListView modifiée.

Cette listView contient un bouton qui permet de supprimer le fichier et un listener qui permet de cliquer sur le fichier lui meme, pour lire/editer son contenu.



# Démarche 

Premierement, le systeme de fichier de java n'est pas assez centralisé pour se lancer dans la programmation de l'application directement. C'est pour cela que nous avons ajouter une surcouche ajoutant des fonctionnalitée à ce systeme de fichier.

## 
## Le fileHolder

Le fileHolder est est une classe qui permet de stocker un nom de fichier, d'ouvrir ce fichier, d'editer son contenu, de le supprimer à l'aide de simples methodes.

## Le fileHolderManager

Cette classe est un singleton. Une seulle peut etre créer, apportant l'avantage d'etre appelable nimporte-ou, et donc dans des classes différentes ou des methodes différentes.

Le fileHolderManager est une classe qui permet de stocker une liste de fileHolder, de les ajouter, de les supprimer.


