package turner.bsbsnd.crypto;

import java.io.File;

/**
 * This is a cryptography program that can encode or decode a file of txt. The incocding is a simply ASCII-shift of 7. Shift 7 
 * upward to encrypt(example:  'A'->'H'), 7 downward to decrypt(example:  'H'->'A').  
 * The actual work occurs in FileTransformer class.
 * 
 * Usage: java BSBSCrypto <operation>, <input file>, <output file>
 * 							operation.  valid values=ENCODE,DECODE.    default:DECODE
 * 							input file default:inputs.txt
 * 							output file default:outputs.txt
 * 
NOTE:  I SUSPECT THERE WAS SOMETHING MISSING/INCORRECT WITH THE TEST DATA I WAS PROVIDED.
 *  * Line 1 of the text decrypts as "oridian".  I suspect that this was intended to be "Noridian"(missing N).
 *  However, if my decryption algorithm is correct, the encrpted input text should have began with U'('N' encrypted), 
 *  but it does not.  
 * 
 * 
 * @author Jonathan Turner
 *
 */
public class BCBSCrypto {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		// input and output file names can be passed on command line to override default values.
		try {
			String inputFilePath="inputs.txt";
			String outputFilePath="outputs.txt";
			String operation="DECODE";
			
			if ((args.length >= 1))
				
			//validate operation parm	
			if ( (args[0].equals("?")) ||
			     (  (!args[0].toUpperCase().equals("DECODE") && !args[0].toUpperCase().equals("ENCODE"))
			     ))
			{
				System.out.println("Usage:  java BSBSCrypto <operation> <input file>, <output file>");
				System.out.println("Usage:  operation.  valid values=ENCODE,DECODE.    default:DECODE");
				System.out.println("Usage:  input file default:inputs.txt");
				System.out.println("Usage:  output file default:outputs.txt");
				System.exit(0);
			}
			
			if (args[0].toUpperCase().equals("DECODE") || args[0].toUpperCase().equals("ENCODE"))
			{
				operation = args[0];
			}
			
			 
			
			//validate input file existence
			if (args.length >= 2)
			{
				inputFilePath=args[0];
				File f = new File ("inputFilePath");
				if (!f.exists())
				{
					System.out.println("Error:  input file " + inputFilePath + " does not exist or is inaccessible.");
					System.exit(0);
				}
			}
			
			if (args.length >= 3)
			{
				outputFilePath=args[1];
			}
			
			
			FileTransformer transformer = new FileTransformer();
			if (operation.equals("DECODE"))
			{
				transformer.decodeFile(inputFilePath,  outputFilePath);
			}
			else if (operation.equals("ENCODE"))
			{
				transformer.encodeFile(inputFilePath,  outputFilePath);
			}
				
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
		}

	}

}
