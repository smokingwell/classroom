/*
 * Created on 2005-10-9
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package j2se.util;

import junit.framework.TestCase;

/**
 *<p> Title:</p>
 *<p>Description: </p>
 *<p>Copyright: Copyright (c) 2004</p>
 *<p>Company: ÓÃÓÑÕþÎñ</p>
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

import junit.framework.*;

//import javax.servlet.ServletContext;
import java.util.Properties;

public class JPropertiesTest extends TestCase {
    JProperties jProperties;
    String key = "helloworld.title";
    String value = "Hello World!";

    public void testLoadProperties() throws Exception {
        String name = null;
        Properties p = new Properties();

        name = "C:\\IDEAP\\Properties4Methods\\src\\com\\kindani\\test\\LocalStrings.properties";
        p = JProperties.loadProperties(name, JProperties.BY_PROPERTIES);
        assertEquals(value, p.getProperty(key));

        name = "com.kindani.test.LocalStrings";
        p = JProperties.loadProperties(name,JProperties.BY_RESOURCEBUNDLE);
        assertEquals(value, p.getProperty(key));
        assertEquals(value,((JProperties.ResourceBundleAdapter)p).getString(key));

        name = "C:\\IDEAP\\Properties4Methods\\src\\com\\kindani\\test\\LocalStrings.properties";
        p = JProperties.loadProperties(name, JProperties.BY_PROPERTYRESOURCEBUNDLE);
        assertEquals(value, p.getProperty(key));
        assertEquals(value,((JProperties.ResourceBundleAdapter)p).getString(key));

        name = "\\com\\kindani\\test\\LocalStrings.properties";
        p = JProperties.loadProperties(name, JProperties.BY_SYSTEM_CLASSLOADER);
        assertEquals(value, p.getProperty(key));

        name = "\\com\\kindani\\test\\LocalStrings.properties";
        p = JProperties.loadProperties(name, JProperties.BY_CLASSLOADER);
        assertEquals(value, p.getProperty(key));

        name = "test\\LocalStrings.properties";
        p = JProperties.loadProperties(name, JProperties.BY_CLASS);
        assertEquals(value, p.getProperty(key));
    }

/*
    public void testLoadProperties2() throws Exception {
        ServletContext context = null;
        String path = null;
        Properties p = null;
        path = "/WEB-INF/classes/LocalStrings.properties";
        p = JProperties.loadProperties(context, path);
        assertEquals(value, p.getProperty(key));
    }
*/
}
