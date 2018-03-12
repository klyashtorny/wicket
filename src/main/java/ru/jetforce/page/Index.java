package ru.jetforce.page;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import ru.jetforce.model.Cheese;

public class Index extends CheesrPage  {

    private ShoppingCartPanel shoppingcart;

    public Index() {
        PageableListView cheeses
                = new PageableListView("cheeses", getCheeses(), 5) {
            @Override
            protected void populateItem(ListItem item) {
                Cheese cheese = (Cheese) item.getModelObject();
                item.add(new Label("name", cheese.getName()));
                item.add(new Label("description",
                        cheese.getDescription()));
                item.add(new Label("price", "$" + cheese.getPrice()));
                item.add(new AjaxFallbackLink("add", item.getModel()) {
                    @Override
                    public void onClick(AjaxRequestTarget target) {
                        Cheese selected = (Cheese)getModelObject();
                        getCart().getCheeses().add(selected);
                        if(target!=null) target.add(shoppingcart);

                    }
                });
                /**
                 * Add a link to cheese details
                 */
                PageParameters params = new PageParameters();
                params.add("name", cheese.getName().toLowerCase());
                item.add(new BookmarkablePageLink("details", CheesrDetails.class, params));
            }

        };
        add(cheeses);
        add(new PagingNavigator("navigator", cheeses));
        shoppingcart = new ShoppingCartPanel("shoppingcart", getCart());
        shoppingcart.setOutputMarkupId(true);
        add(shoppingcart);
        add(new Link("checkout") {
            @Override
            public void onClick() {
                setResponsePage(new CheckOut());
            }
            @Override
            public boolean isVisible() {
                return !getCart().getCheeses().isEmpty();
            }
        });
    }
}
