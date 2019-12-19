package com.example.project;

import java.util.ArrayList;

public class Librarysingleton {
    public static Librarysingleton library_instance;
    private ArrayList<Library> librarys =  new ArrayList<>();

    public static Librarysingleton getInstance() {
        if(library_instance == null)
            library_instance = new Librarysingleton();
        return library_instance;
    }

    public void add (Library library) {
        this.librarys.add(library);
    }

    public ArrayList<Library> get() {
        return librarys;
    }
    public void init(){
        librarys.add(new Library(1,"Badan Perpustakaan dan Arsip Daerah Provinsi DKI Jakarta","Jalan Cikini Raya No. 73, Komplek TIM, Jakarta Pusat 10330","(021) 47860095","-6.17168325","106.88568961"));
        librarys.add(new Library(2,"Perpustakaan Japan Foundation","Gedung Summitmas 1 3rd Floor, Jl. Jend. Sudirman Kavling 61-62, Senayan, Kebayoran Baru, RT.5/RW.3, Senayan, Kby. Baru, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12190","(021) 5201266","-6.2269682",""));
        librarys.add(new Library(3,"Perpustakaan Goethe-Institut","Jl. Dr. GSSJ Ratulangi No.9-15, RT.2/RW.3, Gondangdia, Menteng, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10350","(021) 23550208","-6.1898973","106.829218"));
        librarys.add(new Library(4,"Perpustakaan Nasional Republik Indonesia","Jl. Medan Merdeka Sel. No.11, RT.11/RW.2, Gambir, Senen, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10110","0800 1737787","-6.1898972","106.8226519"));
        librarys.add(new Library(5,"Perpustakaan Freedom","Wisma Bakrie, Jl. H. R. Rasuna Said No.Kav, B-1, RT.11/RW.2, Kuningan, Karet Kuningan, Menteng, South Jakarta City, Jakarta 12920","(021) 3100349","-6.2130083","106.8274914"));
        librarys.add(new Library(6,"Perpustakaan Umum Provinsi DKI Jakarta","Gedung Nyi Ageng Serang Lantai 7-8, I.H.R. Rasuna Said Kav. C-22, Setiabudi, RT.2/RW.5, Karet Kuningan, Setia Budi, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12940", "(021) 5263249","-6.2229314","106.8321061"));
        librarys.add(new Library(7,"Perpustakaan Rujak Center for Urban Studies (RCUS)","Gedung Ranuza lantai 2, Jalan Timor No. 10, Menteng, Jakarta Pusat", "(021) 3152478", "-6.1898073","106.823521"));
        librarys.add(new Library(8,"Perpustakaan Sekolah Tinggi Ilmu Ekonomi PERBANAS Jakarta","JL Ciputat Raya, No. 77A, Ciputat, RT.6/RW.8, Pd. Pinang, Kby. Lama, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 15412","(021) 7430930","-6.2826025","106.7693102"));
    }
}
