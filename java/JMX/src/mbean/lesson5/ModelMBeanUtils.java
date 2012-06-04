package mbean.lesson5;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.modelmbean.ModelMBeanAttributeInfo;
import javax.management.modelmbean.ModelMBeanInfo;
import javax.management.modelmbean.ModelMBeanInfoSupport;
import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.management.modelmbean.RequiredModelMBean;

public class ModelMBeanUtils {
    private static final boolean READABLE = true;
    private static final boolean WRITABLE = true;
    private static final boolean BOOLEAN = true;
    private static final String STRING_CLASS = "java.lang.String";

    public static RequiredModelMBean createModelerMBean() {
        RequiredModelMBean model = null;
        try {
            model = new RequiredModelMBean();
            model.setManagedResource(new Hello(), "ObjectReference");
            ModelMBeanInfo info = createModelMBeanInfo();
            model.setModelMBeanInfo(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    private static ModelMBeanInfo createModelMBeanInfo() {
        //////////////////////////////////////////////////////////////////
        //                        ����                                        //
        //////////////////////////////////////////////////////////////////
        // ����name������Ϣ
        ModelMBeanAttributeInfo nameAttrInfo = new ModelMBeanAttributeInfo(//
                "Name", // ������        
                STRING_CLASS, //��������     
                "people name", // ��������       
                READABLE, WRITABLE, !BOOLEAN, // ��д       
                null // ����������
        );

        //////////////////////////////////////////////////////////////////
        //                        ����                                        //
        //////////////////////////////////////////////////////////////////
        //���� printHello()��������Ϣ        
        ModelMBeanOperationInfo print1Info = new ModelMBeanOperationInfo(//
                "printHello", //
                null, //   
                null, //
                "void", //   
                MBeanOperationInfo.INFO, //     
                null //
        );

        // ����printHello(String whoName)������Ϣ      
        ModelMBeanOperationInfo print2Info;
        MBeanParameterInfo[] param2 = new MBeanParameterInfo[1];
        param2[0] = new MBeanParameterInfo("whoName", STRING_CLASS, "say hello to who");
        print2Info = new ModelMBeanOperationInfo(//
                "printHello", //
                null,//
                param2,//
                "void", //
                MBeanOperationInfo.INFO, //
                null//
        );

        //////////////////////////////////////////////////////////////////
        //                        ����ܺ�                                    //
        //////////////////////////////////////////////////////////////////
        // create ModelMBeanInfo        
        ModelMBeanInfo mbeanInfo = new ModelMBeanInfoSupport(//
                RequiredModelMBean.class.getName(), // MBean��
                null, // ��������      
                new ModelMBeanAttributeInfo[] { // ���е�������Ϣ�����飩 
                nameAttrInfo },//ֻ��һ������ 
                null, // ���еĹ��캯����Ϣ   
                new ModelMBeanOperationInfo[] { // ���еĲ�����Ϣ�����飩
                        print1Info,
                        print2Info },//
                null, // ���е�֪ͨ��Ϣ(������)
                null//MBean������
        );
        return mbeanInfo;
    }
}


