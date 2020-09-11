package com.example.hw222;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {
    private EditText inputMoney;
    private EditText inputInfo;
    private Button btnOk;
    private CheckBox bankCardChkBx;
    private CheckBox mobilePhoneChkBx;
    private CheckBox cashAddressChkBx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        init();
    }

    private void init(){
        inputMoney = findViewById(R.id.inputMoney);
        inputInfo = findViewById(R.id.inputInfo);
        btnOk = findViewById(R.id.btnOK);
        bankCardChkBx = findViewById(R.id.bankCardChkBx);
        mobilePhoneChkBx = findViewById(R.id.mobilePhoneChkBx);
        cashAddressChkBx = findViewById(R.id.cashAddressChkBx);

        CompoundButton.OnCheckedChangeListener checkedChangeListener =
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            switch (compoundButton.getId()) {
                                case R.id.bankCardChkBx:
                                    resetCheckBoxes();
                                    bankCardChkBx.setChecked(true);
                                    inputInfo.getText().clear();
                                    inputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                                    break;
                                case R.id.mobilePhoneChkBx:
                                    resetCheckBoxes();
                                    mobilePhoneChkBx.setChecked(true);
                                    inputInfo.getText().clear();
                                    inputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                                    break;
                                case R.id.cashAddressChkBx:
                                    resetCheckBoxes();
                                    cashAddressChkBx.setChecked(true);
                                    inputInfo.getText().clear();
                                    inputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                                    break;
                                default:
                            }
                        }
                    }
                };

        bankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        cashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bankCardChkBx.isChecked()) {
                    Toast.makeText(PaymentActivity.this, R.string.toastPaymentBankCard, Toast.LENGTH_LONG).show();
                }
                else if (mobilePhoneChkBx.isChecked()) {
                    Toast.makeText(PaymentActivity.this, R.string.toastPaymentMobilePhone, Toast.LENGTH_LONG).show();
                }
                else if (cashAddressChkBx.isChecked()) {
                    Toast.makeText(PaymentActivity.this, R.string.toastPaymentCashAddress, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void resetCheckBoxes(){
        bankCardChkBx.setChecked(false);
        mobilePhoneChkBx.setChecked(false);
        cashAddressChkBx.setChecked(false);
    }
}