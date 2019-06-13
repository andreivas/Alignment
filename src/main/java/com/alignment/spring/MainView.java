package com.alignment.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("solution")
@Theme(Lumo.class)
public class MainView extends VerticalLayout {

	private static final long serialVersionUID = 8624675119030983174L;

	public MainView() {

		Label label = new Label("String Alignment Exercise");

		TextField original = new TextField("Original");
		original.setLabel("Original Text:");

		TextField cleaned = new TextField("Cleaned");
		cleaned.setLabel("Cleaned text:");

		Button btn = new Button("Click me");
		btn.addClickListener(buttonClickEvent -> {

			Solution sol = new Solution();

			int[] solution = sol.solution(original.getValue(), cleaned.getValue());
			Label result = new Label("Offset from original text to cleaned text:  ");

			for (int i = 0; i < solution.length; i++) {

				if (solution[i] == 1) {

					result.add("<" + original.getValue().charAt(i) + ">");

				} else
					result.add(String.valueOf(original.getValue().charAt(i)));
			}

			add(result);

		});

		addComponent(label, original, cleaned, btn);
	}

	private void addComponent(Label label, TextField original, TextField cleaned, Button btn) {
		add(label);
		add(original);
		add(cleaned);
		add(btn);
	}

}
