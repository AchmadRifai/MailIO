package MailIO;

import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.bind.JAXBException;

public class Main {
	public static void main(String[] args) {
            try {
                MailIO.util.Work.styler();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                MailIO.util.Db.hindar(ex);
            }
		java.awt.EventQueue.invokeLater(() -> {
                if(MailIO.util.Work.f.exists()){
                    try {
                        MailIO.util.Conf c=MailIO.util.Work.loadConf();
                        new MailIO.ui.Dash(c).setVisible(true);
                    } catch (JAXBException ex) {
                        MailIO.util.Db.hindar(ex);
                    }
                }else new MailIO.ui.Conect().setVisible(true);
            });
	}
}
