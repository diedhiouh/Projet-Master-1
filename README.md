# Projet-Master-1
Projet ps0 M1

Le projet consiste à mettre en œuvre les méthodes pour qu'on puisse les exécuter.
Dans le premier package, on doit mettre en œuvre la méthodes RulesOf6005 tout en respectant les règles établies par la consigne. 
Les variables de type booléens sont vérifiées suivant les conditions ci-dessous

# la fonction des variables boolen

## 1 writeByYourself

Le variable « writeByYourself » est vrai si le code en question a été écrit par vous-même ou, dans le cas d'un projet d'équipe,
vos coéquipiers, sinon il est faux.

## 2 availableToOthers

Le variable « availableToOthers» s’il n'est pas écrit Par toi-même, que le code en question est disponible pour tous les autres
étudiants de la classe. Sinon ignoré.

## 3 writeAsCourseWork

Le variable « writeAsCourseWork » sinon écritByYourself, que le code en question a été écrit spécifiquement 
dans le cadre d'une solution à une affectation de 6.005, dans les semestres actuels ou passés. Autrement ignoré.

## 4 citingYourSource

 Le variable « citingYourSource » si pas écritByYourself, que vous soyez ou non citer correctement votre source. Sinon ignoré.
 
 ## 5 implementationRequired
 
Le variable « implementationRequired » si l'affectation demande spécifiquement vous mettre en œuvre la fonctionnalité en question.

###############################################################

On nous demande de retourner en fonction des informations fournies dans les arguments, si tu es autorisé ou non à utiliser le code.
 Dans le package, la classe les méthodes de la classe TurtleSoup doit être mis en œuvre. 
 
###############################################################


# les methodes de dessin et de calcul

La méthode drawSquare : Méthode qui sert à dessiner un rectangle ou carré. 
Ceci à l’aide de la package TurtleGraphics (Package de dessin de graphe). Les fonctions « forward » et « turn » servent
respectivement à tracer et tourner selon le nombre degré donné.

##la methodes calculateRegularPolygonAngle

La méthode calculateRegularPolygonAngle calcule l'angle interne du polygone régulier à partir du nombre de cote donné. 
La formule est appliquée est :
Angle= (nombre de cote-2) *180) /nombre de cote

## la methode calculatePolygonSidesFromAngle

La méthode calculatePolygonSidesFromAngle : Calcule du nombre de cote du polygone à partir de l'angle. 
Nombre de cote = (360/(180-angle) +0.5)

## la methode drawRegularPolygon

La méthode drawRegularPolygon dessine un polygone régulier en utilisant le résultat retourné par la fonction calculateRegularPolygonAngle.

## la methode calculateHeadingToPoint

La méthode calculateHeadingToPoint calcule et retourne de l'angle de la direction d'orientation de la tortue.

## la methode calculateHeadings

La méthode calculateHeadings calcule et retourne la liste d’ajustements qui pourrait être utilisée
pour guider la tortue vers chaque point de la liste.

## la methode drawPersonalArt

La methode drawPersonalArt dessine un art personnalisé.

###########################################################
###########################################################
