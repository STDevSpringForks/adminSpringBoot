<%@ include file="/WEB-INF/views/includes/header.jsp" %>
	<div id="locationField">
		<input id="autocomplete" placeholder="Enter your address" type="text"></input>
	</div>
	<table id="address">
		<tr>
			<td class="label">Street address</td>
			<td class="slimField"><input class="field" id="street_number"
				disabled="disabled"></input></td>
			<td class="wideField" colspan="2"><input class="field"
				id="route" disabled="disabled"></input></td>
		</tr>
		<tr>
			<td class="label">City</td>
			<td class="wideField" colspan="3"><input class="field"
				id="locality" disabled="disabled"></input></td>
		</tr>
		<tr>
			<td class="label">State</td>
			<td class="slimField"><input class="field"
				id="administrative_area_level_1" disabled="disabled"></input></td>
			<td class="label">Zip code</td>
			<td class="wideField"><input class="field" id="postal_code"
				disabled="disabled"></input></td>
		</tr>
		<tr>
			<td class="label">Country</td>
			<td class="wideField" colspan="3"><input class="field"
				id="country" disabled="disabled"></input></td>
		</tr>
	</table>
	<div id="map"></div>
<script src="${pageContext.request.contextPath}/resources/js/googleMaps/places-autocomplete-addressform.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD1LbckIQe3RQf7eN0cvOkuttwSrGfqCDg&libraries=places&callback=initAutocomplete" async defer></script>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
