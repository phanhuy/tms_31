<%@ taglib prefix="s" uri="/struts-tags"%>

<h2>Struts2 File Upload Example</h2>
User Image:
<s:property value="userImage" />
<br />
Content Type:
<s:property value="userImageContentType" />
<br />
File Name:
<s:property value="userImageFileName" />
<br />
Uploaded Image:
<br />
<img src="http://localhost:8080/tms31-imgs/<s:property value="userImageFileName"/>" />

