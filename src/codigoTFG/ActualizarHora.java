/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoTFG;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JLabel;

/**
 *
 * @author Hugo
 */
public class ActualizarHora {

    public static void actualizarHora(JLabel labelhora) {
        Locale spanish = new Locale("es", "ES");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendario = Calendar.getInstance();

        int horas = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);

        String horasString = (horas < 10) ? "0" + horas : String.valueOf(horas);
        String minutosString = (minutos < 10) ? "0" + minutos : String.valueOf(minutos);
        String segundosString = (segundos < 10) ? "0" + segundos : String.valueOf(segundos);

        labelhora.setText(sdf.format(new java.util.Date()) + "  " + horasString + ":" + minutosString + ":" + segundosString);
    }
}
