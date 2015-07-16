<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="#session.logined == 'true'">
	You have logged!<br>
	<a href="<s:url value="/logout"/>">Logout</a>
</s:if>
<s:else>

	<div id="loginbox" style="margin-top: 50px;"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Login</div>
				<div
					style="float: right; font-size: 80%; position: relative; top: -10px">
					<a href="#">Forgot password?</a>
				</div>
			</div>

			<div style="padding-top: 30px" class="panel-body">

				<div style="display: none" id="login-alert"
					class="alert alert-danger col-sm-12"></div>
				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="msg">${msg}</div>
				</c:if>




				<form name="loginForm" id="loginform" action="dologin" method="POST">

					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span>
						<s:actionmessage />
						<input id="login-username" type="text" class="form-control"
							name="user.email" value="" placeholder="Email">
					</div>

					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-lock"></i></span>
						<s:actionmessage />
						<input id="login-password" type="password" class="form-control"
							name="user.password" placeholder="Password">
					</div>

					<div style="margin-top: 10px" class="form-group">
						<div class="col-sm-12 controls">
							<s:submit value="Login" align="center" />
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
	<s:if test="#session.logined == 'false'">
	Login failed
</s:if>
</s:else>







<!-- 
<s:if test="#session.logined == 'true'">
	You have logged!<br>
	<a href="<s:url value="/logout"/>">Logout</a>
</s:if>
<s:else>
	<s:form action="dologin">
		<s:textfield name="user.email" label="Email" value="" cols="50"
			rows="5" />
		<s:password name="user.password" label="Password" cols="50"
			maxlength="15" />
		<s:submit value="Login" />
	</s:form>

	<s:if test="#session.logined == 'false'">
	Login failed
</s:if>
</s:else>

 -->





