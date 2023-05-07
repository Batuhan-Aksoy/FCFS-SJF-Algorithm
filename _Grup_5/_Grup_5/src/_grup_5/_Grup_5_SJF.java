/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _grup_5;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Batuhan
 */
public class _Grup_5_SJF {

    public void SJF(ArrayList<String> proses_ad, ArrayList<Integer> proses_gelis_zamani, ArrayList<Integer> proses_calisma_sure) throws InterruptedException {

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
        System.out.println("SJF (non-preemptive) Simulasyonu:");
        int time = proses_gelis_zamani.get(0);
        int index = 0;
        int ayni_gelis_sure = 0;
        boolean kuyruk_flag = false;
        int kuyruk_temp_calisma = 0;
        ArrayList<Integer> bekleme_zamanlari = new ArrayList<>();
        ArrayList<String> bekleme_zamanlari_proses_ad = new ArrayList<>();
        String kuyruk_temp_ad;
        ArrayList<Integer> kuyruk_proses_calisma_sure = new ArrayList<>();
        ArrayList<String> kuyruk_proses_ad = new ArrayList<>();
        int toplam_calisma_sure = 0;
        for (int tci = 0; tci < proses_calisma_sure.size(); tci++) {
            toplam_calisma_sure += proses_calisma_sure.get(tci);
        }
        int bitirme_index = 0;
        for (int pi = 0; pi < toplam_calisma_sure; pi++) {
            if (proses_gelis_zamani.contains(time) == true) {
                for (int b = proses_gelis_zamani.indexOf(time); b < proses_gelis_zamani.size(); b++) {
                    if (proses_gelis_zamani.get(b) == time) {
                        ayni_gelis_sure += 1;
                    }
                }
                kuyruk_flag = true;
                for (int k = 0; k < ayni_gelis_sure; k++) {
                    index = proses_gelis_zamani.indexOf(time);
                    kuyruk_proses_calisma_sure.add(proses_calisma_sure.get(index + k));
                    kuyruk_proses_ad.add(proses_ad.get(index + k));
                    System.out.println(proses_ad.get(index + k) + " Prosesi " + time + ". Saniyede kuyruga Girdi");
                }

            }

            for (int si = 1; si < kuyruk_proses_calisma_sure.size(); si++) {
                for (int i = 0; i < si; i++) {
                    if (kuyruk_proses_calisma_sure.get(si) < kuyruk_proses_calisma_sure.get(i)) {
                        kuyruk_temp_calisma = kuyruk_proses_calisma_sure.get(si);
                        kuyruk_proses_calisma_sure.set(si, kuyruk_proses_calisma_sure.get(i));
                        kuyruk_proses_calisma_sure.set(i, kuyruk_temp_calisma);

                        kuyruk_temp_ad = kuyruk_proses_ad.get(si);
                        kuyruk_proses_ad.set(si, kuyruk_proses_ad.get(i));
                        kuyruk_proses_ad.set(i, kuyruk_temp_ad);
                    }
                }
            }

            if (kuyruk_proses_calisma_sure.size() > 0) {
                for (int ci = 0; ci < kuyruk_proses_calisma_sure.get(0); ci++) {
                    if (proses_gelis_zamani.contains(time) == true) {
                        index = proses_gelis_zamani.indexOf(time);
                        if (kuyruk_flag == false) {
                            ayni_gelis_sure = 0;
                            for (int b = proses_gelis_zamani.indexOf(time); b < proses_gelis_zamani.size(); b++) {
                                if (proses_gelis_zamani.get(b) == time) {
                                    ayni_gelis_sure += 1;
                                }
                            }
                            for (int k = 0; k < ayni_gelis_sure; k++) {
                                kuyruk_proses_calisma_sure.add(proses_calisma_sure.get(index));
                                kuyruk_proses_ad.add(proses_ad.get(index));
                                System.out.println(proses_ad.get(index + k) + " Prosesi " + time + ". Saniyede kuyruga Girdi");
                            }
                        }

                    }
                    kuyruk_flag = false;

                    if (ci == 0) {
                        System.out.println(kuyruk_proses_ad.get(0) + " Prosesi " + (time) + ". Saniyede calismaya basladi");
                        bekleme_zamanlari.add(time - proses_gelis_zamani.get(proses_ad.indexOf(kuyruk_proses_ad.get(0))));
                        bekleme_zamanlari_proses_ad.add(kuyruk_proses_ad.get(0));

                    }
                    System.out.println(kuyruk_proses_ad.get(0) + " Prosesi Toplamda " + (ci + 1) + " saniye calisti");
                    Thread.sleep(1000);
                    time += 1;
                }
                kuyruk_proses_calisma_sure.remove(0);
                kuyruk_proses_ad.remove(0);
                ayni_gelis_sure = 0;
                bitirme_index += 1;
                if (bitirme_index == proses_gelis_zamani.size()) {
                    break;
                }
            } else {
                for (int ti = 0; ti < 1000; ti++) {
                    Thread.sleep(1000);
                    time += 1;
                    if (proses_gelis_zamani.contains(time) == true) {
                        break;
                    }
                }

            }
        }

        String bekleme_ad_temp = "";
        int bekleme_sure_temp = 0;
        for (int si = 1; si < bekleme_zamanlari.size(); si++) {
            for (int i = 0; i < si; i++) {
                if (Integer.parseInt(bekleme_zamanlari_proses_ad.get(si).substring(1, bekleme_zamanlari_proses_ad.get(si).length())) < Integer.parseInt(bekleme_zamanlari_proses_ad.get(i).substring(1, bekleme_zamanlari_proses_ad.get(i).length()))) {
                    bekleme_ad_temp = bekleme_zamanlari_proses_ad.get(si);
                    bekleme_zamanlari_proses_ad.set(si, bekleme_zamanlari_proses_ad.get(i));
                    bekleme_zamanlari_proses_ad.set(i, bekleme_ad_temp);

                    bekleme_sure_temp = bekleme_zamanlari.get(si);
                    bekleme_zamanlari.set(si, bekleme_zamanlari.get(i));
                    bekleme_zamanlari.set(i, bekleme_sure_temp);
                }
            }
        }

        String bekleme_sure = "";
        double ort_bekleme = 0;
        for (int i = 0; i < proses_ad.size(); i++) {
            bekleme_sure += bekleme_zamanlari_proses_ad.get(i) + " " + bekleme_zamanlari.get(i) + " ";
            ort_bekleme += bekleme_zamanlari.get(i);
        }
        System.out.println("Bekleme Zamanlari: " + bekleme_sure);
        System.out.println("Ortalama Bekleme Suresi: " + (ort_bekleme / proses_ad.size()));
    }
}
