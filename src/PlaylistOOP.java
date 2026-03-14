/*
TUGAS KELOMPOK KE-1 (WEEK 3) - OOP & DATA STRUCTURES
Sistem Manajemen Playlist Musik Sederhana

Group 4
Anggota:
1. ERMAWAN WICAKSONO - 2902721213
2. FIRMANSYAH SEPTIAN - 2902716705
3. IGNASIUS SANTONI M. RAJAGUKGUK - 2902733195
4. INDRA KOESUMAH - 2902742483
5. RIZKIADI - 2902739513
====================================================
*/


/*
CLASS LAGU
Class ini merepresentasikan objek lagu dalam playlist
Konsep: Encapsulation
=====================
*/

class Lagu {
    // atribut lagu dibuat private (enkapsulasi)
    private String judul;
    private String artis;
    private double durasi;

    // constructor untuk membuat objek lagu
    public Lagu(String judul, String artis, double durasi){
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    // getter judul lagu
    public String getJudul(){
        return judul;
    }

    // getter durasi lagu
    public double getDurasi(){
        return durasi;
    }

    // method untuk menampilkan informasi lagu
    public void tampilkanInfo(){
        System.out.println("Judul Lagu : " + judul);
        System.out.println("Artis      : " + artis);
        System.out.println("Durasi     : " + durasi + " menit");
        System.out.println(); // spasi agar tidak menumpuk
    }
}

/*

CLASS USER (PARENT CLASS)
Class induk dari Admin dan Member
Konsep: Inheritance
===================
*/

class User{
    protected String nama;

    public User(String nama){
        this.nama = nama;
    }

    // method yang akan dioverride
    public void tampilkanAkses(){
        System.out.println("User biasa");
    }
}

/*
CLASS ADMIN
Admin bertugas menambahkan lagu ke playlist
Konsep: Inheritance & Polymorphism
==================================
*/

class Admin extends User{
    public Admin(String nama){
        super(nama);
    }

    // override method
    public void tampilkanAkses(){
        System.out.println("Admin dapat menambahkan lagu ke playlist.");
        System.out.println();
    }

    // method menambahkan lagu ke array playlist
    public void tambahLagu(Lagu[] playlist, Lagu lagu, int index){
        playlist[index] = lagu;
    }
}

/*
CLASS MEMBER
Member dapat melihat playlist, mencari lagu,
dan menghitung rata-rata durasi lagu
====================================
*/

class Member extends User{
    public Member(String nama){
        super(nama);
    }

    // override method
    public void tampilkanAkses(){
        System.out.println("Member dapat melihat playlist dan mencari lagu.");
        System.out.println();
    }

    // melihat semua lagu dalam playlist
    public void lihatPlaylist(Lagu[] playlist){

        System.out.println("===== DAFTAR LAGU DALAM PLAYLIST =====");
        System.out.println();

        for(Lagu lagu : playlist){
            if(lagu != null){
                lagu.tampilkanInfo();
            }
        }
    }

    // mencari lagu berdasarkan judul
    public void cariLagu(Lagu[] playlist, String judul){

        System.out.println("===== HASIL PENCARIAN LAGU =====");
        System.out.println();

        for(Lagu lagu : playlist){
            if(lagu != null && lagu.getJudul().equalsIgnoreCase(judul)){
                lagu.tampilkanInfo();
            }
        }
    }

    // menghitung rata-rata durasi lagu
    public void rataDurasi(Lagu[] playlist){

        double total = 0;
        int count = 0;

        for(Lagu lagu : playlist){
            if(lagu != null){
                total += lagu.getDurasi();
                count++;
            }
        }

        System.out.println("Rata-rata durasi lagu dalam playlist : " + (total/count) + " menit");
    }
}

/*
CLASS UTAMA PROGRAM
File: PlaylistOOP.java
======================
*/
public class PlaylistOOP {
    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("SELAMAT DATANG DI SISTEM MANAJEMEN PLAYLIST MUSIK");
        System.out.println("Program ini dibuat untuk memenuhi Tugas Kelompok");
        System.out.println("Mata Kuliah Struktur Data & Object Oriented Programming");
        System.out.println("====================================================");
        System.out.println();

        // array sebagai struktur data untuk menyimpan objek lagu
        Lagu[] playlist = new Lagu[10];

        // membuat objek admin dan member
        Admin admin = new Admin("Admin Playlist");
        Member member = new Member("Pengguna Playlist");

        // menampilkan hak akses
        admin.tampilkanAkses();
        member.tampilkanAkses();

        // admin menambahkan lagu religi / ramadhan ke playlist
        admin.tambahLagu(playlist, new Lagu("Selamat Lebaran", "GIGI", 4.1), 0);
        admin.tambahLagu(playlist, new Lagu("Ramadhan Tiba", "Opick", 4.3), 1);
        admin.tambahLagu(playlist, new Lagu("Tombo Ati", "Opick", 4.5), 2);
        admin.tambahLagu(playlist, new Lagu("Assalamu'alaikum", "Maher Zain", 4.2), 3);
        admin.tambahLagu(playlist, new Lagu("Ya Nabi Salam Alaika", "Maher Zain", 4.4), 4);

        // member melihat daftar lagu
        member.lihatPlaylist(playlist);

        // member mencari lagu tertentu
        member.cariLagu(playlist, "Ramadhan Tiba");

        // member menghitung rata-rata durasi lagu
        member.rataDurasi(playlist);

    }


}
