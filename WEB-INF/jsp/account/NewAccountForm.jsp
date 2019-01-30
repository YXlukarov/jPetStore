<%@ include file="../common/IncludeTop.jsp"%>
<script type="text/javascript">
    var xmlHttpRequest;
    function createXMLHttpRequest() {
        if (window.XMLHttpRequest) {
            xmlHttpRequest = new XMLHttpRequest();
        }
        else if (window.ActiveXObject){
            xmlHttpRequest = new ActiveXObject("Msxm12.XMLHTTP");
        }
        else {
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }

    function usernameIsExist() {
        var un = document.registerForm.username.value;
        sendRequest("usernameIsExist?username=" + un);
    }

    function sendRequest(url) {
        createXMLHttpRequest();
        xmlHttpRequest.open("GET",url,true);
        xmlHttpRequest.onreadystatechange = processResponse;
        xmlHttpRequest.send(null);
    }

    function processResponse() {
        if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
            var responseInfo = xmlHttpRequest.responseXML.getElementsByTagName("msg")[0].childNodes[0].data;
            console.info(responseInfo);
            var div1 = document.getElementById("usernameMsg");
            if (responseInfo == "Exist"){
                div1.innerHTML = "<font color='red'>Username invalid</font>";
            }else {
                div1.innerHTML = "<font color='green'>Username valid</font>";
            }
        }
    }

</script>
<div id="Catalog">
	<form action="newAccount" method="post" name="registerForm" >

	<h3>User Information</h3>

        <table>
		<tr>
			<td>User ID:</td>
			<td>
                <input type="text" id="username" name="username" onblur="usernameIsExist();" />
                <div id="usernameMsg"></div>
            </td>

		</tr>
		<tr>
			<td>New password:</td>
			<td><input type="text" name="password"/></td>
		</tr>
		<tr>
			<td>Repeat password:</td>
			<td><input type="text" name="repeatedPassword"/></td>
		</tr>
	</table>
	<%@ include file="IncludeAccountFields.jsp"%>

	<input type="submit" name="newAccount" value="Save Account Information"/>

	</form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>