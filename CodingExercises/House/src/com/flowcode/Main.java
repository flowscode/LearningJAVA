package com.flowcode;

public class Main {

    public static void main(String[] args) {
	LivingRoom livingRoom = new LivingRoom
            ("White", "Carpet",
                    new Dimensions(16,10),
                    new Television("LG","55inch",13,'F',true,
                            new Size(80,124,8),
                            new Resolution(3840,2160)),
                    new Sofa("Cream",6,"Lamb Skin","Semi-circle",130),
                    new Speakers("Bose","Black",6,6)
            );

    livingRoom.tvPowerButton(false);
    }
}
