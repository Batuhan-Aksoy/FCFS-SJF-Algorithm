/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _grup_5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Batuhan
 */
public class _Grup_5_Main {

    public static void main(String args[]) throws IOException, InterruptedException {
        ArrayList<String> proses_ad = new ArrayList<>();
        ArrayList<Integer> proses_gelis_zamani = new ArrayList<>();
        ArrayList<Integer> proses_calisma_suresi = new ArrayList<>();
        _Grup_5_Dosya_Okuma obje = new _Grup_5_Dosya_Okuma();
        proses_ad = obje.dosya_siniflandirma_prosesad();
        proses_gelis_zamani = obje.proses_gelis_zaman();
        proses_calisma_suresi = obje.proses_calisma_suresi();
        System.out.println("");
        _Grup_5_SJF sjf = new _Grup_5_SJF();
        sjf.SJF(proses_ad, proses_gelis_zamani, proses_calisma_suresi);
        System.out.println("");
        _Grup_5_FCFS fcfs = new _Grup_5_FCFS();
        fcfs.FCFS(proses_ad, proses_gelis_zamani, proses_calisma_suresi);

    }
}
