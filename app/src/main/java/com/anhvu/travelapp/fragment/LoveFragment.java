package com.anhvu.travelapp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anhvu.travelapp.R;
import com.anhvu.travelapp.adapter.FoodAdapter;
import com.anhvu.travelapp.adapter.HotelAdapter;
import com.anhvu.travelapp.model.Food;
import com.anhvu.travelapp.model.Hotel;

import java.util.ArrayList;

public class LoveFragment extends Fragment {
    RecyclerView listLove, listActivity;
    FoodAdapter foodAdapter;
    HotelAdapter hotelAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.love_fragment, container, false);
        listLove = (RecyclerView) view.findViewById(R.id.listLove);
        listActivity = (RecyclerView) view.findViewById(R.id.listActivity);
        getDataFood();
        getDataHotel();
        return view;
    }

    private void getDataFood() {
        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food(1, "Buffer Lạp Xưởng", "food22", "Nhà hàng Hải Sản ở LOTTE", "Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00. " +
                "Nhà hàng Hải Sản ở LOTTE: địa chỉ 18A đường Đồng Tiến, phường TMT, quận 12.\n" +
                "Đầu bếp nhà hàng đến từ khắp mọi vùng miền với kinh nghiệm nấu ăn đa dạng các món trên 10 năm", 2, 2100, 4.5, 1));
        foods.add(new Food(2, "Beef Bread", "food17", "Nhà hàng Hải Sản ở LOTTE", "Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00. " +
                "Nhà hàng Hải Sản ở LOTTE: địa chỉ 18A đường Đồng Tiến, phường TMT, quận 12.\n" +
                "Đầu bếp nhà hàng đến từ khắp mọi vùng miền với kinh nghiệm nấu ăn đa dạng các món trên 10 năm", 1, 2100, 4.5, 8));
        foods.add(new Food(3, "Vegetable Pizza", "food18", "Nhà hàng Hải Sản ở LOTTE", "Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00. " +
                "Nhà hàng Hải Sản ở LOTTE: địa chỉ 18A đường Đồng Tiến, phường TMT, quận 12.\n" +
                "Đầu bếp nhà hàng đến từ khắp mọi vùng miền với kinh nghiệm nấu ăn đa dạng các món trên 10 năm", 2, 2500, 5.0, 7));
        foods.add(new Food(4, "Pork Porridge", "food15", "Nhà hàng Hải Sản ở LOTTE", "Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00. " +
                "Nhà hàng Hải Sản ở LOTTE: địa chỉ 18A đường Đồng Tiến, phường TMT, quận 12.\n" +
                "Đầu bếp nhà hàng đến từ khắp mọi vùng miền với kinh nghiệm nấu ăn đa dạng các món trên 10 năm", 3, 2100, 4.5, 5));
        listLove.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        foodAdapter = new FoodAdapter(foods);
        listLove.setAdapter(foodAdapter);
    }

    private void getDataHotel(){
        ArrayList<Hotel> services = new ArrayList<>();
        services.add(new Hotel(2,1,"VUNGTAU EDENSEE Lake Holtel and Spa","hotel3","Vũng Tàu",4.0,120.7,"0","0","1"));
        services.add(new Hotel(6,1,"DANANG Lake Holtel and Spa","hotel7","Đà Nẵng",4.8,450.4,"1","0","1"));
        services.add(new Hotel(7,1,"BINHDINH Lake Resort and Spa","hotel8","Bình Định",5.0,250.2,"0","1","1"));
        services.add(new Hotel(9,1,"Los Angeles Holtel and Spa","hotel10","Los Angeles",4.5,4.503,"1","1","1"));
        listActivity.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        hotelAdapter = new HotelAdapter(services);
        listActivity.setAdapter(hotelAdapter);
    }
}
