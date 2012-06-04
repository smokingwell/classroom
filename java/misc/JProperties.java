/*
 * Created on 2005-10-9
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package j2se.util;

/**
 *<p> Title:</p>
 *<p>Description: </p>
 *<p>Copyright: Copyright (c) 2004</p>
 *<p>Company: 用友政务</p>
 * @author ryan
 * @time 2005-10-9
 * 
 */
/**
** This program is free software.
** 
** You may redistribute it and/or modify it under the terms of the GNU
** General Public License as published by the Free Software Foundation.
** Version 2 of the license should be included with this distribution in
** the file LICENSE, as well as License.html. If the license is not
** included with this distribution, you may find a copy at the FSF web
** site at 'www.gnu.org' or 'www.fsf.org', or you may write to the
** Free Software Foundation, 675 Mass Ave, Cambridge, MA 02139 USA.
**
** THIS SOFTWARE IS PROVIDED AS-IS WITHOUT WARRANTY OF ANY KIND,
** NOT EVEN THE IMPLIED WARRANTY OF MERCHANTABILITY. THE AUTHOR
** OF THIS SOFTWARE, ASSUMES _NO_ RESPONSIBILITY FOR ANY
** CONSEQUENCE RESULTING FROM THE USE, MODIFICATION, OR
** REDISTRIBUTION OF THIS SOFTWARE. 
**/

//import javax.servlet.ServletContext;
import java.util.*;
import java.io.InputStream;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * 使用J2SE API?取Properties文件的六?方法
 * User: SYNFORM
 * Date: 2005/07/12
 * Time: 18:40:55
 * To change this template use File | Settings | File Templates.
 */
public class JProperties {

    public final static int BY_PROPERTIES = 1;
    public final static int BY_RESOURCEBUNDLE = 2;
    public final static int BY_PROPERTYRESOURCEBUNDLE = 3;
    public final static int BY_CLASS = 4;
    public final static int BY_CLASSLOADER = 5;
    public final static int BY_SYSTEM_CLASSLOADER = 6;

    public final static Properties loadProperties(final String name, final int type) throws IOException {
        Properties p = new Properties();
        InputStream in = null;
        if (type == BY_PROPERTIES) {
            in = new BufferedInputStream(new FileInputStream(name));
            //assert (in != null);
            p.load(in);
        } else if (type == BY_RESOURCEBUNDLE) {
            ResourceBundle rb = ResourceBundle.getBundle(name, Locale.getDefault());
            //assert (rb != null);
            //rb.get
            p = new ResourceBundleAdapter(rb);
        } else if (type == BY_PROPERTYRESOURCEBUNDLE) {
            in = new BufferedInputStream(new FileInputStream(name));
            //assert (in != null);
            ResourceBundle rb = new PropertyResourceBundle(in);
            p = new ResourceBundleAdapter(rb);
        } else if (type == BY_CLASS) {
            //assert (JProperties.class.equals(new JProperties().getClass()));
            in = JProperties.class.getResourceAsStream(name);
            //assert (in != null);
            p.load(in);
            //        return new JProperties().getClass().getResourceAsStream(name);
        } else if (type == BY_CLASSLOADER) {
            //assert (JProperties.class.getClassLoader().equals(new JProperties().getClass().getClassLoader()));
            in = JProperties.class.getClassLoader().getResourceAsStream(name);
            //assert (in != null);
            p.load(in);
            //         return new JProperties().getClass().getClassLoader().getResourceAsStream(name);
        } else if (type == BY_SYSTEM_CLASSLOADER) {
            in = ClassLoader.getSystemResourceAsStream(name);
            //assert (in != null);
            p.load(in);
        }

        if (in != null) {
            in.close();
        }
        return p;

    }

    // ---------------------------------------------- servlet used
/*
    public static Properties loadProperties(ServletContext context, String path) throws IOException {
        //assert (context != null);
        InputStream in = context.getResourceAsStream(path);
        //assert (in != null);
        Properties p = new Properties();
        p.load(in);
        in.close();
        return p;
    }
*/

    // ---------------------------------------------- support class

    /**
     * ResourceBundle Adapter class.
     */
    public static class ResourceBundleAdapter extends Properties {
        public ResourceBundleAdapter(ResourceBundle rb) {
            //assert (rb instanceof java.util.PropertyResourceBundle);
            this.rb = rb;
            java.util.Enumeration e = rb.getKeys();
            while (e.hasMoreElements()) {
                Object o = e.nextElement();
                this.put(o, rb.getObject((String) o));
            }
        }

        private ResourceBundle rb = null;

        public ResourceBundle getBundle(String baseName) {
            return ResourceBundle.getBundle(baseName);
        }

        public ResourceBundle getBundle(String baseName, Locale locale) {
            return ResourceBundle.getBundle(baseName, locale);
        }

        public ResourceBundle getBundle(String baseName, Locale locale, ClassLoader loader) {
            return ResourceBundle.getBundle(baseName, locale, loader);
        }

       /* public Enumeration<String> getKeys() {
            return rb.getKeys();
        }*/

        public Locale getLocale() {
            return rb.getLocale();
        }

        public Object getObject(String key) {
            return rb.getObject(key);
        }

        public String getString(String key) {
            return rb.getString(key);
        }

        public String[] getStringArray(String key) {
            return rb.getStringArray(key);
        }

        protected Object handleGetObject(String key) {
            return ((PropertyResourceBundle) rb).handleGetObject(key);
        }

    }

}


