package views;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Module;
import services.ModuleService;

public class ModuleVue {
    private static Scanner scanner = new Scanner(System.in);
    private ModuleVue(){}

    public static Module saisieModule(){
        Module module = new Module();
        String libelle;
        libelle = Vue.saisieChaine("Entrez le libelle");
        scanner.nextLine();
        if (ModuleService.searchModuleByLibelle(libelle)==null) {
            module.setLibelle(libelle);
            ModuleService.addModule(module);
            System.out.println("Module ajoutéé avec succes");
        }else{
            System.out.println("Le module existe deja");
            module = ModuleService.searchModuleByLibelle(libelle);
        }
        return module;
    }

    public static void afficheModule(ArrayList<Module> modules){
        for (Module module : modules) {
            System.out.println(module.toString());
        }
    }
}
