//MockCreator v3.14.3 build 5700; HashCode:-1039503324; javax.servlet.jsp.PageContext

package junit.mock;
import net.sf.mockcreator.MockKernel;
public class MockPageContext extends javax.servlet.jsp.PageContext implements net.sf.mockcreator.MockBase {
    public MockPageContext()  {
        super();
        id = net.sf.mockcreator.MockKernel.generateId();
    }        public static class Returnable287046588 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable287046588(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.Exception v){
            ir.returns(v);
        }            }    public  java.lang.Exception getException()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getException()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.Exception)ret;
            }    public Returnable287046588 expectGetException() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable287046588(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getException()"),params));
    }        public Returnable287046588 expectZeroOrMoreGetException() {
        return new Returnable287046588(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getException()"),null));
    }        public static class Returnable1571578424 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1571578424(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void initialize(javax.servlet.Servlet p0_Servlet, javax.servlet.ServletRequest p1_ServletRequest, javax.servlet.ServletResponse p2_ServletResponse, java.lang.String p3_String, boolean p4_boolean, int p5_int, boolean p6_boolean)  throws java.io.IOException, java.lang.IllegalStateException, java.lang.IllegalArgumentException {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Servlet);
        params.add(p1_ServletRequest);
        params.add(p2_ServletResponse);
        params.add(p3_String);
        params.add(new Boolean(p4_boolean));
        params.add(new Integer(p5_int));
        params.add(new Boolean(p6_boolean));
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("initialize(Servlet,ServletRequest,ServletResponse,String,boolean,int,boolean)"),params);
        if( ret instanceof java.io.IOException ) {
            throw (java.io.IOException)ret;
        }                if( ret instanceof java.lang.IllegalStateException ) {
            throw (java.lang.IllegalStateException)ret;
        }                if( ret instanceof java.lang.IllegalArgumentException ) {
            throw (java.lang.IllegalArgumentException)ret;
        }                if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnable1571578424 expectInitialize(javax.servlet.Servlet p0_Servlet, javax.servlet.ServletRequest p1_ServletRequest, javax.servlet.ServletResponse p2_ServletResponse, java.lang.String p3_String, boolean p4_boolean, int p5_int, boolean p6_boolean) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Servlet);
        params.add(p1_ServletRequest);
        params.add(p2_ServletResponse);
        params.add(p3_String);
        params.add(new Boolean(p4_boolean));
        params.add(new Integer(p5_int));
        params.add(new Boolean(p6_boolean));
        return new Returnable1571578424(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("initialize(Servlet,ServletRequest,ServletResponse,String,boolean,int,boolean)"),params));
    }        public Returnable1571578424 acceptInitialize(Object p0_Servlet, Object p1_ServletRequest, Object p2_ServletResponse, Object p3_String, Object p4_boolean, Object p5_int, Object p6_boolean) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Servlet);
        params.add(p1_ServletRequest);
        params.add(p2_ServletResponse);
        params.add(p3_String);
        params.add(p4_boolean);
        params.add(p5_int);
        params.add(p6_boolean);
        return new Returnable1571578424(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("initialize(Servlet,ServletRequest,ServletResponse,String,boolean,int,boolean)"),params));
    }        public Returnable1571578424 expectZeroOrMoreInitialize() {
        return new Returnable1571578424(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("initialize(Servlet,ServletRequest,ServletResponse,String,boolean,int,boolean)"),null));
    }        public Returnable1571578424 expectZeroOrMoreInitialize(javax.servlet.Servlet p0_Servlet, javax.servlet.ServletRequest p1_ServletRequest, javax.servlet.ServletResponse p2_ServletResponse, java.lang.String p3_String, boolean p4_boolean, int p5_int, boolean p6_boolean) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Servlet);
        params.add(p1_ServletRequest);
        params.add(p2_ServletResponse);
        params.add(p3_String);
        params.add(new Boolean(p4_boolean));
        params.add(new Integer(p5_int));
        params.add(new Boolean(p6_boolean));
        return new Returnable1571578424(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("initialize(Servlet,ServletRequest,ServletResponse,String,boolean,int,boolean)"),params));
    }        public static class Returnablex304241273 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex304241273(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void release()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("release()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnablex304241273 expectRelease() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex304241273(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("release()"),params));
    }        public Returnablex304241273 expectZeroOrMoreRelease() {
        return new Returnablex304241273(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("release()"),null));
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
    }        public Returnablex1862653278 expectZeroOrMoreGetSession() {
        return new Returnablex1862653278(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getSession()"),null));
    }        public static class Returnablex1018574842 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1018574842(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.Object v){
            ir.returns(v);
        }            }    public  java.lang.Object getPage()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getPage()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.Object)ret;
            }    public Returnablex1018574842 expectGetPage() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex1018574842(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getPage()"),params));
    }        public Returnablex1018574842 expectZeroOrMoreGetPage() {
        return new Returnablex1018574842(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getPage()"),null));
    }        public static class Returnablex1311388547 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1311388547(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(javax.servlet.ServletRequest v){
            ir.returns(v);
        }            }    public  javax.servlet.ServletRequest getRequest()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getRequest()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (javax.servlet.ServletRequest)ret;
            }    public Returnablex1311388547 expectGetRequest() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex1311388547(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getRequest()"),params));
    }        public Returnablex1311388547 expectZeroOrMoreGetRequest() {
        return new Returnablex1311388547(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getRequest()"),null));
    }        public static class Returnable680553713 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable680553713(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(javax.servlet.ServletResponse v){
            ir.returns(v);
        }            }    public  javax.servlet.ServletResponse getResponse()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getResponse()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (javax.servlet.ServletResponse)ret;
            }    public Returnable680553713 expectGetResponse() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable680553713(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getResponse()"),params));
    }        public Returnable680553713 expectZeroOrMoreGetResponse() {
        return new Returnable680553713(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getResponse()"),null));
    }        public static class Returnable953619308 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable953619308(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(javax.servlet.ServletConfig v){
            ir.returns(v);
        }            }    public  javax.servlet.ServletConfig getServletConfig()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getServletConfig()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (javax.servlet.ServletConfig)ret;
            }    public Returnable953619308 expectGetServletConfig() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable953619308(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getServletConfig()"),params));
    }        public Returnable953619308 expectZeroOrMoreGetServletConfig() {
        return new Returnable953619308(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getServletConfig()"),null));
    }        public static class Returnablex660258762 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex660258762(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(javax.servlet.ServletContext v){
            ir.returns(v);
        }            }    public  javax.servlet.ServletContext getServletContext()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getServletContext()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (javax.servlet.ServletContext)ret;
            }    public Returnablex660258762 expectGetServletContext() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex660258762(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getServletContext()"),params));
    }        public Returnablex660258762 expectZeroOrMoreGetServletContext() {
        return new Returnablex660258762(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getServletContext()"),null));
    }        public static class Returnablex1280749205 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1280749205(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void forward(java.lang.String p0_String)  throws javax.servlet.ServletException, java.io.IOException {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("forward(String)"),params);
        if( ret instanceof javax.servlet.ServletException ) {
            throw (javax.servlet.ServletException)ret;
        }                if( ret instanceof java.io.IOException ) {
            throw (java.io.IOException)ret;
        }                if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnablex1280749205 expectForward(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1280749205(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("forward(String)"),params));
    }        public Returnablex1280749205 acceptForward(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1280749205(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("forward(String)"),params));
    }        public Returnablex1280749205 expectZeroOrMoreForward() {
        return new Returnablex1280749205(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("forward(String)"),null));
    }        public Returnablex1280749205 expectZeroOrMoreForward(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1280749205(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("forward(String)"),params));
    }        public static class Returnable480617745 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable480617745(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void include(java.lang.String p0_String, boolean p1_boolean)  throws javax.servlet.ServletException, java.io.IOException {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Boolean(p1_boolean));
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("include(String,boolean)"),params);
        if( ret instanceof javax.servlet.ServletException ) {
            throw (javax.servlet.ServletException)ret;
        }                if( ret instanceof java.io.IOException ) {
            throw (java.io.IOException)ret;
        }                if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnable480617745 expectInclude(java.lang.String p0_String, boolean p1_boolean) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Boolean(p1_boolean));
        return new Returnable480617745(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("include(String,boolean)"),params));
    }        public Returnable480617745 acceptInclude(Object p0_String, Object p1_boolean) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_boolean);
        return new Returnable480617745(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("include(String,boolean)"),params));
    }        public Returnable480617745 expectZeroOrMoreInclude_String_boolean() {
        return new Returnable480617745(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("include(String,boolean)"),null));
    }        public Returnable480617745 expectZeroOrMoreInclude(java.lang.String p0_String, boolean p1_boolean) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Boolean(p1_boolean));
        return new Returnable480617745(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("include(String,boolean)"),params));
    }        public static class Returnablex211600856 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex211600856(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void include(java.lang.String p0_String)  throws javax.servlet.ServletException, java.io.IOException {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("include(String)"),params);
        if( ret instanceof javax.servlet.ServletException ) {
            throw (javax.servlet.ServletException)ret;
        }                if( ret instanceof java.io.IOException ) {
            throw (java.io.IOException)ret;
        }                if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnablex211600856 expectInclude(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex211600856(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("include(String)"),params));
    }        public Returnablex211600856 acceptInclude(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex211600856(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("include(String)"),params));
    }        public Returnablex211600856 expectZeroOrMoreInclude_String() {
        return new Returnablex211600856(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("include(String)"),null));
    }        public Returnablex211600856 expectZeroOrMoreInclude(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex211600856(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("include(String)"),params));
    }        public static class Returnable1130015833 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1130015833(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void handlePageException(java.lang.Throwable p0_Throwable)  throws javax.servlet.ServletException, java.io.IOException {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Throwable);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("handlePageException(Throwable)"),params);
        if( ret instanceof javax.servlet.ServletException ) {
            throw (javax.servlet.ServletException)ret;
        }                if( ret instanceof java.io.IOException ) {
            throw (java.io.IOException)ret;
        }                if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnable1130015833 expectHandlePageException(java.lang.Throwable p0_Throwable) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Throwable);
        return new Returnable1130015833(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("handlePageException(Throwable)"),params));
    }        public Returnable1130015833 acceptHandlePageException_Throwable(Object p0_Throwable) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Throwable);
        return new Returnable1130015833(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("handlePageException(Throwable)"),params));
    }        public Returnable1130015833 expectZeroOrMoreHandlePageException_Throwable() {
        return new Returnable1130015833(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("handlePageException(Throwable)"),null));
    }        public Returnable1130015833 expectZeroOrMoreHandlePageException(java.lang.Throwable p0_Throwable) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Throwable);
        return new Returnable1130015833(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("handlePageException(Throwable)"),params));
    }        public static class Returnablex427613336 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex427613336(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void handlePageException(java.lang.Exception p0_Exception)  throws javax.servlet.ServletException, java.io.IOException {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Exception);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("handlePageException(Exception)"),params);
        if( ret instanceof javax.servlet.ServletException ) {
            throw (javax.servlet.ServletException)ret;
        }                if( ret instanceof java.io.IOException ) {
            throw (java.io.IOException)ret;
        }                if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnablex427613336 expectHandlePageException(java.lang.Exception p0_Exception) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Exception);
        return new Returnablex427613336(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("handlePageException(Exception)"),params));
    }        public Returnablex427613336 acceptHandlePageException_Exception(Object p0_Exception) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Exception);
        return new Returnablex427613336(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("handlePageException(Exception)"),params));
    }        public Returnablex427613336 expectZeroOrMoreHandlePageException_Exception() {
        return new Returnablex427613336(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("handlePageException(Exception)"),null));
    }        public Returnablex427613336 expectZeroOrMoreHandlePageException(java.lang.Exception p0_Exception) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Exception);
        return new Returnablex427613336(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("handlePageException(Exception)"),params));
    }        public static class Returnablex1011304793 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1011304793(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(javax.servlet.jsp.tagext.BodyContent v){
            ir.returns(v);
        }            }    public  javax.servlet.jsp.tagext.BodyContent pushBody()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("pushBody()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (javax.servlet.jsp.tagext.BodyContent)ret;
            }    public Returnablex1011304793 expectPushBody() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex1011304793(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("pushBody()"),params));
    }        public Returnablex1011304793 expectZeroOrMorePushBody_returning_BodyContent() {
        return new Returnablex1011304793(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("pushBody()"),null));
    }        public static class Returnable153182018 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable153182018(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(javax.servlet.jsp.ErrorData v){
            ir.returns(v);
        }            }    public  javax.servlet.jsp.ErrorData getErrorData()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getErrorData()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (javax.servlet.jsp.ErrorData)ret;
            }    public Returnable153182018 expectGetErrorData() {
        java.util.List params = new java.util.ArrayList();
        return new Returnable153182018(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getErrorData()"),params));
    }        public Returnable153182018 expectZeroOrMoreGetErrorData() {
        return new Returnable153182018(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getErrorData()"),null));
    }        public static class Returnable1453346372 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1453346372(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(javax.servlet.jsp.JspWriter v){
            ir.returns(v);
        }            }    public  javax.servlet.jsp.JspWriter pushBody(java.io.Writer p0_Writer)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Writer);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("pushBody(Writer)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (javax.servlet.jsp.JspWriter)ret;
            }    public Returnable1453346372 expectPushBody(java.io.Writer p0_Writer) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Writer);
        return new Returnable1453346372(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("pushBody(Writer)"),params));
    }        public Returnable1453346372 acceptPushBody(Object p0_Writer) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Writer);
        return new Returnable1453346372(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("pushBody(Writer)"),params));
    }        public Returnable1453346372 expectZeroOrMorePushBody_Writer_returning_JspWriter() {
        return new Returnable1453346372(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("pushBody(Writer)"),null));
    }        public Returnable1453346372 expectZeroOrMorePushBody(java.io.Writer p0_Writer) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Writer);
        return new Returnable1453346372(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("pushBody(Writer)"),params));
    }        public Returnable1453346372 acceptZeroOrMorePushBody(Object p0_Writer) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_Writer);
        return new Returnable1453346372(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("pushBody(Writer)"),params));
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
    }        public Returnablex697445631 expectZeroOrMoreGetAttribute_String_returning_Object() {
        return new Returnablex697445631(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getAttribute(String)"),null));
    }        public Returnablex697445631 expectZeroOrMoreGetAttribute(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex697445631(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getAttribute(String)"),params));
    }        public Returnablex697445631 acceptZeroOrMoreGetAttribute(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex697445631(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getAttribute(String)"),params));
    }        public static class Returnablex416164143 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex416164143(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.Object v){
            ir.returns(v);
        }            }    public  java.lang.Object getAttribute(java.lang.String p0_String, int p1_int)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Integer(p1_int));
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getAttribute(String,int)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.Object)ret;
            }    public Returnablex416164143 expectGetAttribute(java.lang.String p0_String, int p1_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Integer(p1_int));
        return new Returnablex416164143(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getAttribute(String,int)"),params));
    }        public Returnablex416164143 acceptGetAttribute(Object p0_String, Object p1_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_int);
        return new Returnablex416164143(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getAttribute(String,int)"),params));
    }        public Returnablex416164143 expectZeroOrMoreGetAttribute_String_int_returning_Object() {
        return new Returnablex416164143(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getAttribute(String,int)"),null));
    }        public Returnablex416164143 expectZeroOrMoreGetAttribute(java.lang.String p0_String, int p1_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Integer(p1_int));
        return new Returnablex416164143(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getAttribute(String,int)"),params));
    }        public Returnablex416164143 acceptZeroOrMoreGetAttribute(Object p0_String, Object p1_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_int);
        return new Returnablex416164143(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getAttribute(String,int)"),params));
    }        public static class Returnablex424921672 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex424921672(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void setAttribute(java.lang.String p0_String, java.lang.Object p1_Object, int p2_int)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_Object);
        params.add(new Integer(p2_int));
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("setAttribute(String,Object,int)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnablex424921672 expectSetAttribute(java.lang.String p0_String, java.lang.Object p1_Object, int p2_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_Object);
        params.add(new Integer(p2_int));
        return new Returnablex424921672(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setAttribute(String,Object,int)"),params));
    }        public Returnablex424921672 acceptSetAttribute(Object p0_String, Object p1_Object, Object p2_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_Object);
        params.add(p2_int);
        return new Returnablex424921672(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("setAttribute(String,Object,int)"),params));
    }        public Returnablex424921672 expectZeroOrMoreSetAttribute_String_Object_int() {
        return new Returnablex424921672(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setAttribute(String,Object,int)"),null));
    }        public Returnablex424921672 expectZeroOrMoreSetAttribute(java.lang.String p0_String, java.lang.Object p1_Object, int p2_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_Object);
        params.add(new Integer(p2_int));
        return new Returnablex424921672(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setAttribute(String,Object,int)"),params));
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
    }        public Returnablex1437863288 expectZeroOrMoreSetAttribute_String_Object() {
        return new Returnablex1437863288(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setAttribute(String,Object)"),null));
    }        public Returnablex1437863288 expectZeroOrMoreSetAttribute(java.lang.String p0_String, java.lang.Object p1_Object) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_Object);
        return new Returnablex1437863288(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("setAttribute(String,Object)"),params));
    }        public static class Returnable1252945918 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable1252945918(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.lang.Object v){
            ir.returns(v);
        }            }    public  java.lang.Object findAttribute(java.lang.String p0_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("findAttribute(String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.lang.Object)ret;
            }    public Returnable1252945918 expectFindAttribute(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1252945918(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("findAttribute(String)"),params));
    }        public Returnable1252945918 acceptFindAttribute(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1252945918(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("findAttribute(String)"),params));
    }        public Returnable1252945918 expectZeroOrMoreFindAttribute() {
        return new Returnable1252945918(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("findAttribute(String)"),null));
    }        public Returnable1252945918 expectZeroOrMoreFindAttribute(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1252945918(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("findAttribute(String)"),params));
    }        public Returnable1252945918 acceptZeroOrMoreFindAttribute(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1252945918(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("findAttribute(String)"),params));
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
    }        public Returnable1453669976 expectZeroOrMoreRemoveAttribute_String() {
        return new Returnable1453669976(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("removeAttribute(String)"),null));
    }        public Returnable1453669976 expectZeroOrMoreRemoveAttribute(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnable1453669976(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("removeAttribute(String)"),params));
    }        public static class Returnablex354739832 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex354739832(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }    }    public  void removeAttribute(java.lang.String p0_String, int p1_int)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Integer(p1_int));
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("removeAttribute(String,int)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }    }    public Returnablex354739832 expectRemoveAttribute(java.lang.String p0_String, int p1_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Integer(p1_int));
        return new Returnablex354739832(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("removeAttribute(String,int)"),params));
    }        public Returnablex354739832 acceptRemoveAttribute(Object p0_String, Object p1_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(p1_int);
        return new Returnablex354739832(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("removeAttribute(String,int)"),params));
    }        public Returnablex354739832 expectZeroOrMoreRemoveAttribute_String_int() {
        return new Returnablex354739832(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("removeAttribute(String,int)"),null));
    }        public Returnablex354739832 expectZeroOrMoreRemoveAttribute(java.lang.String p0_String, int p1_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        params.add(new Integer(p1_int));
        return new Returnablex354739832(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("removeAttribute(String,int)"),params));
    }        public static class Returnablex1482506996 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1482506996(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(int v){
            ir.returns(v);
        }        public void returns(java.lang.Integer v){
            ir.returns(v);
        }            }    public  int getAttributesScope(java.lang.String p0_String)  {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getAttributesScope(String)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        if( ret == null ) throw net.sf.mockcreator.MockKernel.makeException("return value is not prepared");
        return ((Integer)ret).intValue();
            }    public Returnablex1482506996 expectGetAttributesScope(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1482506996(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getAttributesScope(String)"),params));
    }        public Returnablex1482506996 acceptGetAttributesScope(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1482506996(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getAttributesScope(String)"),params));
    }        public Returnablex1482506996 expectZeroOrMoreGetAttributesScope() {
        return new Returnablex1482506996(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getAttributesScope(String)"),null));
    }        public Returnablex1482506996 expectZeroOrMoreGetAttributesScope(java.lang.String p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1482506996(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getAttributesScope(String)"),params));
    }        public Returnablex1482506996 acceptZeroOrMoreGetAttributesScope(Object p0_String) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_String);
        return new Returnablex1482506996(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getAttributesScope(String)"),params));
    }        public static class Returnable794040664 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnable794040664(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(java.util.Enumeration v){
            ir.returns(v);
        }            }    public  java.util.Enumeration getAttributeNamesInScope(int p0_int)  {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getAttributeNamesInScope(int)"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (java.util.Enumeration)ret;
            }    public Returnable794040664 expectGetAttributeNamesInScope(int p0_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        return new Returnable794040664(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getAttributeNamesInScope(int)"),params));
    }        public Returnable794040664 acceptGetAttributeNamesInScope(Object p0_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_int);
        return new Returnable794040664(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getAttributeNamesInScope(int)"),params));
    }        public Returnable794040664 expectZeroOrMoreGetAttributeNamesInScope() {
        return new Returnable794040664(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getAttributeNamesInScope(int)"),null));
    }        public Returnable794040664 expectZeroOrMoreGetAttributeNamesInScope(int p0_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(new Integer(p0_int));
        return new Returnable794040664(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getAttributeNamesInScope(int)"),params));
    }        public Returnable794040664 acceptZeroOrMoreGetAttributeNamesInScope(Object p0_int) {
        java.util.List params = new java.util.ArrayList();
        params.add(p0_int);
        return new Returnable794040664(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getAttributeNamesInScope(int)"),params));
    }        public static class Returnablex717582330 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex717582330(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(javax.servlet.jsp.JspWriter v){
            ir.returns(v);
        }            }    public  javax.servlet.jsp.JspWriter getOut()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getOut()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (javax.servlet.jsp.JspWriter)ret;
            }    public Returnablex717582330 expectGetOut() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex717582330(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getOut()"),params));
    }        public Returnablex717582330 expectZeroOrMoreGetOut() {
        return new Returnablex717582330(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getOut()"),null));
    }        public static class Returnablex713560756 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex713560756(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(javax.servlet.jsp.el.ExpressionEvaluator v){
            ir.returns(v);
        }            }    public  javax.servlet.jsp.el.ExpressionEvaluator getExpressionEvaluator()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getExpressionEvaluator()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (javax.servlet.jsp.el.ExpressionEvaluator)ret;
            }    public Returnablex713560756 expectGetExpressionEvaluator() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex713560756(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getExpressionEvaluator()"),params));
    }        public Returnablex713560756 expectZeroOrMoreGetExpressionEvaluator() {
        return new Returnablex713560756(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getExpressionEvaluator()"),null));
    }        public static class Returnablex1247909962 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1247909962(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(javax.servlet.jsp.el.VariableResolver v){
            ir.returns(v);
        }            }    public  javax.servlet.jsp.el.VariableResolver getVariableResolver()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("getVariableResolver()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (javax.servlet.jsp.el.VariableResolver)ret;
            }    public Returnablex1247909962 expectGetVariableResolver() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex1247909962(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("getVariableResolver()"),params));
    }        public Returnablex1247909962 expectZeroOrMoreGetVariableResolver() {
        return new Returnablex1247909962(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("getVariableResolver()"),null));
    }        public static class Returnablex1031037183 {
        private net.sf.mockcreator.IReturnable ir;
        public Returnablex1031037183(net.sf.mockcreator.IReturnable ir) {
            this.ir = ir;
        }        public void throwable(java.lang.Throwable th) {
            ir.throwable(th);
        }        public void returns(javax.servlet.jsp.JspWriter v){
            ir.returns(v);
        }            }    public  javax.servlet.jsp.JspWriter popBody()  {
        java.util.List params = new java.util.ArrayList();
        Object ret = net.sf.mockcreator.MockKernel.getReturnValue(getClassObjectMethodSignature("popBody()"),params);
        if( ret instanceof java.lang.RuntimeException ) {
            throw (java.lang.RuntimeException)ret;
        }        if( ret instanceof java.lang.Error ) {
            throw (java.lang.Error)ret;
        }        return (javax.servlet.jsp.JspWriter)ret;
            }    public Returnablex1031037183 expectPopBody() {
        java.util.List params = new java.util.ArrayList();
        return new Returnablex1031037183(net.sf.mockcreator.MockKernel.addExpectedMethodCall(getClassObjectMethodSignature("popBody()"),params));
    }        public Returnablex1031037183 expectZeroOrMorePopBody() {
        return new Returnablex1031037183(net.sf.mockcreator.MockKernel.setDummy(getClassObjectMethodSignature("popBody()"),null));
    }        private String getClassObjectMethodSignature(String method){
        return "javax.servlet.jsp.MockPageContext"+"#"+__id()+"#"+method;
    }
    private String id;
    public String __id(){
        return id;
    }
    public static final String MOCK_CREATOR_BASE_TYPE = "javax.servlet.jsp.PageContext";
}
