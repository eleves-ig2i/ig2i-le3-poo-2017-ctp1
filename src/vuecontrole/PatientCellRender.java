package vuecontrole;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import modele.Patient;

/**
 * Project derbyassurance.
 */
public class PatientCellRender extends JLabel implements javax.swing.ListCellRenderer<Patient> {


	public PatientCellRender() {
		setOpaque(true);
	}

	/**
	 * Return a component that has been configured to display the specified
	 * value. That component's <code>paint</code> method is then called to
	 * "render" the cell.  If it is necessary to compute the dimensions
	 * of a list because the list cells do not have a fixed size, this method
	 * is called to generate a component on which <code>getPreferredSize</code>
	 * can be invoked.
	 *
	 * @param list		 The JList we're painting.
	 * @param value		The value returned by list.getModel().getElementAt(index).
	 * @param index		The cells index.
	 * @param isSelected   True if the specified cell was selected.
	 * @param cellHasFocus True if the specified cell has the focus.
	 * @return A component whose paint() method will render the specified value.
	 * @see JList
	 * @see ListSelectionModel
	 * @see ListModel
	 */
	@Override
	public Component getListCellRendererComponent(
			JList<? extends Patient> list,
			Patient value,
			int index,
			boolean isSelected,
			boolean cellHasFocus
	) {
		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		setText(value.getNom() + " " + value.getPrenom());
		return this;
	}
}
