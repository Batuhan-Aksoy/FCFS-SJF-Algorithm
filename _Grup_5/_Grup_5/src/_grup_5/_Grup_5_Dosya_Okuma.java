/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _grup_5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;

/**
 *
 * @author Batuhan
 */
public class _Grup_5_Dosya_Okuma {

    ArrayList<String> prosesler = new ArrayList<>();

    public _Grup_5_Dosya_Okuma() throws IOException {
        prosesler = dosya_oku();
    }

    public ArrayList dosya_oku() throws IOException {
        String dosya_yolu = "prosesler.txt";
        File dosya = new File(dosya_yolu);
        if (!dosya.exists()) {
            System.out.println("Dosya Yok");
        } else {

            System.out.println(dosya.getName() + " okundu");
            FileReader dosya_okuyucu = new FileReader(dosya);
            String satir;
            BufferedReader buffer_okuyucu = new BufferedReader(dosya_okuyucu);
            while ((satir = buffer_okuyucu.readLine()) != null) {
                prosesler.add(satir);
            }
            buffer_okuyucu.close();
        }
        return prosesler;
    }

    public ArrayList dosya_siniflandirma_prosesad() throws IOException {

        ArrayList<String> proses_ad = new ArrayList<>();
        String p_satir = "", p_ad = "";
        for (int i = 0; i < prosesler.size(); i++) {
            p_satir = prosesler.get(i);
            for (int j = 0; j < p_satir.length(); j++) {
                if (p_satir.charAt(j) != ' ') {
                    p_ad += p_satir.charAt(j);
                } else {
                    break;
                }
            }
            proses_ad.add(p_ad);
            p_ad = "";
        }
        return proses_ad;
    }

    public ArrayList proses_gelis_zaman() throws IOException {
        ArrayList<Integer> proses_gelis_zamani = new ArrayList<>();
        String p_satir = "", p_gelis_zaman = "";
        int bosluk_sayisi = 0;
        for (int i = 0; i < prosesler.size(); i++) {
            p_satir = prosesler.get(i);
            for (int j = 0; j < p_satir.length(); j++) {
                if (p_satir.charAt(j) == ' ') {
                    bosluk_sayisi += 1;
                } else {
                    if (bosluk_sayisi == 1) {
                        p_gelis_zaman += p_satir.charAt(j);
                    } else if (bosluk_sayisi == 2) {
                        break;
                    }
                }
            }
            proses_gelis_zamani.add(parseInt(p_gelis_zaman));
            p_gelis_zaman = "";
            bosluk_sayisi = 0;
        }
        return proses_gelis_zamani;
    }

    public ArrayList proses_calisma_suresi() throws IOException {
        ArrayList<Integer> proses_calisma_sure = new ArrayList<>();
        String p_satir = "", p_calisma_sure = "";
        int bosluk_sayisi = 0;
        for (int i = 0; i < prosesler.size(); i++) {
            p_satir = prosesler.get(i);
            for (int j = 0; j < p_satir.length(); j++) {
                if (p_satir.charAt(j) == ' ') {
                    bosluk_sayisi += 1;
                } else {
                    if (bosluk_sayisi == 2) {
                        p_calisma_sure += p_satir.charAt(j);
                    }
                }
            }

            proses_calisma_sure.add(parseInt(p_calisma_sure));
            p_calisma_sure = "";
            bosluk_sayisi = 0;
        }
        return proses_calisma_sure;
    }

}
