/**
 * 
 */
package edu.ics211.h03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author isaac
 *
 */
public class ReadFile implements IReadFile {

  @Override
  public String readFile(String fileName) throws IOException {
    // TODO Auto-generated method stub
    String str = null;
    //Wrap a FileInputStream with a DataInputStream
    DataInputStream in = new DataInputStream(new FileInputStream(fileName));
    //read in the number of bytes: an int
    int numBytes = in.readInt();
    //read in the encoding: a byte
    int encodeType = in.readByte();
    //create a byte[] of the right size
    byte[] byteArr = new byte[numBytes];
    //fill the byte[]
    for (int i = 0; i < numBytes; i++) {
      byteArr[i] = in.readByte();
    }
    if (encodeType == 1) {
      str = new String(byteArr, StandardCharsets.US_ASCII);
    }
    else if (encodeType == 2) {
      str = new String(byteArr, StandardCharsets.UTF_16LE);
    }
    else if (encodeType == 3) {
      str = new String(byteArr, StandardCharsets.UTF_8);
    }
    else if (encodeType == 4) {
      str = new String(byteArr, StandardCharsets.UTF_16);
    }
    in.close();
    //depending on the encoding return a new String
    return str;
  }

}
