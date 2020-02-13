package models;

import java.util.ArrayList;

public class Project {
    String nameProject;
    String descriptionProject;
    ArrayList<String> domains;

    public Project(String nameProject, String descriptionProject, ArrayList<String> domains) {
        this.nameProject = nameProject;
        this.descriptionProject = descriptionProject;
        this.domains = domains;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public String getDescriptionProject() {
        return descriptionProject;
    }

    public void setDescriptionProject(String descriptionProject) {
        this.descriptionProject = descriptionProject;
    }

    public ArrayList<String> getDomains() {
        return domains;
    }

    public void setDomains(ArrayList<String> domains) {
        this.domains = domains;
    }

     // arrayList <String>


}
