<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="#session.logined == 'true'">
	<b>ID:</b><s:property value="user.id" /><br>
	<b>Username:</b><s:property value="user.name" /><br>
	<b>Email:</b><s:property value="user.email" /><br>
	<a href="<s:url value="/logout"/>">Logout</a>
</s:if>
<s:else>	
	<a href="<s:url value="/login"/>">Please login!</a><br>	
</s:else>