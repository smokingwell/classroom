package mytools.srtconvert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class Srt2Html {
	String sourcePath;
	//String enTitle;
	//String cnTitle;
	//SrtOption option;
	boolean isOutputNum=false;
	String destinationPath;
	String defaultDestinationPath;
	String movieName;

	public String getDefaultDestinationPath() {
		return defaultDestinationPath;
	}

	public void setDefaultDestinationPath(String defaultDestinationPath) {
		this.defaultDestinationPath = defaultDestinationPath;
	}

	public String getDestinationPath() {
		return destinationPath;
	}

	public void setDestinationPath(String destinationPath) {
		this.destinationPath = destinationPath;
	}

	public boolean isOutputNum() {
		return isOutputNum;
	}

	public void setOutputNum(boolean isOutputNum) {
		this.isOutputNum = isOutputNum;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getSourcePath() {
		return sourcePath;
	}

	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}

	/**
	 * 如果是两个参数，分别表示中文，英文字母文件	 * 允许使用通配符*，？
	 * 如果只有一个参数表示要转换的目录
	 * 如果没有参数表示转换当前目录
	 * @param args
	 */
	public static void main(String []args){
		Srt2Html handler=new Srt2Html();
		String path = null;
		String action = null;
		String usage="用法是：第一个参数为action,可以是HTML或者TEXT 默认是HTML,大小写不敏感，第二个参数是需要转换的路径，默认是当前路径。";
		if(args.length==0){
			path=".";
			action="HTML";
		}else if(args.length==1){
			action = handleActionArgs(args[0], action, usage);
			path=".";
		}else if(args.length==2){
			action = handleActionArgs(args[0], action, usage);
			path = handlePathArgs(args[1]);
		}
		handler.multiSrtProcess(path,action);
		
	}

	private static String handlePathArgs(String arg) {
		String path;
		if(!arg.endsWith("\\"))path=arg+"\\";
		else
			path=arg;
		return path;
	}

	private static String handleActionArgs(String arg, String action, String usage) {
		if(arg.equalsIgnoreCase("html")||arg.equalsIgnoreCase("text")){
			action=arg.toUpperCase();
		}else
			throw new IllegalArgumentException("参数不对！请参考:"+usage);
		return action;
	}
	
	public Map parseSrt(File srcFile) throws FileNotFoundException{
		if(sourcePath==null){
			sourcePath=srcFile.getPath();
			defaultDestinationPath=sourcePath.substring(0,sourcePath.length()-srcFile.getName().length());
		}
		//int cutPoint=srcFil
		if(movieName==null||(!srcFile.getName().startsWith(movieName))){
			movieName=srcFile.getName();
			movieName=movieName.substring(0,movieName.length()-4);
			if(movieName.endsWith(".chs")){
				movieName=movieName.substring(0,movieName.length()-4);
			}else if(movieName.endsWith(".en")){
				movieName=movieName.substring(0,movieName.length()-3);
			}
			
		}
		BufferedReader sourceFileReader=new BufferedReader(new FileReader(srcFile));
		Map result=new LinkedHashMap();
		try{
			StringBuffer strContent=new StringBuffer();
			String timeline=null;
			while(true){
				String curLine=sourceFileReader.readLine();
				if(curLine==null)break;				
				if(curLine.matches("^\\d+$"))continue;
				if(!curLine.matches("\\d\\d:\\d\\d.*->.*")){
					strContent.append(curLine);
				}else{
					if(timeline!=null){
						result.put(timeline,strContent.toString());						
					}										
					timeline=curLine.trim();
					strContent=new StringBuffer();
				}
			}
		}catch(IOException e){
			//read file end,it's normal
			
		}
		return result;
	}
	
	public void createHtml(String cnSrtFileName,String enSrtFileName){
		if(cnSrtFileName==null&&enSrtFileName==null)throw new RuntimeException("英文字幕，中文字幕至少要一种");
		Map cnSrtList=null;
		Map enSrtList=null;
		try {
			if(cnSrtFileName!=null)
				cnSrtList = this.parseSrt(new File(cnSrtFileName));
			
			if(enSrtFileName!=null)
				enSrtList = this.parseSrt(new File(enSrtFileName));
		} catch (FileNotFoundException e1) {			
			e1.printStackTrace();
			System.out.println("由于无法打开文件，转换失败！请检查文件是否存在。");
			return ;
		}
		String fileName=null;
		fileName = getOutputFileName();
		fileName+=".htm";
		BufferedWriter fileWriter;
		try {
			fileWriter = new BufferedWriter(new FileWriter(fileName));
			fileWriter.write(makeHtmlHead());
			fileWriter.write(makeHtmlBody(cnSrtList,enSrtList));
			fileWriter.write("</body></html>");
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private String getOutputFileName() {
		String fileName;
		if(destinationPath==null)fileName=defaultDestinationPath;
		else
			fileName=destinationPath;
		return fileName+movieName;
	}

	private String makeHtmlHead() {
		// TODO Auto-generated method stub
		StringBuffer result = new StringBuffer();
		result.append("<html><head>\n");
		result.append("<script language=\"javascript\">\n");
		result.append("var isShowAll=false;\n");
		result.append("var fontSize=8;\n");
		result.append("function increaseFontSize(){\n");
		result.append("	var objArrays=document.getElementsByTagName(\"div\");\n");
		result.append("	if(fontSize<28)fontSize++;\n");
		result.append("	else fontSize=8;\n");
		result.append("	for(var i=0,j=objArrays.length;i<j;i++){\n");
		result.append("		objArrays[i].style.fontSize=fontSize+\"pt\";\n");
		result.append("	}\n");
		result.append("}\n");
		
		result.append("function addFontSize(){}");
		result.append("function switchVisiablity(visibility){\n");
		result.append("	var objArrays=document.getElementsByTagName(\"span\");\n");
		result.append("	for(var i=0,j=objArrays.length;i<j;i++){\n");
		result.append("if(!(visibility=='all')){");	
		result.append("objArrays[i].style.display=visibility;objArrays[i].style.backgroundColor='white';isShowAll=false;\n");
		result.append("}else{objArrays[i].style.display='';objArrays[i].style.backgroundColor='silver';isShowAll=true;}");
		result.append("	}\n");
		result.append("}\n");
		result.append("function showCurrentEnglish(id,flag){\n");
		result.append("if(isShowAll)return ;\n");
		result.append("	var objArray=document.getElementById(id+\"_en\");\n");
		result.append("	if(flag==true){\n");
		result.append("		objArray.style.backgroundColor=\"silver\";\n");
		result.append("		objArray.style.color=\"white\";\n");
		result.append("	}else{\n");
		result.append("		objArray.style.backgroundColor=\"white\";\n");
		result.append("		objArray.style.color=\"white\";\n");
		result.append("	}\n");
		result.append("}\n");
		
		result.append("</script>");
		result.append("</head><body>\n");
		result.append("<h1>" + movieName + "字幕中英文对照</h1><p>");
		result.append("<input type=button onclick=\"switchVisiablity('none');\" value=禁止字母显示 />&nbsp;&nbsp;");
		result.append("<input type=button onclick=\"switchVisiablity('');\" value=允许字母显示 />&nbsp;&nbsp;");	
		result.append("<input type=button onclick=\"switchVisiablity('all');\" value=所有字母显示 />&nbsp;&nbsp;");	
		result.append("<input type=button onclick=\"increaseFontSize();\" value=加大字体 /><p>\n");	
		return result.toString();
	}

	private String makeHtmlBody(Map cnSrtMap,Map enSrtMap) {
		// TODO Auto-generated method stub
		StringBuffer result=new StringBuffer();
		if(cnSrtMap==null){
			if(enSrtMap!=null)
				cnSrtMap=enSrtMap;
				enSrtMap=new HashMap();
		}else{
			if(enSrtMap==null){
				enSrtMap=new HashMap();
			}
		}
			
		int length=cnSrtMap.size();
		if(length>enSrtMap.size()){
			length=enSrtMap.size();
			System.out.println("Warning:中文字母比英文字母长!");
		}else if(length<enSrtMap.size())
			System.out.println("Warning:中文字母比英文字母短!");
		Set keySet=cnSrtMap.keySet();
		Iterator iter=keySet.iterator();
		int i=0;
		while (iter.hasNext()) {
			i++;
			String timeLine = (String) iter.next();			
			
			result.append("&nbsp;&nbsp;&nbsp;<div id=\""+i+"\" style=\"font:9pt\""  +
					"onmouseover=\"showCurrentEnglish(this.id,true);this.style.cursor='hand';\" " +
					"onmouseout=\"showCurrentEnglish(this.id,false);this.style.cursor='';\" >");
			result.append(cnSrtMap.get(timeLine).toString()+"\n");		
			result.append("</div>");
			result.append("<span id=\""+i+"_en\" style=\"width:80%;color:white;font:16pt;'MS Sans Serif';\" ><strong>");
			if(enSrtMap.containsKey(timeLine))
				result.append(enSrtMap.get(timeLine).toString()+"\n");
			result.append("</strong></span>");
			result.append("<p>");
		}	
		return result.toString();
	}

	public void createText(String srtFileName) {
		if(srtFileName==null)return ;
		Map srtMap=null;
		try {
			srtMap = this.parseSrt(new File(srtFileName));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("转换失败！");
			return ;
		}
		String fileName=srtFileName.substring(0,srtFileName.length()-4);
		fileName+=".txt";
		BufferedWriter fileWriter = null;
		try {
			fileWriter = new BufferedWriter(new FileWriter(fileName));
			//fileWriter.write(makeHtmlHead());
			fileWriter.write(makeText(srtMap));
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(fileWriter!=null)
					fileWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	
	private String makeText(Map srtMap) {
		StringBuffer result=new StringBuffer();
		Set keySet=srtMap.keySet();
		Iterator iter=keySet.iterator();
		int i=0;;
		while (iter.hasNext()) {
			
			String element = (String) iter.next();
			result.append(srtMap.get(element)+"\n");
		}
		return result.toString();
	}
	
	/**
	 * 批处理
	 * @param testPath 批处理目录
	 */
	public void multiSrtProcess(String testPath,String action) {
		Map movieMap=getMovieMap(testPath);
		Set keySet=movieMap.keySet();
		Iterator iter=keySet.iterator();
		while (iter.hasNext()) {
			String element = (String) iter.next();
			CN_EN_SRT srt=(CN_EN_SRT)movieMap.get(element);
			if(action.equalsIgnoreCase("HTML")){
				this.createHtml(srt.cn_srt_filename,srt.en_srt_filename);
				
			}else if(action.equalsIgnoreCase("TEXT")){
				this.createText(srt.cn_srt_filename);
				this.createText(srt.en_srt_filename);
			}
				
		}
	}

	private Map getMovieMap(String testPath) {
		File theDirectory=new File(testPath);
		if(!theDirectory.isDirectory()){
			System.out.println("multi process only input directory!");
			return new HashMap();
		}
		String filePath=theDirectory.getAbsolutePath();
		if(!filePath.endsWith("\\"))filePath+="\\";
		String[] srtFileNameList=theDirectory.list(new FilenameFilter(){

			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				if(name.endsWith(".srt"))return true;
				else
				return false;
			}
			
		});
		Map movieNameMap=new HashMap();
		for(int i=0,j=srtFileNameList.length;i<j;i++){
			String item=srtFileNameList[i];
			String movieName=item.substring(0,item.length()-4);
			CN_EN_SRT srt=new CN_EN_SRT();
			if(movieName.endsWith(".chs")){
				movieName=movieName.substring(0,movieName.length()-4);
				srt.putCn(filePath+item);
			}else if(movieName.endsWith(".en")){
				movieName=movieName.substring(0,movieName.length()-3);
				srt.putEn(filePath+item);
			}
			if(movieNameMap.containsKey(movieName)){
				movieNameMap.put(movieName,((CN_EN_SRT)movieNameMap.get(movieName)).add(srt));
			}else{
				movieNameMap.put(movieName,srt);
			}
		}
		return movieNameMap;
	}
	public class CN_EN_SRT {
		String en_srt_filename;
		String cn_srt_filename;
		int size=0;
		public int putCn(String srt){
			cn_srt_filename=srt;
			return ++size;
		}
		public CN_EN_SRT add(CN_EN_SRT srt) {
			// TODO Auto-generated method stub
			if(srt==null)return this;
			if(srt.cn_srt_filename!=null&&this.cn_srt_filename==null){
				this.cn_srt_filename=srt.cn_srt_filename;
				size++;
			}
			if(srt.en_srt_filename!=null&&this.en_srt_filename==null){
				this.en_srt_filename=srt.en_srt_filename;
				size++;
			}
			return this;
		}
		public int putEn(String srt){
			en_srt_filename=srt;
			return ++size;
		}
		public int size(){
			return size();
		}
		
	}
}
