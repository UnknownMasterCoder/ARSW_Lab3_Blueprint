/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.services;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsFilter;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcadavid
 */
@Service
public class BlueprintsServices {
   
    @Autowired
    BlueprintsPersistence bpp;
    
    @Autowired
    BlueprintsFilter bpf;
    
    public void addNewBlueprint(Blueprint bp) throws BlueprintPersistenceException{
        Blueprint bpWithFilter = bpf.blueprintsFilter(bp);
        bpp.saveBlueprint(bpWithFilter);
    }
    
    public Set<Blueprint> getAllBlueprints() throws BlueprintNotFoundException{        
        Set<Blueprint> allBlueprints = bpp.getAllBlueprints();
        return allBlueprints;
    }
    
    /**
     * 
     * @param author blueprint's author
     * @param name blueprint's name
     * @return the blueprint of the given name created by the given author
     * @throws BlueprintNotFoundException if there is no such blueprint
     */
    public Blueprint getBlueprint(String author,String name) throws BlueprintNotFoundException{
        /*Blueprint blueprint = bpp.getBlueprint(author, name);
        Blueprint bpWithFilter = bpf.blueprintsFilter(blueprint);
        return bpWithFilter; */
        
        Blueprint blueprint = bpp.getBlueprint(author, name);
        return blueprint;
    }
    
    /**
     * 
     * @param author blueprint's author
     * @return all the blueprints of the given author
     * @throws BlueprintNotFoundException if the given author doesn't exist
     */
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException{
        Set<Blueprint> blueprintsByAuthor = bpp.getBlueprintsByAuthor(author);
        return blueprintsByAuthor; 
    }
    
    public void putBlueprint(String author, String blueprintName, Point[] points) throws BlueprintPersistenceException, BlueprintNotFoundException{
        
        /*
        bpp.putBlueprint(author, blueprintName, points);
        Blueprint bp = bpp.getBlueprint(author, blueprintName);
        Blueprint bpWithFilter = bpf.blueprintsFilter(bp);
        bpp.saveBlueprint(bpWithFilter);
        */
        bpp.putBlueprint(author, blueprintName, points);
    }
    
}
