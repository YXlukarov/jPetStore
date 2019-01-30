<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/4 0004
  Time: 上午 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeTop.jsp"%>
<div id="Welcome">
    <div id="WelcomeContent">
        <c:if test="${sessionScope.account == null}">
            <a style="font-family: Broadway">Welcome to MyPetStore!</a>
        </c:if>
        <c:if test="${sessionScope.account != null}">
            Welcome ${sessionScope.account.firstName}!
        </c:if>
    </div>
</div>

<div id="Main">
    <div id="Sidebar">
        <div id="SidebarContent">
            <a href="viewCategory?categoryId=FISH"><img src="images/fish_icon.gif" /></a>
            <br/><em style="font-family: 'Comic Sans MS';text-decoration-color: black"> Saltwater, Freshwater </em><br/><br/>
            <a href="viewCategory?categoryId=DOGS"><img src="images/dogs_icon.gif" /></a>
            <br /><em style="font-family: 'Comic Sans MS';text-decoration-color: black"> Various Breeds </em><br /><br/>
            <a href="viewCategory?categoryId=CATS"><img src="images/cats_icon.gif" /></a>
            <br /><em style="font-family: 'Comic Sans MS';text-decoration-color: black"> Various Breeds, Exotic Varieties </em><br /><br/>
            <a href="viewCategory?categoryId=REPTILES"><img src="images/reptiles_icon.gif" /></a>
            <br /><em style="font-family: 'Comic Sans MS';text-decoration-color: black"> Lizards, Turtles, Snakes </em><br /><br/>
            <a href="viewCategory?categoryId=BIRDS"><img src="images/birds_icon.gif" /></a>
            <br /><em style="font-family: 'Comic Sans MS';text-decoration-color: black"> Exotic Varieties </em>
        </div>
    </div>

    <div id="MainImage">
        <div id="MainImageContent">
            <map name="estoremap">
                <area alt="Birds" coords="72,2,280,250" href="viewCategory?categoryId=BIRDS" shape="rect" />
                <area alt="Fish" coords="2,180,72,250" href="viewCategory?categoryId=FISH" shape="rect" />
                <area alt="Dogs" coords="60,250,130,320" href="viewCategory?categoryId=DOGS" shape="rect" />
                <area alt="Reptiles" coords="140,270,210,340" href="viewCategory?categoryId=REPTILES" shape="rect" />
                <area alt="Cats" coords="225,240,295,310" href="viewCategory?categoryId=CATS" shape="rect" />
                <area alt="Birds" coords="280,180,350,250" href="viewCategory?categoryId=BIRDS" shape="rect" />
            </map>
            <img height="355" src="images/splash.gif" align="middle" usemap="#estoremap" width="350" />
        </div>
    </div>
    <div id="Separator">&nbsp;</div>
</div>
<%@ include file="../common/IncludeBottom.jsp"%>
