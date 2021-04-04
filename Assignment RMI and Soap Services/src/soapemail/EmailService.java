package soapemail;

import java.io.File;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface EmailService {
	@WebMethod
	public String sendEmail(File ip);
}
