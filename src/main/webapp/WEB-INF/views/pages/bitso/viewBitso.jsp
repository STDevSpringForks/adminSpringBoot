<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="ui image label">
	<img src="${pageContext.request.contextPath}/resources/images/criptoCurrency/ethereum.png">
	${balanceTotalETH}
</div>
<div class="ui image label">
  <img src="${pageContext.request.contextPath}/resources/images/criptoCurrency/ripple.png">
${balanceTotalXRP}
</div>
<div class="ui image label">
  <img src="${pageContext.request.contextPath}/resources/images/criptoCurrency/bitcoin.png">
${balanceTotalBTC}
</div>
<div class="ui image label">
  <img src="${pageContext.request.contextPath}/resources/images/criptoCurrency/mxn.jpg">
${balanceTotalMXN}
</div>
<div class="ui image label">
   Comisión TOTAL al finalizar los trade: &nbsp;&nbsp; <b>${comisionTOTAL_MXN}</b>
</div>

<div class="ui top attached tabular menu">
    <a class="active item" data-tab="first">Inversión Inicial &nbsp; 
    	<span class="ui teal tag label" >&nbsp;&nbsp;${inversionInicialTotalMXN}</span>
    </a>
    <a class="item" data-tab="second">Ganancia &nbsp; 
    	<span class="ui teal  tag label">&nbsp;&nbsp;${gananciaTotalMXN_MXN}</span>
    </a>
    <a class="item" data-tab="third">Balance Total &nbsp; 
    	<span class="ui teal tag label" >&nbsp;&nbsp;${balanceTotal_MXN}</span>
    </a>
</div>
<div class="ui bottom attached active tab segment" data-tab="first">
<table class="ui sortable celled table">
		<tr>
			<th>ETH</th>
			<th>XRP</th>
			<th>BTC</th>
			<th>MXN</th>
		</tr>
	    <tr>
			<td class="warning" style="text-align: right;" >${inversionInicialETH}</td>
			<td class="warning" style="text-align: right;" >${inversionInicialXRP}</td>
			<td class="warning" style="text-align: right;" >${inversionInicialBTC}</td>
			<td class="warning" style="text-align: right;" >${inversionInicialMXN}</td>
		</tr>
	</table>
  </div>
<div class="ui bottom attached tab segment" data-tab="second">
	<table class="ui sortable celled table">
		<tr>
			<th>ETH</th>
			<th>XRP</th>
			<th>BTC</th>
			<th>MXN</th>
		</tr>
	    <tr>
			<td class="positive" style="text-align: right;" >${gananciaTotal_ETH}</td>
			<td class="negative" style="text-align: right;" >${gananciaTotal_XRP}</td>
			<td class="positive" style="text-align: right;" >${gananciaTotal_BTC}</td>
			<td class="positive" style="text-align: right;" >${gananciaTotal_MXN}</td>
		</tr>
	</table>
</div>
<div class="ui bottom attached tab segment" data-tab="third">
	<table class="ui sortable celled table">
		<tr>
			<th>ETH</th>
			<th>XRP</th>
			<th>BTC</th>
			<th>MXN</th>
		</tr>
	    <tr>
			<td class="positive" style="text-align: right;" >${balanceTotalETH_MXN}</td>
			<td class="negative" style="text-align: right;" >${balanceTotalXRP_MXN}</td>
			<td class="positive" style="text-align: right;" >${balanceTotalBTC_MXN}</td>
			<td class="positive" style="text-align: right;" >${balanceTotalMXN_MXN}</td>
		</tr>
	</table>
</div>

<%--
<table id="example" class="ui celled table sortable" >
    <thead>
        <tr>
         <th>BOOK</th>
            <th>Orden de Venta</th>
            <th>Orden de Compra</th>
            <th>Precio más alto</th>
            <th>Precio más bajo</th>
        </tr>
    </thead>
    <tbody></tbody>
</table>

<div class="ui form">
	<form:form id="formBitso" action="viewBitso" method="post" modelAttribute="formBitsoBalance">
		<div class="ten wide field">
			<p class="msgResult">${msgResult}</p>
			<form:errors path="*" cssClass="errorDiv" element="div"/>
			<div class="field">
				<div class="ui labeled input">
				  <form:input path="precioEspeculativoETH" placeholder="Especular precio ETH en MXN" />
				</div>
			</div>
			<input class="ui basic blue button" type="submit" value="Submit" />
		</div>
	</form:form>
</div>
--%>

<script>
$(document).ready(function() {
	
	/* https://datatables.net/forums/discussion/30540/fn-datatable-render-number-documentation */
	
	$('#example').DataTable({
		data: ${bitsoPayloadList},
		order: [[ 1, "desc" ]],
		columns: [
			{ "data": "book" },
			{ "data": "ask", render: $.fn.dataTable.render.number(',', '.', 2, '$ ') }, 
			{ "data": "bid", render: $.fn.dataTable.render.number(',', '.', 2, '$ ') },
			{ "data": "high", render: $.fn.dataTable.render.number(',', '.', 2, '$ ') },
			{ "data": "low", render: $.fn.dataTable.render.number(',', '.', 2, '$ ') },
// 			{ "data": null, 
//                 render: function(data, type, row){
//              	   return '$ ' + data.low;
//                 } 
//              }
		],
		"fnRowCallback": function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
            if (aData.book.includes("mxn")){
                $('td',nRow).css('background-color', '#7BC0F3');
            }
        }
	}).columns.adjust();
	
	$('.menu .item').tab();
	
});
</script>
