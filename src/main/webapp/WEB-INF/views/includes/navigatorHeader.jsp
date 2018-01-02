<div class="mainMenu">
	<div class="ui menu">
		<a href="${pageContext.request.contextPath}/" class="item"><i class="home icon"></i> Home </a>
		<a class="browse item">Browse <i class="dropdown icon"></i></a>
		<div class="ui fluid popup bottom left transition hidden"
			style="top: 554px; left: 1px; bottom: auto; right: auto; width: 670px;">
			<div class="ui four column relaxed divided grid">
				<div class="column">
					<h4 class="ui header">Catalog</h4>
					<div class="ui link list">
						<a href="${pageContext.request.contextPath}/person/viewPerson" class="item"><span style="color: orange;">(wip) </span>Person</a>
						<a href="${pageContext.request.contextPath}/contact/viewContact" class="item"><span style="color: orange;">(wip) </span>Contact Form</a>
						<a href="${pageContext.request.contextPath}/modules/finance/viewFinance" class="item"><span style="color: orange;">(wip) </span>Finance</a>
						<a href="${pageContext.request.contextPath}/streams/exStreams" class="item">exStreams</a>
					</div>
				</div>
				<div class="column">
					<h4 class="ui header">Ejemplos</h4>
					<div class="ui link list">
						<a href="${pageContext.request.contextPath}/escuela/areaTriangulo" class="item">Area Triangulo</a>
						<a href="${pageContext.request.contextPath}/files/addTextToFile" class="item">RandomAccessFile</a>
						<a class="item">Large</a>
						<a class="item">Plus Sizes</a>
					</div>
				</div>
				<div class="column">
					<h4 class="ui header">Utils</h4>
					<div class="ui link list">
						<a href="${pageContext.request.contextPath}/twilio/viewTiwilioSMS" class="item">Twilio</a>
						<a href="${pageContext.request.contextPath}/home/gastos/addGasto" class="item"><span style="color: red;">(new) </span>Añadir Gasto</a>
						<a href="${pageContext.request.contextPath}/java8/javalambda1" class="item"><span style="color: red;">(new) </span>Java 8</a>
						<a href="${pageContext.request.contextPath}/java8/javaListIterator" class="item"><span style="color: red;">(new) </span>javaListIterator</a>
						<a href="${pageContext.request.contextPath}/java8/javaMultiArray" class="item">Java 8 MultiArray</a>
						<a href="${pageContext.request.contextPath}/java8/ordenarLista" class="item">Java 8 OrdenarLista</a>
						<a href="${pageContext.request.contextPath}/java8/funcionesJava" class="item">funcionesJava</a>
						<a href="${pageContext.request.contextPath}/java8/java8Testing" class="item">java8Testing</a>
						<a class="item">...</a>
					</div>
				</div>
				<div class="column">
					<h4 class="ui header">Exercises</h4>
					<div class="ui link list">
						<a href="${pageContext.request.contextPath}/exercises/viewPalindrome" class="item"><span style="color: orange;">(wip) </span>Palindromo</a> 
						<a href="${pageContext.request.contextPath}/exercises/viewSerializable" class="item"><span style="color: orange;">(wip) </span>Serialize</a>
						<a href="${pageContext.request.contextPath}/googleMaps/placeAutocompleteAddressForm" class="item"><span style="color: orange;">(wip) </span>Google Map API</a>
						<a href="${pageContext.request.contextPath}/reports/viewJasperReport" class="item"><span style="color: red;">(new) </span>Jasper Repors</a>
						<a href="${pageContext.request.contextPath}/email/viewSendEmailTest" class="item"><span style="color: orange;">(wip) </span>Send Email</a>
						<a href="${pageContext.request.contextPath}/exercises/viewJQuery3" class="item"><span style="color: orange;">(wip) </span>JQuery3</a>
						<a href="${pageContext.request.contextPath}/ejerciciosProgramacion/viewEjercicios" class="item">Ejercicios Programción</a>
					</div>
				</div>
				<div class="column">
					<h4 class="ui header">Bitso</h4>
					<div class="ui link list">
						<a href="${pageContext.request.contextPath}/bitso/viewBitso" class="item">Bitso</a>
						<a href="${pageContext.request.contextPath}/bitso/viewBitsoOrderBook" class="item">Bitso Order Book</a>
						<a href="${pageContext.request.contextPath}/ethereum/viewEthereum" class="item">Ethereum</a>
					</div>
				</div>
				<div class="column">
					<h4 class="ui header">Personal</h4>
					<div class="ui link list">
						<a href="${pageContext.request.contextPath}/personal/socialNetwork/viewSocialNetwork" class="item">View Social Network</a>
					</div>
				</div>
				<div class="column">
					<h4 class="ui header">Testing API</h4>
					<div class="ui link list">
						<a href="${pageContext.request.contextPath}/api/viewMapBox" class="item">View MapBox</a>
						<a href="${pageContext.request.contextPath}/viewTwitterHome" class="item">View Twitter</a>
					</div>
				</div>
			</div>
		</div>
		<a class="item"><i class="cart icon"></i> Checkout </a>
		<a class="right item"><i class="sign in icon"></i> Sign in </a>
	</div>
</div>
<div class="ui secondary menu">
	<div class="item">
		<a href="${pageContext.request.contextPath}/">Home</a>&nbsp;>&nbsp;<a id="btitle" href="#"></a>
	</div>
</div>
<script>
	$('.mainMenu .menu .browse').popup({
		inline : true,
		hoverable : true,
		position : 'bottom left',
		delay : {
			show : 300,
			hide : 800
		}
	});
</script>