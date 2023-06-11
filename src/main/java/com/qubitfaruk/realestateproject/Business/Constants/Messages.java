package com.qubitfaruk.realestateproject.Business.Constants;

import com.qubitfaruk.realestateproject.Entity.enums.CustomerType;

public class Messages {

    private Messages(){

    }
    public static final String realEstatateDetailsListed="Emlak detayları Listelendi.";

    public static final String realEstateDetailsNotFoundMessage="Emlak detayları bulunamadı";
    public static String addCustomerMessage(String email){
        return "Müşteri eklendi : "+email;
    }
    public static  String  customerNotFoundMessage(int id){
        return "Müşteri id :"+id+" bulunamadı.";
    }
    public static  String  customerDeletedMessage(int id){
        return "Müşteri id :"+id+" silindi.";
    }

    public static final String customerListMessage="Müşteriler listelendi.";

    public static String getCustomerMessage(int id){
        return "Müşteri id"+id;
    }

    public static String customerTypeNotFound(CustomerType customerType){
        return "Müşteri tipi: "+customerType+" tipinde müşteri bulunamadı";
    }
    public static final String customerEmailMustBeUnique="Email benzersiz olmalı";
    public static final String workplaceAddMessage="İş yeri eklendi.";
    public static final String workplaceUpdateMessage="İş yeri güncellendi.";
    public static String workPlaceIdNotFound(int id){
        return "İş yeri Id : "+id+" bulunamadı";
    }
    public static String workPlaceDeleted(int id){
        return "İş yeri Id : "+id+"silindi";
    }

    public static final String buildingFloorsLessThanOrEqualNumberOfFloors="Emlağın bulunduğu kat toplam kat sayısından az veya eşit olmalıdır";
    public static String realEstateAdd="Emlak eklendi.";
    public static String realEstateUpdate="Emlak eklendi.";
    public static  String realEstateNotFound(int id){
        return "Emlak Id : "+id+" bulunamadı.";
    }
    public static String realEstateDeleted(int id){
        return "Emlak Id : "+id+"silindi";
    }

    public static String getAllByNumberOfRoomsRangeMessage(int min, int max) {
        return "Oda sayısı "+min+"-"+max+" aralığındaki emlaklar getirildi.";
    }

    public static String getAllByNumberOfFloorsRangeMessage(int min, int max) {
        return "Kat sayısı "+min+"-"+max+" aralığındaki emlaklar getirildi.";
    }

    public static String getAllByM2RangeMessage(double min, double max) {
        return "Alanı "+min+"-"+max+" m2 aralığındaki emlaklar getirildi.";
    }
}
