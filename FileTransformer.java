package turner.bsbsnd.crypto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Encrypt or decrypt a file using a  character shift algorithm.
 * each character is shifted +7 to encrypt and -7 to decrypt.
 * 
 * NOTE:  I SUSPECT THERE WAS SOMETHING MISSING/INCORRECT WITH THE TEST DATA I WAS PROVIDED.
 *  * Line 1 of the text decrypts as "oridian".  I suspect that this was intended to be "Noridian"(missing N).
 *  However, if my decryption algorithm is correct, the encrpted input text should have began with U'('N' encrypted), 
 *  but it does not.
 * 
 * 
 * @author Jonathan Turner
 *
 */
public class FileTransformer {
	
	
	/** helper method
	 * @param inputFile
	 * @param outputFile
	 * @return
	 */
	public boolean decodeFile(String inputFile, String outputFile)
	{
		return transformFile(true,inputFile,outputFile);
	}
	
	/** helper method
	 * @param inputFile
	 * @param outputFile
	 * @return
	 */
	public boolean encodeFile(String inputFile, String outputFile)
	{
		return transformFile(false,inputFile,outputFile);
	}	
		
   /**
    * encode or decode a file.  Algorithm is a "shift" type.  Add or subtract 7 to/from  character codes.
    * 
    * 
 * @param boolean decode - true if decoding, false id encrypting.
 * @param inputFile
 * @param outputFile
 * @return
 */
private boolean transformFile(boolean decode, String inputFile, String outputFile)
	{
	try {
		
		// open the input and output files
	   FileInputStream inStream = new FileInputStream(inputFile);
		FileOutputStream outStream = new FileOutputStream(outputFile);
		
		// read  the contents of the input file into a byte array.
		byte[] bytes = new byte[inStream.available()];
		inStream.read(bytes);
		String inputString= new String(bytes);
		String outputString="";
		
		//   // iterate through the bytes and transform each character by subtracting 7 from its value as an it, skipping the EOL characters.
		for (int i=0;i<bytes.length;i++)
		{
			char oldChar = inputString.charAt(i);
			int  newChar= oldChar;
					
			if ((newChar != 13) &&( newChar !=10))
			{
				if (decode== true)
				  newChar= oldChar -7;
				else
				  newChar= oldChar +7;
			}
			
			outputString += (char)newChar;
		}
		
		//write out the result and close files.
		outStream.write(outputString.getBytes());
		inStream.close();
		outStream.close();
		
		} 
   
   catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
		}
		
		return true;
	}
		



}
