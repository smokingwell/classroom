package mytools.daomaker;

import java.util.Properties;

import mytools.util.FileTools;
import mytools.util.StringTools;

import org.apache.log4j.Logger;

public class PropertyFileC2ETranslator implements Translator {
	 Logger logger=Logger.getLogger(PropertyFileC2ETranslator.class);	
	public PropertyFileC2ETranslator(String mappingFile){
		mappings=FileTools.loadPropertiesFileByPhysicalPath(mappingFile);
	}
	private static Properties mappings=null;
	public String translate(String name) {
		  if(!mappings.containsKey(StringTools.convGB2312(name))){
		  logger.warn("查找翻译的时候，无法找到"+name+"项,但操作仍将继续。使用未翻译的名称");
		  return name;
	  }else{
		  
		  return mappings.getProperty(StringTools.convGB2312(name));
	  }
	}
}
