package ru.jetforce.service;

import ru.jetforce.model.Cheese;

import java.io.Serializable;
import java.util.List;

/**
 * @author Alexey Skorobogatov
 */
public class CheesrServiceImpl implements CheesrService, Serializable {

    private static final long serialVersionUID = 1L;

    private List<Cheese> cheeses;

    public CheesrServiceImpl(List<Cheese> cheeses){
        this.cheeses = cheeses;
    }

    @Override
    public Cheese findByName(final String name) {
        return cheeses.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
