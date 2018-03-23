# TP2
### Binome : Caroni Christopher et Lepretre Guillaume

## Capture de trames : 

1. Que fait cette commande (utilisez le man) ?  

    Il affiche l'état des différents interfaces réseaux présent sur le noyau. Le `-a` affiche toutes les interfaces même si elles ne sont pas actives.
 
2. Quelles interfaces réseaux sont actuellement actives (running) ?  

    Il y a `eth0` et `l0`.

3. Parmi ces interfaces, quelle est celle qui vous permet de communiquer avec d'autres machines ?  

    C'est `l0` qui représente le `loopback`.

4. Quelles sont les adresses MAC et IPv4 de cette interface ?  

    Il y a: 
    - MAC: 98:90:96:bb:7c:da
    - IPv4:192.168.5.55 

5. Utilisez la commande ping pour tester la connectivité de votre machine vers la machine du voisin.

    ping 192.168.5.56  
    PING 192.168.5.56 (192.168.5.56) 56(84) bytes of data.  
    64 bytes from 192.168.5.56: icmp_seq=1 ttl=64 time=1.56 ms  
    64 bytes from 192.168.5.56: icmp_seq=2 ttl=64 time=0.797 ms  
    64 bytes from 192.168.5.56: icmp_seq=3 ttl=64 time=0.712 ms  

6. Que représente la valeur « Time » retournée par la commande ping ?  

    C'est le temps en ms du trajet entre deux machines.

7. Selon vous, de manière générale,pourquoi utilise-t-on l'adresse IP et non directement l'adresse MAC pour les communications réseaux ?  

    L'adresse `MAC` est lier à la machine physique et ne donne pas de précision sur le réseau.  

8. Lancez la commande ping vers votre voisin. D'après les informations capturées et décodées par wireshark, quels sont les paquets envoyés et reçus suite à l'exécution du ping ? Quels protocoles sont utilisés ?

    - Le protocol est `ICMP`
    - On envoie des paquets avec `ECHO request` et reçoit avec `ECHO reply`

9. A quelles couches appartiennent les protocoles cités précédemment ?  

    Il y a la couche `liaison`, `réseaux`, `transport` et `physique`

10. le filtre à l'affichage : après avoir effectué la capture précédente, dans le menu « analyse > display filters », faites en sorte que s'affiche uniquement le dialogue entre votre machine et celle du voisin.  

    Nous avons ajouter le filte suivant :
    - nom :voisin
    - filtre: ipp.addr == 192.168.5.56

11. le filtre de capture : dans le menu « capture > options », faites en sorte que soit capturé uniquement le dialogue entre votre machine et celle du voisin 

    Nous ajoutons le filtre de capture suivant :
    - IP address 192.168.5.56
    - host 192.168.5.56

## Ethernet
1. Sélectionnez un paquet ICMP. Situez, dans la fenêtre du bas, le champ de l'en-tête ethernet qui assure la fonction de multiplexage, c'est-à-dire qui indique le protocole de couche supérieur encapsulé dans la trame. Quel est le code du protocole de couche supérieur ?  

    - Ethernet II, Src: Dell_bb:7d:44 (98:90:96:bb:7d:44), Dst: Dell_bb:7c:da (98:90:96:bb:7c:da)
    - Destination: Dell_bb:7c:da (98:90:96:bb:7c:da)
    - Source: Dell_bb:7d:44 (98:90:96:bb:7d:44)

2. Quel est le rôle des 2 premiers champs de l'en-tête de la trame ?  
C'est la destination et la source. 
3. Utilisez les commandes mii-tool et ethtool pour connaître le mode de duplex et la vitesse de l'interface. Quelle est l'utilité de ces commandes et à quel niveau du modèle OSI interviennent-elles principalement ?  

    - Speed: 100Mb/s
    - Duplex: Full  
    - C'est utile pour la couche physique.

4. Déconnectez le câble de la prise « EXT » qui connecte votre machine au réseau EXTérieur.
Lancez de nouveau les commandes mii-tool et ifconfig -a. Que constatez-vous ?
Supprimez la route vers le réseau extérieur en lançant la commande :
route del -net default  

    Nous constatons que nous avons plus de réseaux. Le speed et le duplex est `unknown`.
    - Cannot get wake-on-lan settings: Operation not permitted
    - Current message level: 0x00000007 (7)
    - drv probe link
    - ink detected: no



5. Connectez-vous maintenant à un voisin en point-à-point, sans passer par un actif réseau (hub, switch,routeur), en réalisant le brassage au niveau de la baie (attention au type de câble).
Puis tester la connectivité de votre machine vers la machine du voisin.  

    64 bytes from 192.168.5.58: icmp_seq=1 ttl=64 time=0.341 ms  
    64 bytes from 192.168.5.58: icmp_seq=2 ttl=64 time=0.165 ms  
    64 bytes from 192.168.5.58: icmp_seq=3 ttl=64 time=0.180 ms  
    64 bytes from 192.168.5.58: icmp_seq=4 ttl=64 time=0.162 ms  

## Concentrateur

1. Lancez une capture de trames sur un poste, et transmettez un ping entre les deux autres postes. Que constatez-vous ? Déduisez-en la manière dont fonctionne cet équipement. Les données émises par un poste sont-elles reçues par ce même poste ?  

    Les données émisent sur un port du hub sont transmise vers tous les autres ports.
    Un concentrateur = hub. Il faut utiliser des cables droits.

2. Recommencez la manipulation en désactivant le mode promiscuous de wireshark. A quoi sert-il ?  

    Cela affiche les paquets même ceux qui ne nous sont pas destinés.

3. Quel est le mode de duplex des interfaces connectées au hub ? Quelle en est la signification ?  

    C'est du 10baseT-HD qui signifie qu'on ne peux envoyer et recevoir en même temps : half duplex.

4. Quelles sont les topologies physique et logique du réseau constitué par le concentrateur et les postes qui y sont connectés ? 

    Physique : étoile.  
    Logique : bus.

5. Utilisez « iperf -s » sur un poste et « iperf -c ip_du_serveur » sur un autre poste pour lancer un test de bande passante. Notez le débit atteint et les valeurs du compteur de collisions (ifconfig) avant et après la manipulation.
Connectez un poste supplémentaire sur le hub (soit au minimum 4 postes) et réalisez de nouveau la manip en parallèle sur les deux paires de postes.
Notez le débit atteint et les nouvelles valeurs des compteurs de collisions. Déduisez-en la manière dont fonctionne un hub.    
    
    `Première manipulation :` 
    _____________________________________________________________________________
    Client connecting to 192.168.5.54, TCP port 5001   
    TCP window size: 85.0 KByte (default)  
    _____________________________________________________________________________
    [  3] local 192.168.5.55 port 58216 connected with 192.168.5.54 port 5001  
    [ ID] Interval       Transfer     Bandwidth  
    [  3]  0.0-10.2 sec  `10.0 MBytes  8.19 Mbits/sec`  
    ____________________________________________________________________________

    `Deuxieme manipulation :`

    On remarque des conflits et la bande passante diminue fortement. 
    ____________________________________________________________________________
    Client connecting to 192.168.5.54, TCP port 5001  
    TCP window size: 85.0 KByte (default)
    ____________________________________________________________________________
    [  3] local 192.168.5.55 port 58226 connected with 192.168.5.54 port 5001  
    [ ID] Interval       Transfer     Bandwidth  
    [  3]  0.0-11.1 sec   `256 KBytes   188 Kbits/sec`  
    ____________________________________________________________________________


## Commutateur

1. Réactivez le mode promiscuous. Recommencez les manipulations précédentes et répondez aux questions 1 à 5 de la partie « concentrateur » en remplaçant le concentrateur par un commutateur (switch).
Pour paramétrer les équipements réseau et obtenir des informations sur leur configuration,il faut établir une liaison série entre votre poste de travail et le port console de l'équipement en question.
Cette liaison permet d'établir une connexion dite « hors bande », c'est-à-dire hors de la bande passante du réseau ethernet.
Connectez-vous sur le port console d'un switch, noté Sx-C (avec x=R,J,B ou V selon votre baie de brassage).Utilisez pour cela un câble série DB9-RJ45 (câble bleu et plat) et lancez le programme « minicom ».
Une fois connecté, si la question « voulez-vous lancer le setup du switch ? » vous est posée, répondez « non ». 
Vous êtes actuellement en mode USER EXEC (prompt >), qui ne permet de lancer qu'un nombre réduit de commandes, que vous pouvez lister en tapant « ? ». Passez en mode privilégié (prompt #) en tapant « enable ». Puis lancez la commande « show mac-address-table » ou « show mac address-table.  

    Le dialogue entre deux postes ne peux plus être caputuré.  
    On est en full duplex : 100baseTx-FD.  
    On est en topologie d'étoile que ce soit en physique ou logique.  
    On reçoit uniquement les paquet qui nous concerne. On a pas d'erreur supplémentaire au niveau des collisions : la bande passante est non partagé.

    ____________________________________________________________________________
    Client connecting to 192.168.5.54, TCP port 5001  
    TCP window size: 85.0 KByte (default)  
     ____________________________________________________________________________
    [  3] local 192.168.5.55 port 58232 connected with 192.168.5.54 port 5001  
    [ ID] Interval       Transfer     Bandwidth  
    [  3]  0.0-10.1 sec   114 MBytes  95.2 Mbits/sec  
    ____________________________________________________________________________

2. Comparez les adresses MAC listée avec celles de vos postes et les ports du switch sur lesquels ils sont connectés. Comment le switch a-t-il obtenu ces adresses ? Quel est le rôle de la table de commutation (appelée aussi table d'adresses MAC) ?  

    Pour être connecté avec minicom il faut être branché au port SJx-c. 

    SJ3#show mac-address-table  
    Dynamic Address Count:                 0  
    Secure Address Count:                  0  
    Static Address (User-defined) Count:   0  
    System Self Address Count:             39  
    Total MAC addresses:                   39  
    Maximum MAC addresses:                 8192 

    Les requêtes effectués par les machines permet au switch de les identifier.

    Le switch, reçoit les trames ethernet et associe les adresse sources avec le port où ils ont reçu celui-ci.  
    Le switch recherche l'adresse de destination dans la table et envoie la trame uniquement pour le port qui est concerné. Si l'adresse de destination n'est pas sur la table alors il est envoyé pour tous les autres ports. La table permet donc d'identifier les machines.


3. Pour fonctionner, le switch a-t-il besoin de connaître les adresses mac des trames ? les adresses IP des paquets ? Déduisez-en à quels niveaux du modèle OSI interviennent un switch et un hub et quelles sont les unités de données sur lesquelles ils agissent. 

    Oui il a besoin des adresses MAC pour identifier les machines concernés. Il n'a pas besoin des adresse IP puisque c'est un réseau LAN : couche liaison, envoie que de trame ethernet.   
    Les switchs et hubs interviennent sur les couches liaions en Mbit/s.

4. Concluez sur les avantages du switch par rapport au hub. 

  Le switch permet d'envoyer des paquets à la machine uniquement concernés ce qui évite les collisions et les erreurs : meilleur performance. Le hub lui est "bête" et ne fait que retransmettre le signal. Le switch a donc un avantage en terme de sécurité.

5. Lancez maintenant une capture de trames sur plusieurs postes connectés au switch et transmettez un ping vers l'adresse IP 192.168.5.255. Que constatez-vous ? Comment s'appelle ce type de transfert ? Quelle est l'adresse ethernet de destination des trames reçues ?  

  En broadcast, tout le monde reçoit les pings et tout le monde répond.

## Routeur

    Pour changer adresse ip : `sudo ifconfig eth0 192.168.1.100 netmask 255.255.255.0` dans le cas du poste 3
    Pour changer la route : `sudo route add default gw 192.168.1.200` dans le cas du poste 3

6. Après avoir lancé une capture de trames sur les postes 2 et 3, lancez un ping depuis le poste 1 vers le poste 2, puis vers le poste 3 (voir schéma). Il s'agit d'un transfert unicast. Comparez les valeurs du champ TTL de l'entête IP des paquets reçus sur les postes 2 et 3. Pourquoi sont-elles différentes ? Quelle est l'utilité de ce champ.  

    La valeur du TTL pour le poste 3 est de 63 alors que le poste 1 ou 2, le TTl à une valeur de 64. Ce  n'est pas le même car la trame passe par le switch et routeur alors que les postes 1 et 2 passe uniquement par le switch pour communiquer. 



7. Quelle devrait être la valeur du TTL pour que le poste 1 puisse communiquer avec le poste 2, mais pas avec le poste 3 ? Testez la validité de votre réponse en envoyant, depuis le poste 1, un ping avec ce TTL vers les postes 2 et 3 (voir « man ping »).  
Lancez une capture sur le poste 1 et envoyez un ping du poste 1 vers le poste 3 en conservant le TTL que vous avez choisi. Que se passe-t-il ?  

    La valeur doit être 1. On remarque alors que le poste 1 communique avec le poste 2 mais pas avec le poste 3. Lors de la capture on remarque  : `"Time-to-live exceeded"`

8. Lancez de nouveau un ping depuis le poste 1 vers le poste 3. Quelles sont l'adresse MAC source de la trame reçue (sur le poste 3) et l'adresse MAC de destination de la trame envoyée (à partir du poste 1) ?  
Selon vous, à quelles interfaces ethernet correspondent ces adresses ? Pour vous aider, lancez la commande « show interface fastethernet » sur le routeur.


    L'adresse source MAC de la trame est celui du routeur sur le poste 3. Il est de même pour l'adresse de destination pour le poste 1.


9. Comment le poste 1 a-t-il su que la trame ethernet contenant le paquet IP à destination du poste 3 devait être envoyée au routeur ?

    D'après la table de routage, le seule moyen d'y accéder est de passer par le routeur. 


10. Dessinez un schéma des couches OSI utilisées dans chaque équipement mis en jeu dans le transfert unicast (2 postes, 1 switch et 1 routeur), et tracez une ligne représentant le flux de données passant d'un équipement à l'autre (communication horizontale) en traversant les couches (communication verticale).  

    (VOIR SCHEMA)

11. Lancez une capture de trames sur plusieurs postes des deux réseaux et lancez un ping depuis un poste du réseau 192.168.5.0 vers l'adresse 255.255.255.255. Il s'agit d'un transfert en diffusion limitée. Que constatez-vous ?  

    On constate que ne nous pouvons pas envoyer à travers la routeur car celui-ci le protege. Seule les reponse provienne d'une adresse ip de ce type : 192.168.5.x soit les postes 1 et 2.

12. Lancez une capture de trames sur plusieurs postes des deux réseaux et lancez un ping depuis le réseau 192.168.1.0 vers l'adresse 192.168.5.255. Que constatez-vous ?  

    On ne reçoit pas de réponses de la part des postes 1 et 2 mais le routeur répond à leur place. 

13. Recommencez la manipulation précédente. Il s'agit d'un transfert en diffusion dirigée. Que constatez-vous ? Quelle est l'adresse IP des paquets reçus ? Selon vous, pourquoi ce mode de transfert est-il désactivé par défaut ?  

    On remarque que cette fois-ci nous pouvons communiquer avec les postes 1 et 2. L'adresse IP est celle des postes 1 et 2 : 192.168.5.x. Ce mode est désactiver pour éviter les surchages des réseaux.

14. Quelle est la différence entre diffusion limitée, diffusion dirigée et unicast.

    - Unicast c'est une machine A vers une machine B.
    - Limité c'est la diffusion en broadcast vers son propre réseau uniquement.
    - Dirigé c'est la diffusion en broadcast vers un autre réseau.
    

15. Comment un routeur réagit à ces différents types de paquets ? Concluez sur la différence entre un routeur et un switch vis-à-vis de la diffusion IP.

    Par défault, un routeur ne transmet pas les diffusions dirigés. 

## ARP

1. Utilisez la commande « arp » pour consulter le cache ARP de votre poste et y ajouter une entrée statique faisant correspondre l'adresse MAC du voisin 1 avec l'adresse IP du voisin 2.  

    Obtenir une adresse ipv4 connue, son adresse MAC : 
        arp -a
        ? (192.168.5.51) à 98:90:96:bb:7c:8d [ether] sur eth0
        ? (192.168.5.54) à 98:90:96:bb:80:83 [ether] sur eth0
        ? (192.168.5.57) à 98:90:96:bb:80:70 [ether] sur eth0

    arp -s 192.168.5.54 98:90:96:bb:80:83 pour ajouter une entrée statique. 

2. Lancez une capture de trames sur voisin 1 et voisin 2 et lancez, depuis votre poste, un ping sur voisin 2. Que constatez-vous ? Déduisez-en le rôle du cache ARP. 

    On constate que voisin 1 ne repond plus à l'echo request du ping. Le cache ARP permet de savoir queolle adresse physique correspond à une adresse IP, pour ainsi, compléter l'adresse de destination dans la trame.     

3. Lancez une capture de trames et exécutez un ping vers votre voisin. Consultez la table ARP et la capture de trames. Que constatez-vous ? Comment votre machine a-t-elle eu connaissance de l'adresse MAC de votre voisin ?  

    On constate que avant les requête ICMP, une requête ARP est émise en brodcast afin d'identifier la machine qui possède l'adresse IP voulue.  
    Une entrée est alors ajouté au cache ARP. On peux ainsi effectuer des requêtes ICMP.

4. Analysez l'en-tête ethernet pour identifier le code associé au protocole ARP.  

    C'est le code hexadecimale suivant : (0x0806).

5. Dans la requête ARP, que contient le champ constitué des 6 octets commençant à l'octet n° 0x20. Quel est son rôle ?  

    Elle contient des zéros. C'est l'adresse broadcast puisque nous ne connaissons pas l'adresse MAC du destinataire. 

6. Dans la réponse ARP, situez l'adresse MAC objet de la requête précédente.  

      Elle est à l'offset 0x16. 

7. Pourquoi la fin des paquets ARP est-elle constituée de 0 ou de motifs répétitifs ?  

    Etant donnée que la trame ethernet possède une taille minimale de 64 octets, on rajoute des 0 pour remplir la fin lorsqu'il n'y a plus de données. 

8. Faites un schéma représentant les différents champs de la requête et de la réponse ARP, ainsi que leur longueur. 

    (voir schema ARP)

