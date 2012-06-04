package junit.beanutil;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BasicDynaBean;
import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;


public class DynaBeanTry {

	 private DynaClass dynaClass;
	    private DynaBean dynaBean;
	    /**
	     * create basicDynaClass
	     */
	    public void createBasicDynaClass() {
	        dynaClass = null;
	        //create basic field for dynaClass
	        DynaProperty[] dynaProps = new DynaProperty[4];
	        dynaProps[0] = new DynaProperty("any");
	        dynaProps[1] = new DynaProperty("nameStr", String.class);
	        //create array field for dynaClass
	        String[] nameArray = new String[4];
	        dynaProps[2] = new DynaProperty("nameArray", nameArray.getClass());
	        //create map filed for dynaClass
	        Map nameAliasMap = new HashMap();
	        dynaProps[3] = new DynaProperty("nameAliasMap",nameAliasMap.getClass());
	        dynaClass = new BasicDynaClass("first", BasicDynaBean.class, dynaProps);
	    }

	    public void createBasicDynaBean() {
	        dynaBean = null;
	        this.createBasicDynaClass();
	        try {
	            dynaBean = dynaClass.newInstance();
	            dynaBean.set("any", "bull shit");
	            dynaBean.set("nameStr", "bull");
	            //dynaBean.set("nameStr",new Integer(9));
	            dynaBean.set("nameArray", new String[4]);
	            dynaBean.set("nameArray", 0, "b");
	            dynaBean.set("nameArray", 1, "u");
	            dynaBean.set("nameArray", 2, "l");
	            dynaBean.set("nameArray", 3, "l");
	            dynaBean.set("nameAliasMap", new HashMap());
	            dynaBean.set("nameAliasMap", "1st", "b");
	            dynaBean.set("nameAliasMap", "2nd", "u");
	            dynaBean.set("nameAliasMap", "3rd", "l");
	            dynaBean.set("nameAliasMap", "4th", "l");
	        } catch (IllegalAccessException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (InstantiationException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        this.descDynaBean(dynaBean);
	    }

		private void descDynaBean(DynaBean dynaBean) {
			// TODO Auto-generated method stub
			//System.out.println(dynaBean);
			System.out.println(dynaBean.get("nameStr"));
			System.out.println(dynaBean.get("nameAliasMap"));
			
		}
		public static void main(String []args){
			
			(new DynaBeanTry()).createBasicDynaBean();
		}
	}

