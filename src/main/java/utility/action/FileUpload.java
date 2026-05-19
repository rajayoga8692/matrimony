package utility.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.core.header.ContentDisposition;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataParam;


@Path("/file")
public class FileUpload {
	
	ResourceBundle bundle = ResourceBundle.getBundle("serversetup");
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@POST
	@Path("/upload/{dynfolder}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response uploadFile(@FormDataParam("files") List<FormDataBodyPart> files,@PathParam("dynfolder") String dynfolder ) {

		Date date = new Date();
		List list =new ArrayList();

		try{
   	 	String dir = bundle.getString("serverpath");
   	 	String filename;
   	 	String tbPath=dynfolder;
   	 	File f=new File(dir+tbPath);
     
   	 	
   	 	if(!f.exists())
   	 		f.mkdirs();
   	 
		long l=10;
		for (int i = 0; i < files.size(); i++) {
			FormDataBodyPart this_formDataBodyPartFile = files.get(i);
			ContentDisposition this_contentDispositionHeader = this_formDataBodyPartFile.getContentDisposition();
			InputStream this_fileInputStream = this_formDataBodyPartFile.getValueAs(InputStream.class);
			FormDataContentDisposition fileDetail=(FormDataContentDisposition) this_contentDispositionHeader;
			
			date = new Date();
      	  	filename=Long.toString(date.getTime()+(l++));
      	  	String name =  fileDetail.getFileName();
      	  	String type= name.substring(name.lastIndexOf("."),name.length());
      	  	
      	  	String joinPath=tbPath + "/" +filename+type;
      	  	
      	  	HashMap<String, String> hm = new HashMap<String, String>();
      	  	System.out.println("print paths "+joinPath);
			hm.put("path", ""+joinPath);
			hm.put("name", ""+name);
			
			
      	  	writeToFile(this_fileInputStream, dir+joinPath);
			
			list.add(hm);
		};
		
		}catch (Exception e){
			e.printStackTrace();
		}
		

		return Response.status(200).entity(list).build();

	}
	
	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream,
		String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	
	

}