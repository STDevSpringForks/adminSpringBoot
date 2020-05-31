package com.fd.mvc.admin.data_service.repository.impl;

import com.fd.mvc.admin.data_service.repository.JDBCRepository;
import com.fd.mvc.admin.data_service.repository.ObjectsRepository;
import com.fd.mvc.admin.model.criteria.SerializableGeneralSearchCriteria;
import com.fd.mvc.admin.model.result.ObjectsResult;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@AllArgsConstructor
@Repository
public class ObjectsRepositoryImpl implements ObjectsRepository {

	private final JDBCRepository jdbcRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ObjectsRepositoryImpl.class);

	@Override
	public ObjectsResult retrieveObjects() {
		
		Connection conn = jdbcRepository.getConnectionJDBC();
		
		try {
			// La consulta y bucle para recorrer resultados
			PreparedStatement ps = conn.prepareStatement("select * from objetos");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// Se obtiene el campo blob
				Blob blob = rs.getBlob("objeto");

				// Se reconstruye el objeto con un ObjectInputStream
				ObjectInputStream ois = new ObjectInputStream(blob.getBinaryStream());
				SerializableGeneralSearchCriteria dato = (SerializableGeneralSearchCriteria) ois.readObject();
				System.out.println(dato);
				if(dato != null){
					LOGGER.info(dato.toString());
				}
			} 
			rs.close();
			ps.close();
		} catch (Exception e) {
			LOGGER.debug("Exception ",e);
		}
		return null;
	}
	
}