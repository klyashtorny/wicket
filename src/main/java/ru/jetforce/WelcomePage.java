package ru.jetforce;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WelcomePage extends WebPage implements Serializable {

    private List<String> genderChoices = new ArrayList<>();

    public WelcomePage() {
        genderChoices.add("Male");
        genderChoices.add("Female");
        final User user = new User();
        Form<?> form = new Form("form");
        TextField<String> text = new TextField<String>("text", new PropertyModel<String>(user, "name"));
        DropDownChoice<String> gender = new DropDownChoice<String>("gender",
                new PropertyModel<String>(user, "gender"), genderChoices);

        Button button = new Button("submit"){
            @Override
            public void onSubmit() {
                super.onSubmit();
                System.out.println("Name :" + user.getName());
                System.out.println("Gender :" + user.getGender());
            }
        };
        add(form);
        form.add(text);
        form.add(gender);
        form.add(button);
    }
}
