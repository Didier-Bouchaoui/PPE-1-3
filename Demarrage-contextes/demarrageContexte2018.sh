#!/bin/bash

# arrêt et suppression des conteneurs passés
docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)

#suppression des volumes associés aux conteneurs supprimés
docker volume rm $(docker volume ls)

# suppression des volumes
docker volume rm $(docker volume ls)

# démarrage des conteneurs de production

# les conteneurs de bases de données [MODELE persistant]
docker run --name postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=newsletterDB -d postgres
docker run --name db4o -d lecoz/db4o

# les conteneurs de services WEB de type RESTful [CONTRÔLEURS]
docker run -d --name tomcatserviceinscription --link postgres:postgres lecoz/tomcatsshsiolapie
docker run -d --name tomcatservicegestion --link postgres:postgres lecoz/tomcatsshsiolapie
docker run -d --name tomcatservicestatistique --link postgres:postgres lecoz/tomcatsshsiolapie
docker run -d --name tomcatservicecontributeurs --link db4o:db4o lecoz/tomcatsshsiolapie

# le serveur d'applications WEB (interfaces Homme-Machine) [VUE]  
docker run -d --name tomcatihm --link tomcatserviceinscription:tomcatserviceinscription --link tomcatservicegestion:tomcatservicegestion --link tomcatservicestatistique --link tomcatservicecontributeurs:tomcatservicecontributeurs lecoz/tomcatsshsiolapie

# conteneur d'administration (pgadmin4) de la base de données newsletterDB (interface d'administration http://172.17.0.x)
docker run -d  --name pgadmin4 dpage/pgadmin4

# conteneur de supervision (portainer) des conteneurs Docker (interface de supervision http://172.17.0.x:9000) 
docker run -d --name portainer --privileged -p 9000:9000 -v /var/run/docker.sock:/var/run/docker.sock -v /opt/portainer:/data portainer/portainer


# peuplement initial de la base de données relationnelle (actions, rôles, utilisateurs)
/opt/logiciels/jdk1.8.0_152/bin/java -jar ./peuplement.jar > /dev/null 2>1&


# affichage des adresses TCP-IP des conteneurs
for conteneur in $(docker ps -a -q)
do
	echo $(docker inspect -f '{{.Name}} - {{.NetworkSettings.IPAddress }}' $conteneur | cut -c2-)
done
