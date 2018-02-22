package ru.jetforce;

import org.apache.wicket.markup.html.WebPage;


import java.io.Serializable;

public class WelcomePage extends WebPage implements Serializable {

    public WelcomePage() {
        add(new SamplePanel("panel"));
    }
}
