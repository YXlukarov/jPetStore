<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/4 0004
  Time: 上午 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <link rel="StyleSheet" href="css/jpetstore.css" type="text/css" media="screen" />
    <script language="JavaScript" src="js/Search.js"></script>
    <script src="js/jquery-3.3.1.js"></script>
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

        function findPro() {
            var proKey = document.search.keyword.value;
            sendRequest("find?keyword=" + proKey);
        }

        function sendRequest(url) {
            createXMLHttpRequest();
            xmlHttpRequest.open("GET",url,true);
            xmlHttpRequest.onreadystatechange = processResponse;
            xmlHttpRequest.send();
        }

        function hideSearch() {
            var div2 = document.getElementById("context");
            div2.style.cssText = "display:none;";
        }

        function processResponse() {
            if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
                var responseInfo = "";
                responseInfo += xmlHttpRequest.responseXML.getElementsByTagName("msg").item(0).innerHTML;
                var div1 = document.getElementById("context");
                var td = document.getElementsByClassName("searchFill");
                var info = responseInfo.split(",",5);
                for (var i=0;i<info.length;i++) {
                    td[i].innerHTML = "<td style='width: 120px;background-color: white;' onclick='setSearch_onclick(this);' on onmouseout='changeBackColor_out(this)' onmouseover='changeBackColor_over(this)'>"+info[i]+"</td>";
                }
                if (responseInfo == null) {
                    hideSearch();
                } else {
                    div1.style.cssText = "display:block;";
                }
            }
        }

        //鼠标移动到内容上
        function changeBackColor_over(td){
            $(td).css("background-color","#CCCCCC");
        }
        //鼠标离开内容
        function changeBackColor_out(td){
            $(td).css("background-color","white");
        }
        //将点击的内容放到搜索框
        function setSearch_onclick(td){
            var selected = $(td).text();
            $(".inputtable").val(selected);
            $("#context").css("display","none");
        }
    </script>
    <meta name="generator" content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org" />
    <title>MyPetStore</title>
    <meta content="text/html; charset=windows-1252"
          http-equiv="Content-Type" />
    <meta http-equiv="Cache-Control" content="max-age=0" />
    <meta http-equiv="Cache-Control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
    <meta http-equiv="Pragma" content="no-cache" />
</head>

<body>

<div id="Header">

    <div id="Logo">
        <div id="LogoContent">
            <a href="main"><img src="images/logo-topbar.gif" /></a>
        </div>
    </div>

    <div id="Menu">
        <div id="MenuContent">
            <a href="viewCart"><img align="middle" name="img_cart"
                                    src="images/cart.gif" /></a>
            <img align="middle" src="images/separator.gif" />
            <c:if test="${sessionScope.account == null}">
                <a href="signonForm">Sign In</a>
            </c:if>
            <c:if test="${sessionScope.account != null}">
                <a href="signoff">Sign Out</a> <img align="middle" src="images/separator.gif" />
                <a href="editAccountForm">My Account</a> <img align="middle" src="images/separator.gif" />
            </c:if>
            <a href="../../../help.html">?</a>
        </div>
    </div>

    <div id="Search">
        <div id="SearchContent">
            <form name="search" action="searchProducts" method="post">
                <input type="text" name="keyword" class="inputtable" size="14" onkeyup="findPro();" /> <input type="submit"
                                                                      name="searchProducts" value="Search" />
                <div id="context">
                    <table class="acc">
                        <tr class="searchFill"></tr>
                        <tr class="searchFill"></tr>
                        <tr class="searchFill"></tr>
                        <tr class="searchFill"></tr>
                        <tr class="searchFill"></tr>
                        <tr><td style='width: 120px;background-color: white;text-align: right;text-decoration: underline;text-decoration-color: #003399;' onclick='hideSearch();' >close</td></tr>
                    </table>
                </div>
            </form>
        </div>
    </div>

    <div id="QuickLinks">
        <a href="viewCategory?categoryId=FISH">
            <img src="images/sm_fish.gif" />
        </a>
        <img src="images/separator.gif" />

        <a href="viewCategory?categoryId=DOGS">
            <img src="images/sm_dogs.gif" />
        </a>
        <img src="images/separator.gif" />

        <a href="viewCategory?categoryId=REPTILES">
            <img src="images/sm_reptiles.gif" />
        </a>
        <img src="images/separator.gif" />

        <a href="viewCategory?categoryId=CATS">
            <img src="images/sm_cats.gif" />
        </a>
        <img src="images/separator.gif" />

        <a href="viewCategory?categoryId=BIRDS">
            <img src="images/sm_birds.gif" />
        </a>
    </div>

</div>
<div id="Content"><c:if test="${requestScope.message != null}"><ul class="messages"><li>${requestScope.message}</li></ul></c:if>
</body>
</html>
