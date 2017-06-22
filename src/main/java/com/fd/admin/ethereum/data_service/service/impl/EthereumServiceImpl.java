package com.fd.admin.ethereum.data_service.service.impl;

import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import com.fd.admin.ethereum.data_service.service.EthereumService;

/**
 * 
 * @author Muguruza
 *
 */
@Service("ethereumServiceImpl")
public class EthereumServiceImpl implements EthereumService {

	@Override
	public void ethereumWeb3jTest() {
		
		Web3j web3j = Web3j.build(new HttpService()); //default localhost:8545
		try{
			Web3ClientVersion clientVersion = web3j.web3ClientVersion().sendAsync().get();
			System.out.println("Version del cliente web3j: " + clientVersion.getWeb3ClientVersion());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
