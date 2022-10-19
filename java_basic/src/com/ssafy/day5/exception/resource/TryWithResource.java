package com.ssafy.day5.exception.resource;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @since 2021. 7. 8.
 */
public class TryWithResource {

    public static void main(String[] args) {
        TryWithResource test = new TryWithResource();
        test.useStream();
        test.useStreamNewStye();

    }


    public void useStream() {
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream("abc.txt");
            fileInput.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInput != null) {
                try {
                    fileInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void useStreamNewStye() {
        // TODO: useStream을 try~with~resource 문장으로 변경하세요. : autocloseable interface의 하위 객체를
        try(FileInputStream fileInput = new FileInputStream("abc.txt")) { // finally에서의 close는 자동으로 처리됨
        	fileInput.read();
        } catch(IOException e) {
        	e.printStackTrace();
        }
    	
    	
    	// END:
    }
}
