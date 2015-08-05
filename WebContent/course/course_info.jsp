<%@ taglib prefix="s" uri="/struts-tags"%>

<h2>
	Course
	<s:property value="course.name" />
	<br>
</h2>
ID:
<s:property value="course.id" />
<br>
Name:
<s:property value="course.name" />
<br>
Detail:
<s:property value="course.detail" />
<br>
<form></form>
<a href="<s:url value="/courses/delete%{course.id}"/>">Delete</a>
<a href="<s:url value="/courses/edit%{course.id}"/>">Edit</a>
<br>
<br>
<h3>
	Subject in course:<br>
</h3>
<s:if test="course.getSubjectCourses().size()>0">
	<br>
	<s:iterator value="course.subjectCourses">
		<a
			href="<s:url value="/subjects/detail"/><s:property value="subject_id"/>">
			<button type="button" class="btn btn-info">
				<s:property value="subjects.name" />
			</button>
		</a>
	</s:iterator>
</s:if>
<s:else>
	<br>
	<br>
	<div class="alert alert-info" role="alert">
		<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
		<span class="sr-only">Error:</span> This Course hasn't subject! :D
	</div>
</s:else>