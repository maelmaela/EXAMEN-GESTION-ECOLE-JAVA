package services;
import entity.Module;

import java.util.ArrayList;

public class ModuleService {
    private static ArrayList<Module> modules = new ArrayList<>();

    private ModuleService(){}

    public static ArrayList<Module> getModules() {
        return modules;
    }

    public static void setModules(ArrayList<Module> modules) {
        ModuleService.modules = modules;
    }

    public static void addModule(Module module){
        modules.add(module);
    }

    public static Module searchModuleByLibelle(String libelle){
        for (Module module : modules) {
            if (module.getLibelle().equals(libelle)) {
                return module;
            }
        }
        return null;
    }
}
