package junit.mock;
import org.apache.commons.beanutils.DynaBean;
import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;
//import org.apache.
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class DynaPropertiesTag extends TagSupport {
	private String varName;
	private String item;
	public void setVar(String varName)
	{
	this.varName = varName;
	}
	public String getVar()
	{
	return this.varName;
	}
	public void setItem(String item)
	{
	this.item = item;
	}
	public String getItem()
	{
	return this.item;
	}
	public int doStartTag() throws JspException
	{
//	 Evaluate the item attribute (an EL expression) which
//	 must result in a DynaBean object.
	DynaBean bean =
	(DynaBean) ExpressionEvaluatorManager.evaluate(
	"item", getItem(), DynaBean.class, this,
	this.pageContext);
//	 Get the DynaBean meta-properties and store them in the
//	 variable pointed to by the "var" attribute.
	this.pageContext.setAttribute(getVar(),
	bean.getDynaClass().getDynaProperties());
	return SKIP_BODY;
	}
	public int doEndTag() throws JspException
	{
	return EVAL_PAGE;
	}
}

