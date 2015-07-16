<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="#session.logined == 'true'">	
	<a href="<s:url value="/logout"/>">Logout</a>
</s:if>
<s:else>	
	<a href="<s:url value="/login"/>">Please login!</a>
</s:else>