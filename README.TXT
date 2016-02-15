Pour fonctionner ce programme nécessite l'installation et l'acces a MySQL

Les 3 scripts Shell permettent d'installer de deinstaller et de lancer le programme sans avoir a ouvrir le dossier source(programme)

Il est neanmoins necessaire d'avoir le mot de passe root de mySQL afin de creer la base de donnees GDR et l'utilisateur javalink necessaire au programme (mot de passe javalink)

le fichier programme contient :
	le dossier BDD contenant les scripts SQL pour creer et detruire la base de donnees
	le dossier src contenant les codes sources
	le dosssier bin contenant les classes compiles 
	le dossier doc contenant la javadoc de toutes les classes
	le dossier lib contenant le jar plugin Jconnector permettant de se connecter a la base de donnees 
	divers scripts :
		compiler (compile toute les sources)
		ImportData importe les donnees sources dans la base de donnees
		Installation
		LancerProg
		
Les programmes ont été initialement penses sur open-jdk 1.7.


