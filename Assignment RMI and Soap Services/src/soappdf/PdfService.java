package soappdf;

import java.io.File;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface PdfService {
	@WebMethod
	public File getPdf(File ip); 
}
