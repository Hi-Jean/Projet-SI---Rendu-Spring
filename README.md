# Projet-SI---Rendu-Spring

# Auteurs
COTTO Erwan / JEAN Hippolyte / THOMAS Jean-André

# Fonctionnalités API
L'API membre est capable :

**@RequestMapping("/membre")**

Récupère la liste de tous les membres enregistrés \
@GetMapping \
**public List<MembreDto> getMembres()** 

Récupérer les détails d'un membre avec son ID \
@GetMapping("/{id}") \
**public MembreDto getMembre(Long id)**

Enregistre le membre passé dans la requête \
@PostMapping \
**public MembreDto saveMembre(MembreDto membreDto)**

Met à jour les détails d'un membre selon son ID \
@PutMapping("/{id}") \
**public MembreDto updateMembre(Long id, MembreDto membreDto)**

Supprimer un membre avec son ID \
@DeleteMapping("/{id}")} \
**public Boolean deleteMembre(Long id)**

# Docker
Docker compose comprends :
+ Création de deux conteneurs pour les bases de données :
  + mongoDB avec 1 fichier d'import de peuplement de données
  +  Mysql avec 1 fichier d'import de peuplement de données 
 + montage de volume pour les bdd

+ Création de quattre conteneurs pour les API
  + API Membre
  + API Evenement
  + API Lieu
  + API Message

# Postman
La collection Postman comprends :
  + Collection d'endPoints API pour API Membre






