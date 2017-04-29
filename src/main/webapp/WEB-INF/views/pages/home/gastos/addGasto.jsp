<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<div class="ui form">
		<form id="formGasto" action="addGasto"  method="POST" enctype="multipart/form-data" >
			<div class="ten wide field">
				<div class="field">
					<label for="tipoGasto">Tipo de Gasto</label>
					<input type="text" name="tipoGasto" placeholder="Tipo de Gasto"  />
				</div>
				<div class="field">
					<label for="monto">Monto</label>
					<input type="text" name="monto" placeholder="Monto"  />
				</div>
				<div class="field">
					<label for="descripcion">Descripción</label>
					<input type="text" name="descripcion" placeholder="Descripción"  />
				</div>
				<div class="field">
					<label for="fileComprobante">Comprobante</label>
					<input type="file" name="fileComprobante" />
				</div>
				<input class="ui basic blue button" type="submit" value="Submit" />
			</div>
		</form>

	</div>
<script>
	$(function(){
		
	});
</script>