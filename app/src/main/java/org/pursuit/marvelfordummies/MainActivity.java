package org.pursuit.marvelfordummies;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.pursuit.marvelfordummies.data.network.HashCalculator;
import org.pursuit.marvelfordummies.data.network.HeroRepository;
import org.pursuit.marvelfordummies.data.network.MarvelRetrofit;
import org.pursuit.marvelfordummies.data.network.MarvelService;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public final class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity.DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}
