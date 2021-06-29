package com.prime.food.howtocook;

public class Foods {

    private String name,food_des;

    private int imageResourceId;

    public static final Foods[] foods={

            new Foods("Afang Soup", "afang_soupx.html", R.drawable.afang_soup),
            new Foods("Banana Poridge", "banana_pooridge.html", R.drawable.oto_mboro),
            new Foods("Stuffed Squid With Eggs", "stuffed_egg.html", R.drawable.stuffed_squid_640x381),
            new Foods("Banga Soup", "banga.html", R.drawable.banga_soup1),
            new Foods("Bitterleaf soup", "bitter_leave_soup.html", R.drawable.bitterleaf_soup),
            new Foods("Club Sandwich", "club_sandwich.html", R.drawable.chicken_club_sandwich),
            new Foods("Spicy Chicken Peri", "chicken_peri.html", R.drawable.chickz),
            new Foods("Braise Rice", "braied_rice.html", R.drawable.braise_rice),
            new Foods("Caribbean rice", "caribbean_rice.html", R.drawable.caribean_rice),
            new Foods("Chicken Shawarma", "chicken_shawarma.html", R.drawable.chicken_shawarma_stuffed),
            new Foods("Crunchy And Crispy French Fries", "chrunchy.html", R.drawable.cruchy),
            new Foods("Creamy Coconut Puff", "coconut_puff.html", R.drawable.coconut_puff),
            new Foods("Coconut Rice", "coconut_rice.html", R.drawable.cocoanut_rice),
            new Foods("Egg Roll Recipe", "eggroll.html", R.drawable.egg_roll),
            new Foods("Ewa Agoyin", "ewa_agboyin.html", R.drawable.ewa_agoyin),
            new Foods("Ewedu Soup", "ewedu_soup.html", R.drawable.ewedu_soup),
            new Foods("Fried Rice", "fried_rice.html", R.drawable.friedricemaking),
            new Foods("Ghanaian Jollof Rice", "gjollof.html", R.drawable.ghanajallof2),
            new Foods("Indomie Noodles", "indomiex.html", R.drawable.indomie_recipe),
            new Foods("Creamy Macaroni Salad", "macaroni.html", R.drawable.macaroni1),
            new Foods("Homemade Mayonnaise", "mayonnaise.html", R.drawable.how_to_make_mayonnaise_732x1024),
            new Foods("Moi Moi", "moi_moi.html", R.drawable.making_moi_moip),
            new Foods("Ofada Sauce Stew", "ofada_sauce_stew.html", R.drawable.ofada_rice_stew),
            new Foods("Pancakes", "pancakes.html", R.drawable.pancakes),
            new Foods("spaghetti/macaroni recipe", "spagetti.html", R.drawable.spaghetti_recipe),
            new Foods("Tomato Stew", "tomato_stew.html", R.drawable.tomato_stew),
            new Foods("Creamy Italian Tortellini Soup", "tortellini_soup.html", R.drawable.creamy_tortellini_soup),
            new Foods("Vegetable Sauce", "vegetable.html", R.drawable.vegetable_stew1),
            // new Foods("f7", "f7", R.drawable.afang_soup),
            new Foods("Veggie Chicken Sauce", "veggie_chicken.html", R.drawable.viggie_chic)

    };

    public Foods(String name, String food_des, int imageResourceId) {
        this.name = name;
        this.food_des = food_des;
        this.imageResourceId = imageResourceId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
    public String getName() {
        return name;
    }

    public String getFood_des() {
        return food_des;
    }

}
