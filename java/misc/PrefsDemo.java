package j2se.util.pref;

import java.io.*;
import java.util.prefs.*;

public class PrefsDemo {
	public static void main(String args[]) {
		String keys[] = { "sunway", "copyright", "author" };
		String values[] = { "sunway technology company", "copyright 2002",
				"turbochen@163.com" };

		/* ����һ��λ��user root�µ�/com/sunway/spc�ڵ������ */
		Preferences prefsdemo = Preferences.userRoot().node("/com/sunway/spc");
		
		System.out.println(System.getProperty("java.util.prefs.PreferencesFactory"));
		/* ��������� */
		for (int i = 0; i < keys.length; i++) {
			prefsdemo.put(keys[i], values[i]);
		}

		/* ������XML�ļ� */
		try {
			FileOutputStream fos = new FileOutputStream("prefsdemo.xml");
			prefsdemo.exportNode(fos);
		} catch (Exception e) {
			System.err.println("Cannot export nodes: " + e);
		}

		/* ȥ��ע�Ϳ������ע����еĲ����� */
		/*
		 * try { prefsdemo.removeNode(); } catch (BackingStoreException e) { }
		 */
	}
}
