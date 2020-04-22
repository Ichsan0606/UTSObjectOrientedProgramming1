/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOP;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Mhs {
    public void printMenu() {
        Scanner Ichsan = new Scanner(System.in);
        System.out.println("------------------------------------");
        System.out.println("Pendaftaran Mahasiswa Baru 2019-2020");
        System.out.println("------------------------------------");
        System.out.println("1. Tambah " + "\n2. Ubah " + 
                "\n3. Hapus " + "\n4. Lihat " + "\n5. Keluar");
        System.out.print("Pilihan: ");
    }

    public void hapusData() {
        Scanner Ichsan = new Scanner(System.in);
        System.out.print("Urutan data yang dihapus: ");
        int idx = Integer.parseInt(Ichsan.nextLine());
        // proses hapus data
        Code.removeData(idx - 1);
    }

    public void ubahData() {
        Scanner Ichsan = new Scanner(System.in);
        System.out.println();
        System.out.print("Urutan data yang diubah: ");
        int idx = Integer.parseInt(Ichsan.nextLine());
        System.out.println("--------------------------");
        System.out.print("NIM       : ");
        String NIM = Ichsan.nextLine();
        System.out.print("NAMA LENGKAP      : ");
        String NAMA = Ichsan.nextLine();
        System.out.print("PRODI     : ");
        String PRODI = Ichsan.nextLine();
        System.out.print("ALAMAT     : ");
        String ALAMAT = Ichsan.nextLine();
        // proses ubah data
        Code.editData(new Doc(NIM, NAMA, PRODI, ALAMAT), idx - 1);
    }

    public void listData() {
        List<Doc> result = Code.getListData();
        for (int i = 0; i < result.size(); i++) {
            System.out.println();
            System.out.println("Data ke-" + (i + 1));
            System.out.println("  NIM           : " + result.get(i).getnim());
            System.out.println("  NAMA LENGKAP  : " + result.get(i).getnama());
            System.out.println("  PRODI         : " + result.get(i).getprodi());
            System.out.println("  ALAMAT        : " + result.get(i).getalamat());
        }
    }

    public void addData() {
        Scanner Ichsan = new Scanner(System.in);
        System.out.println();
        System.out.print("NIM : ");
        String NIM = Ichsan.nextLine();
        System.out.print("NAMA LENGKAP : ");
        String NAMA = Ichsan.nextLine();
        System.out.print("PRODI : ");
        String PRODI = Ichsan.nextLine();
        System.out.print("ALAMAT : ");
        String ALAMAT = Ichsan.nextLine();
        //proses tambah data
        Code.addData(new Doc(NIM, NAMA, PRODI, ALAMAT));
    }

    public static void main(String[] args) {
        Scanner Ichsan = new Scanner(System.in);
        Mhs app = new Mhs();
        while (true) {
            app.printMenu();
            int pilihan = Ichsan.nextInt();
            switch (pilihan) {
                case 1:
                    System.out.println("Form Tambah Data");
                    app.addData();
                    break;
                case 2:
                    System.out.println("Daftar Data");
                    app.listData();
                    System.out.println("Form Ubah Data");
                    app.ubahData();
                    break;
                case 3:
                    System.out.println("Daftar Data");
                    app.listData();
                    System.out.println("Form Hapus Data");
                    app.hapusData();
                    break;
                case 4:
                    System.out.println("Daftar Data");
                    app.listData();
                    break;
                case 5:
                    System.out.println("\nApakah Anda ingin Melanjutkan Pendaftaran ?");
                    System.out.println("1.Ya \t2.Tidak");
                    char persetuju = Ichsan.next().charAt(0);
                    if (persetuju == '1') {
                        app.printMenu();

                    } else if (persetuju == '2') {
                        System.out.println("Terima kasih");
                        System.exit(0);
                    }
            }
        }
    }
}

