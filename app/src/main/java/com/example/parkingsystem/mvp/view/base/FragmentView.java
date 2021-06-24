package com.example.parkingsystem.mvp.view.base;

import android.content.Context;
import androidx.fragment.app.Fragment;
import java.lang.ref.WeakReference;

public class FragmentView {
    private WeakReference<Fragment> fragmentWeakRef;

    public FragmentView(Fragment fragment) {
        this.fragmentWeakRef = new WeakReference<>(fragment);
    }

    public Fragment getFragment() {
        return fragmentWeakRef.get();
    }

    public Context getContext() {
        return getFragment().getContext();
    }
}
