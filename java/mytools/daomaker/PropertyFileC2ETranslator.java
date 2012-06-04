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
		  logger.warn("���ҷ����ʱ���޷��ҵ�"+name+"��,�������Խ�������ʹ��δ���������");
		  return name;
	  }else{
		  
		  return mappings.getProperty(StringTools.convGB2312(name));
	  }
	}
}
