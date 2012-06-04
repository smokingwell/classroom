// MockCreator v3.14.3 build 5700; HashCode:-536390219; javax.servlet.http.HttpServletRequest
package junit.mock;
import net.sf.mockcreator.MockKernel;
public class MockHttpServletRequest implements javax.servlet.http.HttpServletRequest, net.sf.mockcreator.MockBase {
    public MockHttpServletRequest()  {
        super();
        id = net.sf.mockcreator.MockKernel.generateId();
    }        public static class Returnablex1557972410 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1557972410(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getMethod()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getMethod()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnablex1557972410 expectGetMethod() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex1557972410(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getMethod()"),params));
    }        public Returnablex1557972410 expectZeroOrMoreGetMethod() {
        return new Returnablex1557972410(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getMethod()"),null));
    }        public static class Returnable1824957595 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1824957595(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.util.Enumeration v){
            ir.returns(v);
        }            }    public  java.util.Enumeration getHeaders(java.lang.String p0_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getHeaders(String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.util.Enumeration)ret;
            }    public Returnable1824957595 expectGetHeaders(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1824957595(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getHeaders(String)"),params));
    }        public Returnable1824957595 acceptGetHeaders(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1824957595(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getHeaders(String)"),params));
    }        public Returnable1824957595 expectZeroOrMoreGetHeaders() {
        return new Returnable1824957595(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getHeaders(String)"),null));
    }        public Returnable1824957595 expectZeroOrMoreGetHeaders(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1824957595(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getHeaders(String)"),params));
    }        public Returnable1824957595 acceptZeroOrMoreGetHeaders(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1824957595(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getHeaders(String)"),params));
    }        public static class Returnablex1025869371 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1025869371(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getAuthType()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getAuthType()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnablex1025869371 expectGetAuthType() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex1025869371(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getAuthType()"),params));
    }        public Returnablex1025869371 expectZeroOrMoreGetAuthType() {
        return new Returnablex1025869371(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getAuthType()"),null));
    }        public static class Returnablex319773238 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex319773238(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(javax.servlet.http.Cookie[] v){
            ir.returns(v);
        }            }    public  javax.servlet.http.Cookie[] getCookies()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getCookies()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (javax.servlet.http.Cookie[])ret;
            }    public Returnablex319773238 expectGetCookies() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex319773238(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getCookies()"),params));
    }        public Returnablex319773238 expectZeroOrMoreGetCookies() {
        return new Returnablex319773238(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getCookies()"),null));
    }        public static class Returnablex1027374263 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1027374263(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(long v){
            ir.returns(v);
        }        public void returns(java.lang.Long v){
            ir.returns(v);
        }            }    public  long getDateHeader(java.lang.String p0_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getDateHeader(String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        if( ret == null ) throw net.sf.mockcreator.MockKernel.makeException("return value is not prepared");
        return ((Long)ret).longValue();
            }    public Returnablex1027374263 expectGetDateHeader(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1027374263(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getDateHeader(String)"),params));
    }        public Returnablex1027374263 acceptGetDateHeader(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1027374263(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getDateHeader(String)"),params));
    }        public Returnablex1027374263 expectZeroOrMoreGetDateHeader() {
        return new Returnablex1027374263(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getDateHeader(String)"),null));
    }        public Returnablex1027374263 expectZeroOrMoreGetDateHeader(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1027374263(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getDateHeader(String)"),params));
    }        public Returnablex1027374263 acceptZeroOrMoreGetDateHeader(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1027374263(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getDateHeader(String)"),params));
    }        public static class Returnablex119939728 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex119939728(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getHeader(java.lang.String p0_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getHeader(String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnablex119939728 expectGetHeader(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex119939728(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getHeader(String)"),params));
    }        public Returnablex119939728 acceptGetHeader(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex119939728(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getHeader(String)"),params));
    }        public Returnablex119939728 expectZeroOrMoreGetHeader() {
        return new Returnablex119939728(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getHeader(String)"),null));
    }        public Returnablex119939728 expectZeroOrMoreGetHeader(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex119939728(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getHeader(String)"),params));
    }        public Returnablex119939728 acceptZeroOrMoreGetHeader(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex119939728(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getHeader(String)"),params));
    }        public static class Returnable1368756064 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1368756064(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.util.Enumeration v){
            ir.returns(v);
        }            }    public  java.util.Enumeration getHeaderNames()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getHeaderNames()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.util.Enumeration)ret;
            }    public Returnable1368756064 expectGetHeaderNames() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable1368756064(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getHeaderNames()"),params));
    }        public Returnable1368756064 expectZeroOrMoreGetHeaderNames() {
        return new Returnable1368756064(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getHeaderNames()"),null));
    }        public static class Returnablex1192594739 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1192594739(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(int v){
            ir.returns(v);
        }        public void returns(java.lang.Integer v){
            ir.returns(v);
        }            }    public  int getIntHeader(java.lang.String p0_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getIntHeader(String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        if( ret == null ) throw net.sf.mockcreator.MockKernel.makeException("return value is not prepared");
        return ((Integer)ret).intValue();
            }    public Returnablex1192594739 expectGetIntHeader(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1192594739(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getIntHeader(String)"),params));
    }        public Returnablex1192594739 acceptGetIntHeader(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1192594739(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getIntHeader(String)"),params));
    }        public Returnablex1192594739 expectZeroOrMoreGetIntHeader() {
        return new Returnablex1192594739(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getIntHeader(String)"),null));
    }        public Returnablex1192594739 expectZeroOrMoreGetIntHeader(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1192594739(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getIntHeader(String)"),params));
    }        public Returnablex1192594739 acceptZeroOrMoreGetIntHeader(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1192594739(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getIntHeader(String)"),params));
    }        public static class Returnablex132901772 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex132901772(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getPathInfo()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getPathInfo()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnablex132901772 expectGetPathInfo() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex132901772(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getPathInfo()"),params));
    }        public Returnablex132901772 expectZeroOrMoreGetPathInfo() {
        return new Returnablex132901772(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getPathInfo()"),null));
    }        public static class Returnable728974732 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable728974732(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getPathTranslated()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getPathTranslated()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnable728974732 expectGetPathTranslated() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable728974732(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getPathTranslated()"),params));
    }        public Returnable728974732 expectZeroOrMoreGetPathTranslated() {
        return new Returnable728974732(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getPathTranslated()"),null));
    }        public static class Returnablex404762945 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex404762945(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getContextPath()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getContextPath()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnablex404762945 expectGetContextPath() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex404762945(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getContextPath()"),params));
    }        public Returnablex404762945 expectZeroOrMoreGetContextPath() {
        return new Returnablex404762945(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getContextPath()"),null));
    }        public static class Returnablex1678559014 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1678559014(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getQueryString()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getQueryString()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnablex1678559014 expectGetQueryString() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex1678559014(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getQueryString()"),params));
    }        public Returnablex1678559014 expectZeroOrMoreGetQueryString() {
        return new Returnablex1678559014(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getQueryString()"),null));
    }        public static class Returnablex824558858 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex824558858(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getRemoteUser()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getRemoteUser()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnablex824558858 expectGetRemoteUser() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex824558858(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getRemoteUser()"),params));
    }        public Returnablex824558858 expectZeroOrMoreGetRemoteUser() {
        return new Returnablex824558858(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getRemoteUser()"),null));
    }        public static class Returnable792410172 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable792410172(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(boolean v){
            ir.returns(v);
        }        public void returns(java.lang.Boolean v){
            ir.returns(v);
        }            }    public  boolean isUserInRole(java.lang.String p0_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("isUserInRole(String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        if( ret == null ) throw net.sf.mockcreator.MockKernel.makeException("return value is not prepared");
        return ((Boolean)ret).booleanValue();
            }    public Returnable792410172 expectIsUserInRole(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable792410172(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("isUserInRole(String)"),params));
    }        public Returnable792410172 acceptIsUserInRole(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable792410172(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("isUserInRole(String)"),params));
    }        public Returnable792410172 expectZeroOrMoreIsUserInRole() {
        return new Returnable792410172(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("isUserInRole(String)"),null));
    }        public Returnable792410172 expectZeroOrMoreIsUserInRole(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable792410172(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("isUserInRole(String)"),params));
    }        public Returnable792410172 acceptZeroOrMoreIsUserInRole(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable792410172(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("isUserInRole(String)"),params));
    }        public static class Returnablex1107845905 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1107845905(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.security.Principal v){
            ir.returns(v);
        }            }    public  java.security.Principal getUserPrincipal()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getUserPrincipal()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.security.Principal)ret;
            }    public Returnablex1107845905 expectGetUserPrincipal() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex1107845905(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getUserPrincipal()"),params));
    }        public Returnablex1107845905 expectZeroOrMoreGetUserPrincipal() {
        return new Returnablex1107845905(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getUserPrincipal()"),null));
    }        public static class Returnablex588586524 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex588586524(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getRequestedSessionId()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getRequestedSessionId()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnablex588586524 expectGetRequestedSessionId() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex588586524(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getRequestedSessionId()"),params));
    }        public Returnablex588586524 expectZeroOrMoreGetRequestedSessionId() {
        return new Returnablex588586524(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getRequestedSessionId()"),null));
    }        public static class Returnable1821975882 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1821975882(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getRequestURI()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getRequestURI()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnable1821975882 expectGetRequestURI() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable1821975882(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getRequestURI()"),params));
    }        public Returnable1821975882 expectZeroOrMoreGetRequestURI() {
        return new Returnable1821975882(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getRequestURI()"),null));
    }        public static class Returnablex767839545 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex767839545(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.StringBuffer v){
            ir.returns(v);
        }            }    public  java.lang.StringBuffer getRequestURL()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getRequestURL()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.StringBuffer)ret;
            }    public Returnablex767839545 expectGetRequestURL() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex767839545(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getRequestURL()"),params));
    }        public Returnablex767839545 expectZeroOrMoreGetRequestURL() {
        return new Returnablex767839545(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getRequestURL()"),null));
    }        public static class Returnable703073257 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable703073257(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getServletPath()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getServletPath()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnable703073257 expectGetServletPath() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable703073257(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getServletPath()"),params));
    }        public Returnable703073257 expectZeroOrMoreGetServletPath() {
        return new Returnable703073257(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getServletPath()"),null));
    }        public static class Returnablex1542891317 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1542891317(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(javax.servlet.http.HttpSession v){
            ir.returns(v);
        }            }    public  javax.servlet.http.HttpSession getSession(boolean p0_boolean)  {
        java.util.List params = new java.util.ArrayList();
        params.add(new Boolean(p0_boolean));
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getSession(boolean)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (javax.servlet.http.HttpSession)ret;
            }    public Returnablex1542891317 expectGetSession(boolean p0_boolean) {
        java.util.List params = new java.util.ArrayList();
        params.add(new Boolean(p0_boolean));
        return new Returnablex1542891317(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getSession(boolean)"),params));
    }        public Returnablex1542891317 acceptGetSession(Object p0_boolean) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_boolean);
        return new Returnablex1542891317(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getSession(boolean)"),params));
    }        public Returnablex1542891317 expectZeroOrMoreGetSession_boolean_returning_HttpSession() {
        return new Returnablex1542891317(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getSession(boolean)"),null));
    }        public Returnablex1542891317 expectZeroOrMoreGetSession(boolean p0_boolean) {
        java.util.List params = new java.util.ArrayList();
        params.add(new Boolean(p0_boolean));
        return new Returnablex1542891317(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getSession(boolean)"),params));
    }        public Returnablex1542891317 acceptZeroOrMoreGetSession(Object p0_boolean) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_boolean);
        return new Returnablex1542891317(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getSession(boolean)"),params));
    }        public static class Returnablex1862653278 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1862653278(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(javax.servlet.http.HttpSession v){
            ir.returns(v);
        }            }    public  javax.servlet.http.HttpSession getSession()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getSession()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (javax.servlet.http.HttpSession)ret;
            }    public Returnablex1862653278 expectGetSession() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex1862653278(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getSession()"),params));
    }        public Returnablex1862653278 expectZeroOrMoreGetSession_returning_HttpSession() {
        return new Returnablex1862653278(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getSession()"),null));
    }        public static class Returnablex87795317 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex87795317(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(boolean v){
            ir.returns(v);
        }        public void returns(java.lang.Boolean v){
            ir.returns(v);
        }            }    public  boolean isRequestedSessionIdValid()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("isRequestedSessionIdValid()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        if( ret == null ) throw net.sf.mockcreator.MockKernel.makeException("return value is not prepared");
        return ((Boolean)ret).booleanValue();
            }    public Returnablex87795317 expectIsRequestedSessionIdValid() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex87795317(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("isRequestedSessionIdValid()"),params));
    }        public Returnablex87795317 expectZeroOrMoreIsRequestedSessionIdValid() {
        return new Returnablex87795317(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("isRequestedSessionIdValid()"),null));
    }        public static class Returnablex172874569 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex172874569(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(boolean v){
            ir.returns(v);
        }        public void returns(java.lang.Boolean v){
            ir.returns(v);
        }            }    public  boolean isRequestedSessionIdFromCookie()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("isRequestedSessionIdFromCookie()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        if( ret == null ) throw net.sf.mockcreator.MockKernel.makeException("return value is not prepared");
        return ((Boolean)ret).booleanValue();
            }    public Returnablex172874569 expectIsRequestedSessionIdFromCookie() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex172874569(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("isRequestedSessionIdFromCookie()"),params));
    }        public Returnablex172874569 expectZeroOrMoreIsRequestedSessionIdFromCookie() {
        return new Returnablex172874569(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("isRequestedSessionIdFromCookie()"),null));
    }        public static class Returnablex365155852 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex365155852(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(boolean v){
            ir.returns(v);
        }        public void returns(java.lang.Boolean v){
            ir.returns(v);
        }            }    public  boolean isRequestedSessionIdFromURL()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("isRequestedSessionIdFromURL()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        if( ret == null ) throw net.sf.mockcreator.MockKernel.makeException("return value is not prepared");
        return ((Boolean)ret).booleanValue();
            }    public Returnablex365155852 expectIsRequestedSessionIdFromURL() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex365155852(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("isRequestedSessionIdFromURL()"),params));
    }        public Returnablex365155852 expectZeroOrMoreIsRequestedSessionIdFromURL() {
        return new Returnablex365155852(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("isRequestedSessionIdFromURL()"),null));
    }        public static class Returnablex1815925260 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1815925260(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(boolean v){
            ir.returns(v);
        }        public void returns(java.lang.Boolean v){
            ir.returns(v);
        }            }    public  boolean isRequestedSessionIdFromUrl()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("isRequestedSessionIdFromUrl()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        if( ret == null ) throw net.sf.mockcreator.MockKernel.makeException("return value is not prepared");
        return ((Boolean)ret).booleanValue();
            }    public Returnablex1815925260 expectIsRequestedSessionIdFromUrl() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex1815925260(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("isRequestedSessionIdFromUrl()"),params));
    }        public Returnablex1815925260 expectZeroOrMoreIsRequestedSessionIdFromUrl() {
        return new Returnablex1815925260(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("isRequestedSessionIdFromUrl()"),null));
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
    }        public static class Returnable778925570 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable778925570(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getScheme()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getScheme()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnable778925570 expectGetScheme() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable778925570(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getScheme()"),params));
    }        public Returnable778925570 expectZeroOrMoreGetScheme() {
        return new Returnable778925570(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getScheme()"),null));
    }        public static class Returnable1736660719 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1736660719(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getProtocol()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getProtocol()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnable1736660719 expectGetProtocol() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable1736660719(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getProtocol()"),params));
    }        public Returnable1736660719 expectZeroOrMoreGetProtocol() {
        return new Returnable1736660719(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getProtocol()"),null));
    }        public static class Returnablex816325539 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex816325539(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(javax.servlet.ServletInputStream v){
            ir.returns(v);
        }            }    public  javax.servlet.ServletInputStream getInputStream()  throws java.io.IOException {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getInputStream()"),params);
        if( ret instanceof java.io.IOException ) {
            throw (java.io.IOException)ret;
        }                if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (javax.servlet.ServletInputStream)ret;
            }    public Returnablex816325539 expectGetInputStream() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex816325539(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getInputStream()"),params));
    }        public Returnablex816325539 expectZeroOrMoreGetInputStream() {
        return new Returnablex816325539(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getInputStream()"),null));
    }        public static class Returnable2026857644 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable2026857644(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(int v){
            ir.returns(v);
        }        public void returns(java.lang.Integer v){
            ir.returns(v);
        }            }    public  int getContentLength()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getContentLength()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        if( ret == null ) throw net.sf.mockcreator.MockKernel.makeException("return value is not prepared");
        return ((Integer)ret).intValue();
            }    public Returnable2026857644 expectGetContentLength() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable2026857644(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getContentLength()"),params));
    }        public Returnable2026857644 expectZeroOrMoreGetContentLength() {
        return new Returnable2026857644(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getContentLength()"),null));
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
    }        public static class Returnablex697445631 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex697445631(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.Object v){
            ir.returns(v);
        }            }    public  java.lang.Object getAttribute(java.lang.String p0_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getAttribute(String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.Object)ret;
            }    public Returnablex697445631 expectGetAttribute(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex697445631(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getAttribute(String)"),params));
    }        public Returnablex697445631 acceptGetAttribute(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex697445631(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getAttribute(String)"),params));
    }        public Returnablex697445631 expectZeroOrMoreGetAttribute() {
        return new Returnablex697445631(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getAttribute(String)"),null));
    }        public Returnablex697445631 expectZeroOrMoreGetAttribute(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex697445631(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getAttribute(String)"),params));
    }        public Returnablex697445631 acceptZeroOrMoreGetAttribute(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex697445631(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getAttribute(String)"),params));
    }        public static class Returnablex465265123 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex465265123(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.util.Enumeration v){
            ir.returns(v);
        }            }    public  java.util.Enumeration getAttributeNames()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getAttributeNames()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.util.Enumeration)ret;
            }    public Returnablex465265123 expectGetAttributeNames() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex465265123(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getAttributeNames()"),params));
    }        public Returnablex465265123 expectZeroOrMoreGetAttributeNames() {
        return new Returnablex465265123(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getAttributeNames()"),null));
    }        public static class Returnable1076250166 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1076250166(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void setCharacterEncoding(java.lang.String p0_String)  throws java.io.UnsupportedEncodingException {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("setCharacterEncoding(String)"),params);
        if( ret instanceof java.io.UnsupportedEncodingException ) {
            throw (java.io.UnsupportedEncodingException)ret;
        }                if( ret instanceof java.lang.RuntimeException ) {
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
    }        public static class Returnablex970817056 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex970817056(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getParameter(java.lang.String p0_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getParameter(String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnablex970817056 expectGetParameter(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex970817056(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getParameter(String)"),params));
    }        public Returnablex970817056 acceptGetParameter(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex970817056(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getParameter(String)"),params));
    }        public Returnablex970817056 expectZeroOrMoreGetParameter() {
        return new Returnablex970817056(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getParameter(String)"),null));
    }        public Returnablex970817056 expectZeroOrMoreGetParameter(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex970817056(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getParameter(String)"),params));
    }        public Returnablex970817056 acceptZeroOrMoreGetParameter(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex970817056(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getParameter(String)"),params));
    }        public static class Returnable1779258608 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1779258608(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.util.Enumeration v){
            ir.returns(v);
        }            }    public  java.util.Enumeration getParameterNames()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getParameterNames()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.util.Enumeration)ret;
            }    public Returnable1779258608 expectGetParameterNames() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable1779258608(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getParameterNames()"),params));
    }        public Returnable1779258608 expectZeroOrMoreGetParameterNames() {
        return new Returnable1779258608(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getParameterNames()"),null));
    }        public static class Returnable143841429 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable143841429(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String[] v){
            ir.returns(v);
        }            }    public  java.lang.String[] getParameterValues(java.lang.String p0_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getParameterValues(String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String[])ret;
            }    public Returnable143841429 expectGetParameterValues(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable143841429(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getParameterValues(String)"),params));
    }        public Returnable143841429 acceptGetParameterValues(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable143841429(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getParameterValues(String)"),params));
    }        public Returnable143841429 expectZeroOrMoreGetParameterValues() {
        return new Returnable143841429(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getParameterValues(String)"),null));
    }        public Returnable143841429 expectZeroOrMoreGetParameterValues(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable143841429(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getParameterValues(String)"),params));
    }        public Returnable143841429 acceptZeroOrMoreGetParameterValues(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable143841429(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getParameterValues(String)"),params));
    }        public static class Returnablex2099821735 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex2099821735(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.util.Map v){
            ir.returns(v);
        }            }    public  java.util.Map getParameterMap()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getParameterMap()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.util.Map)ret;
            }    public Returnablex2099821735 expectGetParameterMap() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex2099821735(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getParameterMap()"),params));
    }        public Returnablex2099821735 expectZeroOrMoreGetParameterMap() {
        return new Returnablex2099821735(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getParameterMap()"),null));
    }        public static class Returnablex849019559 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex849019559(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getServerName()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getServerName()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnablex849019559 expectGetServerName() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex849019559(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getServerName()"),params));
    }        public Returnablex849019559 expectZeroOrMoreGetServerName() {
        return new Returnablex849019559(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getServerName()"),null));
    }        public static class Returnablex653054147 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex653054147(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(int v){
            ir.returns(v);
        }        public void returns(java.lang.Integer v){
            ir.returns(v);
        }            }    public  int getServerPort()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getServerPort()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        if( ret == null ) throw net.sf.mockcreator.MockKernel.makeException("return value is not prepared");
        return ((Integer)ret).intValue();
            }    public Returnablex653054147 expectGetServerPort() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex653054147(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getServerPort()"),params));
    }        public Returnablex653054147 expectZeroOrMoreGetServerPort() {
        return new Returnablex653054147(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getServerPort()"),null));
    }        public static class Returnable547619349 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable547619349(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.io.BufferedReader v){
            ir.returns(v);
        }            }    public  java.io.BufferedReader getReader()  throws java.io.IOException {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getReader()"),params);
        if( ret instanceof java.io.IOException ) {
            throw (java.io.IOException)ret;
        }                if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.io.BufferedReader)ret;
            }    public Returnable547619349 expectGetReader() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable547619349(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getReader()"),params));
    }        public Returnable547619349 expectZeroOrMoreGetReader() {
        return new Returnable547619349(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getReader()"),null));
    }        public static class Returnable1925258128 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1925258128(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getRemoteAddr()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getRemoteAddr()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnable1925258128 expectGetRemoteAddr() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable1925258128(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getRemoteAddr()"),params));
    }        public Returnable1925258128 expectZeroOrMoreGetRemoteAddr() {
        return new Returnable1925258128(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getRemoteAddr()"),null));
    }        public static class Returnable1426294457 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1426294457(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getRemoteHost()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getRemoteHost()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnable1426294457 expectGetRemoteHost() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable1426294457(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getRemoteHost()"),params));
    }        public Returnable1426294457 expectZeroOrMoreGetRemoteHost() {
        return new Returnable1426294457(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getRemoteHost()"),null));
    }        public static class Returnablex1437863288 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1437863288(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void setAttribute(java.lang.String p0_String, java.lang.Object p1_Object)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_Object);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("setAttribute(String,Object)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnablex1437863288 expectSetAttribute(java.lang.String p0_String, java.lang.Object p1_Object) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_Object);
        return new Returnablex1437863288(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setAttribute(String,Object)"),params));
    }        public Returnablex1437863288 acceptSetAttribute(Object p0_String, Object p1_Object) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_Object);
        return new Returnablex1437863288(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setAttribute(String,Object)"),params));
    }        public Returnablex1437863288 expectZeroOrMoreSetAttribute() {
        return new Returnablex1437863288(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setAttribute(String,Object)"),null));
    }        public Returnablex1437863288 expectZeroOrMoreSetAttribute(java.lang.String p0_String, java.lang.Object p1_Object) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_Object);
        return new Returnablex1437863288(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setAttribute(String,Object)"),params));
    }        public static class Returnable1453669976 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1453669976(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void removeAttribute(java.lang.String p0_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("removeAttribute(String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnable1453669976 expectRemoveAttribute(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1453669976(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("removeAttribute(String)"),params));
    }        public Returnable1453669976 acceptRemoveAttribute(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1453669976(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("removeAttribute(String)"),params));
    }        public Returnable1453669976 expectZeroOrMoreRemoveAttribute() {
        return new Returnable1453669976(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("removeAttribute(String)"),null));
    }        public Returnable1453669976 expectZeroOrMoreRemoveAttribute(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1453669976(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("removeAttribute(String)"),params));
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
    }        public static class Returnablex89013634 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex89013634(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.util.Enumeration v){
            ir.returns(v);
        }            }    public  java.util.Enumeration getLocales()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getLocales()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.util.Enumeration)ret;
            }    public Returnablex89013634 expectGetLocales() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex89013634(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getLocales()"),params));
    }        public Returnablex89013634 expectZeroOrMoreGetLocales() {
        return new Returnablex89013634(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getLocales()"),null));
    }        public static class Returnablex1473730403 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1473730403(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(boolean v){
            ir.returns(v);
        }        public void returns(java.lang.Boolean v){
            ir.returns(v);
        }            }    public  boolean isSecure()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("isSecure()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        if( ret == null ) throw net.sf.mockcreator.MockKernel.makeException("return value is not prepared");
        return ((Boolean)ret).booleanValue();
            }    public Returnablex1473730403 expectIsSecure() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex1473730403(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("isSecure()"),params));
    }        public Returnablex1473730403 expectZeroOrMoreIsSecure() {
        return new Returnablex1473730403(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("isSecure()"),null));
    }        public static class Returnable391103834 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable391103834(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(javax.servlet.RequestDispatcher v){
            ir.returns(v);
        }            }    public  javax.servlet.RequestDispatcher getRequestDispatcher(java.lang.String p0_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getRequestDispatcher(String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (javax.servlet.RequestDispatcher)ret;
            }    public Returnable391103834 expectGetRequestDispatcher(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable391103834(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getRequestDispatcher(String)"),params));
    }        public Returnable391103834 acceptGetRequestDispatcher(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable391103834(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getRequestDispatcher(String)"),params));
    }        public Returnable391103834 expectZeroOrMoreGetRequestDispatcher() {
        return new Returnable391103834(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getRequestDispatcher(String)"),null));
    }        public Returnable391103834 expectZeroOrMoreGetRequestDispatcher(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable391103834(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getRequestDispatcher(String)"),params));
    }        public Returnable391103834 acceptZeroOrMoreGetRequestDispatcher(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable391103834(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getRequestDispatcher(String)"),params));
    }        public static class Returnable1714570822 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1714570822(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getRealPath(java.lang.String p0_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getRealPath(String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnable1714570822 expectGetRealPath(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1714570822(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getRealPath(String)"),params));
    }        public Returnable1714570822 acceptGetRealPath(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1714570822(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getRealPath(String)"),params));
    }        public Returnable1714570822 expectZeroOrMoreGetRealPath() {
        return new Returnable1714570822(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getRealPath(String)"),null));
    }        public Returnable1714570822 expectZeroOrMoreGetRealPath(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1714570822(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getRealPath(String)"),params));
    }        public Returnable1714570822 acceptZeroOrMoreGetRealPath(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1714570822(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getRealPath(String)"),params));
    }        public static class Returnable85646720 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable85646720(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(int v){
            ir.returns(v);
        }        public void returns(java.lang.Integer v){
            ir.returns(v);
        }            }    public  int getRemotePort()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getRemotePort()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        if( ret == null ) throw net.sf.mockcreator.MockKernel.makeException("return value is not prepared");
        return ((Integer)ret).intValue();
            }    public Returnable85646720 expectGetRemotePort() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable85646720(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getRemotePort()"),params));
    }        public Returnable85646720 expectZeroOrMoreGetRemotePort() {
        return new Returnable85646720(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getRemotePort()"),null));
    }        public static class Returnablex1270998435 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1270998435(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getLocalName()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getLocalName()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnablex1270998435 expectGetLocalName() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex1270998435(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getLocalName()"),params));
    }        public Returnablex1270998435 expectZeroOrMoreGetLocalName() {
        return new Returnablex1270998435(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getLocalName()"),null));
    }        public static class Returnablex2016792137 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex2016792137(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.String v){
            ir.returns(v);
        }            }    public  java.lang.String getLocalAddr()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getLocalAddr()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.String)ret;
            }    public Returnablex2016792137 expectGetLocalAddr() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex2016792137(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getLocalAddr()"),params));
    }        public Returnablex2016792137 expectZeroOrMoreGetLocalAddr() {
        return new Returnablex2016792137(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getLocalAddr()"),null));
    }        public static class Returnablex1723674439 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1723674439(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(int v){
            ir.returns(v);
        }        public void returns(java.lang.Integer v){
            ir.returns(v);
        }            }    public  int getLocalPort()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getLocalPort()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        if( ret == null ) throw net.sf.mockcreator.MockKernel.makeException("return value is not prepared");
        return ((Integer)ret).intValue();
            }    public Returnablex1723674439 expectGetLocalPort() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex1723674439(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getLocalPort()"),params));
    }        public Returnablex1723674439 expectZeroOrMoreGetLocalPort() {
        return new Returnablex1723674439(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getLocalPort()"),null));
    }        private String getClassObjectMethodSignature(String method){
        return "javax.servlet.http.MockHttpServletRequest"+"#"+__id()+"#"+method;
    }
    private String id;
    public String __id(){
        return id;
    }
    public static final String MOCK_CREATOR_BASE_TYPE = "javax.servlet.http.HttpServletRequest";
}
