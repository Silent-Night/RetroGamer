package com.SilentNight.RetroGamer.fragment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.SilentNight.RetroGamer.interfaces.ScreenShotable;
import com.SilentNight.RetroGamer.R;


public class ContentFragment extends Fragment implements ScreenShotable {
    public static final String CLOSE = "Close";
    public static final String P3DO = "P3DO";
    public static final String AMIGA = "AMIGA";
    public static final String ATARI2600 = "ATARI2600";
    public static final String ATARILYNX = "ATARILYNX";
    public static final String COLECOVISION = "COLECOVISION";
    public static final String COMMODORE64 = "COMMODORE64";
    public static final String FBA = "FBA";
    public static final String MAME = "MAME";
    public static final String MSX = "MSX";
    public static final String NGP = "NGP";
    public static final String NEOGEO = "NEOGEO";
    public static final String N64 = "N64";
    public static final String NDS = "NDS";
    public static final String NES = "NES";
    public static final String GB = "GB";
    public static final String GBA = "GBA";
    public static final String GBC = "GBC";
    public static final String NGC = "NGC";
    public static final String VIRTUALBOY = "VIRTUALBOY";
    public static final String Wii = "Wii";
    public static final String SEGA32X = "32X";
    public static final String SEGACD = "SEGACD";
    public static final String DC = "DC";
    public static final String GAMEGEAR = "GAMEGEAR";
    public static final String SMS = "SMS";
    public static final String MD = "MD";
    public static final String SATURN = "SATURN";
    public static final String ZXSPECTRUM = "ZXSPECTRUM";
    public static final String PSX = "PSX";
    public static final String PS2 = "PS2";
    public static final String PSP = "PSP";
    public static final String SNES = "SNES";
    public static final String TG16 = "TG16";
    public static final String WONDERSWAN = "WONDERSWAN";

    private View containerView;
    protected ImageView mImageView;
    protected int res;
    private Bitmap bitmap;

    public static ContentFragment newInstance(int resId) {
        ContentFragment contentFragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Integer.class.getName(), resId);
        contentFragment.setArguments(bundle);
        return contentFragment;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.containerView = view.findViewById(R.id.container);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        res = getArguments().getInt(Integer.class.getName());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mImageView = (ImageView) rootView.findViewById(R.id.image_content);
        mImageView.setClickable(true);
        mImageView.setFocusable(true);
        mImageView.setImageResource(res);
        return rootView;
    }

    @Override
    public void takeScreenShot() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Bitmap bitmap = Bitmap.createBitmap(containerView.getWidth(),
                        containerView.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                containerView.draw(canvas);
                ContentFragment.this.bitmap = bitmap;
            }
        };

        thread.start();

    }

    @Override
    public Bitmap getBitmap() {
        return bitmap;
    }
}

