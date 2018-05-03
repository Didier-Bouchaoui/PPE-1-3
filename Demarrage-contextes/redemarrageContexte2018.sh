#!/bin/bash

# arrêt de tous les conteneurs et suppression des conteneurs qui hébergent une instance TOMCAT 
docker stop $(docker ps -a -q)
docker rm tomcatserviceinscription
docker rm tomcatservicegestion
docker rm tomcatservicestatistique
docker rm tomcatservicecontributeurs
docker rm tomcatihm

# arrêt et suppression des conteneurs de supervision pgadmin4 et portainer 
docker rm pgadmin4
docker rm portainer

#suppression des volumes associés aux conteneurs supprimés
docker volume rm $(docker volume ls)


# redémarrage du conteneur qui héberge la bases de données [MODELE persistant]
# donc la base de données newsletterDB est dans l'état qu'elle avait au dernier # arrêt du conteneur qui l'héberge
docker start postgres
docker start db4o

# démarrage des conteneurs de production qui hébergent une instance TOMCAT

# les conteneurs de services WEB de type RESTful [CONTRÔLEURS]
docker run -d --name tomcatserviceinscription --link postgres:postgres lecoz/tomcatsshsiolapie
docker run -d --name tomcatservicegestion --link postgres:postgres lecoz/tomcatsshsiolapie
docker run -d --name tomcatservicestatistique --link postgres:postgres lecoz/tomcatsshsiolapie
docker run -d --name tomcatservicecontributeurs --link db4o:db4o lecoz/tomcatsshsiolapie

# le serveur d'applications WEB (interfaces Homme-Machine) [VUE]  
docker run -d --name tomcatihm --link tomcatserviceinscription:tomcatserviceinscription --link tomcatservicegestion:tomcatservicegestion --link tomcatservicestatistique:tomcatservicestatistique --link tomcatservicecontributeurs:tomcatservicecontributeurs lecoz/tomcatsshsiolapie

# démarrage du conteneur d'administration (pgadmin4) de la base de données 
# newsletterDB (interface d'administration http://172.17.0.x)
# attention: les scripts plpgsql ne sont plus dans le conteneur !
docker run -d  --name pgadmin4 dpage/pgadmin4


# conteneur de supervision (portainer) des conteneurs Docker (interface de supervision http://172.17.0.x:9000) 
docker run -d --name portainer --privileged -p 9000:9000 -v /var/run/docker.sock:/var/run/docker.sock -v /opt/portainer:/data portainer/portainer


# affichage des adresses TCP-IP des conteneurs
for conteneur in $(docker ps -a -q)
do
	echo $(docker inspect -f '{{.Name}} - {{.NetworkSettings.IPAddress }}' $conteneur | cut -c2-)
done
