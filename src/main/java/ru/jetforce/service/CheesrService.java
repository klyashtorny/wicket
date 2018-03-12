package ru.jetforce.service;

import ru.jetforce.model.Cheese;

/**
 * @author Anton Klyashtorny
 */
public interface CheesrService  {
    public Cheese findByName(String name);
}
