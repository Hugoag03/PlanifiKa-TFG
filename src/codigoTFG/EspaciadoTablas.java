package codigoTFG;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class EspaciadoTablas implements TableCellRenderer {
    private int padding;

    public EspaciadoTablas(int padding) {
        this.padding = padding;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Obtener el renderizador de celdas predeterminado para la celda actual
        TableCellRenderer defaultRenderer = table.getDefaultRenderer(table.getColumnClass(column));
        Component cellComponent = defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Ajustar el espaciado solo si la fila no está seleccionada
        if (!isSelected) {
            // Obtener las dimensiones del componente de la celda
            Dimension dim = cellComponent.getPreferredSize();
            dim.height += padding; // Aumentar la altura de la celda según el espacio deseado
            cellComponent.setPreferredSize(dim);
        }

        return cellComponent;
    }
}
