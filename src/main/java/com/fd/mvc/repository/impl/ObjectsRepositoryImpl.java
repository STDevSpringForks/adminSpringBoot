package com.fd.mvc.repository.impl;

import com.fd.mvc.model.SerializableGeneralSearchCriteria;
import com.fd.mvc.model.ObjectsResult;
import com.fd.mvc.repository.JDBCRepository;
import com.fd.mvc.repository.ObjectsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Slf4j
@AllArgsConstructor
@Repository
public class ObjectsRepositoryImpl implements ObjectsRepository {

	private final JDBCRepository jdbcRepository;
	
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
					log.info(dato.toString());
				}
			} 
			rs.close();
			ps.close();
		} catch (Exception e) {
			log.debug("Exception ",e);
		}
		return null;
	}
	
}
