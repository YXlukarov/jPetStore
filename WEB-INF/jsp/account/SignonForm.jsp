<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<form action="signon" method="post">
	<p>Please enter your username and password.</p>
		<script type="text/javascript">
            function checkImg() {
            	document.getElementById("validateCode").src =
					document.getElementById("validateCode").src+ "?nocache=" + new Date().getTime();
            }
		</script>
	<p>Username:<input type="text" name="username" value="j2ee"/> <br /> <br />
	Password:<input type="password" name="password" value="j2ee"/> <br /> <br />
		CheckImg:<input type="text" name="validateCode"/> <br /></p>
		<br />
        <img alt="验证码看不清，换一张" src="draw" id="validateCode" onclick="checkImg()">
		<a style="font-size: smaller;position: relative;top: -8px;text-decoration: underline" onclick="checkImg()">Change picture</a>
		</p>
		<input type="submit" name="signOn" value="Login"/>
		<br />
		${sessionScope.message}
	</form> Need a user name and password?
	<a href="newAccountForm">Register Now!</a>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>

