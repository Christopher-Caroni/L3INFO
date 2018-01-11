package fil.coo.gui.impl.answers;

import fil.coo.gui.impl.AnswerPanel;

import javax.swing.*;
import java.awt.*;

public class NumericalAnswerPanel extends AnswerPanel {

	private JSpinner spinner;
	
    public NumericalAnswerPanel() {
        super();

        initCustomView();
    }

    @Override
    public String getUserInput() {
        return String.valueOf(spinner.getValue());
    }

    @Override
    public void setUserInput(String input) {
        spinner.setValue(Integer.parseInt(input));
    }

    @Override
    protected void initCustomView() {

        spinner = new JSpinner();
        spinner.setPreferredSize(new Dimension(100, 40));

        rootPanel.add(spinner);

    }

}
