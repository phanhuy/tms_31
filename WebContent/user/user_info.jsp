<%@ taglib prefix="s" uri="/struts-tags"%>

<h1>View profile</h1>
<s:if test="#session.currentUser != null">
	<b>ID:</b><s:property value="user.id" /><br>
	<b>Username:</b><s:property value="user.name" /><br>
	<b>Email:</b><s:property value="user.email" /><br>
	<s:if test="#session.currentUser.id == user.id">
		<a href="<s:url value="/users/edit%{user.id}"/>">Edit</a>
	</s:if>		
</s:if>
<s:else>	
	<a href="<s:url value="/login"/>">Please login!</a><br>	
</s:else>

<div class="user-activities">
	<h3>Activities</h3>	
</div>



Test upload-download:

<h3>File Upload:</h3>
Select a file to upload: <br />
<form action="UploadServlet" method="post"
                        enctype="multipart/form-data">
<input type="file" name="file" size="50" />
<br />
<input type="submit" value="Upload File" />
</form>