package backend;

import java.util.ArrayList;

public class CsceState extends MajorState {
    private ArrayList<Class> labScienceElective;

    public CsceState(Roadmap roadmap) {
        super(roadmap);
    };

    public ArrayList<Class> getLabScienceElective() {
        return labScienceElective;
    }

    public String toString() {
        StringBuilder csceString = new StringBuilder();
        csceString.append("Major Classes:\n");
        System.out.println(majorClasses);
        if(!majorClasses.isEmpty()) {
            for (Class course : majorClasses) {
                csceString.append(course.toString()).append("\n");
            }
        }

        csceString.append("Lab Science Electives:\n");
        for (Class course : labScienceElective) {
            csceString.append(course.toString()).append("\n");
        }

        return csceString.toString();
    
    }
    
}