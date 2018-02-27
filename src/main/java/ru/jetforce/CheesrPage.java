package ru.jetforce;

import org.apache.wicket.markup.html.WebPage;

import java.io.Serializable;
import java.util.List;

public class CheesrPage extends WebPage implements Serializable {

    public CheesrSession getCheesrSession() {
        return (CheesrSession) getSession();
    }
    public Cart getCart() {
        return getCheesrSession().getCart();
    }
    public List<Cheese> getCheeses() {
        return CheesrApplication.get().getCheeses();
    }
}
