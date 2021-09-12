# Projet de gestion de compte bancaire et de simulateur de GAB
# SPÉCIFICATIONS
Éléments clés
Les grandes lignes du fonctionnement du simulateur de guichet automatique sont résumées comme suit :
* Avant d’effectuer une transaction, l’utilisateur doit saisir son nom et son NIP (numéro d’identification personnel) sur un écran de saisie. Le fonctionnement de cet écran de saisie doit simuler celui que nous retrouvons généralement et le NIP ne doit pas apparaître à l’écran.
En plus du message apparaissant suite à toute tentative infructueuse, si le NIP correspondant au nom n’a toujours pas été saisie correctement après trois essais, l’application doit afficher à l’écran un message demandant à l’utilisateur d’essayer de réutiliser le guichet automatique plus tard.
Lorsque l’accès aux opérations est autorisé, la fenêtre principale de l’application doit pouvoir permettre à l’utilisateur de réaliser l’une des transactions suivantes :
  * Dépôt
  * Retrait
  * Virement
* Lors d’un dépôt, l’utilisateur doit saisir le montant et, si requis, il doit être capable de sélectionner le type de compte qui doit être crédité. Le compte chèque est le compte utilisé par défaut pour cette transaction.
* Lors d’un retrait, l’utilisateur doit saisir le montant et, si requis, il doit être capable de sélectionner le type de compte qui doit être débité. Le compte chèque est le compte utilisé par défaut pour cette transaction dont le montant maximum est de $1,000. Le guichet n’acceptera que les transactions dont les valeurs saisies sont des multiples de $10. Il n’y a aucun montant maximal journalier (si ce n’est le solde du compte de l’utilisateur).
* Lors d’un virement, l’utilisateur doit saisir le montant et le type de virement (du compte chèque vers le compte épargne, ou vice-versa). Le montant maximum pour cette transaction est de $100,000. Le système doit permettre seulement les virements du compte chèque vers le compte épargne ou du compte épargne vers le compte chèque.
* L’application doit vérifier le solde du compte avant de faire une transaction. Toute opération dont le résultat entraînerait une balance négative devrait être rejetée.
* Le solde du compte affecté par une transaction devrait être mis à jour et affiché après chaque transaction avec un Toast.
* L’utilisateur devrait pouvoir faire le nombre de transaction qu’il désire avant de quitter le guichet.
Les prochains éléments ne concernent plus le fonctionnement du simulateur de guichet automatique par rapport à l’utilisateur mais plutôt par rapport à l’administrateur du système et aux mécanismes internes.
* L’administrateur du système, comme tout autre utilisateur, doit saisir son nom et son NIP (numéro d’identification personnel) sur le même écran de saisie. L’administrateur du système ne peut faire que des transactions système (il ou elle n’a pas de compte personnel).
* L’administrateur du système peut exécuter le paiement d’intérêt sur tous les comptes d’épargne au taux de 1.25%
* Une fois l’accès aux opérations système autorisé, un menu spécial apparaît. Ce menu offre les options suivantes :
  * Paiement des intérêts
  * Génération des rapports sur les comptes
# CONCEPTION DES CLASSES :
## Class Compte
  * Propriétés : numeroNIP, numeroCompte,soldeCompte.
  * Méthodes : retrait (montant); depot (montant).
## Class Cheque
  * Hérite de la classe Compte.
## Class Epargne
  * Hérite de la classe Compte.
  * Propriétés constantes : tauxInteret.
  * Méthodes : paiementInterets ()
## Class Client
  * Propriétés : nom, prenom, username, numeroNIP.
## Class Guichet
  * Propriétés : clients, comptesCheque, comptesEpargne.
  * Méthodes :
    * ValiderUtilisateur (nom, nip) retourne une valeur Boolean
    * RetraitCheque (nip, montant) retourne le solde du compte
    * RetraitEpargne (nip, montant) retourne le solde du compte
    * DepotCheque (nip, montant) retourne le solde du compte
    * DepotEpargne (nip, montant) retourne le solde du compte