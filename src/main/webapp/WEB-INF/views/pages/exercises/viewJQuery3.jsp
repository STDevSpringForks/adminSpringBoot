<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<img title="Get Width/Height" style="cursor: pointer;" id="imgLogo" alt="spring-logo" src="${pageContext.request.contextPath}/resources/images/spring-logo.png">
	
	<div class="buttonsShowHide">
		<button id="showLogo" >Mostar</button>
		<button id="hideLogo" >Ocultar</button>
	</div>
<script>
$(function(){
	
	fData();
	letFor();
	$('#imgLogo').click(function(){
		alertImg(this);
	});
	
	//Start Efecto botones....
	$('#showLogo').click(function(){
// 		$('#imgLogo').slideDown(2000);
// 		$('#imgLogo').fadeIn(2000);
		$('#imgLogo').animate({
			"height":"240px"
		},1000);
	});
	$('#hideLogo').click(function(){
// 		$('#imgLogo').slideUp(2000);
// 		$('#imgLogo').fadeOut(2000);
		$('#imgLogo').animate({
			"height":"120px"
		},1000);
	});
	//End Efecto botones....
});
// $.when($.ready,$.getScript("${pageContext.request.contextPath}/resources/js/simple-testBORRAR.js")).then(function(){
$.when($.ready,$.getScript("${pageContext.request.contextPath}/resources/js/simple-test.js")).then(function(){
	console.log("Cargo documento JS");
}).catch(function(){
	console.log("No cargo documento JS");
});

function fData(){
	var datosIMG = $('#hideLogo').data('datosIMG');
	console.log("---> 1: ");
	console.log(datosIMG);
	var jsonIMG = {
		uno:1,
		dos:2,
		tres:3
	}
	$('#hideLogo').data('datosIMG',jsonIMG);
	var datosIMG = $('#hideLogo').data('datosIMG');
	console.log("---> 2: ");
	console.log(datosIMG);
}

function alertImg(t){
	var w = t.width();
	var h = t.height();
	alert("ancho: " + w + " alto: " + h);
}

function letFor(){
	var arr = [{
		personas:[
			{	nombre:"Miguel",
				edad:19
			},
			{	nombre:"Esmeralda",
				edad:18
			},
			{	nombre:"Karla",
				edad:21
			}
		]
	}];
	for(let a of arr){
		console.log(a.personas[2]);
		console.log(a.personas[1].edad);
	}
}
</script>