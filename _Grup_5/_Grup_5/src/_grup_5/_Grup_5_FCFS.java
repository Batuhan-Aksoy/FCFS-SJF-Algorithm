/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _grup_5;

import java.util.ArrayList;

/**
 *
 * @author Batuhan
 */
public class _Grup_5_FCFS {

    public void FCFS(ArrayList<String> proses_ad, ArrayList<Integer> proses_gelis_zamani, ArrayList<Integer> proses_calisma_sure) throws InterruptedException {

        int temp_gelis = 0;
        int temp_calisma = 0;
        String temp_ad;
        for (int si = 1; si < proses_gelis_zamani.size(); si++) {
            for (int i = 0; i < si; i++) {
                if (proses_gelis_zamani.get(si) < proses_gelis_zamani.get(i)) {
                    temp_gelis = proses_gelis_zamani.get(si);
                    proses_gelis_zamani.set(si, proses_gelis_zamani.get(i));
                    proses_gelis_zamani.set(i, temp_gelis);

                    temp_calisma = proses_calisma_sure.get(si);
                    proses_calisma_sure.set(si, proses_calisma_sure.get(i));
                    proses_calisma_sure.set(i, temp_calisma);

                    temp_ad = proses_ad.get(si);
                    proses_ad.set(si, proses_ad.get(i));
                    proses_ad.set(i, temp_ad);
                }
            }
        }
        System.out.println("FCFS Simulasyonu:");
        int time = proses_gelis_zamani.get(0);
        int index;
        int aynı_gelis_zaman = 0;
        boolean flag = false;
        ArrayList<String> kuyruk_girme_proses_ad = new ArrayList<>();
        ArrayList<Integer> kuyruk_girme_sure = new ArrayList<>();
        ArrayList<Integer> kuyruk_girme_calismaya_baslama_sure = new ArrayList<>();
        for (int tci = 0; tci < proses_gelis_zamani.size(); tci++) {
            if (time >= proses_gelis_zamani.get(tci)) {
                for (int ci = 0; ci < proses_calisma_sure.get(tci); ci++) {
                    if (proses_gelis_zamani.contains(time) == true) {
                        if (flag == false) {
                            flag = true;
                            for (int b = tci; b < proses_gelis_zamani.size(); b++) {
                                if (proses_gelis_zamani.get(b) == time) {
                                    aynı_gelis_zaman += 1;
                                }
                            }
                        }
                        index = proses_gelis_zamani.indexOf(time);
                        for (int k = 0; k < aynı_gelis_zaman; k++) {
                            System.out.println(proses_ad.get(index + k) + " Prosesi " + time + ". Saniyede kuyruga Girdi");
                            kuyruk_girme_proses_ad.add(proses_ad.get(index + k));
                            kuyruk_girme_sure.add(time);
                        }

                    } else {
                        flag = false;
                    }

                    if (ci == 0) {
                        System.out.println(proses_ad.get(tci) + " Prosesi " + (time) + ". Saniyede calismaya basladi");
                        kuyruk_girme_calismaya_baslama_sure.add(time);
                    }
                    System.out.println(proses_ad.get(tci) + " Prosesi Toplamda " + (ci + 1) + " saniye calisti");
                    Thread.sleep(1000);
                    time += 1;
                }
                aynı_gelis_zaman = 0;

            } else {

                for (int k = 0; k < 1000; k++) {
                    Thread.sleep(1000);
                    time += 1;
                    if (time == proses_gelis_zamani.get(tci)) {
                        tci -= 1;
                        break;
                    }
                }
            }
        }
        String bekleme_sure = "";
        double ort_bekleme = 0;
        for (int i = 0; i < proses_ad.size(); i++) {
            bekleme_sure += kuyruk_girme_proses_ad.get(i) + " " + (kuyruk_girme_calismaya_baslama_sure.get(i) - kuyruk_girme_sure.get(i)) + " ";
            ort_bekleme += kuyruk_girme_calismaya_baslama_sure.get(i) - kuyruk_girme_sure.get(i);
        }
        System.out.println("Bekleme Zamanlari: " + bekleme_sure);
        System.out.println("Ortalama Bekleme Suresi: " + (ort_bekleme / proses_ad.size()));
    }
}
