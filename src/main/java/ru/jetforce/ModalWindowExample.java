package ru.jetforce;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;

public class ModalWindowExample extends WebPage {

    private ModalWindow modalWindow;

    private String action;

    public ModalWindowExample() {

        modalWindow = new ModalWindow("modalWindow");
        modalWindow.setPageCreator(new ModalWindow.PageCreator() {
            @Override
            public Page createPage() {
                return new WelcomePage(action);
            }
        });
        modalWindow.setTitle("ModalWindowExample");
        modalWindow.setWindowClosedCallback(new ModalWindow.WindowClosedCallback() {
            @Override
            public void onClose(AjaxRequestTarget ajaxRequestTarget) {

            }
        });

        add(new AjaxLink<String>("viewLink") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                action = "view";
                modalWindow.show(target);
            }
        });
        add(new AjaxLink<String>("editLink") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                action = "edit";
                modalWindow.show(target);
            }
        });
        add(modalWindow);
    }
}
