package services;
import entity.*;
import java.util.ArrayList;
                                           
public class DemandeService {
    private static ArrayList<Demande> demandes = new ArrayList<>();

    private DemandeService(){}

    public static ArrayList<Demande> getDemandes() {
        return demandes;
    }

    public static void setDemandes(ArrayList<Demande> demandes) {
        DemandeService.demandes = demandes;
    }

    public static void addDemande(Demande demande){
        demandes.add(demande);
    }

    public static Demande searchDemandeById(int id){
        for (Demande demande : demandes) {
            if (demande.getId()==id) {
                return demande;
            }
        }
        return null;
    }

    public static ArrayList<Demande> getDemandeAcceptes(ArrayList<Demande> demandes){
        ArrayList<Demande> demandesAcceptees = new ArrayList<>();
        for (Demande demande : demandes) {
            if (demande.getEtat() == Etat.ACCEPTER) {
                demandesAcceptees.add(demande);
            }
        }
        return demandesAcceptees;
    }

    public static ArrayList<Demande> getDemandeRefuses(ArrayList<Demande> demandes){
        ArrayList<Demande> demandesRefuses = new ArrayList<>();
        for (Demande demande : demandes) {
            if (demande.getEtat() == Etat.REFUSER) {
                demandesRefuses.add(demande);
            }
        }
        return demandesRefuses;
    }

    public static ArrayList<Demande> getDemandeSupendues(ArrayList<Demande> demandes){
        ArrayList<Demande> demandeSuspendues = new ArrayList<>();
        for (Demande demande : demandes) {
            if (demande.getEtat() == Etat.REFUSER) {
                demandeSuspendues.add(demande);
            }
        }
        return demandeSuspendues;
    }
}
