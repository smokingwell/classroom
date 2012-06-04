// MockCreator v3.14.3 build 5700; HashCode:-748623696; javax.servlet.http.HttpServletResponse
package junit.mock;
import net.sf.mockcreator.MockKernel;
public class MockHttpServletResponse implements javax.servlet.http.HttpServletResponse, net.sf.mockcreator.MockBase {
    public MockHttpServletResponse()  {
        super();
        id = net.sf.mockcreator.MockKernel.generateId();
    }        public static class Returnable710961182 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable710961182(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void addCookie(javax.servlet.http.Cookie p0_Cookie)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Cookie);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("addCookie(Cookie)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnable710961182 expectAddCookie(javax.servlet.http.Cookie p0_Cookie) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Cookie);
        return new Returnable710961182(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("addCookie(Cookie)"),params));
    }        public Returnable710961182 acceptAddCookie(Object p0_Cookie) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Cookie);
        return new Returnable710961182(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("addCookie(Cookie)"),params));
    }        public Returnable710961182 expectZeroOrMoreAddCookie() {
        return new Returnable710961182(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("addCookie(Cookie)"),null));
    }        public Returnable710961182 expectZeroOrMoreAddCookie(javax.servlet.http.Cookie p0_Cookie) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Cookie);
        return new Returnable710961182(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("addCookie(Cookie)"),params));
    }        public static class Returnable1940712928 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1940712928(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(boolean v){
            ir.returns(v);
        }        public void returns(java.lang.Boolean v){
            ir.returns(v);
        }            }    public  boolean containsHeader(java.lang.String p0_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("containsHeader(String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        if( ret == null ) throw net.sf.mockcreator.MockKernel.makeException("return value is not prepared");
        return ((Boolean)ret).booleanValue();
            }    public Returnable1940712928 expectContainsHeader(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1940712928(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("containsHeader(String)"),params));
    }        public Returnable1940712928 acceptContainsHeader(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1940712928(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("containsHeader(String)"),params));
    }        public Returnable1940712928 expectZeroOrMoreContainsHeader() {
        return new Returnable1940712928(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("containsHeader(String)"),null));
    }        public Returnable1940712928 expectZeroOrMoreContainsHeader(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1940712928(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("containsHeader(String)"),params));
    }        public Returnable1940712928 acceptZeroOrMoreContainsHeader(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1940712928(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("containsHeader(String)"),params));
    }        public static class Returnablex107142810 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex107142810(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String encodeURL(java.lang.String p0_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("encodeURL(String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnablex107142810 expectEncodeURL(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex107142810(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("encodeURL(String)"),params));
    }        public Returnablex107142810 acceptEncodeURL(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex107142810(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("encodeURL(String)"),params));
    }        public Returnablex107142810 expectZeroOrMoreEncodeURL() {
        return new Returnablex107142810(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("encodeURL(String)"),null));
    }        public Returnablex107142810 expectZeroOrMoreEncodeURL(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex107142810(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("encodeURL(String)"),params));
    }        public Returnablex107142810 acceptZeroOrMoreEncodeURL(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex107142810(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("encodeURL(String)"),params));
    }        public static class Returnablex760685078 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex760685078(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String encodeRedirectURL(java.lang.String p0_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("encodeRedirectURL(String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnablex760685078 expectEncodeRedirectURL(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex760685078(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("encodeRedirectURL(String)"),params));
    }        public Returnablex760685078 acceptEncodeRedirectURL(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex760685078(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("encodeRedirectURL(String)"),params));
    }        public Returnablex760685078 expectZeroOrMoreEncodeRedirectURL() {
        return new Returnablex760685078(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("encodeRedirectURL(String)"),null));
    }        public Returnablex760685078 expectZeroOrMoreEncodeRedirectURL(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex760685078(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("encodeRedirectURL(String)"),params));
    }        public Returnablex760685078 acceptZeroOrMoreEncodeRedirectURL(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex760685078(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("encodeRedirectURL(String)"),params));
    }        public static class Returnablex1160698522 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1160698522(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String encodeUrl(java.lang.String p0_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("encodeUrl(String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnablex1160698522 expectEncodeUrl(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1160698522(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("encodeUrl(String)"),params));
    }        public Returnablex1160698522 acceptEncodeUrl(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1160698522(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("encodeUrl(String)"),params));
    }        public Returnablex1160698522 expectZeroOrMoreEncodeUrl() {
        return new Returnablex1160698522(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("encodeUrl(String)"),null));
    }        public Returnablex1160698522 expectZeroOrMoreEncodeUrl(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1160698522(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("encodeUrl(String)"),params));
    }        public Returnablex1160698522 acceptZeroOrMoreEncodeUrl(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1160698522(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("encodeUrl(String)"),params));
    }        public static class Returnablex1814240790 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1814240790(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String encodeRedirectUrl(java.lang.String p0_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("encodeRedirectUrl(String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnablex1814240790 expectEncodeRedirectUrl(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1814240790(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("encodeRedirectUrl(String)"),params));
    }        public Returnablex1814240790 acceptEncodeRedirectUrl(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1814240790(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("encodeRedirectUrl(String)"),params));
    }        public Returnablex1814240790 expectZeroOrMoreEncodeRedirectUrl() {
        return new Returnablex1814240790(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("encodeRedirectUrl(String)"),null));
    }        public Returnablex1814240790 expectZeroOrMoreEncodeRedirectUrl(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1814240790(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("encodeRedirectUrl(String)"),params));
    }        public Returnablex1814240790 acceptZeroOrMoreEncodeRedirectUrl(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1814240790(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("encodeRedirectUrl(String)"),params));
    }        public static class Returnablex1779762160 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1779762160(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void sendError(int p0_int)  throws java.io.IOException {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("sendError(int)"),params);
        if( ret instanceof java.io.IOException ) {
            throw (java.io.IOException)ret;
        }                if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnablex1779762160 expectSendError(int p0_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        return new Returnablex1779762160(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("sendError(int)"),params));
    }        public Returnablex1779762160 acceptSendError(Object p0_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_int);
        return new Returnablex1779762160(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("sendError(int)"),params));
    }        public Returnablex1779762160 expectZeroOrMoreSendError_int() {
        return new Returnablex1779762160(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("sendError(int)"),null));
    }        public Returnablex1779762160 expectZeroOrMoreSendError(int p0_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        return new Returnablex1779762160(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("sendError(int)"),params));
    }        public static class Returnable717134656 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable717134656(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void sendError(int p0_int, java.lang.String p1_String)  throws java.io.IOException {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        params.add(p1_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("sendError(int,String)"),params);
        if( ret instanceof java.io.IOException ) {
            throw (java.io.IOException)ret;
        }                if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnable717134656 expectSendError(int p0_int, java.lang.String p1_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        params.add(p1_String);
        return new Returnable717134656(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("sendError(int,String)"),params));
    }        public Returnable717134656 acceptSendError(Object p0_int, Object p1_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_int);
        params.add(p1_String);
        return new Returnable717134656(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("sendError(int,String)"),params));
    }        public Returnable717134656 expectZeroOrMoreSendError_int_String() {
        return new Returnable717134656(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("sendError(int,String)"),null));
    }        public Returnable717134656 expectZeroOrMoreSendError(int p0_int, java.lang.String p1_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        params.add(p1_String);
        return new Returnable717134656(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("sendError(int,String)"),params));
    }        public static class Returnablex1167382836 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1167382836(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void sendRedirect(java.lang.String p0_String)  throws java.io.IOException {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("sendRedirect(String)"),params);
        if( ret instanceof java.io.IOException ) {
            throw (java.io.IOException)ret;
        }                if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnablex1167382836 expectSendRedirect(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1167382836(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("sendRedirect(String)"),params));
    }        public Returnablex1167382836 acceptSendRedirect(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1167382836(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("sendRedirect(String)"),params));
    }        public Returnablex1167382836 expectZeroOrMoreSendRedirect() {
        return new Returnablex1167382836(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("sendRedirect(String)"),null));
    }        public Returnablex1167382836 expectZeroOrMoreSendRedirect(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1167382836(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("sendRedirect(String)"),params));
    }        public static class Returnablex1580823576 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1580823576(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void setDateHeader(java.lang.String p0_String, long p1_long)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Long(p1_long));
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("setDateHeader(String,long)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnablex1580823576 expectSetDateHeader(java.lang.String p0_String, long p1_long) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Long(p1_long));
        return new Returnablex1580823576(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setDateHeader(String,long)"),params));
    }        public Returnablex1580823576 acceptSetDateHeader(Object p0_String, Object p1_long) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_long);
        return new Returnablex1580823576(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setDateHeader(String,long)"),params));
    }        public Returnablex1580823576 expectZeroOrMoreSetDateHeader() {
        return new Returnablex1580823576(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setDateHeader(String,long)"),null));
    }        public Returnablex1580823576 expectZeroOrMoreSetDateHeader(java.lang.String p0_String, long p1_long) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Long(p1_long));
        return new Returnablex1580823576(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setDateHeader(String,long)"),params));
    }        public static class Returnablex1220149529 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1220149529(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void addDateHeader(java.lang.String p0_String, long p1_long)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Long(p1_long));
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("addDateHeader(String,long)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnablex1220149529 expectAddDateHeader(java.lang.String p0_String, long p1_long) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Long(p1_long));
        return new Returnablex1220149529(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("addDateHeader(String,long)"),params));
    }        public Returnablex1220149529 acceptAddDateHeader(Object p0_String, Object p1_long) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_long);
        return new Returnablex1220149529(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("addDateHeader(String,long)"),params));
    }        public Returnablex1220149529 expectZeroOrMoreAddDateHeader() {
        return new Returnablex1220149529(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("addDateHeader(String,long)"),null));
    }        public Returnablex1220149529 expectZeroOrMoreAddDateHeader(java.lang.String p0_String, long p1_long) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Long(p1_long));
        return new Returnablex1220149529(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("addDateHeader(String,long)"),params));
    }        public static class Returnablex99273009 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex99273009(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void setHeader(java.lang.String p0_String, java.lang.String p1_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("setHeader(String,String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnablex99273009 expectSetHeader(java.lang.String p0_String, java.lang.String p1_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_String);
        return new Returnablex99273009(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setHeader(String,String)"),params));
    }        public Returnablex99273009 acceptSetHeader(Object p0_String, Object p1_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_String);
        return new Returnablex99273009(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setHeader(String,String)"),params));
    }        public Returnablex99273009 expectZeroOrMoreSetHeader() {
        return new Returnablex99273009(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setHeader(String,String)"),null));
    }        public Returnablex99273009 expectZeroOrMoreSetHeader(java.lang.String p0_String, java.lang.String p1_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_String);
        return new Returnablex99273009(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setHeader(String,String)"),params));
    }        public static class Returnable1921211790 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1921211790(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void addHeader(java.lang.String p0_String, java.lang.String p1_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("addHeader(String,String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnable1921211790 expectAddHeader(java.lang.String p0_String, java.lang.String p1_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_String);
        return new Returnable1921211790(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("addHeader(String,String)"),params));
    }        public Returnable1921211790 acceptAddHeader(Object p0_String, Object p1_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_String);
        return new Returnable1921211790(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("addHeader(String,String)"),params));
    }        public Returnable1921211790 expectZeroOrMoreAddHeader() {
        return new Returnable1921211790(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("addHeader(String,String)"),null));
    }        public Returnable1921211790 expectZeroOrMoreAddHeader(java.lang.String p0_String, java.lang.String p1_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_String);
        return new Returnable1921211790(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("addHeader(String,String)"),params));
    }        public static class Returnable735701158 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable735701158(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void setIntHeader(java.lang.String p0_String, int p1_int)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Integer(p1_int));
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("setIntHeader(String,int)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnable735701158 expectSetIntHeader(java.lang.String p0_String, int p1_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Integer(p1_int));
        return new Returnable735701158(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setIntHeader(String,int)"),params));
    }        public Returnable735701158 acceptSetIntHeader(Object p0_String, Object p1_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_int);
        return new Returnable735701158(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setIntHeader(String,int)"),params));
    }        public Returnable735701158 expectZeroOrMoreSetIntHeader() {
        return new Returnable735701158(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setIntHeader(String,int)"),null));
    }        public Returnable735701158 expectZeroOrMoreSetIntHeader(java.lang.String p0_String, int p1_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Integer(p1_int));
        return new Returnable735701158(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setIntHeader(String,int)"),params));
    }        public static class Returnablex1538781339 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1538781339(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void addIntHeader(java.lang.String p0_String, int p1_int)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Integer(p1_int));
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("addIntHeader(String,int)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnablex1538781339 expectAddIntHeader(java.lang.String p0_String, int p1_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Integer(p1_int));
        return new Returnablex1538781339(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("addIntHeader(String,int)"),params));
    }        public Returnablex1538781339 acceptAddIntHeader(Object p0_String, Object p1_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_int);
        return new Returnablex1538781339(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("addIntHeader(String,int)"),params));
    }        public Returnablex1538781339 expectZeroOrMoreAddIntHeader() {
        return new Returnablex1538781339(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("addIntHeader(String,int)"),null));
    }        public Returnablex1538781339 expectZeroOrMoreAddIntHeader(java.lang.String p0_String, int p1_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Integer(p1_int));
        return new Returnablex1538781339(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("addIntHeader(String,int)"),params));
    }        public static class Returnable1066874668 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1066874668(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void setStatus(int p0_int, java.lang.String p1_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        params.add(p1_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("setStatus(int,String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnable1066874668 expectSetStatus(int p0_int, java.lang.String p1_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        params.add(p1_String);
        return new Returnable1066874668(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setStatus(int,String)"),params));
    }        public Returnable1066874668 acceptSetStatus(Object p0_int, Object p1_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_int);
        params.add(p1_String);
        return new Returnable1066874668(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setStatus(int,String)"),params));
    }        public Returnable1066874668 expectZeroOrMoreSetStatus_int_String() {
        return new Returnable1066874668(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setStatus(int,String)"),null));
    }        public Returnable1066874668 expectZeroOrMoreSetStatus(int p0_int, java.lang.String p1_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        params.add(p1_String);
        return new Returnable1066874668(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setStatus(int,String)"),params));
    }        public static class Returnablex1592086108 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1592086108(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void setStatus(int p0_int)  {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("setStatus(int)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnablex1592086108 expectSetStatus(int p0_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        return new Returnablex1592086108(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setStatus(int)"),params));
    }        public Returnablex1592086108 acceptSetStatus(Object p0_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_int);
        return new Returnablex1592086108(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setStatus(int)"),params));
    }        public Returnablex1592086108 expectZeroOrMoreSetStatus_int() {
        return new Returnablex1592086108(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setStatus(int)"),null));
    }        public Returnablex1592086108 expectZeroOrMoreSetStatus(int p0_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        return new Returnablex1592086108(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setStatus(int)"),params));
    }        public static class Returnable1934883535 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1934883535(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void reset()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("reset()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnable1934883535 expectReset() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable1934883535(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("reset()"),params));
    }        public Returnable1934883535 expectZeroOrMoreReset() {
        return new Returnable1934883535(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("reset()"),null));
    }        public static class Returnablex429457897 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex429457897(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getCharacterEncoding()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getCharacterEncoding()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnablex429457897 expectGetCharacterEncoding() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex429457897(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getCharacterEncoding()"),params));
    }        public Returnablex429457897 expectZeroOrMoreGetCharacterEncoding() {
        return new Returnablex429457897(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getCharacterEncoding()"),null));
    }        public static class Returnablex1951193628 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1951193628(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void flushBuffer()  throws java.io.IOException {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("flushBuffer()"),params);
        if( ret instanceof java.io.IOException ) {
            throw (java.io.IOException)ret;
        }                if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnablex1951193628 expectFlushBuffer() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex1951193628(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("flushBuffer()"),params));
    }        public Returnablex1951193628 expectZeroOrMoreFlushBuffer() {
        return new Returnablex1951193628(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("flushBuffer()"),null));
    }        public static class Returnable1730188224 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1730188224(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getContentType()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getContentType()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnable1730188224 expectGetContentType() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable1730188224(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getContentType()"),params));
    }        public Returnable1730188224 expectZeroOrMoreGetContentType() {
        return new Returnable1730188224(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getContentType()"),null));
    }        public static class Returnablex811277281 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex811277281(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void setContentType(java.lang.String p0_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("setContentType(String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnablex811277281 expectSetContentType(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex811277281(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setContentType(String)"),params));
    }        public Returnablex811277281 acceptSetContentType(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex811277281(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setContentType(String)"),params));
    }        public Returnablex811277281 expectZeroOrMoreSetContentType() {
        return new Returnablex811277281(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setContentType(String)"),null));
    }        public Returnablex811277281 expectZeroOrMoreSetContentType(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex811277281(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setContentType(String)"),params));
    }        public static class Returnable304984749 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable304984749(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void setContentLength(int p0_int)  {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("setContentLength(int)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnable304984749 expectSetContentLength(int p0_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        return new Returnable304984749(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setContentLength(int)"),params));
    }        public Returnable304984749 acceptSetContentLength(Object p0_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_int);
        return new Returnable304984749(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setContentLength(int)"),params));
    }        public Returnable304984749 expectZeroOrMoreSetContentLength() {
        return new Returnable304984749(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setContentLength(int)"),null));
    }        public Returnable304984749 expectZeroOrMoreSetContentLength(int p0_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        return new Returnable304984749(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setContentLength(int)"),params));
    }        public static class Returnable1110100273 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1110100273(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(javax.servlet.ServletOutputStream v){
            ir.returns(v);
        }            }    public  javax.servlet.ServletOutputStream getOutputStream()  throws java.io.IOException {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getOutputStream()"),params);
        if( ret instanceof java.io.IOException ) {
            throw (java.io.IOException)ret;
        }                if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (javax.servlet.ServletOutputStream)ret;
            }    public Returnable1110100273 expectGetOutputStream() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable1110100273(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getOutputStream()"),params));
    }        public Returnable1110100273 expectZeroOrMoreGetOutputStream() {
        return new Returnable1110100273(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getOutputStream()"),null));
    }        public static class Returnable1076250166 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1076250166(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void setCharacterEncoding(java.lang.String p0_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("setCharacterEncoding(String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnable1076250166 expectSetCharacterEncoding(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1076250166(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setCharacterEncoding(String)"),params));
    }        public Returnable1076250166 acceptSetCharacterEncoding(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1076250166(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setCharacterEncoding(String)"),params));
    }        public Returnable1076250166 expectZeroOrMoreSetCharacterEncoding() {
        return new Returnable1076250166(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setCharacterEncoding(String)"),null));
    }        public Returnable1076250166 expectZeroOrMoreSetCharacterEncoding(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1076250166(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setCharacterEncoding(String)"),params));
    }        public static class Returnablex1108792266 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1108792266(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.util.Locale v){
            ir.returns(v);
        }            }    public  java.util.Locale getLocale()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getLocale()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.util.Locale)ret;
            }    public Returnablex1108792266 expectGetLocale() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex1108792266(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getLocale()"),params));
    }        public Returnablex1108792266 expectZeroOrMoreGetLocale() {
        return new Returnablex1108792266(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getLocale()"),null));
    }        public static class Returnable662816061 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable662816061(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void setLocale(java.util.Locale p0_Locale)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Locale);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("setLocale(Locale)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnable662816061 expectSetLocale(java.util.Locale p0_Locale) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Locale);
        return new Returnable662816061(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setLocale(Locale)"),params));
    }        public Returnable662816061 acceptSetLocale(Object p0_Locale) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Locale);
        return new Returnable662816061(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setLocale(Locale)"),params));
    }        public Returnable662816061 expectZeroOrMoreSetLocale() {
        return new Returnable662816061(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setLocale(Locale)"),null));
    }        public Returnable662816061 expectZeroOrMoreSetLocale(java.util.Locale p0_Locale) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Locale);
        return new Returnable662816061(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setLocale(Locale)"),params));
    }        public static class Returnable1131218557 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1131218557(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.io.PrintWriter v){
            ir.returns(v);
        }            }    public  java.io.PrintWriter getWriter()  throws java.io.IOException {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getWriter()"),params);
        if( ret instanceof java.io.IOException ) {
            throw (java.io.IOException)ret;
        }                if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.io.PrintWriter)ret;
            }    public Returnable1131218557 expectGetWriter() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable1131218557(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getWriter()"),params));
    }        public Returnable1131218557 expectZeroOrMoreGetWriter() {
        return new Returnable1131218557(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getWriter()"),null));
    }        public static class Returnablex1735767661 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1735767661(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void setBufferSize(int p0_int)  {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("setBufferSize(int)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnablex1735767661 expectSetBufferSize(int p0_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        return new Returnablex1735767661(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setBufferSize(int)"),params));
    }        public Returnablex1735767661 acceptSetBufferSize(Object p0_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_int);
        return new Returnablex1735767661(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setBufferSize(int)"),params));
    }        public Returnablex1735767661 expectZeroOrMoreSetBufferSize() {
        return new Returnablex1735767661(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setBufferSize(int)"),null));
    }        public Returnablex1735767661 expectZeroOrMoreSetBufferSize(int p0_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        return new Returnablex1735767661(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setBufferSize(int)"),params));
    }        public static class Returnablex626239878 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex626239878(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(int v){
            ir.returns(v);
        }        public void returns(java.lang.Integer v){
            ir.returns(v);
        }            }    public  int getBufferSize()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getBufferSize()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        if( ret == null ) throw net.sf.mockcreator.MockKernel.makeException("return value is not prepared");
        return ((Integer)ret).intValue();
            }    public Returnablex626239878 expectGetBufferSize() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex626239878(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getBufferSize()"),params));
    }        public Returnablex626239878 expectZeroOrMoreGetBufferSize() {
        return new Returnablex626239878(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getBufferSize()"),null));
    }        public static class Returnable2086331375 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable2086331375(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void resetBuffer()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("resetBuffer()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnable2086331375 expectResetBuffer() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable2086331375(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("resetBuffer()"),params));
    }        public Returnable2086331375 expectZeroOrMoreResetBuffer() {
        return new Returnable2086331375(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("resetBuffer()"),null));
    }        public static class Returnablex1734863474 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1734863474(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(boolean v){
            ir.returns(v);
        }        public void returns(java.lang.Boolean v){
            ir.returns(v);
        }            }    public  boolean isCommitted()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("isCommitted()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        if( ret == null ) throw net.sf.mockcreator.MockKernel.makeException("return value is not prepared");
        return ((Boolean)ret).booleanValue();
            }    public Returnablex1734863474 expectIsCommitted() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex1734863474(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("isCommitted()"),params));
    }        public Returnablex1734863474 expectZeroOrMoreIsCommitted() {
        return new Returnablex1734863474(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("isCommitted()"),null));
    }        private String getClassObjectMethodSignature(String method){
        return "javax.servlet.http.MockHttpServletResponse"+"#"+__id()+"#"+method;
    }
    private String id;
    public String __id(){
        return id;
    }
    public static final String MOCK_CREATOR_BASE_TYPE = "javax.servlet.http.HttpServletResponse";
}
