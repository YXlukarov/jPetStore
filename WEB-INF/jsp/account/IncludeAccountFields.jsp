<h3>Account Information</h3>

<table>
	<tr>
		<td>First name:</td>
		<td><input type="text" name="firstname" value="${sessionScope.account.firstName}"/></td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><input type="text" name="lastname" value="${sessionScope.account.lastName}"/></td>
	</tr>
	<tr>
		<td>Email:</td>
		<td><input size="40" type="text" name="email" value="${sessionScope.account.email}"/></td>
	</tr>
	<tr>
		<td>Phone:</td>
		<td><input type="text" name="phone" value="${sessionScope.account.phone}"/></td>
	</tr>
	<tr>
		<td>Address 1:</td>
		<td><input size="40" type="text" name="address1" value="${sessionScope.account.address1}"/></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><input size="40" type="text" name="address2" value="${sessionScope.account.address2}"/></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><input type="text" name="city" value="${sessionScope.account.city}"/></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><input size="4" type="text" name="state" value="${sessionScope.account.state}"/></td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td><input size="10" type="text" name="zip" value="${sessionScope.account.zip}"/></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><input size="15" type="text" name="country" value="${sessionScope.account.country}"/></td>
	</tr>
</table>

<h3>Profile Information</h3>

<table>
	<tr>
		<td>Language Preference:</td>
		<td>
			<select name="languagePreference">
				<c:if test="${sessionScope.account != null}">
					<option value="${sessionScope.account.languagePreference}">${sessionScope.account.languagePreference}</option>
				</c:if>
				<c:forEach var="language" items="${requestScope.languages}">
					<c:if test="${language != sessionScope.account.languagePreference}">
						<option value="${language}">${language}</option>
					</c:if>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>Favourite Category:</td>
		<td>
			<select name="favouriteCategoryId">
				<c:if test="${sessionScope.account != null}">
					<option value="${sessionScope.account.favouriteCategoryId}">${sessionScope.account.favouriteCategoryId}</option>
				</c:if>
				<c:forEach var="category" items="${requestScope.categories}">
					<c:if test="${category != sessionScope.account.favouriteCategoryId}">
						<option value="${category}">${category}</option>
					</c:if>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>Enable MyList</td>
		<td>
			<c:if test="${sessionScope.account.listOption}">
				<input name="listOption" type="checkbox" value="true" checked/>
			</c:if>
			<c:if test="${sessionScope.account.listOption != true}">
				<input name="listOption" type="checkbox" value="false"/>
			</c:if>
		</td>
	</tr>
	<tr>
		<td>Enable MyBanner</td>
		<td>
			<c:if test="${sessionScope.account.bannerOption}">
				<input name="bannerOption" type="checkbox" value="true" checked/>
			</c:if>
			<c:if test="${sessionScope.account.bannerOption != true}">
				<input name="bannerOption" type="checkbox" value="false"/>
			</c:if>
		</td>
	</tr>

</table>
