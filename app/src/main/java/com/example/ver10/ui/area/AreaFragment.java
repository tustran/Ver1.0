package com.example.ver10.ui.area;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.ver10.R;

import java.util.ArrayList;

public class AreaFragment extends Fragment {

    private AreaViewModel areaViewModel;
    ArrayList<Product> listProduct;
    ArrayList<Sensor> listSensor;
    ArrayList<Motor> listMotor;
    ProductListViewAdapter productListViewAdapter;
    SensorListViewAdapter sensorListViewAdapter;
    MotorListViewAdapter motorListViewAdapter;
    ListView listViewProduct;
    ListView listViewSensor;
    ListView listViewMotor;
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
    class Motor {

        int motorID;
        boolean status;

        public Motor(int motorID, boolean status) {
            this.motorID = motorID;
            this.status = status;
        }
        public void setOn(){
            this.status=true;
        }
        public void setOff(){
            this.status=false;
        }
        public boolean getStatus(){
            return this.status;
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

    class MotorListViewAdapter extends BaseAdapter {

        //Dữ liệu liên kết bởi Adapter là một mảng các cảm biến
        final ArrayList<Motor> listMotor;

        MotorListViewAdapter(ArrayList<Motor> listMotor) {
            this.listMotor = listMotor;
        }

        @Override
        public int getCount() {
            //Trả về tổng số phần tử, nó được gọi bởi ListView
            return listMotor.size();
        }

        @Override
        public Object getItem(int position) {
            //Trả về dữ liệu ở vị trí position của Adapter, tương ứng là phần tử
            //có chỉ số position trong listProduct
            return listMotor.get(position);
        }

        @Override
        public long getItemId(int position) {
            //Trả về một ID của phần
            return listMotor.get(position).motorID;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //convertView là View của phần tử ListView, nếu convertView != null nghĩa là
            //View này được sử dụng lại, chỉ việc cập nhật nội dung mới
            //Nếu null cần tạo mới

            final View viewMotor;
            if (convertView == null) {
                viewMotor = View.inflate(parent.getContext(), R.layout.motor_view, null);
            } else viewMotor = convertView;

            //Bind sữ liệu phần tử vào View
//            TextView textID  = viewMotor.findViewById(R.id.text_id);
            final Motor motor = (Motor) getItem(position);
            ((Switch) viewMotor.findViewById(R.id.switch_id)).setText(String.format("%s", motor.motorID+"           "));
            ((Switch) viewMotor.findViewById(R.id.switch_id)).setChecked(motor.status);
//            ((TextView) viewSensor.findViewById(R.id.sensortemp)).setText(String.format("%s oC", sensor.Temperature));
//            ((TextView) viewSensor.findViewById(R.id.sensormois)).setText(String.format("%s percent", sensor.Moisture));
            ((Switch) viewMotor.findViewById(R.id.switch_id)).setOnCheckedChangeListener(
                    new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton,
                                                     boolean b) {
                            Toast.makeText(AreaFragment.super.getContext(),"Switch is " + (motor.status ? "On" : "Off"),Toast.LENGTH_LONG).show();
                        }
                    });

            return viewMotor;
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
        listSensor.add(new Sensor(18, "27", "20"));
        listSensor.add(new Sensor(29, "27", "20"));
        listSensor.add(new Sensor(38, "27", "20"));
        listSensor.add(new Sensor(42, "29", "20"));
        listSensor.add(new Sensor(53, "27", "30"));
        listSensor.add(new Sensor(63, "27", "20"));
        listSensor.add(new Sensor(72, "27", "20"));
        listSensor.add(new Sensor(11, "27", "20"));
        listSensor.add(new Sensor(12, "27", "20"));
        listSensor.add(new Sensor(13, "27", "20"));
        listSensor.add(new Sensor(14, "29", "20"));
        listSensor.add(new Sensor(15, "27", "30"));
        listSensor.add(new Sensor(16, "27", "20"));
        listSensor.add(new Sensor(17, "27", "20"));

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
        //Khoi tao ListProduct
        listMotor = new ArrayList<Motor>();
        listMotor.add(new Motor(1, false));
        listMotor.add(new Motor(2,true));


        motorListViewAdapter = new MotorListViewAdapter(listMotor);

        listViewMotor = root.findViewById(R.id.listmotor);
        listViewMotor.setAdapter(motorListViewAdapter);


        //Lắng nghe bắt sự kiện một phần tử danh sách được chọn
        listViewMotor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Motor motor = (Motor) motorListViewAdapter.getItem(position);
                //Làm gì đó khi chọn sản phẩm (ví dụ tạo một Activity hiện thị chi tiết, biên tập ..)
                Toast.makeText(AreaFragment.super.getContext(), "khong co gi ca", Toast.LENGTH_LONG).show();
            }
        });


        return root;
    }
}
