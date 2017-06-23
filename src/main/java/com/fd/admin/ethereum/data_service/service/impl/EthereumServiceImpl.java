package com.fd.admin.ethereum.data_service.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.exceptions.TransactionTimeoutException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import com.fd.admin.ethereum.data_service.service.EthereumService;

/**
 * 
 * @author Muguruza
 * https://github.com/ethereum/go-ethereum/wiki/geth
 * Run (windows) geth --fast --cache=512 --rpcapi personal,db,eth,net,web3 --rpc —testnet
 * https://docs.web3j.io/
 * 
 * URL: Blockchain test :: https://testnet.etherscan.io/
 * https://www.youtube.com/watch?v=ea3miXs_P6Y
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

	@Override
	public String sendingEther() {
		String result = "Funds transfer completed";
		Web3j web3j = Web3j.build(new HttpService());
		Credentials credentials = null;
		try {
			credentials = WalletUtils.loadCredentials("password","/path/to/walletfile");
		} catch (IOException | CipherException e) {
			e.printStackTrace();
			result = "error to sendingEther";
		}	
		String toAddressExample = "0xaca0cc3a6bf9552f2866ccc67801d4e6aa6a70f2"; /* "0x<to address>"; */
		BigDecimal value = BigDecimal.valueOf(0.2);
		
		try {
			if(credentials != null){
				TransactionReceipt transactionReceipt = Transfer.sendFundsAsync(web3j, credentials, toAddressExample, value, Convert.Unit.ETHER).get();
			}
		} catch (InterruptedException | ExecutionException | TransactionTimeoutException e) {
			e.printStackTrace();
			result = "error to sendingEther";
		}
		
		return result;
	}
	
	

}
