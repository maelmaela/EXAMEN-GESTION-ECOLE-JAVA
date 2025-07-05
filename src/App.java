
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Attache;
import entity.Classe;
import entity.Demande;
import entity.Etat;
import entity.Etudiant;
import entity.Inscription;
import entity.Personne;
import entity.Module;
import entity.Professeur;
import services.ClasseService;
import services.DemandeService;
 import services.InscriptionService;
import services.ModuleService;
import services.PersonneService;
import views.ClasseVue;
import views.DemandeVue;
import views.InscriptionVue;
import views.ModuleVue;
import views.PersonneVue;
import views.Vue;

public class App {
  

    public static void main(String[] args) throws Exception {
        
        String tel;
        String libelle;
        String matricule;
        int choix1;
        int choix2;
        int choix3;
        int choix4;
        do {
            
            choix1=Vue.MenuPrincipal();
            if (choix1==1) {
                do {
                    choix2 = Vue.menuRP();
                    switch (choix2) {
                        case 1:
                            Classe classe = ClasseVue.saisieClasse();   
                            break;
                        case 2:
                            ClasseVue.afficheClasse(ClasseService.getClasses());
                            break;
                        case 4:
                            ModuleVue.afficheModule(ModuleService.getModules());
                            break;
                        case 3:
                            Module module = ModuleVue.saisieModule();
                            break;
                        case 5:
                            Personne personne = PersonneVue.saisiePersonne(3);
                            PersonneService.addPersonne(personne);
                            break;
                        case 6:
                            PersonneVue.afficheProfesseur(PersonneService.getAllProfesseur());
                            break;
                        case 7:
                            PersonneVue.afficheProfesseur(PersonneService.getAllProfesseur());
                            tel = Vue.saisieChaine("Entrez le telephone du professeur");
                            personne = PersonneService.searchPersonneByTel(tel);
                            if (personne instanceof Professeur) {
                                Professeur professeur = (Professeur) personne;
                                ModuleVue.afficheModule(ModuleService.getModules());
                                libelle = Vue.saisieChaine("Entrez le libelle du module");
                                module = ModuleService.searchModuleByLibelle(libelle);
                                if (module!=null) {
                                    professeur.addModuleToProfesseur(module);
                                    System.out.println("Le module a ete affecté avec succes");
                                }else{
                                    System.out.println("Le module n'existe pas");
                                }
                            }else {
                                System.out.println("Cette personne n'existe pas");
                            }
                            break;
                        case 8:
                            PersonneVue.afficheProfesseur(PersonneService.getAllProfesseur());
                            tel = Vue.saisieChaine("Entrez le numero de telephone du professeur");
                            personne = PersonneService.searchPersonneByTel(tel);
                            if (personne instanceof Professeur) {
                                Professeur professeur = (Professeur) personne;
                                ClasseVue.afficheClasse(ClasseService.getClasses());
                                libelle = Vue.saisieChaine("Entrez le libelle de la classe que vous voulez affecter au professeur");
                                classe = ClasseService.searchClasseByLibelle(libelle);
                                if (classe!=null) {
                                    professeur.addClasseToProfesseur(classe);
                                    System.out.println("La classe a étéaffecté avec succes");
                                }else{
                                    System.out.println("Cette classe n'existe pas");
                                }
                            }else{
                                System.out.println("Ce professeur n'existe pas");
                            }
                            break;
                        case 9:
                            tel = Vue.saisieChaine("Entrez le numero de telephone du professeur");
                            personne = PersonneService.searchPersonneByTel(tel);
                            if (personne instanceof Professeur) {
                                Professeur professeur = (Professeur) personne;
                                PersonneVue.afficheModuleProf(professeur);
                            }else{
                                System.out.println("Cette personne n'est pas un professeur");
                            }
                            break;
                        case 10:
                            tel = Vue.saisieChaine("Entrez le numero de telephone du professeur");
                            personne = PersonneService.searchPersonneByTel(tel);
                            if (personne instanceof Professeur) {
                                Professeur professeur = (Professeur) personne;
                                PersonneVue.afficheClasseProf(professeur);
                            }else{
                                System.out.println("Cette personne n'est pas un professeur");
                            }
                            break;
                        case 12:
                            personne = PersonneVue.saisiePersonne(2);
                            PersonneService.addPersonne(personne);
                            break;
                        case 11:
                            matricule = Vue.saisieChaine("Entrez la matricule de l'etudiant dont vous voulez traiter la demande");
                            personne = PersonneService.searchEtudiantByMatricule(matricule);
                            if (personne instanceof Etudiant) {
                                Etudiant etudiant = (Etudiant) personne;
                                DemandeVue.afficheDemandeEtudiant(etudiant);
                                int id = Vue.saisiEntier("Entrez l'id de la demande");
                                Demande demande = DemandeService.searchDemandeById(id);
                                if (demande!=null) {
                                    String rep = Vue.saisieChaine("Que voulez vous faire à la demande?").toLowerCase();
                                    if (rep=="accepter") {
                                        demande.setEtat(Etat.ACCEPTER);
                                    }else if (rep == "refuser") {
                                        demande.setEtat(Etat.REFUSER);
                                    }else{
                                        demande.setEtat(Etat.SUSPENSION);
                                    }
                                }
                            }
                            break;
                        case 13:
                            tel = Vue.saisieChaine("Entrez le numero de téléphone de l'attache");
                            personne = PersonneService.searchPersonneByTel(tel);
                            if (personne == null) {
                                System.out.println("Cette personne n'existe pas");
                            }else{
                                if (personne instanceof Attache) {
                                    Attache attache = (Attache) personne;
                                    libelle = Vue.saisieChaine("Entrez le libelle de la classe");
                                    classe = ClasseService.searchClasseByLibelle(libelle);
                                    if (classe!=null) {
                                        attache.addClassToAttache(classe);
                                        classe.setAttache(attache);
                                        System.out.println("Classe affecté avec succes");
                                    }else{
                                        System.out.println("Cette classe n'existe pas");
                                    }
                                }else{
                                    System.out.println("Cette personne n'est pas un attache");
                                }
                            }
                            break;
                        case 14:
                            PersonneVue.afficheAttache(PersonneService.getAllAttache());
                            break;
                        case 15:
                            // System.out.println("Entrer l'année dont vous voulez savoir l'effectif'");
                            // LocalDate date=LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                            int effectif = InscriptionService.getAllInscriptionAnnes(LocalDate.now());
                            System.out.println(effectif);
                            break;
                        case 16:
                            // System.out.println("Entrer l'année dont vous voulez savoir le nombre de fille");
                            // date=LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                            effectif = InscriptionService.getNbreFilleParAnne(LocalDate.now());
                            System.out.println(effectif);
                            break;
                        case 17:
                            // System.out.println("Entrer l'année dont vous voulez savoir le nombre de garcon");
                            // date=LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                            effectif = InscriptionService.getNbreGarconParAnne(LocalDate.now());
                            System.out.println(effectif);
                            break;
                        case 18:
                            libelle = Vue.saisieChaine("Entrez le libelle de la classe");
                            classe = ClasseService.searchClasseByLibelle(libelle);
                            // System.out.println("Entrer l'année ");
                            // date=LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                            if (classe!=null) {
                                
                                effectif = ClasseService.getNbreEtudiantClasse(classe.getInscriptions(),LocalDate.now());
                                System.out.println(effectif);
                            }else{
                                System.out.println("La classe n'existe pas");
                            }
                            break;
                        case 19:
                            libelle = Vue.saisieChaine("Entrez le libelle de la classe");
                            classe = ClasseService.searchClasseByLibelle(libelle);
                            // System.out.println("Entrer l'année ");
                            // date=LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                            if (classe!=null) {
                                System.out.println(classe.getInscriptions());
                                effectif = ClasseService.getNbreFilleParClasse(classe.getInscriptions(), LocalDate.now());
                                System.out.println(effectif);
                            }else{
                                System.out.println("La classe n'existe pas");
                            }
                            break;
                        case 20:
                            libelle = Vue.saisieChaine("Entrez le libelle de la classe");
                            classe = ClasseService.searchClasseByLibelle(libelle);
                            // System.out.println("Entrer l'année");
                            // date=LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                            if (classe!=null) {
                                effectif = ClasseService.getNbreGarconParClasse(classe.getInscriptions(), LocalDate.now());
                                System.out.println(effectif);
                            }else{
                                System.out.println("La classe n'existe pas");
                            }
                            break;
                        case 21:
                            // System.out.println("Entrer l'année n");
                            // date=LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                            effectif = InscriptionService.getNbreEtudiantInscriptionSuspendu(LocalDate.now());
                            System.out.println(effectif);
                            break;
                        case 22:
                            // System.out.println("Entrer l'année n");
                            // date=LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                            effectif = InscriptionService.getNbreEtudiantInscriptionAnnule(LocalDate.now());
                            System.out.println(effectif);
                            break;
                        default:
                            break;
                    }
                }while (choix2!=24);
            }else if (choix1 == 2) {
                do {
                    choix3 = Vue.menuAttache();
                switch (choix3) {
                    case 1:
                        Personne personne = PersonneVue.saisiePersonne(4);
                        if (personne instanceof Etudiant) {
                            PersonneService.addPersonne(personne);
                            Etudiant etudiant = (Etudiant) personne;
                            Classe classe = new Classe();
                            libelle = Vue.saisieChaine("Entrez le libelle de la classe");
                            classe = ClasseService.searchClasseByLibelle(libelle);
                            if (classe != null) {
                                Inscription inscription = InscriptionVue.saisieInscription(etudiant, classe);
                                InscriptionService.addInscription(inscription);
                                classe.addInscriptionToClasse(inscription);
                                etudiant.addInscriptionToEtudiant(inscription);
                                etudiant.setClasse(classe);
                                System.out.println("Inscription ajoutée avec succes");
                            }else{
                                System.out.println("Cette classe n'existe pas");
                            }
                        }else {
                            System.out.println("Cette personne n'est pas un etudiant");
                        }
                        break;
                    case 2:
                        matricule = Vue.saisieChaine("Entrez la matricule de l'etudiant");
                        personne = PersonneService.searchEtudiantByMatricule(matricule);
                        if (personne instanceof Etudiant) {
                            Etudiant etudiant = (Etudiant) personne;
                            Classe classe = new Classe();
                            libelle = Vue.saisieChaine("Entrez le libelle de la classe");
                            classe = ClasseService.searchClasseByLibelle(libelle);
                            if (classe != null ) {
                                if (etudiant.getClasse()!= classe) {
                                    Inscription inscription = InscriptionVue.saisieInscription(etudiant, classe);
                                    InscriptionService.addInscription(inscription);
                                    classe.addInscriptionToClasse(inscription);
                                    etudiant.addInscriptionToEtudiant(inscription);
                                    System.out.println("Inscription ajoutée avec succes");
                                }else{
                                    System.out.println("L'etudiant est deja inscrit dans cette classe");
                                } 
                            }else{
                                System.out.println("L'etudiant n'existe pas");
                            }
                        }
                        break;
                    case 3:
                        libelle = Vue.saisieChaine("Entrez le libelle de classe");
                        Classe classe = ClasseService.searchClasseByLibelle(libelle);
                        if (classe != null) {
                            LocalDate date = LocalDate.now();
                            ClasseVue.afficheInscriptionClasse(classe, date);
                        }else{
                            System.out.println("La classe n'existe pas");
                        }
                        break;
                    case 4:
                        LocalDate date = LocalDate.now();
                        InscriptionVue.afficheEtudiantInscritsAnne(InscriptionService.getInscriptions(), date);
                        break;
                    default:
                        break;
                }
                } while (choix3!=6);
                
            }else if (choix1 == 3) {

                do {
                    choix4 = Vue.menuEtudiant();
                    switch (choix4) {
                        case 2:
                            matricule = Vue.saisieChaine("Entrez votre matricule");
                            Personne personne = PersonneService.searchEtudiantByMatricule(matricule);
                            if (personne !=null) {
                                Etudiant etudiant = (Etudiant) personne;
                                InscriptionVue.afficheInscription(InscriptionService.getInscriptions());
                                int id = Vue.saisiEntier("Entrez l'id de l'inscription que vous voulez annuler");
                                Inscription inscription = InscriptionService.searchInscriptionById(id);
                                Demande demande = DemandeVue.saisieDemande(etudiant);
                                etudiant.addDemandeToEtudiant(demande);
                                inscription.addDemandeToInscription(demande);
                                demande.setInscription(inscription);
                                inscription.setEtat(Etat.REFUSER);
                                DemandeService.addDemande(demande);
                                System.out.println("La demande a été effectuée avec succes");
                            }else{
                                System.out.println("Cet etudiant n'existe pas");
                            }
                            break;
                        case 3:
                            matricule = Vue.saisieChaine("Entrez votre matricule");
                            personne = PersonneService.searchEtudiantByMatricule(matricule);
                            if (personne !=null) {
                                Etudiant etudiant = (Etudiant) personne;
                                InscriptionVue.afficheInscription(InscriptionService.getInscriptions());
                                int id = Vue.saisiEntier("Entrez l'id de l'inscription que vous voulez suspendre");
                                Inscription inscription = InscriptionService.searchInscriptionById(id);
                                Demande demande = DemandeVue.saisieDemande(etudiant);
                                etudiant.addDemandeToEtudiant(demande);
                                inscription.addDemandeToInscription(demande);
                                inscription.setEtat(Etat.SUSPENSION);
                                DemandeService.addDemande(demande);
                                System.out.println("La demande a été effectuée avec succes");
                            }else{
                                System.out.println("Cet etudiant n'existe pas");
                            }
                            break;
                        case 4:
                            matricule = Vue.saisieChaine("Entrez votre matricule");
                            personne = PersonneService.searchEtudiantByMatricule(matricule);;
                            Etudiant etudiant = (Etudiant) personne;
                            DemandeVue.afficheDemandeEtudiant(etudiant);
                            break;
                        case 5:
                            matricule = Vue.saisieChaine("Entrez votre matricule");
                            personne = PersonneService.searchEtudiantByMatricule(matricule);;
                            etudiant = (Etudiant) personne;
                            int etat = Vue.saisieEtat();
                            if (etat==1) {
                                DemandeVue.affciheDemande(DemandeService.getDemandeAcceptes(etudiant.getDemandes()));
                            }else if(etat==2){
                                DemandeVue.affciheDemande(DemandeService.getDemandeRefuses(etudiant.getDemandes()));
                            }else{
                                DemandeVue.affciheDemande(DemandeService.getDemandeSupendues(etudiant.getDemandes()));
                            }
                            break;
                        default:
                            break;
                    }
                } while (choix4!=7);
                
            }
        } while (choix1!=4);
    }
}
