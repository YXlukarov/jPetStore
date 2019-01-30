<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
<form action="newOrder" method="post">

<table>
	<tr>
		<th colspan=2>Payment Details</th>
	</tr>
	<tr>
		<td>Card Type:</td>
		<td>
			<select name="cardType">
				<c:forEach var="card" items="${sessionScope.cardList}">
					<option value="${card}">${card}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>Card Number:</td>
		<td><input type="text" value="${sessionScope.order.creditCard}" name="creditCard"/> * Use a fake
		number!</td>
	</tr>
	<tr>
		<td>Expiry Date (MM/YYYY):</td>
		<td><input type="text" value="${sessionScope.order.expiryDate}" name="expiryDate"/></td>
	</tr>
	<tr>
		<th colspan=2>Billing Address</th>
	</tr>

	<tr>
		<td>First name:</td>
		<td><input type="text" value="${sessionScope.order.billToFirstName}" name="billToFirstName"/></td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><input type="text" value="${sessionScope.order.billToLastName}" name="billToLastName"/></td>
	</tr>
	<tr>
		<td>Address 1:</td>
		<td><input size="40" type="text" value="${sessionScope.order.billAddress1}" name="billAddress1"/></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><input size="40" type="text" value="${sessionScope.order.billAddress2}" name="billAddress2"/></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><input type="text" value="${sessionScope.order.billCity}" name="billCity"/></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><input type="text" value="${sessionScope.order.billState}" name="billState"/></td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td><input type="text" size="10" value="${sessionScope.order.billZip}" name="billZip"/></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><input type="text" size="15" value="${sessionScope.order.billCountry}" name="billCountry"/></td>
	</tr>

	<tr>
		<td colspan=2>
			<input type="checkbox" value="true" name="shippingAddressRequired" />
		Ship to different address...
		</td>
	</tr>

</table>

<input type="submit" name="newOrder" value="Continue"/>

</form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>