//package com.fd.admin;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobExecutionListener;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
//import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.database.JdbcCursorItemReader;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import com.fd.admin.data_service_api.GoogleMapService;
//import com.fd.admin.model.GeocoderRequest;
//import com.fd.admin.model.GeocoderRequestParams;
//import com.fd.admin.model.GeocoderResult;
//
///**
// * Ejemplo: https://www.youtube.com/watch?v=ssJ8Dd4v-NQ con archivo.
// * @author Muguruza
// *
// */
//@Configuration
//@EnableBatchProcessing
//public class BatchConfiguration {
//
//	private static final String QUERY_FIND_STUDENTS = "SELECT * FROM hibernate_adminspringmvc.geocoderrequest;";
//	
//	@Autowired
//	private GoogleMapService googleMapService;
//	
//    @Bean
//    public ItemReader<GeocoderRequest> reader(DataSource dataSource) {
//        JdbcCursorItemReader<GeocoderRequest> databaseReader = new JdbcCursorItemReader<>();
// 
//        databaseReader.setDataSource(dataSource);
//        databaseReader.setSql(QUERY_FIND_STUDENTS);
//        /*databaseReader.setRowMapper(new BeanPropertyRowMapper<>(GeocoderRequest.class));*/
//        
//        
//        databaseReader.setRowMapper(new RowMapper<GeocoderRequest>() {
//            @Override
//            public GeocoderRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
//            	
//            	GeocoderRequest geocoderRequest = new GeocoderRequest();
//            	geocoderRequest.setIdGeocoderRequest(rs.getInt(1));
//            	geocoderRequest.setAddressLine1(rs.getString(2));
//            	geocoderRequest.setAddressLine2(rs.getString(3));
//            	geocoderRequest.setCity(rs.getString(4));
//            	geocoderRequest.setState(rs.getString(5));
//            	geocoderRequest.setZipCode(rs.getString(6));
//            	geocoderRequest.setCounty(rs.getString(7));
//            	
//            	System.out.println("1. ----------------------------------------");
//            	System.out.println(geocoderRequest);
//            	GeocoderResult geocoderResult = googleMapService.retrieveGeocoding(geocoderRequest);
//            	System.out.println("2. ----------------------------------------");
//            	System.out.println(geocoderRequest);
//            	
//                return geocoderRequest;
//            }
//        });
//        
// 
//        return databaseReader;
//    }
//    
//    
//	/**
//	 * The ItemReader that provides items for processing.  (insert ok)
//	 * @return
//	 */
////     @Bean
////     public ItemReader<GeocoderRequest> reader(){
////    	 FlatFileItemReader<GeocoderRequest> reader = new FlatFileItemReader<GeocoderRequest>();
////    	 reader.setResource(new ClassPathResource("sample-data.csv"));
////    	 reader.setLineMapper(new DefaultLineMapper<GeocoderRequest>(){{
////    		 setLineTokenizer(new DelimitedLineTokenizer(){{
////    			setNames(new String[] {"addressLine1","addressLine2","city","state","zipCode","county"}); 
////    		 }});
////    		 setFieldSetMapper(new BeanWrapperFieldSetMapper<GeocoderRequest>(){{
////    			 setTargetType(GeocoderRequest.class); 
////    		 }});
////    	 }});
////    	 
////    	 return reader;
////     }
//    
//    
//    @Bean
//    public ItemProcessor<GeocoderRequest,GeocoderRequest> processor(){
//    	return new GeocoderRequestItemProccessor();
//    }
//    
//    /**
//     * The ItemWriter that processes the items provided by the ItemReader.
//     * @param dataSource
//     * @return
//     */
//    @Bean
//    public ItemWriter<GeocoderRequest> writer(DataSource dataSource){
//    	JdbcBatchItemWriter<GeocoderRequest> writer = new JdbcBatchItemWriter<GeocoderRequest>();
//    	writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<GeocoderRequest>());
//    	
//    	StringBuilder sbQuery = new StringBuilder();
//    	
//    	/* Ecample with insert OK
//    	sbQuery.append("INSERT INTO hibernate_adminspringmvc.geocoderrequest (addressLine1,addressLine2,city,state,zipCode,county,latitude,longitude) ")
//    		   .append("VALUES (:addressLine1, :addressLine2, :city, :state, :zipCode, :county, :latitude, :longitude) ");
//    	*/
//    	
//    	sbQuery.append("UPDATE hibernate_adminspringmvc.geocoderrequest ")
//    		   .append("set addressLine1 = :addressLine1 ")
//    		   .append(", addressLine2 = :addressLine2 ")
//    		   .append(", city = :city ")
//    		   .append(", state = :state ")
//    		   .append(", zipCode = :zipCode ")
//    		   .append(", county = :county ")
//    		   .append(", latitude = :latitude ")
//    		   .append(", longitude = :longitude ")
//    		   .append("where idGeocoderRequest = :idGeocoderRequest ");
//    	
//    	writer.setSql(sbQuery.toString());
//    	
//    	try {
//    		writer.setDataSource(dataSource);
//        } catch (Exception e) {
//        	e.printStackTrace();
//        }
//    	
//    	return writer;
//    }
//    
//    /**
//     * 
//     * 
//     * chuck The number of items that will be processed before the transaction is committed.
//     * @param stepBuilderFactory
//     * @param reader
//     * @param writer
//     * @param processor
//     * @return
//     */
//    @Bean
//    public Step step1(StepBuilderFactory stepBuilderFactory,
//    		ItemReader<GeocoderRequest> reader,
//    		ItemWriter<GeocoderRequest> writer,
//    		ItemProcessor<GeocoderRequest,GeocoderRequest> processor){
//    	
//    	return stepBuilderFactory.get("step1")
//    			.<GeocoderRequest,GeocoderRequest> chunk(10)
//    			.reader(reader)
//    			.processor(processor)
//    			.writer(writer)
//    			.build();
//    }
//    
//    /**
//     * Mi job se va llamar importEmployeeJob.
//     * SpringBatch tiene sus propias tablas para manejar el procesamiento. (batchdemo)
//     * @param jobs
//     * @param s1
//     * @param listener
//     * @return
//     */
//    @Bean
//    public Job importUserJob(JobBuilderFactory jobs,Step s1,JobExecutionListener listener){
//    	return jobs.get("importGeocodeJob").
//    			incrementer(new RunIdIncrementer())
//    			.listener(listener)
//    			.flow(s1)
//    			.end()
//    			.build();
//    }
//    
//     @Bean
//     public JdbcTemplate jsbcTemplate(DataSource dataSource){
//    	 return new JdbcTemplate(dataSource);
//     }
//    
//    /**
//     * Creando Datasource con referencia a los datos de Hibernate
//     * https://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue
//     * @return
//     * @throws SQLException
//     */
//    @Bean
//    public DataSource datasource() throws SQLException {
//    	
//    	final DriverManagerDataSource dataSource = new DriverManagerDataSource();
//    	dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//    	dataSource.setUrl("jdbc:mysql://localhost:3306/hibernate_adminSpringMVC?useSSL=false&serverTimezone=UTC");
//    	dataSource.setUsername("hbuser");
//    	dataSource.setPassword("hbuser");
//    	
//    	return dataSource;
//    	
//    }
//	
//}
