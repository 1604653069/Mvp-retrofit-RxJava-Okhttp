package com.retrofit.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;
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
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {
    @BindView(R.id.tv_test)
    TextView tvTest;
    @BindView(R.id.btn_test)
    Button btnTest;
    @BindView(R.id.edit)
    EditText edit;
    private List<String> strings;
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
        strings = new ArrayList<>();
        strings.add("张三");
        strings.add("张思");
        strings.add("张武");
        strings.add("李四");
        strings.add("李白");
        strings.add("测试");
        List<String> matchString = new ArrayList<>();
        RxTextView.textChanges(edit)
                .map(chars->String.valueOf(chars))
                .flatMap(new Function<String, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(String s) throws Exception {
                        return null;
                    }
                });

        presenter.login(new QueryUser("333", "123456zxA"));
        Person person = new Person();
        person.setAge(10);
        person.setName("张三");
        Address address = new Address("福建省", "福州市");
        Address address1 = new Address("福建省", "建瓯市");
        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        addressList.add(address1);
        person.setAddressList(addressList);


        Person person1 = new Person();
        person1.setAge(11);
        person1.setName("李四");
        Address address2 = new Address("福建省", "南平市");
        Address address3 = new Address("福建省", "123");
        List<Address> addressList2 = new ArrayList<>();
        addressList2.add(address2);
        addressList2.add(address3);
        person1.setAddressList(addressList2);
        List<Person> peoples = new ArrayList<>();
        peoples.add(person);
        peoples.add(person1);

        Observable.fromIterable(peoples)
                .flatMap(people -> Observable.fromIterable(people.getAddressList()))
                .filter(personAddress -> personAddress.getCity().equals("建瓯市"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(address4 -> Log.i("TAG", address4.toString()));
        Observable.range(1, 10)
                .filter(number -> number % 2 == 0)
                .take(3)
                .map(number -> String.valueOf(number))
                .subscribe(vale -> Log.i("TAG", vale + "s"));
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFail() {

    }

    @Override
    public void onLoginSuccessListener(User user) {
        tvTest.setText(user.toString());
    }

    @Override
    public void onLoginFailListener(String errorMessage) {
        T(this, errorMessage);
    }

}