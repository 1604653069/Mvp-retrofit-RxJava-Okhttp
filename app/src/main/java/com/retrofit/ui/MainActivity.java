package com.retrofit.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.retrofit.R;
import com.retrofit.base.BaseActivity;
import com.retrofit.model.Address;
import com.retrofit.model.Person;
import com.retrofit.model.request.QueryUser;
import com.retrofit.model.response.User;
import com.retrofit.mvp.main.MainPresenter;
import com.retrofit.mvp.main.MainView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {
    @BindView(R.id.tv_test)
    TextView tvTest;
    @BindView(R.id.btn_test)
    Button btnTest;
    Button btnTest33;
    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter(this, this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @SuppressLint("CheckResult")
    @Override
    protected void doSomething() {

        presenter.login(new QueryUser("333","123456zxA"));
        Person person = new Person();
        person.setAge(10);
        person.setName("张三");
        Address address = new Address("福建省","福州市");
        Address address1 = new Address("福建省","建瓯市");
        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        addressList.add(address1);
        person.setAddressList(addressList);


        Person person1 = new Person();
        person1.setAge(11);
        person1.setName("李四");
        Address address2 = new Address("福建省","南平市");
        Address address3 = new Address("福建省","123");
        List<Address> addressList2 = new ArrayList<>();
        addressList2.add(address2);
        addressList2.add(address3);
        person1.setAddressList(addressList2);
        List<Person> peoples = new ArrayList<>();
        peoples.add(person);
        peoples.add(person1);

//        Observable.fromIterable(peoples)
//                    .flatMap(new Function<Person,Observable<Address>>(){
//                        @Override
//                        public Observable<Address> apply(Person person) throws Exception {
//                            return Observable.fromIterable(person.getAddressList());
//                        }
//                    }).filter(new Predicate<Address>() {
//            @Override
//            public boolean test(Address address) throws Exception {
//                return address.getCity().equals("建瓯市");
//            }
//        }).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Address>() {
//                    @Override
//                    public void accept(Address address) throws Exception {
//                        Log.i("TAG",address.toString());
//                    }
//                });
//        Observable.fromIterable(peoples)
//                .flatMap(person2 -> Observable.fromIterable(person2.getAddressList()))
//                .filter(address4 -> address4.getCity().equals("建瓯市"))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Address>() {
//                    @Override
//                    public void accept(Address address) throws Exception {
//                        Log.i("TAG",address.toString());
//                    }
//                });
        Observable.range(1,10)
                .filter(number -> number%2==0)
                .take(3)
                .map(number->String.valueOf(number))
                .subscribe(vale -> Log.i("TAG",vale+"s"));
        
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFail() {

    }

    @OnClick({R.id.btn_test})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_test:
                  btnTest33.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {

                      }
                  });
//                startActivity(new Intent(MainActivity.this, SecondActivity.class));
//                finish();
//                break;
        }
    }

    @Override
    public void onLoginSuccessListener(User user) {
        tvTest.setText(user.toString());
    }

    @Override
    public void onLoginFailListener(String errorMessage) {
        T(this,errorMessage);
    }
}