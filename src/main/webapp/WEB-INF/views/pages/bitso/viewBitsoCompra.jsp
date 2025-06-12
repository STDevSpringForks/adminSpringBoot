<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


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