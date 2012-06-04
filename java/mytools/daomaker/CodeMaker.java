/*
 * AutoCreator.java
 *
 * 机能：J2EE数据表文件综合处理程序主要逻辑控模模块.
 * 类名：AutoCreator
 *
 *   ver    变更日        公司     担当者    变更内容
 * ──────────────────────────────────
 *  V1.00  '04-04-21  　 (SURE)    成晓勇    初版
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
 * 根据用户定义的DDL文或者Database中的数据表结构来自动生成VO, DAO的java类。<BR>
 *
 * @author  成晓勇
 * @version Ver1.0 2004-04-21 初版作成
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
	  /*从文件加载参数*/
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
						System.out.println("加载代码生成器"+element+"时候，出现异常，但是任务仍将继续，请检查代码生成器的类是否正确！");
						e.printStackTrace();
						logger.error("加载代码生成器"+element+"时候，出现异常，但是任务仍将继续，请检查代码生成器的类是否正确！异常为:\n"+e.getMessage());
					}
					
				}				
			}
		}

/**
   * @param taskList 要生成的ddl目标文件绝对路径列表。
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
						
					System.out.println(this.output_path+"成功中创建一个文件！");

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

  /*处理目录时并不递归查询*/
  public static void main(String[] args) {
		CodeMaker creator = new CodeMaker();
		
		StringBuffer usage = new StringBuffer();
		usage.append("命令行形式为：\n");
		usage.append("java -jar daomaker.jar [ddlpath] [daopath] [vopath]\n");
		usage.append("ddlpath-数据库文件的路径，也可以是单个文件,默认是当前目录\n");
		usage.append("daopath-dao文件输出目录，只能是有效目录，默认是当前目录\n");
		usage.append("vopath-vo输出目录，只能是有效目录，默认是当前目录\n");
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
			throw new IllegalArgumentException("参数不正确，请参考:" + usage);
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
