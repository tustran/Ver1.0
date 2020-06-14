package com.example.ver10.ui.area;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ver10.R;

import java.util.ArrayList;

public class AreaFragment extends Fragment {

    private AreaViewModel areaViewModel;
    ArrayList<Product> listProduct;
    ArrayList<Sensor> listSensor;
    ProductListViewAdapter productListViewAdapter;
    SensorListViewAdapter sensorListViewAdapter;
    ListView listViewProduct;
    ListView listViewSensor;
//    Model phần tử dữ liệu hiện
    class Product {
        String name;
        int price;
        int productID;

        public Product(int productID, String name, int price) {
            this.name = name;
            this.price = price;
            this.productID = productID;
        }

    }
    class Sensor {
        String Temperature;
        String Moisture;
        int sensorID;

        public Sensor(int sensorID, String Temperature, String Moisture) {
            this.Temperature = Temperature;
            this.Moisture = Moisture;
            this.sensorID = sensorID;
        }

    }
    class Headersensor {
        String Temperature;
        String Moisture;
        String sensorID;

        public Headersensor() {
            this.Temperature = "Độ ẩm";
            this.Moisture = "Nhiệt độ";
            this.sensorID = "Cảm biến";
        }

    }

    class ProductListViewAdapter extends BaseAdapter {

        //Dữ liệu liên kết bởi Adapter là một mảng các sản phẩm
        final ArrayList<Product> listProduct;

        ProductListViewAdapter(ArrayList<Product> listProduct) {
            this.listProduct = listProduct;
        }

        @Override
        public int getCount() {
            //Trả về tổng số phần tử, nó được gọi bởi ListView
            return listProduct.size();
        }

        @Override
        public Object getItem(int position) {
            //Trả về dữ liệu ở vị trí position của Adapter, tương ứng là phần tử
            //có chỉ số position trong listProduct
            return listProduct.get(position);
        }

        @Override
        public long getItemId(int position) {
            //Trả về một ID của phần
            return listProduct.get(position).productID;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //convertView là View của phần tử ListView, nếu convertView != null nghĩa là
            //View này được sử dụng lại, chỉ việc cập nhật nội dung mới
            //Nếu null cần tạo mới

            View viewProduct;
            if (convertView == null) {
                viewProduct = View.inflate(parent.getContext(), R.layout.product_view, null);
            } else viewProduct = convertView;

            //Bind sữ liệu phần tử vào View
            Product product = (Product) getItem(position);
            ((TextView) viewProduct.findViewById(R.id.idproduct)).setText(String.format("ID = %d", product.productID));
            ((TextView) viewProduct.findViewById(R.id.nameproduct)).setText(String.format("Tên SP : %s", product.name));
            ((TextView) viewProduct.findViewById(R.id.priceproduct)).setText(String.format("Giá %d", product.price));


            return viewProduct;
        }
    }

    class SensorListViewAdapter extends BaseAdapter {

        //Dữ liệu liên kết bởi Adapter là một mảng các cảm biến
        final ArrayList<Sensor> listSensor;

        SensorListViewAdapter(ArrayList<Sensor> listSensor) {
            this.listSensor = listSensor;
        }

        @Override
        public int getCount() {
            //Trả về tổng số phần tử, nó được gọi bởi ListView
            return listSensor.size();
        }

        @Override
        public Object getItem(int position) {
            //Trả về dữ liệu ở vị trí position của Adapter, tương ứng là phần tử
            //có chỉ số position trong listProduct
            return listSensor.get(position);
        }

        @Override
        public long getItemId(int position) {
            //Trả về một ID của phần
            return listSensor.get(position).sensorID;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //convertView là View của phần tử ListView, nếu convertView != null nghĩa là
            //View này được sử dụng lại, chỉ việc cập nhật nội dung mới
            //Nếu null cần tạo mới

            View viewSensor;
            if (convertView == null) {
                viewSensor = View.inflate(parent.getContext(), R.layout.sensor_view, null);
            } else viewSensor = convertView;

            //Bind sữ liệu phần tử vào View
            Sensor sensor = (Sensor) getItem(position);
            ((TextView) viewSensor.findViewById(R.id.idsensor)).setText(String.format("%d", sensor.sensorID));
            ((TextView) viewSensor.findViewById(R.id.sensortemp)).setText(String.format("%s oC", sensor.Temperature));
            ((TextView) viewSensor.findViewById(R.id.sensormois)).setText(String.format("%s percent", sensor.Moisture));


            return viewSensor;
        }
    }

    class HeaderSensorListViewAdapter extends BaseAdapter {

        //Dữ liệu liên kết bởi Adapter là một mảng các cảm biến
        final ArrayList<Sensor> listSensor;

        HeaderSensorListViewAdapter(ArrayList<Sensor> listSensor) {
            this.listSensor = listSensor;
        }

        @Override
        public int getCount() {
            //Trả về tổng số phần tử, nó được gọi bởi ListView
            return listSensor.size();
        }

        @Override
        public Object getItem(int position) {
            //Trả về dữ liệu ở vị trí position của Adapter, tương ứng là phần tử
            //có chỉ số position trong listProduct
            return listSensor.get(position);
        }

        @Override
        public long getItemId(int position) {
            //Trả về một ID của phần
            return listSensor.get(position).sensorID;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //convertView là View của phần tử ListView, nếu convertView != null nghĩa là
            //View này được sử dụng lại, chỉ việc cập nhật nội dung mới
            //Nếu null cần tạo mới

            View viewSensor;
            if (convertView == null) {
                viewSensor = View.inflate(parent.getContext(), R.layout.sensor_view, null);
            } else viewSensor = convertView;

            //Bind sữ liệu phần tử vào View
            Sensor sensor = (Sensor) getItem(position);
            ((TextView) viewSensor.findViewById(R.id.idsensor)).setText(String.format("%s", sensor.sensorID));
            ((TextView) viewSensor.findViewById(R.id.sensortemp)).setText(String.format("%s oC", sensor.Temperature));
            ((TextView) viewSensor.findViewById(R.id.sensormois)).setText(String.format("%s percent", sensor.Moisture));


            return viewSensor;
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        areaViewModel =
                ViewModelProviders.of(this).get(AreaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_area, container, false);
//        final TextView textView = root.findViewById(R.id.text_area);
//        areaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        Khoi tao ListProduct
        listProduct = new ArrayList<>();
        listProduct.add(new Product(1, "Iphone 6", 500));
        listProduct.add(new Product(2, "Iphone 7", 700));
//        listProduct.add(new Product(3, "Sony Abc", 800));
//        listProduct.add(new Product(4, "Samsung XYZ", 900));
//        listProduct.add(new Product(5, "SP 5", 500));
//        listProduct.add(new Product(6, "SP 6", 700));
//        listProduct.add(new Product(7, "SP 7", 800));
//        listProduct.add(new Product(8, "SP 8", 900));

        productListViewAdapter = new ProductListViewAdapter(listProduct);

        listViewProduct = root.findViewById(R.id.listproduct);
        listViewProduct.setAdapter(productListViewAdapter);


        //Lắng nghe bắt sự kiện một phần tử danh sách được chọn
        listViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = (Product) productListViewAdapter.getItem(position);
                //Làm gì đó khi chọn sản phẩm (ví dụ tạo một Activity hiện thị chi tiết, biên tập ..)
                Toast.makeText(AreaFragment.super.getContext(), product.name, Toast.LENGTH_LONG).show();
            }
        });

        //Khoi tao ListProduct
        listSensor = new ArrayList<>();
        listSensor.add(new Sensor(1, "27", "20"));
        listSensor.add(new Sensor(2, "27", "20"));
        listSensor.add(new Sensor(3, "27", "20"));
        listSensor.add(new Sensor(4, "29", "20"));
        listSensor.add(new Sensor(5, "27", "30"));
        listSensor.add(new Sensor(6, "27", "20"));
        listSensor.add(new Sensor(7, "27", "20"));

        sensorListViewAdapter = new SensorListViewAdapter(listSensor);

        listViewSensor = root.findViewById(R.id.listsensor);
        listViewSensor.setAdapter(sensorListViewAdapter);


        //Lắng nghe bắt sự kiện một phần tử danh sách được chọn
        listViewSensor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Sensor sensor = (Sensor) sensorListViewAdapter.getItem(position);
                //Làm gì đó khi chọn sản phẩm (ví dụ tạo một Activity hiện thị chi tiết, biên tập ..)
                Toast.makeText(AreaFragment.super.getContext(), sensor.Temperature, Toast.LENGTH_LONG).show();
            }
        });


//        root.findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (listProduct.size() > 0) {
//                    //Xoá phần tử đầu tiên của danh sách
//                    int productpost = 0;
//                    listProduct.remove(productpost);
//                    //Thông báo cho ListView biết dữ liệu đã thay đổi (cập nhật, xoá ...)
//                    productListViewAdapter.notifyDataSetChanged();
//                }
//            }
//        });


        return root;
    }
}
