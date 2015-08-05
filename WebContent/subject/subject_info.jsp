<%@ taglib prefix="s" uri="/struts-tags"%>

<h2>
	Subject
	<s:property value="subject.name" />
	<br>
</h2>


<s:if test="#session.currentUser.suppervisor == 1">
<a href="<s:url value="/subjects/delete%{subject.id}" />">Delete</a>
<a href="<s:url value="/subjects/edit%{subject.id}"/>">Edit</a>
</s:if>

ID:
<s:property value="subject.id" />
<br>
Name:
<s:property value="subject.name" />
<br>
Detail:
<s:property value="subject.detail" />
<br>
<h3>Tasks:</h3>
<s:iterator value="subject.tasks">
	<a href="<s:url value="/tasks/detail"/><s:property value="id"/>" style="float: left; margin-right:10px;">
		<button type="button" class="btn btn-info">
			<s:property value="name" />
		</button>
	</a>

	<s:if test="userFinished == -1">
		<s:form action="/subjects/takeTask" cssClass="custom-form">
			<input type="hidden" name="takeTask.taskId"
				value="<s:property value="id"/>">
			<input type="hidden" name="takeTask.userId"
				value="<s:property value="%{#session.currentUser.id}" />">
			<input type="hidden" name="takeTask.subjectId"
				value="<s:property value="subject.id" />">
			<input type="hidden" name="takeTask.finished" value="0">			
			<input type="submit" value="Start">
		</s:form>
	</s:if>
	<s:else>
		<s:form action="/subjects/updateTask">
			<input type="hidden" name="takeTask.taskId"
				value="<s:property value="id"/>">
			<input type="hidden" name="takeTask.userId"
				value="<s:property value="%{#session.currentUser.id}" />">
			<input type="hidden" name="takeTask.subjectId"
				value="<s:property value="subject.id" />">			
			<select name="takeTask.finished">				
				<option value="0" <s:if test="userFinished == 0">selected</s:if>>Started</option>
				<option value="1" <s:if test="userFinished == 1">selected</s:if>>Finished</option>
			</select>
			<input type="submit" value="Update">
		</s:form>
	</s:else>
	<br>
	<br>
</s:iterator>
<br>
<br>

<s:if test="#session.currentUser.suppervisor == 1">
	<a href="<s:url value="/subjects/delete%{subject.id}" />">Delete</a>
	<a href="<s:url value="/subjects/edit%{subject.id}"/>">Edit</a>
</s:if>

