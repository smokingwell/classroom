/*
 * AutoCreator.java
 *
 * ���ܣ�J2EE���ݱ��ļ��ۺϴ��������Ҫ�߼���ģģ��.
 * ������AutoCreator
 *
 *   ver    �����        ��˾     ������    �������
 * ��������������������������������������������������������������������
 *  V1.00  '04-04-21  �� (SURE)    ������    ����
 *
 * Copyright (c) 2004 Surekam corporation All Rights Reserved.
 */

package mytools.daomaker;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import mytools.util.FileTools;
import mytools.util.StringTools;

import org.apache.log4j.Logger;

/**
 * �����û������DDL�Ļ���Database�е����ݱ�ṹ���Զ�����VO, DAO��java�ࡣ<BR>
 *
 * @author  ������
 * @version Ver1.0 2004-04-21 ��������
 */

public class CodeMaker {
	  protected static Logger logger = Logger.getLogger(CodeMaker.class.getName());
  Map controlMap;
  String output_path;
  
  static OPTION option=new OPTION();
  private static class OPTION{
	  String default_output_path ;
	  String default_input_path ;
	  List lstProduct=new ArrayList();
	  String translatorFile;	  
  }  
  private final String OPTION_FILEPATH="/mytools/daomaker/option.properties";
  private CodeMaker() {
	  /*���ļ����ز���*/
			Properties properties = FileTools.loadPropertiesFileByClassPath(this.getClass(),OPTION_FILEPATH);
			
			option.default_input_path=properties.getProperty("default_input_path");
			option.default_output_path=properties.getProperty("default_output_path");
			option.translatorFile=properties.getProperty("translatorFile");
			
			String strProductList=properties.getProperty("product_list");
			String []temp=strProductList.split(",");
			for(int i=0,j=temp.length;i<j;i++)
				option.lstProduct.add(temp[i]);			
			
			if(controlMap==null){
				controlMap=new HashMap();				
				Iterator iter=option.lstProduct.iterator();
				while (iter.hasNext()) {
					String element = (String) iter.next();
					try {
					if(properties.getProperty(element)!=null)
						controlMap.put(element,Class.forName(properties.getProperty(element)));
					/*else
						controlMap.put(element,Class.forName("mytools.daomaker.MysqlDAOCodeWorker"));*/
					}catch (ClassNotFoundException e) {
						System.out.println("���ش���������"+element+"ʱ�򣬳����쳣�����������Խ�������������������������Ƿ���ȷ��");
						e.printStackTrace();
						logger.error("���ش���������"+element+"ʱ�򣬳����쳣�����������Խ�������������������������Ƿ���ȷ���쳣Ϊ:\n"+e.getMessage());
					}
					
				}				
			}
		}

/**
   * @param taskList Ҫ���ɵ�ddlĿ���ļ�����·���б�
   */
  private void process(List taskList) {
		Iterator iter = option.lstProduct.iterator();
		try {
			while (iter.hasNext()) {
				String product = (String) iter.next();
				IWorker worker;
				worker = (IWorker) ((Class) controlMap.get(product))
						.newInstance();
				Translator translator=null;
				if(option.translatorFile!=null)translator=new PropertyFileC2ETranslator(option.translatorFile);
				Iterator iterT = taskList.iterator();
				while (iterT.hasNext()) {
					String ddl_filepath = (String) iterT.next();
					if(translator==null)
						worker.create(ddl_filepath, this.output_path);
					else
						worker.create(ddl_filepath, this.output_path,translator);
						
					System.out.println(this.output_path+"�ɹ��д���һ���ļ���");

				}
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

  /*����Ŀ¼ʱ�����ݹ��ѯ*/
  public static void main(String[] args) {
		CodeMaker creator = new CodeMaker();
		
		StringBuffer usage = new StringBuffer();
		usage.append("��������ʽΪ��\n");
		usage.append("java -jar daomaker.jar [ddlpath] [daopath] [vopath]\n");
		usage.append("ddlpath-���ݿ��ļ���·����Ҳ�����ǵ����ļ�,Ĭ���ǵ�ǰĿ¼\n");
		usage.append("daopath-dao�ļ����Ŀ¼��ֻ������ЧĿ¼��Ĭ���ǵ�ǰĿ¼\n");
		usage.append("vopath-vo���Ŀ¼��ֻ������ЧĿ¼��Ĭ���ǵ�ǰĿ¼\n");
		if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
			System.out.println(usage);
			return;
		}
		String ddlpath = null;
		if (args.length == 0)
			ddlpath = creator.getDefaultInputPath();
		else
			ddlpath = args[0];
		switch (args.length) {
		case 3:
			creator.setOutputPath(args[2]);
			ddlpath = args[0];
			break;
		case 2:
			creator.setOutputPath(args[1]);
			break;
		case 1:			
		case 0:
			creator.setOutputPath(creator.getDefaultOutputPath());
			break;
		default:
			throw new IllegalArgumentException("��������ȷ����ο�:" + usage);
		}

		File file = new File(ddlpath);
		File[] filelist;
		List filenamelist = new ArrayList();
		if (file.isDirectory()) {
			filelist = file.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					if (name.endsWith(".sql") || name.endsWith(".txt"))
						return true;
					return false;
				}

			});

			for (int i = 0, j = filelist.length; i < j; i++) {
				filenamelist.add(filelist[i].getAbsolutePath());
			}

		} else {
			filenamelist.add(file.getAbsolutePath());
		}
		
		try {
			creator.process(filenamelist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

private void setOutputPath(String outputpath) {
	
	this.output_path=StringTools.getSafeWindowsDirecotyPath(outputpath);
}
private String getDefaultOutputPath(){
	return option.default_output_path;
}
private String getDefaultInputPath(){
	return option.default_input_path;
}
}
