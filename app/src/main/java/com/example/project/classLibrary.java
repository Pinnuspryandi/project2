package com.example.project;

public class classLibrary {


        private Integer libraryId;
        private String libraryName;
        private String libraryAddress;
        private String libraryPhone;
        private double latitude;
        private double longitude;


        /**
         * No args constructor for use in serialization
         *
         */
        public classLibrary() {
        }

    public classLibrary(Integer libraryId, String libraryName, String libraryAddress, String libraryPhone, double latitude, double longitude) {
        this.libraryId = libraryId;
        this.libraryName = libraryName;
        this.libraryAddress = libraryAddress;
        this.libraryPhone = libraryPhone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

//    /**
//         *
//         * @param libraryName
//         * @param libraryPhone
//         * @param libraryId
//         * @param latitude
//         * @param libraryAddress
//         * @param longitude
//         */
    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getLibraryAddress() {
        return libraryAddress;
    }

    public void setLibraryAddress(String libraryAddress) {
        this.libraryAddress = libraryAddress;
    }

    public String getLibraryPhone() {
        return libraryPhone;
    }

    public void setLibraryPhone(String libraryPhone) {
        this.libraryPhone = libraryPhone;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}



