package interfacesgui;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
/**
 * Classe de estilização do JTable das interfaces graficas
 * @see javax.swing.table.TableCellRenderer
 */
public class CellRenderer implements TableCellRenderer {
	/**
	 * O metodo {@code getTableCellRendererComponent} renderiza um icone dentro da JTable.
	 * @param table espera varios parametros de varios tipos
	 * @return ver. Retorna o icone que será exibido.
	 */
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column) {
		
		Icon vsl = new ImageIcon("src\\icones\\vsl.png");
		JLabel ver = new JLabel(vsl);
		return ver;
	}
	
}
