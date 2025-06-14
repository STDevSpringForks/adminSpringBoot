// This example displays an address form, using the autocomplete feature
// of the Google Places API to help users fill in the information.

/* https://developers.google.com/maps/documentation/geocoding/intro?hl=es-419 -> Tipos de dirección y tipos de componentes de dirección */

var placeSearch, autocomplete;
var componentForm = {
  street_number: 'short_name',
  route: 'long_name',
  locality: 'long_name',
  administrative_area_level_1: 'short_name',
  country: 'long_name',
  postal_code: 'short_name'
};

/**
 * Main method, call to load the googleMap.jsp implemented.
 */
function initAutocomplete() {
  // Create the autocomplete object, restricting the search to geographical location types.
  autocomplete = new google.maps.places.Autocomplete((document.getElementById('autocomplete')),{types: ['geocode']});
  // When the user selects an address from the dropdown, populate the address fields in the form.
  autocomplete.addListener('place_changed', fillInAddress);
}

/**
 * autocomplete.getPlace() es creado desde la funcion initAutocomplete
 * la cual fillInAddress se encarga de llenar los input text correspondiente.
 */
function fillInAddress() {
  // Get the place details from the autocomplete object.
  var place = autocomplete.getPlace();

  for (var component in componentForm) {
    document.getElementById(component).value = '';
    document.getElementById(component).disabled = false;
  }

  // Get each component of the address from the place details
  // and fill the corresponding field on the form.
  for (var i = 0; i < place.address_components.length; i++) {
    var addressType = place.address_components[i].types[0];
    if (componentForm[addressType]) {
      var val = place.address_components[i][componentForm[addressType]];
      document.getElementById(addressType).value = val;
    }
  }
}

/**
 * Create map
 */
function initMap() {
  var place = autocomplete.getPlace();
  if(typeof place != "undefined"){
	  var lat = place.geometry.location.lat();
	  var lng = place.geometry.location.lng();
		
	  var location = {lat: lat, lng: lng};

	  var map = new google.maps.Map(document.getElementById('map'), {
	    scaleControl: true,
	    center: location,
	    zoom: 10
	  });

	  var infowindow = new google.maps.InfoWindow;
	  infowindow.setContent('<b>Mapaa!</b>');

	  var marker = new google.maps.Marker({map: map, position: location});
	  marker.addListener('click', function() {
	    infowindow.open(map, marker);
	  });
  }
  
}

//Bias the autocomplete object to the user's geographical location,
//as supplied by the browser's 'navigator.geolocation' object.
//Obteniendo la localizacion del current_usuario browser,
//esto si el usuairo le da permisos de localizacion.
//[Funcion no relevante para places-autocompleFormAddress]
function geolocate() {
	if (navigator.geolocation) {
	 navigator.geolocation.getCurrentPosition(function(position) {
	   var geolocation = {
	     lat: position.coords.latitude,
	     lng: position.coords.longitude
	   };
	   var circle = new google.maps.Circle({
	     center: geolocation,
	     radius: position.coords.accuracy
	   });
	   autocomplete.setBounds(circle.getBounds());
	 });
	}
}

