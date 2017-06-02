<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="ui form">
	<form:form id="formBitso" action="viewBitso" method="post" modelAttribute="formBitsoBalance">
		<div class="ten wide field">
			<p class="msgResult">${msgResult}</p>
			<form:errors path="*" cssClass="errorDiv" element="div"/>
			<div class="field">
				<label for="balanceETH">Balance ETH</label>
				<div class="ui labeled input">
				  <form:input path="balanceETH" />
				</div>
			</div>
			<div class="field">
				<label for="balanceXRP">Balance XRP</label>
				<div class="ui labeled input">
				  <form:input path="balanceXRP" />
				</div>
			</div>
			<div class="field">
				<label for="balanceBTC">Balance BTC</label>
				<div class="ui labeled input">
				  <form:input path="balanceBTC" />
				</div>
			</div>
			<input class="ui basic blue button" type="submit" value="Submit" />
		</div>
	</form:form>
</div>

<table id="example" class="ui celled table" >
     <thead>
         <tr>
             <th>high</th>
             <th>last</th>
             <th>created_at</th>
             <th>book</th>
             <th>volume</th>
             <th>vwap</th>
             <th>low</th>
             <th>VENTA (ask)</th>
             <th>COMPRA (bid)</th>
         </tr>
     </thead>
     <tfoot>
         <tr>
             <th>high</th>
             <th>last</th>
             <th>created_at</th>
             <th>book</th>
             <th>volume</th>
             <th>vwap</th>
             <th>low</th>
             <th>VENTA (ask)</th>
             <th>COMPRA (bid)</th>
         </tr>
     </tfoot>
     <tbody>
        
     </tbody>
 </table>

<script>
$(document).ready(function() {
	$('#example').DataTable({
		"destroy": true,
		"searching": false,
		"processing": true,
        "serverSide": false,
		"pageLength": 10,
		"dom" : '<t><"bottom"ilp>',
		"order": [[ 0, "desc" ]],
		"language":{
			"paginate": {
				"first":" ",
		      	"previous": " ",
		      	"next":" ",
		      	"last":" "
		    },
		    "emptyTable": "Falla en Bitso"
		},
		"ajax": {
			"type": "POST",
			"url": "getPayload",
			"contentType": "application/json",
			"dataSrc": function(json) {
				return json.bitsoPayloadList;
			},
			"dataType": "json",
			"data": function(d) {
				var paramMap = {};
				paramMap.vehicleNumber = "${vehicleNumber}",
				paramMap.clientNumber = "${clientNumber}"

				return JSON.stringify(paramMap);
			},
		},
		"columns": [
			{ "data": "high" }, 
			{ "data": "last" }, 
			{ "data": "created_at" }, 
			{ "data": "book" }, 
			{ "data": "volume" }, 
			{ "data": "vwap" }, 
			{ "data": "low" }, 
			{ "data": "ask" }, 
			{ "data": "bid"}, 
		],
	}).columns.adjust();
});
</script>