package com.negoreserva.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HugeiconNamed {
    HOTEL_01("hgi hgi-stroke hgi-rounded hgi-hotel-01"),
    GUESTHOUSE("hgi hgi-stroke hgi-rounded hgi-guest-house"),
    HOTEL_02("hgi hgi-stroke hgi-rounded hgi-hotel-02"),
    HOTEL_04("hgi hgi-stroke hgi-rounded hgi-house-04"),
    RESTAURANT_01("hgi hgi-stroke hgi-rounded hgi-restaurant-01"),
    RESTAURANT("hgi hgi-stroke hgi-rounded hgi-restaurant-table"),
    AIR_PLANE_TAKE_OFF_01("hgi hgi-stroke hgi-rounded hgi-airplane-take-off-01"),
    SHOPPING_BAG_03("hgi hgi-stroke hgi-rounded hgi-shopping-bag-03"),

    CURTAINS("hgi hgi-stroke hgi-rounded hgi-curtains"),
    HOT_TUB("hgi hgi-stroke hgi-rounded hgi-hot-tub"),
    SOFA_02("hgi hgi-stroke hgi-rounded hgi-sofa-02");

    private final String web;
}
