<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<table id="example" class="ui celled table sortable" >
    <thead>
        <tr>
            <th>BOOK</th>
            <th>Precio de compra</th>
            <th>Monto a comprar</th>
        </tr>
    </thead>
    <tbody></tbody>
</table>

<script>
$(document).ready(function() {
	
	/* https://datatables.net/forums/discussion/30540/fn-datatable-render-number-documentation */
	
	$('#example').DataTable({
		data: ${orderBookResult},
		order: [[ 1, "desc" ]],
		columns: [
			{ "data": "book" },
			{ "data": "price", render: $.fn.dataTable.render.number(',', '.', 2, '$ ') }, 
			{ "data": "amount", render: $.fn.dataTable.render.number(',', '.', 10, '') },
		],
		"fnRowCallback": function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
            if (aData.amount > 5.0){
                $('td',nRow).css('background-color', '#CCCC99');
            }
        }
	}).columns.adjust();
	
	$('.menu .item').tab();
	
});
</script>