package com.example.project;

public class Library {
    String LibraryName,LibraryAddress,LibraryPhone,Latitude,Longitude;
    int LibraryId;


    public int getLibraryId() {
        return LibraryId;
    }

    public String getLibraryName() {
        return LibraryName;
    }

    public String getLibraryAddress() {
        return LibraryAddress;
    }

    public String getLibraryPhone() {
        return LibraryPhone;
    }

    public String getLatitude() {
        return Latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public Library(int libraryId, String libraryName, String libraryAddress, String libraryPhone, String latitude, String longitude) {
        LibraryId = libraryId;
        LibraryName = libraryName;
        LibraryAddress = libraryAddress;
        LibraryPhone = libraryPhone;
        Latitude = latitude;
        Longitude = longitude;
    }

}
