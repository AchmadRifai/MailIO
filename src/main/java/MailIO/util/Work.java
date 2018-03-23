package MailIO.util;

import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Work {
	public static java.io.File f=new java.io.File(System.getProperty("user.home")+"/.MailIO/conf.xml");
	private static JAXBContext context=null;

	static {
		try {
			context = JAXBContext.newInstance(Conf.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void save(Conf c) throws JAXBException {
		Marshaller marshaller = context.createMarshaller();
		if(!f.getParentFile().exists())f.getParentFile().mkdirs();
		if(f.exists())f.delete();
		marshaller.marshal(c, f);
	}

	public static Conf loadConf() throws JAXBException {
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Conf c=(Conf)unmarshaller.unmarshal(f);
		return c;
	}

    public static void styler() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String os=System.getProperty("os.name");
        if(os.contains("Windows"))style("Windows");
        else if(os.contains("Linux"))style("GTK+");
        else style("Nimbus");
    }

    private static void style(String s) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        for(javax.swing.UIManager.LookAndFeelInfo i:javax.swing.UIManager.getInstalledLookAndFeels())if(s == null ? i.getName() == null : s.equals(i.getName())){
            javax.swing.UIManager.setLookAndFeel(i.getClassName());
            break;
        }
    }
}