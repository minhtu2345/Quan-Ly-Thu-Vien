/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class ScanBarcode{
    public static Webcam webcam = null;
    public static WebcamPanel panel = null;
    
    public void initWebCam(JPanel pn, Executor executor, Runnable r){
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);
        
        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);
        
        pn.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 310));
        executor.execute(r);
    }
    
}
