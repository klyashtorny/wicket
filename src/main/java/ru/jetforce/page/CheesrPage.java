package ru.jetforce.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import ru.jetforce.CheesrApplication;
import ru.jetforce.CheesrSession;
import ru.jetforce.model.Cart;
import ru.jetforce.model.Cheese;

import java.io.Serializable;
import java.util.List;

public class CheesrPage extends WebPage implements Serializable {

    public CheesrPage() {}

    public CheesrPage(PageParameters pageParameters){
        super(pageParameters);
    }

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
