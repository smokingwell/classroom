/*
 * Created on 2006-2-8
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author ryan
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MotoQuestion {
/*用户输入任意长度的整数，请打印出他们的和*/
public static void main(String[] args){
	if(args.length!=2){
				System.out.println("请输入两个整数");
				System.exit(0);
			}
			for(int i=0;i<args.length;i++){
				if(!args[i].matches("[\\+|\\-]?[\\d]+")){
					System.out.println("请输入有效的整数");
					System.exit(0);
				}
			}
		
			String largeStr = null;
			String smallStr = null;
			int signLarge=1;
			int signSmall=1;
			
			if(args[0].charAt(0)=='-'){
				signLarge=-1;
				largeStr=args[0].substring(1);
			}else if(args[0].charAt(0)=='+'){
				largeStr=args[0].substring(1);
			}else
				largeStr=args[0];
			
			if(args[1].charAt(0)=='-'){
				signSmall=-1;
				smallStr=args[1].substring(1);
			}else if(args[1].charAt(0)=='+'){
				smallStr=args[1].substring(1);
			}else
				smallStr=args[1];
			
			boolean isNeedSwap=false;
			if(largeStr.length()<smallStr.length())
				isNeedSwap=true;
			else if(largeStr.length()==smallStr.length()){
				for(int i=0;i<largeStr.length();i++){
					if(largeStr.charAt(i)<smallStr.charAt(i)){					
						isNeedSwap=true;
						break;
					}
				}
			}
				
			if(isNeedSwap){
				int temp=signLarge;
				signLarge=signSmall;
				signSmall=temp;
				
				String temp2=largeStr;
				largeStr=smallStr;
				smallStr=temp2;			
			}
			
			boolean isAdditive=(signLarge*signSmall==1);
			
			MotoQuestion m=new MotoQuestion();
			String result=m.caculate(largeStr,smallStr,isAdditive);
			
			
			
			System.out.print("\n结果是：");
			if(signLarge==-1)System.out.print("-");
			System.out.print(result);
}
	/**
	 * 字符串的加减运算方法，字符串没有符号，加减法取决于第三个参数
	 * @param largeStr 较大的数，没有正负号
	 * @param smallStr 较小的数，没有正负号
	 * @param isAdditive 是否是加法
	 * @return
	 */
	public String caculate(String largeStr,String smallStr,boolean isAdditive){
					
		char []charArray=new char[largeStr.length()+1];
		int increment=0;
		int indexResult=largeStr.length();
		for(int i=smallStr.length()-1;i>=0;i--){
			int factor1=charToInt(smallStr.charAt(i));
			int factor2=charToInt(largeStr.charAt(i+largeStr.length()-smallStr.length()));
			int itemRet=(isAdditive)?(factor2+factor1):(factor2-factor1);		
			
			charArray[indexResult--]=intToChar((itemRet+increment)%10);			
			
			if(itemRet>=10)
				increment=1;
			else if(itemRet<=-1)
				increment=-1;
			else 
				increment=0;						
		}
		
		for(int i=largeStr.length()-smallStr.length()-1;i>=0;i--){		
			int itemRet=charToInt(largeStr.charAt(i))+increment;
			charArray[indexResult--]=intToChar(itemRet);
			
			if(itemRet>=10)
				increment=1;
			else if(itemRet<=-1)
				increment=-1;
			else 
				increment=0;		
		}
				
		charArray[indexResult]=intToChar(increment);
		
		String result=new String(charArray);
		while(result.length()>1){
			if(result.charAt(0)=='0')result=result.substring(1);
			else
			break;
		}
		
		return 	result;
	}
	
	private int charToInt(char c){
		return (c-'0')%10;
	}
	
	private char intToChar(int i){
		if(i<0)i=i+10;
		if(i>9)i=i-10;		
		return (char) (i+'0');
	}
		
}
