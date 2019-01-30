<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
<form action="shippingForm" method="post">

<table>
	<tr>
		<th colspan=2>Shipping Address</th>
	</tr>

	<tr>
		<td>First name:</td>
		<td><input type="text" value="${sessionScope.order.shipToFirstName}" name="shipToFirstName"/></td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><input type="text" value="${sessionScope.order.shipToLastName}" name="shipToLastName"/></td>
	</tr>
	<tr>
		<td>Address 1:</td>
		<td><input type="text" size="40" value="${sessionScope.order.shipAddress1}" name="shipAddress1"/></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><input type="text" size="40" value="${sessionScope.order.shipAddress2}" name="shipAddress2"/></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><input type="text" value="${sessionScope.order.shipCity}" name="shipCity"/></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><input type="text" size="4" value="${sessionScope.order.shipState}" name="shipState"/></td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td><input type="text" size="10" value="${sessionScope.order.shipZip}" name="shipZip"/></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><input type="text" size="15" value="${sessionScope.order.shipCountry}" name="shipCountry"/></td>
	</tr>


</table>

<input type="submit" name="newOrder" value="Continue"/>

</form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>