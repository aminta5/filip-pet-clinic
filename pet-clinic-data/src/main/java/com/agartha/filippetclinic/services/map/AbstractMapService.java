package com.agartha.filippetclinic.services.map;

import com.agartha.filippetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();
    protected Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    protected T findById(ID id){
        return map.get(id);
    }
    protected T save(T object){
        if(object != null){
            if(object.getId() == null){
                object.setId(getNextId());
            }
            return map.put(object.getId(), object);
        }
        else if(object == null){
            throw new RuntimeException(("Object cannot be null"));
        }
        return object;
    }

    protected void deleteById(ID id){
        map.remove(id);
    }

    protected void deleteByObject(T object){
        map.entrySet().removeIf( entry -> entry.getValue().equals(object));
    }

    private Long getNextId(){
        Long nextId = null;
        try{
            nextId = Collections.max(map.keySet()) + 1;
        }catch(NoSuchElementException e){
            nextId = 1L;
        }
        return nextId;
    }
 }
