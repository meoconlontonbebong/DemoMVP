package com.example.kienphung.demomvp.screen.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.kienphung.demomvp.R;
import com.example.kienphung.demomvp.data.repositoty.UserRepository;
import com.example.kienphung.demomvp.data.source.local.UserLocalDataSource;
import com.example.kienphung.demomvp.data.source.remode.UserRemoteDataSource;
import com.example.kienphung.demomvp.screen.BaseActivity;
import com.example.kienphung.demomvp.screen.MainActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginContract.View {
    private LoginContract.Presenter mPresenter;
    private EditText mEditTextUserName;
    private EditText mEditTextPassword;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button buttonLogin = findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(this);
        initView();
        UserRepository userRepository = UserRepository.getInstance(
                UserLocalDataSource.getInstance(),
                UserRemoteDataSource.getInstance()
        );
        mPresenter = new LoginPresenter(userRepository);
        mPresenter.setView(this);
    }

    public void initView() {
        mEditTextUserName = findViewById(R.id.text_user_name);
        mEditTextPassword = findViewById(R.id.text_password);
        mProgressBar = findViewById(R.id.progress_bar);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_login:
                String username = mEditTextUserName.getText().toString();
                String password = mEditTextPassword.getText().toString();
                mPresenter.login(username, password);
                break;
            default:
                break;
        }
    }


    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showUsernameErrorMessage() {
        hideProgressBar();
        mEditTextUserName.setError(getString(R.string.message_username_invalid));
    }

    @Override
    public void showPasswordErrorMessage() {
        hideProgressBar();
        mEditTextPassword.setError(getString(R.string.message_password_invalid));
    }

    @Override
    public void showLoginFailMessage() {
        hideProgressBar();
        Toast.makeText(this, getString(R.string.login_fail), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toHomeActivity() {
        hideProgressBar();
        Toast.makeText(this, getString(R.string.to_home_activity), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }
}
