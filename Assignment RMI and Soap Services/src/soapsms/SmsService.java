package soapsms;

import java.io.File;

import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService
public interface SmsService {
	@WebMethod
	public String sendSms(File ip);
}
