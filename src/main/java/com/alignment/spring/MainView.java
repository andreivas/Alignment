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
			
		boolean displayByWords = false;
		
			Solution sol = new Solution();
			
			int[] solution = null;
			
			if (original.getValue().contains(" ") && cleaned.getValue().contains(" ")) {
	
				solution = sol.solutionWord(  splitBySpace(original) , splitBySpace(cleaned) );
				
				displayByWords = true;
				
			} else {
				
				displayByWords = false;
				solution = sol.solutionChar(original.getValue(), cleaned.getValue());
			}
			
			
			Label result = new Label("Offset from original text to cleaned text:  ");
			
			
			if ( displayByWords ) {
				
				displayByWord(original, solution, result);
				
				
			} else displayByChar(original, solution, result);

			add(result);

		});

		addComponent(label, original, cleaned, btn);
	}

	private void displayByChar(TextField original, int[] solution, Label result) {
		for (int i = 0; i < solution.length; i++) {

			if (solution[i] == 1) {

				result.add("<" + original.getValue().charAt(i) + ">");

			} else
				result.add(String.valueOf(original.getValue().charAt(i)));
		}
	}
	
	private void displayByWord (TextField original, int[] solution, Label result)   {
		
		String[] originalArray = splitBySpace(original);
		
		
		for (int i = 0; i< solution.length; i++) {
			
			if ( solution[i]==1 ) {
				result.add("<" + originalArray[i] + ">" );
			}
			else result.add(originalArray[i]);
			
		}
		
	}
	
	private String[] splitBySpace (TextField text) {
		
		String s = text.getValue().toString();
		
		String[] returnArr = s.split(" ");
		
		return returnArr;
		
	}
	
	

	private void addComponent(Label label, TextField original, TextField cleaned, Button btn) {
		add(label);
		add(original);
		add(cleaned);
		add(btn);
	}

}
